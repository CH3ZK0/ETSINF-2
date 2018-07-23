#include <stdio.h> 

#define TAM_FILA 100
#define NUM_FILAS 10
struct FILA {
    float datos[TAM_FILA];
    float suma;
};

// A) Define una variable filas que sea un vector de estructuras FILA de tamaño NUM_FILAS

void suma_fila(struct FILA *pf) {
// B) Implementar suma_fila
}

// Inicia las filas con el valor i*j
void inicia_filas() {
    int i, j;
    for (i = 0; i < NUM_FILAS; i++) {
        for (j = 0; j < TAM_FILA; j++) {
            filas[i].datos[j] = (float)i*j;
        }
    }
}

main() { 
    int i;
    float suma_total;
    
    inicia_filas();
    
    // C) Completar bucle
    suma_total = 0;
    for (i = 0; i < NUM_FILAS; i++) {
        // Llamar a suma_fila
        printf("La suma de la fila %u es %f\n", i, /* COMPLETAR */);
        // sumar la fila a suma_total
    }

    printf("La suma final es %f\n", suma_total); 
}

