#include <stdio.h>
//int a =0;
int inc_a(int a);
int valor_anterior(int v);
int inc_a(int a){

	a++;
return a;
}
int valor_anterior(int v){
	int temp;
	static int s;
	temp = s;
	s=v;
	return temp;
}
main(){
	int a=0;
	int b=2;
	inc_a(a);
	valor_anterior(b);
	printf("a= %d, b=%d\n", a, b);
	a++;
	b++;
	inc_a(a);
	b= valor_anterior(b);
	printf("a= %d, b=%d\n", a, b);
	
}
