// dos_tubos.c
//Carlos Herrero Barbera
//Manel Lurbe Sempere

#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>

int main (int argc,char *argv[]) {
    int i, fd;
    
    char* arguments1 [] = { "ls", "-la", 0 };
    char* arguments2 [] = { "grep", "ejemplo", 0 };
    char* arguments3 [] = { "wc", "-l", 0 };
    
    mode_t fd_mode = S_IRWXU;// file premissions
    fd = open("result.txt" ,O_WRONLY | O_CREAT, fd_mode);
    
    int fildes1[2];
    int fildes2[2];
    
    pid_t pid;
    
    // Parent process creates a pipe
    if ((pipe(fildes1)==-1)) { 
        fprintf(stderr,"Pipe 1 failure  \n");
        exit(-1);
    }
    
    if ((pipe(fildes2)==-1)) { 
        fprintf(stderr,"Pipe 2 failure  \n");
        exit(-1);
    }
    
    for (i=0;i<3;i++) {	
        pid=fork(); // Creates a child process
        if ((pid==0) && (i==0)) {
            // Child process redirects its output to the pipe
            if (dup2(fildes1[1], STDOUT_FILENO) == -1) { 
                printf("Error calling dup2\n");
                exit(-1);
            }
            
            // Child process closes file descriptors
            close(fildes1[0]);
            close(fildes1[1]);
            close(fildes2[0]);
            close(fildes2[1]);
            close(fd);
		  
		        // Child process changes its memory image
            if ( execvp("ls",arguments1)<0) { 
                fprintf(stderr,"ls not found \n");
                exit(-1);
            }
            
        } else if ((pid==0) && (i==1)) {
            // Child process redirects its input to the pipe
            if (dup2(fildes1[0], STDIN_FILENO) == -1 || dup2(fildes2[1], STDOUT_FILENO) == -1) { 
                printf("Error calling dup2\n");
                exit(-1);
            }
            
	          // Child process closses pipe descriptors
            close(fildes1[0]);
            close(fildes1[1]);
            close(fildes2[0]);
            close(fildes2[1]);
            close(fd);
            
		        // Child process changes its memory image
            if (execvp("grep",arguments2)<0) {
                fprintf(stderr,"grep not found \n");
                exit(-1);
            }   
        }else if ((pid==0) && (i==2)) {
            // Child process redirects its input to the pipe
            if (dup2(fildes2[0], STDIN_FILENO) == -1 || dup2(fd, STDOUT_FILENO) == -1) { 
                printf("Error calling dup2\n");
                exit(-1);
            }
            
	          // Child process closses pipe descriptors
            close(fildes1[0]);
            close(fildes1[1]);
            close(fildes2[0]);
            close(fildes2[1]);
            close(fd);
            
		        // Child process changes its memory image
            if (execvp("wc",arguments3)<0) {
                fprintf(stderr,"wc not found \n");
                exit(-1);
            }   
        }
    }
	
    // Parent process closes pipe descriptors
    close(fildes1[0]);
    close(fildes1[1]);
    close(fildes2[0]);
    close(fildes2[1]);
    close(fd);
    for (i = 0; i < 3; i++) wait(NULL);
    return(0);
}
