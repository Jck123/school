#define _POSIX_C_SOURCE 199309L
#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define A_VAL 3
#define B_VAL 2

void init_vec(int* a, size_t size, int val)
{
    for (size_t i = 0; i < size; ++i)
    {
        a[i] = val;
    }
}

void vecadd(int* a, int* b, int* c, size_t size)
{
    for (size_t i = 0; i < size; ++i)
    {
        c[i] = a[i] + b[i];
    }
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

    if (argc != 2)
    {
        fprintf(stderr, "usage: %s N\n", argv[0]);
        return 1;
    }
    size_t n = strtoul(argv[1], NULL, 10);
    int* a = malloc(sizeof(int) * n);
    int* b = malloc(sizeof(int) * n);
    int* c = malloc(sizeof(int) * n);
    init_vec(a, n, A_VAL);
    init_vec(b, n, B_VAL);
    init_vec(c, n, 0);
    clock_gettime(CLOCK_MONOTONIC, &s);

    vecadd(a, b, c, n);

    clock_gettime(CLOCK_MONOTONIC, &e);
    time = e.tv_sec - s.tv_sec + (e.tv_nsec - s.tv_nsec)/1e9;
    fprintf(stderr, "time: %lfs\n", time);

    ret = check_result(c, n);   
    free(a);
    free(b);
    free(c);

    return ret;
}
