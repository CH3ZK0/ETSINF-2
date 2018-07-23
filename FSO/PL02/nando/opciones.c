#include <stdio.h>
//#include <string.h>
int main(int argc, char *argv[])
{

	for(int i=1; i<argc ;i++){
		//char param = argv[i];
		if(strcmp(argv[i],"-c")==0){
			printf("Argumento %d es Compilar \n",i);			
		}else if(strcmp(argv[i],"-E")==0){
			printf("Argumento %d es Preprocesar \n",i);			
		}else{

			printf("Argumento %d es %s \n",i,substr(argv[i], 6));			
		}

		
		
	}
}

