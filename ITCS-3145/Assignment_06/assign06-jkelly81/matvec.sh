#!/bin/bash
srun --mpi=pmix_v3 ./matvec 8192 1000
