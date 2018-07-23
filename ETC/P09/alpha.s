         .globl __start
          .data 0x10000000
alpha: .asciiz"á"
          
          .text 0x00400000
__start:  lbu $t0, alpha
		  