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
    char* arguments[] = {"ls", "-R", "/", NULL};

    childpid = fork();
    if (childpid == -1) {
        fprintf(stderr, "fork failed \n");
        exit(1);
        
    } else if (childpid == 0) {
    	
    	if(strcmp(argv[1], "ps") == 0 && argc == 2){
    		
		    if (execl("/bin/ps", argv[1], NULL) < 0) {
		        fprintf(stderr, "Could not execute ls \n");
		        exit(1);
		    }
		}else if(strcmp(argv[1], "ps") == 0){
			
			 if (execl("/bin/ps", argv[1], argv[2], NULL) < 0) {
		        fprintf(stderr, "Could not execute ls \n");
		        exit(1);
		    }
		}else if(strcmp(argv[1], "ls") == 0 && argc == 2){
			
			 if (execl("/bin/ls", argv[1], NULL) < 0) {
		        fprintf(stderr, "Could not execute ls \n");
		        exit(1);
		    }
		}else if(strcmp(argv[1], "ls") == 0){
			
			 if (execl("/bin/ls", argv[1], argv[2], NULL) < 0) {
		        fprintf(stderr, "Could not execute ls \n");
		        exit(1);
		    }
		}
    }
    
    x = wait(&status);
    if (x != childpid)
        fprintf(stderr, "Child has been interrupted by a signal \n");
    exit(0);
}
