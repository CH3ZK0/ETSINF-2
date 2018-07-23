                ##########################################################
                # Segmento de datos
                ##########################################################

                .data 0x10000000
reloj:          .word 0                # HH:MM:SS (3 bytes de menor peso)

cad_asteriscos: .asciiz "\n  **************************************"
cad_asteriscos_int: .asciiz "\n  ************************************** \n"
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
                # Multiplicacions
				li $a1, 2
				jal multiplicar_per_36
				
				li $a1, 2
				jal multiplicar_per_31
				
				########################################################## 
                # rellotge en segons sumes
				la $a0, reloj
				li $a1, 0x0012202D
				jal inicialitza_rellotge
				
				la $a0, reloj
				jal torna_rellotge_en_s_sd
				
                jal imprime_s
				
				########################################################## 
                # rellotge en segons sumes restes
				la $a0, reloj
				li $a1, 0x0012202D
				jal inicialitza_rellotge
				
				la $a0, reloj
				jal torna_rellotge_en_s_sdr
				
                jal imprime_s
				
				########################################################## 
                # Passar segons
				la $a0, reloj
				li $a1, 0x00173b3b # Hora 23:59:59
				jal inicialitza_rellotge
				
				la $a0, reloj
				jal imprime_reloj
				
				la $a0, reloj
				jal pasa_segon # Incrementa el reloj en un segon
				
				la $a0, reloj
				jal imprime_reloj
				
				la $a0, reloj
				jal pasa_segon # Incrementa el reloj en un segon
				
				la $a0, reloj
				jal imprime_reloj
				
				########################################################## 
                # Incrementar 3:40
				la $a0, reloj
				li $a1, 0x00150F2D # Hora 21:15:45
				jal inicialitza_rellotge
				
				la $a0, reloj
				jal imprime_reloj
				
				la $a0, reloj
				jal incrementar_3_40
				
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
                # Subrutina que incrementa el reloj en un segon
                # Entrada: $a0 con la dirección del reloj
                # Salida: reloj incrementado en memoria
                # Nota: HH:MM:59 -> HH:MM:00
                ########################################################## 
                
pasa_segon:     
				lbu $t0, 0($a0)         # $t0 = SS
				addiu $t0, $t0, 1       # $t0 = SS++
                li $t1, 60
                beq $t0, $t1, S60       # Si SS==60 se pone SS a cero
				
                sb $t0, 0($a0)          # Escribe SS++
                j fin_pasa_hora
				
S60:            sb $zero, 0($a0)        # Escribe SS a 0
				
				lbu $t0, 1($a0)         # $t0 = MM
				addiu $t0, $t0, 1       # $t0 = MM++
                li $t1, 60
                beq $t0, $t1, M60       # Si MM==60 se pone MM a cero
				
                sb $t0, 1($a0)          # Escribe MM++
                j fin_pasa_hora
				
M60:            sb $zero, 1($a0)        # Escribe MM a 0
				
				lbu $t0, 2($a0)         # $t0 = HH
                addiu $t0, $t0, 1       # $t0 = HH++
                li $t1, 24
                beq $t0, $t1, H00       # Si HH==24 se pone HH a cero
                
				sb $t0, 2($a0)          # Escribe HH++
                j fin_pasa_hora
				
H00:            sb $zero, 2($a0)        # Escribe HH a 0
fin_pasa_segon: 
				jr $ra

                ########################################################## 
                # Subrutina que incrementa el reloj en un minut
                # Entrada: $a0 con la dirección del reloj
                # Salida: reloj incrementado en memoria
                # Nota: HH:59:SS -> HH:00:SS
                ########################################################## 
                
pasa_minuts:
				lbu $t0, 1($a0)         # $t0 = MM
				addiu $t0, $t0, 1       # $t0 = MM++
                li $t1, 60
                beq $t0, $t1, MI60       # Si MM==60 se pone MM a cero
				
                sb $t0, 1($a0)          # Escribe MM++
                j fin_pasa_minuts
				
MI60:            sb $zero, 1($a0)        # Escribe MM a 0
				
				lbu $t0, 2($a0)         # $t0 = HH
                addiu $t0, $t0, 1       # $t0 = HH++
                li $t1, 24
                beq $t0, $t1, HI00       # Si HH==24 se pone HH a cero
                
				sb $t0, 2($a0)          # Escribe HH++
                j fin_pasa_minuts
				
