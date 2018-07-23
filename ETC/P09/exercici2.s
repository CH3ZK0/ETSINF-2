			.globl __start
			.data 0x10000000
demana:		.asciiz "Escriviu-me alguna cosa: "
escriu:		.asciiz "Heu escrit: "
longitud:	.asciiz "La longitud es: "
cadena:		.space 80

			.text 0x00400000
__start:	la $a0, demana        
			la $a1, cadena        
			li $a2, 80
			jal InputS
			
			la $a0, escriu        
			la $a1, cadena
			jal PromptS
			
			la $a0, longitud
			jal StrLength
			
			li $v0,10
			syscall


InputS:		li $v0, 4
			syscall
			
			li $v0, 8
			move $a0, $a1
			move $a1, $a2
			syscall
			
			jr $ra


PromptS:	li $v0, 4
			syscall
			
			li $v0, 4
			move $a0, $a1
			syscall

			jr $ra


StrLength:	li $s0, -1
			
bucle:		addiu $s0, $s0, 1
			lbu $s1, cadena($s0)
			bnez $s1, bucle
			
			li $s2, 1
			subu $s0, $s0, $s2
			
			li $v0, 4
			syscall
			
			li $v0, 1
			move $a0, $s0
			syscall
			
			jr $ra
