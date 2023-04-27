#!/bin/bash

sbatch --partition=Centaurus  --time=00:05:00 --nodes=2 --ntasks-per-node=1 --job-name=mpipingpong ./pingpong.sh
