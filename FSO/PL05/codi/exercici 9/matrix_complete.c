#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <string.h>

#define COLUMNES 80
#define FILERES 25

char m[FILERES][COLUMNES];
long retard[COLUMNES];
int filera_b[COLUMNES];

pthread_attr_t atrib;
pthread_t  fil_dibujador[COLUMNES];
pthread_t  fil_borrador[COLUMNES];
pthread_t  fil_refrescador;

void *Esborrador(void *ptr)
{
  int filera, col=(int)(long)ptr;
  for(filera=0;filera<FILERES;filera++){
    m[filera][col]= ' '; //Escriu un espai
    usleep(retard[col]); //Espera abans de l'esborrat següent
  }
}

void *Dibuixador(void *ptr)
{
	

  int filera, col=(int)(long)ptr;
 while(1){
  	retard[col]= 50000+rand()%450000; //Retard aleatori de caràcter, de 0,05s a 0,5s
	  if (rand()%10>4) //De tant en tant, no dibuixa la columna
	    usleep(retard[col]*FILERES); //Espera sense dibuixar
	  else{
	    for(filera=0;filera<FILERES;filera++){
		if(filera == FILERES/2){
		   pthread_create( &fil_borrador[col], &atrib, Esborrador, (void*)(long) col);
		}
	      //filera_b[col] = filera;
	      m[filera_b[col]=filera][col]= 32+rand()%94; //Escriu nou caràcter aleatori
	      usleep(retard[col]); //Espera abans del carácter següent		
	    }
		pthread_join(fil_borrador[col], NULL);
	  }
 }
}

void *RefrescadorDePantalla(void *ptr)
{
  int filera, col;
  char ordre[20];
  while(1){
    write(1,"\033[1;1f\033[1;40;32m",16); //Volver a esquina superior izquierda, texto verde
    for(filera=0;filera<FILERES;filera++){
      write(1,m[filera],COLUMNES); write(1,"\n",1); //Refrescar fila
    }
    write(1,"\033[1;37m",7); //Texto blanco
    for(col=0;col<COLUMNES;col++){
      sprintf(ordre,"\033[%d;%df%c",filera_b[col]+1,col+1,m[filera_b[col]][col]); 
      if(filera_b[col]<FILERES-1) write(1,ordre,strlen(ordre)); //Reescribir en blanco el último carácter de la columna
    }
    usleep(100000); //Esperar 0,1s antes de volver a refrescar
  }
}

int main()
{
  int col;
  memset (m,' ',FILERES*COLUMNES); //Esborra la matriu m
  write(1,"\033[2J\033[?25l",10); //Esborrar pantalla i amagar cursor 
  
  pthread_attr_init(&atrib);
  
  //Heu de crear un fil dibuixador per a cada columna
	
	for(col=0; col < COLUMNES; col++){
		pthread_create( &fil_dibujador[col], &atrib, Dibuixador, (void*)(long)col);
	}
		
  //Heu de crear un fil refrescador de pantalla
		
	pthread_create( &fil_refrescador, &atrib, RefrescadorDePantalla, NULL);

  //Heu d'esperar la terminació dels fils dibuixadors
  
	for(col=0; col < COLUMNES; col++){

		pthread_join(fil_dibujador[col], NULL); 

	}
  write(1,"\033[0m\033[?25h\r",11); //Restaurar text normal, restaurar cursor
}

