#!/bin/bash
sbatch --partition=Centaurus  --time=00:05:00 --nodes=4 --ntasks-per-node=1 --job-name=mpimatvec ./matvec.sh
