                .globl __start
                .text 0x00400000

__start:        li $v0, 7               # Función read_int
                syscall
				mtc1 $v0, $f2   
                li $t0, 23325902       # Constante DNI
				mtc1 $t0, $f2
				cvt.d.w $f2, $f2
				mul.d $f12, $f2, $f0 
				li $v0, 3               # Funció print_float
				syscall
				li $v0, 10
				syscall
                .end
