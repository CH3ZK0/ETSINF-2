	.section	__TEXT,__text,regular,pure_instructions
	.macosx_version_min 10, 11
	.section	__TEXT,__literal8,8byte_literals
	.align	3
LCPI0_0:
	.quad	4614256673094690983     ## double 3.1415999999999999
	.section	__TEXT,__literal4,4byte_literals
	.align	2
LCPI0_1:
	.long	1092616192              ## float 10
	.section	__TEXT,__text,regular,pure_instructions
	.globl	_main
	.align	4, 0x90
_main:                                  ## @main
	.cfi_startproc
## BB#0:
	pushq	%rbp
Ltmp0:
	.cfi_def_cfa_offset 16
Ltmp1:
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
Ltmp2:
	.cfi_def_cfa_register %rbp
	subq	$16, %rsp
	leaq	L_.str(%rip), %rdi
	movsd	LCPI0_0(%rip), %xmm0    ## xmm0 = mem[0],zero
	movss	LCPI0_1(%rip), %xmm1    ## xmm1 = mem[0],zero,zero,zero
	movss	%xmm1, -8(%rbp)
	movss	-8(%rbp), %xmm1         ## xmm1 = mem[0],zero,zero,zero
	mulss	-8(%rbp), %xmm1
	cvtss2sd	%xmm1, %xmm1
	mulsd	%xmm1, %xmm0
	cvtsd2ss	%xmm0, %xmm0
	movss	%xmm0, -4(%rbp)
	cvtss2sd	-8(%rbp), %xmm0
	cvtss2sd	-4(%rbp), %xmm1
	movb	$2, %al
	callq	_printf
	xorl	%ecx, %ecx
	movl	%eax, -12(%rbp)         ## 4-byte Spill
	movl	%ecx, %eax
	addq	$16, %rsp
	popq	%rbp
	retq
	.cfi_endproc

	.section	__TEXT,__cstring,cstring_literals
L_.str:                                 ## @.str
	.asciz	"Area del circulo de radio %f es %f\n"


.subsections_via_symbols
