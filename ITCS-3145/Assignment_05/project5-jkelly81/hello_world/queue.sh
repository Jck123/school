#!/bin/bash

sbatch --partition=Centaurus  --time=00:05:00 --nodes=1 --ntasks-per-node=16 --job-name=mpihello ./hello.sh
sbatch --partition=Centaurus  --time=00:05:00 --nodes=2 --ntasks-per-node=8 --job-name=mpihello ./hello.sh
sbatch --partition=Centaurus  --time=00:05:00 --nodes=4 --ntasks-per-node=8 --job-name=mpihello ./hello.sh

