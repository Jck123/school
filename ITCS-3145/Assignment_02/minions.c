#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>

void *minion(void* arg) {
    printf("Hello! I am minion %i\n", *(int *)arg);
    return NULL;
}

void *overlord() {
    printf("Hello Minions! I am the Overlord!\n");
    return NULL;
}

int main(int argc, char* argv[]) {
    if ((argc != 2) || atoi(argv[1]) <= 0) {
        fprintf(stderr, "Error: Bad command line parameters\n");
        exit(1);
    } else {
        int minCount = atoi(argv[1]);
        int rc = 0;

        for(int i = 0; i < minCount; i++) {
            pthread_t t;
            int arg = i;
            rc = pthread_create(&t, NULL, minion, &arg);
            if (rc) {
                fprintf(stderr, "Failed to create pthread, error code %i", rc);
                exit(rc);
            }
            pthread_join(t, NULL);
        }
        pthread_t ol;
        rc = pthread_create(&ol, NULL, overlord, NULL);
        if (rc) {
            fprintf(stderr, "Failed to create pthread, error code %i", rc);
            exit(rc);
        }
        pthread_join(ol, NULL);
        exit(0);
    }
}