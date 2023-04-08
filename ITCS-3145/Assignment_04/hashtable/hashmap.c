#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <pthread.h>

#include "hashmap.h"


/*
 * This is the djb2 hashing algorithm
 * http://www.cse.yorku.ca/~oz/hash.html
 */
static unsigned int hashmap_hash(const char* key, int size) {
    unsigned long hash = 5381;
    int c;

    while ((c = *key++))
    {
        hash = ((hash << 5) + hash) + c; /* hash * 33 + c */
    }
    return hash % size;
}

void hashmap_insert(hashmap_t* map, const char* key, int value) {
    unsigned int bucket = hashmap_hash(key, map->size);
    pthread_mutex_t bucket_lock = PTHREAD_MUTEX_INITIALIZER;
    pthread_mutex_lock(&bucket_lock);
    // find bucket
    node_t* current = map->buckets[bucket];
    // bucket is a list - walk to the end if needed
    while(current != NULL) {
        if(strcmp(current->key, key) == 0) {
            current->value = value;
            pthread_mutex_unlock(&bucket_lock);
            return;
        }
        current = current->next;
    }
    // if we walk to the end then this is a new entry
    node_t* node = malloc(sizeof(node_t));
    node->key = strdup(key);
    node->value = value;
    node->next = map->buckets[bucket];
    map->buckets[bucket] = node;
    pthread_mutex_unlock(&bucket_lock);
}

int hashmap_find(hashmap_t* map, const char* key, int* value) {
    unsigned int bucket = hashmap_hash(key, map->size);
    pthread_mutex_t bucket_lock = PTHREAD_MUTEX_INITIALIZER;
    pthread_mutex_lock(&bucket_lock);
    node_t* current = map->buckets[bucket];
    while(current != NULL) {
        if(strcmp(current->key, key) == 0) {
            *value = current->value;
            pthread_mutex_unlock(&bucket_lock);
            return 1;
        }
        current = current->next;
    }
    // return false if not found
    pthread_mutex_unlock(&bucket_lock);
    return 0;
}

// Hint: Leave these alone. We don't care if the initializer or destructor are thread-safe;
// they will not be used in a parallel context.

/*
 * Call me to set up your hashmap
 */
void hashmap_init(hashmap_t* map, int size) {
    map->buckets = malloc(size * sizeof(node_t*));
    memset(map->buckets, 0, size * sizeof(node_t*));
    map->size = size;
}


void hashmap_destroy(hashmap_t* map) {
    for(int i = 0; i < map->size; i++) {
        node_t* current = map->buckets[i];
        while(current != NULL) {
            node_t* next = current->next;
            free(current->key);
            free(current);
            current = next;
        }
    }
    free(map->buckets);
}

// HINT: Leave these alone. Iterators are only used in post; they do not need to 
// support parallel access.

void hashmap_iterator_init(hashmap_iterator_t* iterator, hashmap_t* map) {
    iterator->map = map;
    iterator->bucket_index = 0;
    iterator->current_node = map->buckets[0];
}

int hashmap_iterator_has_next(hashmap_iterator_t* iterator) {
    while (iterator->bucket_index < iterator->map->size) {
        if (iterator->current_node != NULL) {
            return 1;
        }
        iterator->bucket_index++;
        if (iterator->bucket_index < iterator->map->size) {
            iterator->current_node = iterator->map->buckets[iterator->bucket_index];
        }
    }
    return 0;
}

void hashmap_iterator_next(hashmap_iterator_t* iterator, char** key, int* value) {
    if (iterator->current_node != NULL) {
        *key = iterator->current_node->key;
        *value = iterator->current_node->value;
        iterator->current_node = iterator->current_node->next;
    } else {
        iterator->bucket_index++;
        if (iterator->bucket_index < iterator->map->size) {
            iterator->current_node = iterator->map->buckets[iterator->bucket_index];
            hashmap_iterator_next(iterator, key, value);
        }
    }
}


#ifdef HASHMAP_TEST
int main() {
    hashmap_t map;
    hashmap_init(&map, 10);
    hashmap_insert(&map, "foo", 1);
    hashmap_insert(&map, "bar", 2);
    int value = 0;
    int ret = hashmap_find(&map, "foo", &value);
    if(ret) {
        printf("Value of foo: %d\n", value);
    }
    ret = hashmap_find(&map, "baz", &value);
    if(ret) {
        printf("Value of baz: %d\n", value);
    } else {
        printf("Key 'baz' not found\n");
    }
    hashmap_destroy(&map);
    return 0;
}
#endif
