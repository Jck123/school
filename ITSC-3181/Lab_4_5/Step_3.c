#include <stdio.h>

int main(int argc, char * argv[]) {
    int t0 = 60;
    int t1 = 0;

    while(t0 != t1) {
        t0 -= 1;
        t1 += 5;
    }

    if(t1 != 0) {
        printf("Exited with code 42(success)\n");
        return 42;
    }
    printf("Exited with code 0(failure)\n");
    return 0;
}