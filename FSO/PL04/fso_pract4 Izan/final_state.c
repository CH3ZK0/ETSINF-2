#include <stdio.h>
#include <stdlib.h>
int i;
int final_state;
pid_t val_return;

int main(int argc, char *argv[]){
for(i=0; i<4;i++){

	val_return = fork();
	if(val_return==0){
		printf("Fill %ld creat en la iteració=%d\n",(long) getpid(),i);
printf("=================================================\n");
	}else{
		printf("Pare %ld, iteracio %d\n",(long) getpid(),i);
		printf("Jo je creat a %ld\n",(long) val_return);
printf("=================================================\n");
		break;
	}
}
	

	while(wait(&final_state)>=0){
		printf("Entra\n");
		printf("Pare %ld, iteracio %d\n",(long) getpid(),i);
		printf("El meu fill %d\n",WEXITSTATUS(final_state));
		printf("El meu fill %d\n", final_state/256);
	
	}
printf("=================================================\n");
	sleep(10);
	exit(i);
	exit(0);
	return 0;
}
