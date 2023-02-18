#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int main(void) {
    int arr[100];
    int arr2[100];

    srand(time(NULL));

    for(int i = 0; i < 100; i++) {
        arr[i] = rand() % 100 + 1;
    }

    float a = 0.1234;

    for (int i = 0; i < 100; i++) {
        double sum = 0;
        for (int j = 0; j <= i; j++)
            sum += a * arr[j];
        arr2[i] = (int)sum;
    }

    printf("Example run: %i --> %i\n", arr[10], arr2[10]);
}