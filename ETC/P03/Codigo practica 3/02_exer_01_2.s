          .data 0x10000000	  
		  .globl __start
          .text 0x00400000
		  
__start:  
		  la $a0,'M'
		  jal Input
		  move $a2,$v0
		  
		  la $a0,'C'
		  jal Input
		  move $a1,$v0
		  
		  move $a0,$a2
		  jal Mult
		  move $a1,$v0
		  
		  jal Prompt
		  
		  li $v0,10
          syscall
	
Mult:     li $v0, 0
          beqz $a1, MultRet
		  
MultFor:  add $v0, $v0, $a0
          addi $a1, $a1, -1
          bne $a1, $zero, MultFor
		  
MultRet:  jr $ra

Input:  
		li $v0,11
		syscall
		
		li $a0,'='
		li $v0,11
		syscall
		
		li $v0,5
        syscall
		jr $ra
		
Prompt: 
		li $a0,'R'
		li $v0,11
		syscall
		
		li $a0,'='
		li $v0,11
		syscall
		
		move $a0,$a1
		li $v0,1
		syscall
		