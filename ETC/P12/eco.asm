### PROGRAMA BASE PRACTICAS DE ENTRADA/SALIDA MIPS R2000

#-------------------------------------------------#
#
#  PRÁCTICA 12: SINCRONIZACIÓN POR PRUEBA DE ESTADO
# 
#-------------------------------------------------#

# ACTIVIDAD 3:  Completar las funciones:
#    char getchar() - obtiene el carácter del teclado
#    void putchar(char c) - imprime un carácter por la consola

# Segmento de datos

	.data		

#-------------------------------------------------#

# Segmento de código ("text")
	.text
    	.globl __start	



__start:			

	li $a0, 'P'		# 
	jal putchar		# putchar('P')
	li $a0, '1'		# 
	jal putchar		# putchar('1')
	li $a0, '2'		# 
	jal putchar		# putchar('2')
	li $a0, 13		# carácter de retorno ('\n')
	jal putchar		# putchar('\n')
	
bucle:
	jal getchar		# $v0 = getchar()
	move $a0, $v0		#
	li $t0, 0x1b      	# detecto ESC (0x1b = 27)
	beq $a0, $t0, fin
	jal putchar		# putchar($a0)
	b bucle
fin:	
	li $v0, 10
	syscall			# exit
	
	
	
getchar:			# $v0 = getchar()
### A COMPLETAR: código de la función




###
	jr $ra


putchar:			# putchar($a0)
### A COMPLETAR: código de la función




###
	jr $ra
