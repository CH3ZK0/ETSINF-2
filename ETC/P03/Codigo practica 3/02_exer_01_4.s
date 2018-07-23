          .data 0x10000000
A: .asciiz "A"		  
		  .globl __start
          .text 0x00400000
__start:  
while: 	bif(bnez $a0 && bnez $a1) endwhile
		  la $a1,077
		  li $a3,061
		  jal Input
		  move $a0,$v0
		  li $a2,081
		  jal Input
		  move $a1,$v0
		  jal Mult
		  move $a0,$v0
		  li $a2,082
		  li $a1,10
		  jal Prompt
		  li $v0,10
          syscall
		  while
endwhile
Mult:     li $v0, 0
          beqz $a1, MultRet
MultFor:  add $v0, $v0, $a0
          addi $a1, $a1, -1
          bne $a1, $zero, MultFor
MultRet:  jr $ra
Input: 	move $v0,$a2
		li $v0,11
		syscall
		move $v0,$a3
		li $v0,11
		syscall
		li $v0,5
        syscall
		jr $ra
Prompt: move $v0,$a2
		li $v0,11
		syscall
		move $v0,$a3
		li $v0,11
		syscall
		move $v0,$a0
		li $v0,1
		syscall
		move $v0,$a1
		li $v0,11
		syscall
		jr null
		
		


