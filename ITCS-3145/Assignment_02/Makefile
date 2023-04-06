all: minions

minions: minions.c Makefile
	gcc -g -Wall -Wextra minions.c -o minions -pthread

clean:
	rm -f minions