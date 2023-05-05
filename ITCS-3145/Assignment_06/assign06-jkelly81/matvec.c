#include <stdio.h>
#include <math.h>
#include <stdlib.h>
#include <stdbool.h>
#include <time.h>
#include <mpi.h>

float genA(int row, int col) {
    if (row > col)
        return 1.0f;
    else
        return 0.0f;
}

float genx0(int i) {
    return 1.0f;
}

void checkx(long i, float xval) {
    float shouldbe = (float)i;
    if (fabs(xval / shouldbe) > 1.01 || fabs(xval / shouldbe) < 0.99)
        printf("incorrect : x[%ld] should be %f not %f\n", i, shouldbe, xval);
}

void matvec(float *A, float *x, float *y, long n) {
    for (long row = 0; row < n; ++row) {
        float sum = 0;

        for (long col = 0; col < n; ++col) {
	    //printf("A[%li][%li]: %f\n", row, col, A[row * n + col]);
            sum += x[col] * A[row * n + col];
        }

        y[row] = sum;
    }
}

int main(int argc, char *argv[]) {

    if (argc < 3) {
        printf("usage: %s <n> <iteration>\n", argv[0]);
        exit(1);
    }

    bool check = true;

    long n = atol(argv[1]);

    long iter = atol(argv[2]);

    float *A = (float *)malloc(n * n * sizeof(float));

    for (long row = 0; row < n; row++) {
        for (long col = 0; col < n; col++) {
            A[row * n + col] = genA(row, col);
        }
    }

    float *x = (float *)malloc(n * sizeof(float));

    for (long i = 0; i < n; ++i)
        x[i] = genx0(i);

    float *y = (float *)malloc(n * sizeof(float));

    clock_t start = clock();
    // TODO all your code changes really take place below here
    int rank, size;
    MPI_Init(NULL, NULL);
    MPI_Comm_rank(MPI_COMM_WORLD, &rank);
    MPI_Comm_size(MPI_COMM_WORLD, &size);

    int sizeperworker = n / size;

    for (int it = 0; it < iter; ++it) {

        float *subx = (float *)malloc(sizeperworker * sizeof(float));
        float *suby = (float *)malloc(sizeperworker * sizeof(float));
        float *subA = (float *)malloc(sizeperworker * n * sizeof(float));

        MPI_Scatter(x, sizeperworker, MPI_FLOAT, subx, sizeperworker, MPI_FLOAT, 0, MPI_COMM_WORLD);
        MPI_Scatter(y, sizeperworker, MPI_FLOAT, suby, sizeperworker, MPI_FLOAT, 0, MPI_COMM_WORLD);
	//MPI_Bcast(x, n, MPI_FLOAT, 0, MPI_COMM_WORLD);
	//MPI_Bcast(y, n, MPI_FLOAT, 0, MPI_COMM_WORLD);
        MPI_Scatter(A, sizeperworker, MPI_FLOAT, subA, sizeperworker, MPI_FLOAT, 0, MPI_COMM_WORLD);

        matvec(subA, subx, suby, sizeperworker);

        MPI_Gather(suby, sizeperworker, MPI_FLOAT, y, sizeperworker, MPI_FLOAT, 0, MPI_COMM_WORLD);

	if (rank == 0) {
            {
                 float *t = x;
                 x = y;
                 y = t;
            }

            if (check && it == 0)
                 for (long i = 0; i < n; ++i)
                     checkx(i, x[i]);
	}
        free(subx);
        free(suby);
        free(subA);
    }

    MPI_Finalize();
    // TODO all your code changes really take place above here
    clock_t end = clock();
    double elapsed_seconds = (double)(end - start) / CLOCKS_PER_SEC;

    fprintf(stderr, "%f\n", elapsed_seconds);

    free(A);
    free(x);
    free(y);

    return 0;
}

