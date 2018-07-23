#include <stdio.h>
#include <string.h>

int main(int argc, char *argv[]) {   
     
	for(int i=0; i<argc; i++){
		
		if(strcmp(argv[i], "-C") == 0 ){
			printf("%s es compilar\n", argv[i]);
			
		}
        
        if(strcmp(argv[i], "-E") == 0 ){
			printf("%s es preprocesar\n", argv[i]);
			
		}
        
        printf("Muestra %s \n", substr(argv[i], 1));
        
        if(strcmp(substr(argv[i], 1), "-I") == 0 ){
			printf("Incluir %c\n",  &argv[i]);
			
		}
	}
}

