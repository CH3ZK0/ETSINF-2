#include <stdio.h>
#include <stdlib.h>
int main(int argc, char *argv[]){
for(int i=0; i<5;i++){
int val_return;
	val_return = fork();
	if(val_return==0){
		printf("Fill creat en la iteració=%d\n",i);
		sleep(20);
		exit(i);	
	}
	sleep(10);
	
}
	exit(0);
	return 0;
}
