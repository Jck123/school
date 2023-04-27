# Makefile for MPI program

# Compiler
CC = mpicc

# Compiler flags
CFLAGS = -Wall -Wextra -O2 -g 

# Target executable
TARGET = pingpong

# Source file
SRC = pingpong.c

# Object file
OBJ = $(SRC:.c=.o)

all: $(TARGET)

$(TARGET): $(OBJ)
	$(CC) $(CFLAGS) -o $@ $^

%.o: %.c
	$(CC) $(CFLAGS) -c $< -o $@

clean:
	rm -f $(OBJ) $(TARGET)

