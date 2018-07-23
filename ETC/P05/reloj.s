                ##########################################################
                # Segmento de datos
                ##########################################################

                .data 0x10000000
reloj:          .word 0                # HH:MM:SS (3 bytes de menor peso)

cad_asteriscos: .asciiz "\n  **************************************"
cad_horas:      .asciiz "\n   Horas: "
cad_minutos:    .asciiz " Minutos: "
cad_segundos:   .asciiz " Segundos: "
cad_reloj_en_s: .asciiz "\n   Reloj en segundos: "

                ##########################################################
                # Segmento de código
                ##########################################################

                .globl __start
                .text 0x00400000

__start:        la $a0, reloj
                jal imprime_reloj
				
				########################################################## 
                # inicialitza rellotge
				la $a0, reloj
				li $a1, 0x0002030c
				jal inicialitza_rellotge_2
				
				la $a0, reloj
                jal imprime_reloj
				
				########################################################## 
                # inicialitza rellotge per separat
				la $a0, reloj
				li $a1, 0x02
				li $a2, 0x03
				li $a3, 0x0c
				jal inicialitza_rellotge_alt
				
				la $a0, reloj
                jal imprime_reloj
				
				########################################################## 
                # inicialitza horo
				la $a0, reloj
				li $a1, 0x02
				jal inicialitza_rellotge_hh
				
				########################################################## 
                # inicialitza minuts
				la $a0, reloj
				li $a1, 0x03
				jal inicialitza_rellotge_mm
				
				########################################################## 
                # inicialitza segons
				la $a0, reloj
				li $a1, 0x0c
				jal inicialitza_rellotge_ss
				
				la $a0, reloj
                jal imprime_reloj
				
				########################################################## 
                # rellotge en segons
				la $a0, reloj
				li $a1, 0x0012202D
				jal inicialitza_rellotge_2
				
				la $a0, reloj
				jal torna_rellotge_en_s
				
                jal imprime_s
				
				########################################################## 
                # inicialityzar en segons
				la $a0, reloj
				li $a1, 66765
				jal inicialitza_relloge_en_s
				
				la $a0, reloj
                jal imprime_reloj
             
salir:          li $v0, 10              # Código de exit (10)
                syscall                 # Última instrucción ejecutada
                .end


                ########################################################## 
                # Subrutina que imprime el valor del reloj
                # Entrada: $a0 con la dirección de la variable reloj
                ########################################################## 

imprime_reloj:  move $t0, $a0
                la $a0, cad_asteriscos  # Dirección de la cadena
                li $v0, 4               # Código de print_string
                syscall

                la $a0, cad_horas       # Dirección de la cadena
                li $v0, 4               # Código de print_string
                syscall

                lbu $a0, 2($t0)         # Lee el campo HH
                li $v0, 1               # Código de print_int
                syscall

                la $a0, cad_minutos     # Dirección de la cadena
                li $v0, 4               # Código de print_string
                syscall

                lbu $a0, 1($t0)         # Lee el campo MM
                li $v0, 1               # Código de print_int
                syscall

                la $a0, cad_segundos    # Dirección de la cadena
                li $v0, 4               # Código de print_string
                syscall

                lbu $a0, 0($t0)         # Lee el campo SS
                li $v0, 1               # Código de print_int
                syscall

                la $a0, cad_asteriscos  # Dirección de la cadena
                li $v0, 4               # Código de print_string
                syscall
                jr $ra

                ########################################################## 
                # Subrutina que imprime los segundos calculados
                # Entrada: $a0 con los segundos a imprimir
                ########################################################## 

imprime_s:      move $t0, $a0
                la $a0, cad_asteriscos  # Dirección de la cadena
                li $v0, 4               # Código de print_string
                syscall


                la $a0, cad_reloj_en_s  # Dirección de la cadena
                li $v0, 4               # Código de print_string
                syscall

                move $a0, $t0           # Valor entero a imprimir
                li $v0, 1               # Código de print_int
                syscall

                la $a0, cad_asteriscos  # Dirección de la cadena
                li $v0, 4               # Código de print_string
                syscall
                jr $ra
                
                ########################################################## 
                # Subrutina que incrementa el reloj en una hora
                # Entrada: $a0 con la dirección del reloj
                # Salida: reloj incrementado en memoria
                # Nota: 23:MM:SS -> 00:MM:SS
                ########################################################## 
                
