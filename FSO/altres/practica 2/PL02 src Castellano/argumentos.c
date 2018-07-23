#include <stdio.h>

int main(int argc, char *argv[]) {  
 
    for(int i=0; i<argc; i++){
		printf("El argumento %d es: %s\n", i, argv[i]);
	} 
}

