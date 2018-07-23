	.file	"circulo.c"
	.section	.rodata
	.align 8
.LC2:
	.string	"Area del circulo de radio %f es %f\n"
	.text
	.globl	main
	.type	main, @function
main:
.LFB0:
	.cfi_startproc
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset 6, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register 6
	subq	$16, %rsp
	movss	.LC0(%rip), %xmm0
	movss	%xmm0, -8(%rbp)
	movss	-8(%rbp), %xmm0
	mulss	-8(%rbp), %xmm0
	cvtss2sd	%xmm0, %xmm0
	movsd	.LC1(%rip), %xmm1
	mulsd	%xmm1, %xmm0
	cvtsd2ss	%xmm0, %xmm2
	movss	%xmm2, -4(%rbp)
	cvtss2sd	-4(%rbp), %xmm1
	cvtss2sd	-8(%rbp), %xmm0
	movl	$.LC2, %edi
	movl	$2, %eax
	call	printf
	movl	$0, %eax
	leave
	.cfi_def_cfa 7, 8
	ret
	.cfi_endproc
.LFE0:
	.size	main, .-main
	.section	.rodata
	.align 4
.LC0:
	.long	1092616192
	.align 8
.LC1:
	.long	776530087
	.long	1074340351
	.ident	"GCC: (Ubuntu 5.4.0-6ubuntu1~16.04.2) 5.4.0 20160609"
	.section	.note.GNU-stack,"",@progbits
