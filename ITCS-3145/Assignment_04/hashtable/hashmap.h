#pragma once


typedef struct node {
    char* key;
    int value;
    struct node* next;
} node_t;

typedef struct {
    node_t** buckets;
    int size;
} hashmap_t;

typedef struct {
    hashmap_t* map;
    int bucket_index;
    node_t* current_node;
} hashmap_iterator_t;

void hashmap_init(hashmap_t*, int size);
void hashmap_insert(hashmap_t* map, const char* key, int value);
int hashmap_find(hashmap_t* map, const char* key, int* value);
void hashmap_destroy(hashmap_t* map);

void hashmap_iterator_init(hashmap_iterator_t* iterator, hashmap_t* map);
int hashmap_iterator_has_next(hashmap_iterator_t* iterator);
void hashmap_iterator_next(hashmap_iterator_t* iterator, char** key, int* value);
