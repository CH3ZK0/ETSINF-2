#include <stdio.h>
#include <pthread.h>
#include <stdlib.h>
#include <semaphore.h>

#define REPETICIONES 10000 //20000000
long int V = 100;
pthread_mutex_t mutex = PTHREAD_MUTEX_INITIALIZER;


int test_and_set(int *spinlock) {
  int ret;
  __asm__ __volatile__(
    "xchg %0, %1"
    : "=r"(ret), "=m"(*spinlock)
    : "0"(1), "m"(*spinlock)
    : "memory");
  return ret;
}

void *agrega (void *argumento) {
  long int cont;
  long int aux;
  
  
  for (cont = 0; cont < REPETICIONES; cont = cont + 1) {
    pthread_mutex_lock(&mutex);
    aux = V;
    aux = aux + 1;
    usleep(500);
    V = aux;
    pthread_mutex_unlock(&mutex);
  }
  
  
  printf("-------> Fin AGREGA (V = %ld)\n", V);
  pthread_exit(0);
}

void *resta (void *argumento) {
  long int cont;
  long int aux;
  
  
  for (cont = 0; cont < REPETICIONES; cont = cont + 1) {
    pthread_mutex_lock(&mutex);
    aux = V;
    aux = aux - 1;
    usleep(500);
    V = aux;
    pthread_mutex_unlock(&mutex);
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
  pthread_create(&hiloSuma, &attr, agrega, NULL);
  pthread_create(&hiloResta, &attr, resta, NULL);
  //pthread_create(&hiloInspeccion, &attr, inspecciona, NULL);

  // EJERCICIO: Hilo principal debe espera a que las
  // tareas "agrega" y "resta" finalicen 
  pthread_join(hiloSuma, NULL);
  pthread_join(hiloResta, NULL);

   
  // Fin del programa principal
  fprintf(stderr, "-------> VALOR FINAL: V = %ld\n\n", V);
  exit(0);
}
