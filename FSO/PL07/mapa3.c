#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

/*** Variables globales ***/
char path_maps[80];
char ni_glob[4096];
long i_glob=20;

void f(int param)
{
   printf("Direccion del parametro de la funcion f:        %10p\n",&param);
}

int main()
{
   /*** Variables locales ***/
   long i_loc=20;
   long ni_loc;
   int *vdin;

   printf("PID del proceso: %d\n\n", getpid());

   /**** VISUALIZACION DE DIRECCIONES ***/
   printf("Direccion de funcion main: %10p \n", main);
   printf("Direccion de funcion f:    %10p \n", f);
   printf("Direccion de var. global inicializada i_glob:   %10p\n", &i_glob);
   printf("Direccion de var. global NO inicializada ni_glob\n");
   printf("           dir. del primer elemento de ni_glob: %10p\n", &ni_glob[0]);
   printf("           dir. del ultimo elemento de ni_glob: %10p\n", &ni_glob[4095]);
   printf("Direccion de var. local inicializada i_loc:     %10p\n", &i_loc);
   printf("Direccion de var. local NO inicializada ni_loc: %10p\n", &ni_loc);
   f(40);

   printf("\n MAPA DE MEMORIA DEL PROCESO /proc/%d/maps \n", getpid());
   sprintf(path_maps,"cat /proc/%d/maps",getpid());
   fflush(stdout);
   system(path_maps);
   printf("            ---------------\n\n");

   /*** Reserva dinamica de memoria ***/
   vdin = (int *) malloc(100*sizeof(int));
   
   printf("Direccion del vector dinamico vdin: %p\n", vdin);
   printf("\n MAPA DE MEMORIA DEL PROCESO (despues de malloc)\n", getpid());
   sprintf(path_maps,"cat /proc/%d/maps",getpid());
   fflush(stdout);
   system(path_maps);
   printf("            ---------------\n\n");

   free(vdin);

   return 0;
}