pasa_hora:      lbu $t0, 2($a0)         # $t0 = HH
                addiu $t0, $t0, 1       # $t0 = HH++
                li $t1, 24
                beq $t0, $t1, H24       # Si HH==24 se pone HH a cero
                sb $t0, 2($a0)          # Escribe HH++
                j fin_pasa_hora
H24:            sb $zero, 2($a0)        # Escribe HH a 0
fin_pasa_hora:  jr $ra

                ########################################################## 
                # inicialitza rellotge
inicialitza_rellotge:
				sw $a1, 0($a0)
fin_inicialitza_rellotge:
				jr $ra
				
                ########################################################## 
                # inicialitza rellotge per separat
inicialitza_rellotge_alt:
				sll $a1, $a1, 16
				sll $a2, $a2, 8
				
				add $a1, $a1, $a2
				add $a1, $a1, $a3
				sw $a1, 0($a0)
fin_inicialitza_rellotge_alt:
				jr $ra
				
                ########################################################## 
                # inicialitza horo
inicialitza_rellotge_hh:
				sb $a1, 2($a0)
				
fin_inicialitza_rellotge_hh:
				jr $ra

				########################################################## 
                # inicialitza minuts
inicialitza_rellotge_mm:
				sb $a1, 1($a0)
				
fin_inicialitza_rellotge_mm:
				jr $ra

				########################################################## 
                # inicialitza segons
inicialitza_rellotge_ss:
				sb $a1, 0($a0)
				
fin_inicialitza_rellotge_ss:
				jr $ra

				########################################################## 
                # inicialitza segons 2
inicialitza_relloge_2:
				li $t1, 0x000000FF
				and $a2, $t1, $a1
				
				li $t4, 60
				blt $t4, $a2, salir  
				
				li $t1, 0x0000FF00
				and $a2, $t1, $a1
				
				blt $t4, $a2, salir  
				
				li $t1, 0x00FF0000
				and $a2, $t1, $a1
				
				li $t5, 24
				blt $t5, $a2, salir  
				
				sw $a1, 0($a0)
				
inicialitza_relloge_2_fin:
                jr $ra
				
				########################################################## 
                # pasar a segons
torna_rellotge_en_s:
				lbu $a1, 2($a0)
				li $t1, 3600
				
				lbu $a2, 1($a0)
				li $t2, 60
				
				lbu $a3, 0($a0)
				
				mult $a1, $t1
				mflo $a1
				
				mult $a2, $t2
				mflo $a2
				
				addu $a0, $a1, $a2
				addu $a0, $a0, $a3
				
torna_rellotge_en_s_fin:
				jr $ra
				
				########################################################## 
                # pasar a segons 2
torna_rellotge_en_s_2:
				lbu $a1, 2($a0)
				li $t1, 3600
				
				lbu $a2, 1($a0)
				li $t2, 60
				
				lbu $a3, 0($a0)
				
				mult $a1, $t1
				mflo $a1
				mfhi $t0
				bgtz $t0, salir
				
				mult $a2, $t2
				mflo $a2
				mfhi $t0
				bgtz $t0, salir
				
				addu $a0, $a1, $a2
				addu $a0, $a0, $a3
				
				move $v0, $s1
				
torna_rellotge_en_s_2_fin:
				jr $ra
				
				########################################################## 
                # inicialityzar en segons
inicialitza_relloge_en_s:
				beqz $a1, salir
				li $t1, 60
				
				div $a1, $t1
				mfhi $a3
				mflo $t2
				
				beqz $t2, salir
				div $t2, $t1
				mfhi $a2
				mflo $a1
				
				sb $a3, 0($a0)
				sb $a2, 1($a0)
				sb $a1, 2($a0)
			
inicialitza_relloge_en_s_fin:
				jr $ra