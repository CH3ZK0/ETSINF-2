	.globl __start
	
	.data 0x10000000
M:      .space 4
Q:		.space 4
R:		.space 4     
     
	.text 0x00400000
	
__start:li $a0,'M'
		la $a1, M
		jal InputV
		
		li $a0,'Q'
		la $a1, Q
		jal InputV

		la $a0, M
		la $a1, Q
		la $a2, R
		jal Mult

		la $a0, R
		jal PromptV

		li $v0,10
		syscall


InputV: li $v0, 11
		syscall

		li $v0, 11
		li $a0, '='
		syscall

		li $v0, 5
		syscall

		sw $v0, 0($a1)
		jr $ra

PromptV:move $s0, $a0

		li $a0, 'R'
		li $v0, 11
		syscall

		li $a0, '='
		li $v0, 11
		syscall

		lw $a0, 0($s0)
		li $v0, 1
		syscall

		jr $ra


Mult:	lw $s0, 0($a0)
		lw $s1, 0($a1)
		lw $s2, 0($a2)
		sw $zero, 0($a2)

		beqz $s0, MultRet
		beqz $s1, MultRet

		bltz $s0, THEN_M
		bltz $s1, THEN_Q

MultFor:add $s2, $s2, $s0
		addi $s1, $s1, -1

		bne $s1, $zero, MultFor

		sw $s2, 0($a2)
		jr $ra

THEN_M:	sub $s0, $zero, $s0

For_M:	add $s2, $s2, $s0
		addi $s1, $s1, -1

		bne $s1, $zero, For_M

		sub $s2, $zero, $s2
		sw $s2, 0($a2)

		jr $ra	

THEN_Q:	sub $s1, $zero, $s1

For_Q:	add $s2, $s2, $s0
		addi $s1, $s1, -1

		bne $s1, $zero, For_Q

		sub $s2, $zero, $s2
		sw $s2, 0($a2)

MultRet:jr $ra
