/**
* Programa d'exemple "Hola món" amb pthreads.
* Per a compilar teclegeu:
*
gcc hola.c -lpthread -o hola
*/

#include <stdio.h>
#include <pthread.h>
#include <unistd.h>

void *Imprimeix( void *ptr )
{

	char *missatge;
	missatge=(char*)ptr;
	sleep(2);
	//EXERCICI1.b
	write(1,missatge,strlen(missatge));
}
int main()
{

	pthread_attr_t atrib;
	pthread_t fil1, fil2;

	pthread_attr_init( &atrib );

	pthread_create( &fil1, &atrib, Imprimeix, "Hola \n");
	pthread_create( &fil2, &atrib, Imprimeix, "món \n");

	//EXERCICI1.a
	  sleep(1);
	//pthread_exit(0);
	//pthread_exit(0);
	//pthread_join( fil1, NULL);
	//pthread_join( fil2, NULL);
}
