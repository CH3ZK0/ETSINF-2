/* my_child.c */
#include <stdio.h>
#include <stdlib.h>

int main(int argc, char *argv[]){
	
	int res, stat_loc, i;
	
	printf("Parent process %ld\nFill de: %ld\n"
		, (long)getpid(), (long)getppid());
	
	for(i=0; i<4; i++){
		
		res = fork();
		if(res == 0){
			printf("Fill creat en iteracio = %d\n", i);
			
		}else{ break;}
	}
	
	while(wait(&stat_loc) >= 0){
		printf("---------------------------\n");
		printf("Proces: %ld\n", (long)getpid());
		printf("Fill de: %ld\n", (long)getppid());
		printf("Mi hijo dice %d\n\n", WEXITSTATUS(stat_loc));
	}
	
	sleep(10);
	exit(i);
	return 0;
}
