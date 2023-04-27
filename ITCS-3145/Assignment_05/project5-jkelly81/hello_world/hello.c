#include <mpi.h>
#include <stdio.h>

int main(void)
{
    int i, P, name_len;
    char name[MPI_MAX_PROCESSOR_NAME];
    MPI_Init(NULL, NULL);

    MPI_Comm_size(MPI_COMM_WORLD, &P);
    MPI_Comm_rank(MPI_COMM_WORLD, &i);
    MPI_Get_processor_name(name, &name_len);

    printf("I am procress %i out of %i. I am running on %s\n", i, P, name);

    MPI_Finalize();
    return 0;
}
