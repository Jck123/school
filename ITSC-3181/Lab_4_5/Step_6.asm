.globl main
.data
	arr: .space 400
	arr2:.space 400
	str: .ascii "arr value[4]: \0"
	str2: .ascii "\narr2 value[4]: \0"
	aFloat: .float 0.1234
	aDouble: .double 0

.text
main:
	la s0, arr
	la s1, arr2
	li t0, 0
	li t1, 400
	li t6, 100
loop1:
	rdcycle t2
	rdtime t3
	div t3, t3, t2
	rdinstret t2
	div t3, t3, t2
	rem t2, t3, t6
	add t4, t0, s0
	sw t2, (t4)
	addi t0, t0, 4
	bne t0, t1, loop1

	li t0, 0
	la s2, aFloat
	la s3, aDouble
	flw f2, (s2)
	fcvt.d.s f2, f2

loop2:
	fld f1, (s3)
	li t2, 0
	beq t0, t1, exit

loop3:
	add t3, s0, t2
	lw t4, (t3)
	fcvt.d.w f5, t4
	fmul.d f0, f2, f5
	fadd.d f1, f1, f0
	addi t2, t2, 4
	ble t2, t0, loop3
	fcvt.w.d t3, f1
	add t4, s1, t0
	sw t3, (t4)
	addi t0, t0, 4
	b loop2

exit:
	lw t0, 16(s0)
	lw t1, 16(s1)

	la a0, str
	li a7, 4
	ecall
	
	mul a0, zero, zero
	add a0, zero, t0
	li a7, 1
	ecall

	la a0, str2
	li a7, 4
	ecall

	mul a0, zero, zero
	add a0, zero, t1
	li a7, 1
	ecall

	li a7, 10
	ecall