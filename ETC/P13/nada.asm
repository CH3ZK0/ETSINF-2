### ESTRUCTURA DE COMPUTADORES (ETS Eng. Inf.)
###
### marzo de 2014
###
### PR�CTICA 13: SINCRONIZACI�N POR INTERRUPCIONES
###
### nada.asm (material de partida para la pr�ctica)

###################################################################
##                  DATOS DEL PROGRAMA USUARIO                   ##
###################################################################
	.data		
var2:	.word 0x77777777

###################################################################
##                  C�DIGO DEL PROGRAMA USUARIO                  ##
###################################################################
	.text

main:	jr $ra	# S�lo una instrucci�n

	.end