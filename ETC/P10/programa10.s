                ######################################################
		   # Segment de dades
                ######################################################

                .data 0x10000000
A:              .word 0,1,2,3,4,5,6,7   # Vector A
                .data 0x10001000
B:              .space 32               # Vector B (resultat)
                .data 0x1000A030
k:              .word 7                 # Constant escalar
dim:            .word 8                 # Dimensi� dels vectors

                ######################################################
		   # Segment de codi
                ######################################################

                .text 0x00400000
                .globl __start
                
__start:        la $a0, A               # $a0 = adre�a de A
		   la $a1, B               # $a1 = adre�a de B
		   la $a2, k               # $a1 = adre�a de k
		   la $a3, dim             # $a2 = adre�a dimensi�
		   jal sax                 # Crida a subrutina
                
                ######################################################
		   # Fi d�execuci� per mitj� de crida al sistema
                ######################################################

		   addi $v0, $zero, 10     # Codi per a exit
		   syscall                 # Fi de l�execuci�
                
                ######################################################
		   # Subrutina que calcula Y <- k*X 
		   # $a0 = Adre�a inici vector X
		   # $a1 = Adre�a inici vector Y
		   # $a2 = Adre�a constant escalar k
		   # $a3 = Adre�a dimensi� dels vectors                
                ######################################################

sax:            lw $a2, 0($a2)          # $a3 = constant k
		   lw $a3, 0($a3)          # $a3 = dimensi�
bucle:          lw $t0, 0($a0)          # Lectura de X[i] en $t0
		   mult $a2, $t0           # Efectua k*X[i]
		   mflo $t0                # $t0 <- k*X[i] (HI val 0)
		   sw $t0, 0($a1)          # Escriptura de Y[i] 
		   addi $a0, $a0, 4        # Adre�a de X[i+1]
		   addi $a1, $a1, 4        # Adre�a de Y[i+1]
		   addi $a3, $a3, -1       # Disminuci� n�mero elements
		   bgtz $a3, bucle         # Bota si queden elements
		   jr $ra                  # Retorn de subrutina
                
                .end
