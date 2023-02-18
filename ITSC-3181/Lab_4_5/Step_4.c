#include <stdio.h>

int main(int argc, char * argv[]) {
    int x = 0;
    
    for(int i = 1; i < 101; i++)
        x += i;
        
    printf("Total: %i\n", x);

    return x;
}