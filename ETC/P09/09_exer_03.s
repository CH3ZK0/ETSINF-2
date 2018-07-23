          .globl __start
          .data 0x10000000
demana:   .asciiz "Escriviu-me alguna cosa: "
demana2:  .asciiz "Heu escrit: "
demana3:  .asciiz "La longitud es: "
cadena:   .space 80             

          .text 0x00400000
__start:  la $a0, demana        
          la $a1, cadena		  
          li $a2, 80            
          jal InputS
		  la $a0, demana2
		  la $a3, cadena
          jal PromptS
		  la $a0, demana3
          jal StrLength		  
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
		  move $a0, $a3
		  li $v0, 4
		  syscall
		  jr $ra
		  
StrLength: li $v0, 4
		   syscall
     	   la $s0, cadena
           li $s1, 0
bucle:     lb $t0, 0($s0)
		   beqz $t0, Fin
		   addi $s1, $s1, 1
		   addi $s0, $s0, 1
		   j bucle		   
Fin:       move $a0,$s1
           li $v0,1
           syscall
		   jr $ra
		   
           
		   
		   
           	