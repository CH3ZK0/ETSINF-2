/* change_memory1.c */
#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <unistd.h>

int main(int argc, char *argv[])
{
    pid_t childpid;
    int status, x;
  //  char* arguments[] = {"ls", "-R", "/", NULL};

    childpid = fork();
    if (childpid == -1) {
        fprintf(stderr, "fork failed \n");
	sleep(10); 
        exit(1);
    } else if (childpid == 0) {
//for(int i=1; i<argc ;i++){	
        if (execvp(argv[1],&argv[1]) < 0) {
            fprintf(stderr, "Could not execute ls \n");
            exit(1);
	//}
//printf("num variable %d \n " , i); 
        }

	/*execl("/bin/ps", "ps",  "-l"," > ","/home/fernando/Escritorio/Practicas/fso_pract4/halo.txt" , NULL);*/
	//printf("MOstrar");	
	//printf("ps -l");
//sleep(10);     
	}
//sleep(10); 
    x = wait(&status);
    if (x != childpid)
        fprintf(stderr, "Child has been interrupted by a signal \n");    
exit(0);
}
