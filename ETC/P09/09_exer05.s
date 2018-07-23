		  .globl __start
          .data 0x10000000
A:        .asciiz "A["
B:        .asciiz "B["
C:        .asciiz "C["
Final:    .asciiz "]="
Dimensio: .asciiz "D="
ValsA:	  .space 50
ValsB:	  .space 50


          .text 0x00400000
__start:  la $a0, Dimensio
          li $v0, 4
		  syscall
		  li $v0, 5
		  syscall
		  move $a1, $v0
		  move $a2, $v0
		  move $a3, $v0
		  la $t0, ValsA
		  li $t1, 0
		  jal InputA
		  li $t1, 0
		  la $t2, ValsB
		  jal InputB
		  li $t1, 0
		  la $t0, ValsA
		  la $t2, ValsB
		  jal PromptS
		  li $v0 ,10
		  syscall

InputA:beqz $a1,Fis
		  la $a0,A
		  li $v0, 4
      syscall
		  move $a0,$t1
		  li $v0, 1
      syscall
		  la $a0,Final
		  li $v0, 4
      syscall
      li $v0, 5
      syscall
		  move $a0, $v0
		  sb $a0, 0($t0)
		  addiu $t0,$t0,1
		  addiu $t1,$t1,1
		  addiu $a1, $a1, -1
		  j InputA
Fis:  jr $ra

InputB:beqz $a2, FIIn
		  la $a0,B
		  li $v0, 4
      syscall
		  move $a0,$t1
		  li $v0, 1
      syscall
		  la $a0,Final
		  li $v0, 4
      syscall
      li $v0, 5
      syscall
		  move $a0, $v0
		  sb $a0, 0($t2)
		  addiu $t1,$t1,1
		  addiu $t2,$t2,1
		  addiu $a2, $a2, -1
		  j InputB
FIIn: jr $ra

PromptS:  beqz $a3, Fi
					lbu $s0, 0($t0)
		  		lbu $s1, 0($t2)
		  		addu $s2, $s0, $s1
		  		la $a0,C
		  		li $v0, 4
          syscall
		  		move $a0,$t1
		  		li $v0, 1
          syscall
		  		la $a0,Final
		  		li $v0, 4
          syscall
		  		addu $t0,$t0,1
		  		addu $t2,$t2,1
		  		addu $t1,$t1,1
		  		move $a0,$s2
		  		li $v0, 1
    			syscall
		  		addu $a3,$a3,-1
		  		li,$a0, 13
		  		li $v0, 11
      		syscall
		  		j PromptS
Fi:				jr $ra
