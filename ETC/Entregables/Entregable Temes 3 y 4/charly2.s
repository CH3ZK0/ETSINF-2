		  .globl __start
          .text 0x00400000
__start:  li $a0, 10
          jal Mult
		  move $a0, $v0 
		  li $v0, 1
		  syscall
          li $v0,10
          syscall
		  
Mult:     sll $t0, $a0, 8
          sll $t1, $a0, 6
		  sll $t2, $a0, 4
		  sll $t3, $a0, 0
		  addu $v0, $v0, $t0
		  addu $v0, $v0, $t1
		  addu $v0, $v0, $t2
		  addu $v0, $v0, $t3
		  jr $ra