HI00:            sb $zero, 2($a0)        # Escribe HH a 0
fin_pasa_minuts: 
				jr $ra
				########################################################## 
                # inicialitza rellotge
inicialitza_rellotge:
				#li $t1, 0x000000FF
				#and $a2, $t1, $a1
				
				#li $t4, 60
				#blt $t4, $a2, salir  
				
				#li $t1, 0x0000FF00
				#and $a2, $t1, $a1
				
				#blt $t4, $a2, salir  
				
				#li $t1, 0x00FF0000
				#and $a2, $t1, $a1
				
				#li $t5, 24
				#blt $t5, $a2, salir  
				
				sw $a1, 0($a0)
fin_inicialitza_rellotge:
				jr $ra
				
				########################################################## 
                # pasar a segons 2
torna_rellotge_en_s:
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
				
torna_rellotge_en_s_fin:
				jr $ra
				
				########################################################## 
                # pasar a segons 2
torna_rellotge_en_s_sd:
				lbu $a1, 2($a0)
				
				sll $t1, $a1, 11
				sll $t2, $a1, 10
				addu $t1, $t1, $t2
				sll $t2, $a1, 9
				addu $t1, $t1, $t2
				sll $t2, $a1, 4
				addu $a1, $t1, $t2
				
				lbu $a2, 1($a0)
				
				sll $t1, $a2, 5
				sll $t2, $a2, 4
				addu $t1, $t1, $t2
				sll $t2, $a2, 3
				addu $t1, $t1, $t2
				sll $t2, $a2, 2
				addu $a2, $t1, $t2
				
				lbu $a3, 0($a0)
				
				addu $a0, $a1, $a2
				addu $a0, $a0, $a3
				
				move $v0, $s1
				
torna_rellotge_en_s_sd_fin:
				jr $ra
				
				########################################################## 
                # pasar a segons am booth
torna_rellotge_en_s_sdr:
				lbu $a1, 2($a0)
				
				sll $t1, $a1, 11
				sll $t2, $a1, 10
				addu $t1, $t1, $t2
				sll $t2, $a1, 9
				addu $t1, $t1, $t2
				sll $t2, $a1, 4
				addu $a1, $t1, $t2
				
				lbu $a2, 1($a0)
				
				sll $t1, $a2, 6
				sll $t2, $a2, 2
				subu $a2, $t1, $t2
				
				lbu $a3, 0($a0)
				
				addu $a0, $a1, $a2
				addu $a0, $a0, $a3
				
				move $v0, $s1
				
torna_rellotge_en_s_sdr_fin:
				jr $ra
				
				########################################################## 
                # $a0 * 36
multiplicar_per_36:
				sll $t1, $a1, 5
				sll $t2, $a1, 2
				addu $a1, $t1, $t2
				
				la $a0, cad_asteriscos_int  # Dirección de la cadena
                li $v0, 4               # Código de print_string
                syscall
				
				move $a0, $a1
                li $v0, 1
                syscall
				
				la $a0, cad_asteriscos  # Dirección de la cadena
                li $v0, 4               # Código de print_string
                syscall
				
multiplicar_per_36_fin:
				jr $ra
				
				########################################################## 
                # $a0 * 31 amb booth
multiplicar_per_31:
				sll $t1, $a1, 5
				subu $a1, $t1, $a1
				
				la $a0, cad_asteriscos_int  # Dirección de la cadena
                li $v0, 4               # Código de print_string
                syscall
				
				move $a0, $a1
				li $v0, 1
                syscall
				
				la $a0, cad_asteriscos  # Dirección de la cadena
                li $v0, 4               # Código de print_string
                syscall
				
multiplicar_per_31_fin:
				jr $ra
				
incrementar_3_40:
				li $t1, 3
				li $t0, 0
				
H:				lbu $t0, 2($a0)         # $t0 = HH
                addiu $t0, $t0, 1       # $t0 = HH++
                li $t1, 24
                beq $t0, $t1, HO24       # Si HH==24 se pone HH a cero
                sb $t0, 2($a0)          # Escribe HH++
                j fin_pasa_hora
HO24:           sb $zero, 2($a0)        # Escribe HH a 0
				jr $ra
				addiu $t0, $t0, 1
				bne $t0, $t1, H
				
				li $t1, 40
				li $t0, 0
				la $a0, reloj
				
S:				jal pasa_minuts
				addiu $t0, $t0, 1
				bne $t0, $t1, S
				
incrementar_3_40_fin:
				jr $ra