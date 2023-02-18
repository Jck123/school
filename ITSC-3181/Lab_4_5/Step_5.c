#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int main(void) {
    int arr[100];
    srand(time(NULL));

    for(int i = 0; i < 100; i++) {
        arr[i] = rand() % 100 + 1;
    }

    int sum = 0;
    for(int i = 0; i < 100; i++) {
        sum += arr[i];
    }
    
    printf("Average: %i\n", sum/100);

    return 0;
}