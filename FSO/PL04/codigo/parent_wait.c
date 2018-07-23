/* my_child.c */
#include <stdio.h>
#include <stdlib.h>

int main(int argc, char *argv[]){
	
	int res;
	
	printf("Parent process %ld\n", (long)getpid());
	
	for(int i=0; i<5; i++){
		
		res = fork();
		if(res == 0){
			printf("Fill creat en iteracio = %d\n", i);
			sleep(10);
			exit((long)getpid());
		}
	}
	
	wait();
	return 0;
}
