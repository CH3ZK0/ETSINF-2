### PROGRAMA BASE PRACTICAS DE ENTRADA/SALIDA MIPS R2000

#-------------------------------------------------#
#
#  PRÁCTICA 12: SINCRONIZACIÓN POR PRUEBA DE ESTADO
# 
#-------------------------------------------------#

# ACTIVIDAD 2:  Añade la instrucción que lee el registro de datos
#               del teclado en el lugar indicado:


#------- Segmento de datos ---------#
	.data		
T1:	.asciiz "Esperando...\n"
T2:	.asciiz "\nFin\n"

#------- Segmento de código ---------#
	.text
    	.globl __start	

__start:
	# Escribe en consola mensaje T1
	li $v0, 4
	la $a0, T1
	syscall	
	
	# Carga dir base teclado
	la $t0, 0xffff0000

espera: # Espera bit R == 1
	lw $t1,0($t0)
	andi $t1,$t1,1
	beqz $t1,espera

### A COMPLETAR: lee el registro de datos del teclado
####	

	#quan llegim un registre pcspim posa el bit R a 0 altra vegada#
	lw $t2,4($t0)#carrega les dades llegides del segment de dades del teclat en $t2#
	
	li $a1, 46 #carrega el punt#
	li $a2, 44 #carrega la coma#
	
	move $a0, $t2 #imprimeix el caracter que hem llegit que es guarda en $t2#
	li $v0, 1
	syscall
	
	move $a0, $a2 #imprimeix el caracter que hem guardat en $a2 que es la coma#
	li $v0, 11 
	syscall
	
	bne $a1, $t2, espera

	# Escribe en consola mensaje T2
	li $v0, 4
	la $a0, T2
	syscall

	# exit
	li $v0, 10
	syscall			

	.end