/*                                                                      */
/*  CondCarr.c                                                          */
/*  Observacion de condiciones de carrera y soluciones)                 */
/*  Fundamentos de los Sistemas Operativos  (sesion 6)                  */
/*  Grupo de Sistemas Operativos DISCA (UPV)                            */
/*  Ultima revision: 14/10/2016                                         */
/*                                                                      */

#include <stdio.h>
#include <pthread.h>
#include <stdlib.h>
#include <semaphore.h>

/* REPETICIONES : Numero de veces que se suma/resta 1 a V*/

#define REPETICIONES      20000000

/*
100 NO CONDICIO DE CARRERA
10000 YA EN DONA UNA CONDICIO DE CARRERA
*/
/*
   VARIABLES GLOBALES (COMPARTIDAS) 
*/

long int V = 100;      // Valor inicial

/* 
   FUNCIONES AUXILIARES
   test_and_set(int * objetivo) : devuelve 1 (cierto) si llave esta siendo utilizada, 
                                  devuelve 0 (falso) si llave esta libre.
*/

int test_and_set(int *spinlock) {
  int ret;
  __asm__ __volatile__(
    "xchg %0, %1"
    : "=r"(ret), "=m"(*spinlock)
    : "0"(1), "m"(*spinlock)
    : "memory");
  return ret;
}


/* 
   FUNCIONES QUE EJECUTAN LAS TAREAS o THREADS
   - Agrega : Ejecuta un bucle donde incrementa la variable V 
   - Resta  : Ejecuta un bucle donde decrementa la variable V
   - Inspecciona : Imprime cada segundo el valor de V
*/

void *agrega (void *argumento) {

  long int cont;
  long int aux;
  
  for (cont = 0; cont < REPETICIONES; cont = cont + 1) {

      V = V + 1;
      
  }
  printf("-------> Fin AGREGA (V = %ld)\n", V);
  pthread_exit(0);
}

void *resta (void *argumento) {

  long int cont;
  long int aux;
  
  for (cont = 0; cont < REPETICIONES; cont = cont + 1) {
    
        V = V - 1;

  }
  
  printf("-------> Fin RESTA  (V = %ld)\n", V);
  pthread_exit(0);
}

void *inspecciona (void *argumento) {
 
  for (;;) {
    usleep(200000);
    fprintf(stderr, "Inspeccion: Valor actual de V = %ld\n", V);
  } 
}

//*PROGRAMA PRINCIPAL  

int main (int argc, char *argv[]) {
  //Declaracion de  variables 
    pthread_t hiloSuma, hiloResta, hiloInspeccion;
    pthread_attr_t attr;   

  // Inicilizacion de los atributos de los hilos (por defecto)
    pthread_attr_init(&attr);
    
  // EJERCICIO: Cree los tres hilos propuestos con dichos atributos 
   pthread_create(&hiloSuma, &attr, agrega,NULL);
   pthread_create(&hiloResta, &attr, resta,NULL);
   pthread_create(&hiloInspeccion, &attr, inspecciona,NULL);

  // EJERCICIO: Hilo principal debe espera a que las
  // tareas "agrega" y "resta" finalicen 
pthread_join(hiloSuma, NULL);
pthread_join(hiloResta, NULL);
   
  // Fin del programa principal
  fprintf(stderr, "-------> VALOR FINAL: V = %ld\n\n", V);
  exit(0);
}
