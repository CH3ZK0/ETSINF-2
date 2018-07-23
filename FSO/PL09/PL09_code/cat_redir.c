// redir_output.c
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>

int main (int argc,char *argv[]) {
    int fd;

    fd = open("ls_salida.txt", O_RDONLY);
    if (dup2(fd, STDIN_FILENO) == -1) { 
        printf("Error calling dup2\n");
        exit(-1);
    }
    
    execl("/bin/cat", "cat", NULL);
    return(0);
}


