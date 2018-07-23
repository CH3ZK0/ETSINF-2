          .globl __start
          .data 0x10000000
demana:   .asciiz "Escriviu-me alguna cosa: "
cadena:   .space 80
tornar:   .asciiz "Heu escrit: "
valor:	  .asciiz "Quin numero? "
escriure: .asciiz "Valor n-essim: "

          .text 0x00400000
__start:  la $a0, demana        
          la $a1, cadena        
          li $a2, 80            
          jal InputS  
		  la $a0, tornar 
		  jal PromptS
		  la $a0, valor
		  li $v0, 4
		  syscall
		  li $v0, 5
		  syscall
		  move $s3, $v0
		  li $v0, 0
		  la $s2, cadena
		  jal StrChar
          li $v0,10
          syscall

InputS:   li $v0, 4
          syscall
          li $v0, 8
          move $a0, $a1
          move $a1, $a2
          syscall
          jr $ra
		  
PromptS:  li $v0, 4
		  syscall
          li $v0, 4
          la $a0, cadena
          syscall
          jr $ra
		  
StrChar:		   
		   lbu $s1, 0($s2)
		   beq $s3,$v0, Fi 
		   addiu $v0,$v0,1
		   addiu $s2,$s2,1
		   bne $s1,$zero, StrChar
		Fi: 
		   la $a0, escriure 
		   li $v0, 4
		   syscall
		   move $a0, $s1
		   li $v0, 11
		   syscall
		   jr $ra
		   
		  

