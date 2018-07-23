#include <stdio.h>

int main(int argc, char *argv[]) {   
     
	for(int i=0; i<argc; i++){
		
		if(strcmp(argv[i], "-C") == 0 ){
			printf("-C es compilar\n");
			
		}
        
        if(strcmp(argv[i], "-E") == 0 ){
			printf("-E es preprocesar\n");
			
		}
        
        if(strcmp(argv[i], "-I") == 0 ){
			printf("Incluir %c\n",  &argv[i]);
			
		}
	}
}

