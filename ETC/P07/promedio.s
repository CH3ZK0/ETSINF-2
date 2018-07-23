                ##########################################################
                # Segmento de datos
                ##########################################################

                .data 0x10000000
dimension:      .word 4
valores:        .float 2.3, 1.0, 3.5, 4.8
pesos:          .float 0.4, 0.3, 0.2, 0.1
media_s:        .float  0.0
media_d:        .double 0.0

                ##########################################################
                # Segmento de c�digo
                ##########################################################

                .globl __start
                .text 0x00400000

__start:        la $t0, dimension      # Direcci�n de la dimensi�n
                lw $t0, 0($t0)         # Lectura de la dimensi�n
                mtc1 $t0, $f4          # Lleva la dimensi�n a $f4
                la $t1, valores        # Direcci�n de los valores       
                mtc1 $zero, $f0        # Lleva 0.0 a $f0

bucle:          lwc1 $f6, 0($t1)       # Lee valor[i]
                add.s $f0, $f0, $f6    # Suma del valor
                addiu $t1, $t1, 4      # Direcci�n de valor[i+1] 
                addiu $t0, $t0, -1     # Decrementa contador
                bgtz $t0, bucle        

                cvt.s.w $f4, $f4       # Convierte dimension a real
                div.s $f0, $f0, $f4    # Calcula media aritm�tica
                cvt.d.s $f2, $f0       # Convierte a doble precisi�n
                la $t0, media_s        # Direcci�n del resultado media_s
                swc1 $f0, 0($t0)       # Escribe resultado simple precisi�n
                la $t0, media_d        # Direcci�n del resultado media_d
                swc1 $f2, 0($t0)       # Escribe parte baja doble precisi�n
                swc1 $f3, 4($t0)       # Escribe parte alta doble precisi�n
 
                ########################################################
                # Finalizaci�n del programa 
                # Llamada al sistema denominada "exit"
                ########################################################= 

                li $v0, 10
                syscall
                .end
