#include <mpi.h>
#include <stdio.h>
#include <stdlib.h>

int main(int argc, char *argv[]) {

  if (argc < 2) {
    fprintf(stderr, "usage: mpirun %s <value>\n", argv[0]);
    return -1;
  }

  int rank, message;

  MPI_Init(&argc, &argv);
  MPI_Comm_rank(MPI_COMM_WORLD, &rank);

  if (rank == 0) {
    message = atoi(argv[1]);
    MPI_Send(&message, 1, MPI_INT, 1, 1, MPI_COMM_WORLD);
    MPI_Recv(&message, 1, MPI_INT, 1, 2, MPI_COMM_WORLD, MPI_STATUS_IGNORE);
    printf("New value: %i\n", message);
  }

  else if (rank == 1) {
    MPI_Recv(&message, 1, MPI_INT, 0, 1, MPI_COMM_WORLD, MPI_STATUS_IGNORE);
    message += 2;
    MPI_Send(&message, 1, MPI_INT, 0, 2, MPI_COMM_WORLD);
  }


  MPI_Finalize();
  return 0;
}

