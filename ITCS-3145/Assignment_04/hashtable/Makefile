all: hashmap main

hashmap: hashmap.c Makefile
	gcc -Wall -Wextra -O3 -g hashmap.c -o hashmap -DHASHMAP_TEST

main: hashmap.c main.c Makefile
	gcc -Wall -Wextra -O3 -g main.c hashmap.c -o main -pthread

clean:
	rm -f main hashmap
