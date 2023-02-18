.data
str:
	.ascii "Total: "

.globl main
.text
main:
	li t0, 0
	li t1, 1
	li t2, 101
loop:
	add t0, t0, t1
	addi t1, t1, 1
	bne t1, t2, loop
	
	la a0, str
	li a7, 4
	ecall
	
	add a0, zero, t0
	li a7, 1
	ecall
	
	li a7, 10
	ecall