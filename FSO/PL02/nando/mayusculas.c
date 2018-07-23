#include <stdio.h>
#define TAM_CADENA 200
main(){
	char *p1, *p2;	
	
	char cadena1[TAM_CADENA];
	char cadena2[TAM_CADENA];
	
	

	printf("Dona'm una cadena: \n");
	scanf("%[^\n]s",cadena1);
	p1=cadena1;
	p2=cadena2;
	while(*p1 != '\0'){
		if(*p1 >= 97 && *p1 <= 122){
			*p2 == *p1-32;	
		}else{
			*p2=*p1;
		}
		p1++;
		p2++;
	}
	*p2='\0';
	printf("La cadena nueva es: %s\n",p2);
	
}

