#define _POSIX_C_SOURCE 199309L
#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <pthread.h>

#define A_VAL 3
#define B_VAL 2

struct vecprob
{
    int* a;
    int* b;
    int* c;
    size_t size;
};

void init_vec(int* a, size_t size, int val)
{
    for (size_t i = 0; i < size; ++i)
    {
        a[i] = val;
    }
}

void _vecadd(int* a, int* b, int* c, size_t size)
{
    for (size_t i = 0; i < size; ++i)
    {
        c[i] = a[i] + b[i];
    }
}

void* vecadd(void* args)
{
    struct vecprob* v = (struct vecprob*)args;
    _vecadd(v->a, v->b, v->c, v->size);
    return NULL;
}


int check_result(int* c, size_t size)
{
    int ret = 0;
    int expected = A_VAL + B_VAL;
    for (size_t i = 0; i < size; ++i)
    {
        if (c[i] != expected)
        {
            fprintf(stderr, "Incorrect result at c[%lu]: %d should be %d\n", i, c[i], expected);
            ret = 1;
        }
    }
    return ret;
}


// TODO all changes should be made above this line
int main(int argc, char* argv[])
{
    int ret = 0;
    double time;
    struct timespec s;
    struct timespec e;

    // args
    if (argc != 3)
    {
        fprintf(stderr, "usage: %s N #threads\n", argv[0]);
        return 1;
    }
    size_t n = strtoul(argv[1], NULL, 10);
    int t = atoi(argv[2]);
    if (t < 1 || t > 16)
    {
        fprintf(stderr, "Invalid thread count; expect a value between 1 and 16\n");
        return 1;
    }

    // setup
    int* a = malloc(sizeof(int) * n);
    int* b = malloc(sizeof(int) * n);
    int* c = malloc(sizeof(int) * n);
    init_vec(a, n, A_VAL);
    init_vec(b, n, B_VAL);
    init_vec(c, n, 0);

    // kernel
    clock_gettime(CLOCK_MONOTONIC, &s);
    pthread_t threads[t];
    pthread_attr_t attr[t];
    struct vecprob v[t];

    // TODO TIP: valgrind to make sure you don't have memory errors
    for (int i = 0; i < t; ++i)
    { // MODIFY HERE
        pthread_attr_init(&attr[i]);

        struct vecprob vp = {.a = a, .b = b, .c = c, .size = n};

        v[i] = vp;
        
        pthread_create(&threads[i], NULL, vecadd, &v[i]);
        
    } // DON'T MODIFY PAST HERE
    for (int i = 0; i < t; ++i)
    {
        pthread_join(threads[i], NULL);
    }
    clock_gettime(CLOCK_MONOTONIC, &e);
    time = e.tv_sec - s.tv_sec + (e.tv_nsec - s.tv_nsec)/1e9;
    fprintf(stderr, "time: %lfs\n", time);
    
    ret = check_result(c, n);
    // cleanup
    free(a);
    free(b);
    free(c);
    for (int i = 0; i < t; ++i)
    {
        pthread_attr_destroy(&attr[i]);
    }

    return ret;
}
