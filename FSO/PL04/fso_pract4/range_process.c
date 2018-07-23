#include <stdio.h>
#include <stdlib.h>
int main(){
int val_return;
for(int i=0; i<5;i++){
	val_return = fork();
	if(val_return==0){
		printf("Fill creat en la iteració=%d\n",i);
		exit(i);	
	}
	//sleep(10);
	sleep(5);
}
	exit(0);
	return 0;
}
