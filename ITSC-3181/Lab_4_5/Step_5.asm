.globl main
.data
	arr: .space 400
	str: .ascii "Average: "
	
.text
main:
	la s0, arr
	li t1, 0
	li t2, 400
	li t6, 100
loop1:
	rdcycle t4
	rdtime t5
	div t5, t5, t4
	rdinstret t4
	div t5, t5, t4
	rem t4, t5, t6
	add t3, t1, s0
	sw t4, (t3)
	addi t1, t1, 4
	bne t1, t2, loop1
	
	li t1, 0
	li t5, 0
loop2:
	add t3, t1, s0
	lw t4, (t3)
	add t5, t5, t4
	addi t1, t1, 4
	bne t1, t2, loop2
	
	div t5, t5, t6
	
	la a0, str
	li a7, 4
	ecall
	
	add a0, zero, t5
	li a7, 1
	ecall
	
	li a7, 10
	ecall
