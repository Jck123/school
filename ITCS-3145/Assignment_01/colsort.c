#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <string.h>

int strptrcmp(const void* p1, const void* p2) {
    return strcmp(*(char* const*) p1, *(char* const*) p2);
}

// Treat this function as main
int drive_sort(int argc, char* argv[])
{
    int arrSize = 10;
    if (argc > 3) {
        fprintf(stderr, "Error: Bad command line parameters\n");
        exit(1);
    } else if (argc == 1) {
        return 0;
    } else if (argc == 2) {
        if(argv[1][0] != '-') {
            FILE* input = fopen(argv[1], "r");
            if (input == NULL) {
                fprintf(stderr, "Error: Cannot open file %s\n", argv[1]);
                exit(1);
            } else {
                char **fileArr = malloc(sizeof(char*) * arrSize);
                char *line = malloc(128);
                int numLines = 0;
                if(fileArr == NULL) {
                    fprintf(stderr, "Error: Malloc failed\n");
                    exit(1);
                }
                while(fgets(line, 128, input) != NULL) {
                    if(line[strlen(line) - 1] != '\n') {
                        fprintf(stderr, "Error: Line too long\n");
                        exit(1);
                    } else {
                        line[strlen(line)-1] = '\0';                        
                        if (numLines >= arrSize -1) {
                            arrSize += 10;
                            fileArr = realloc(fileArr, arrSize);
                            if(fileArr == NULL) {
                                fprintf(stderr, "Error: Malloc failed\n");
                                exit(1);
                            }
                        }
                        fileArr[numLines] = line;
                        fileArr[numLines] = realloc(fileArr[numLines], strlen(line));
                        line = malloc(128);
                        if(fileArr[numLines] == NULL || line == NULL) {
                            fprintf(stderr, "Error: Malloc failed\n");
                            exit(1);
                        }
                        numLines++;
                    }
                }
                qsort(fileArr, numLines, sizeof(char*),strptrcmp);

                for (int i = 0; i < numLines; i++) {
                    printf("%s\n", fileArr[i]);
                }
            }
        } else {
            fprintf(stderr, "Error: Bad command line parameters\n");
            exit(1);
        }
    } else {
        int col;
        if (col = ((atoi(argv[1])*-1)-1) >= 0) {
            FILE* input = fopen(argv[2], "r");
            if (input == NULL) {
                fprintf(stderr, "Error: Cannot open file %s\n", argv[2]);
                exit(1);
            } else {
                //Add sorting code here
            }
        } else {
            fprintf(stderr, "Error: Bad command line parameters\n");
            exit(1);
        }
    }

    return 0;
}

// TODO all changes should be made above this line
int main(int argc, char* argv[])
{
    int ret = 0;
    double time;
    struct timespec s;
    struct timespec e;

    clock_gettime(CLOCK_MONOTONIC, &s);
    ret = drive_sort(argc, argv);
    clock_gettime(CLOCK_MONOTONIC, &e);
    time = e.tv_sec - s.tv_sec + (e.tv_nsec - s.tv_nsec)/1e9;

    fprintf(stderr, "time: %lfs\n", time);
    return ret;
}
