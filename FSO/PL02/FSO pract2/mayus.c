#include <iostream>
#include <cstring>
#include <string>
#include <stdio.h>
using namespace std;
const int Constant1=5;
const int Constant2=5;
 	

 
//using namespace std;
int main() 
{ 
   // Puntero a caracter para copiar las cadenas
    char *p1, *p2;
   //A) Definirlas variables cadena y cadena2 
    char  cadena[Constant1] ;
    char  cadena2[Constant2];
   //B) Leer cadena de consola 
     cout << "Insertar Cadena de Caracteres: ";
      scanf("%[^\n]s", cadena);
     
   //C)Convertir a mayúsculas
    p1 = cadena;
    p2 = cadena2;
    while (*p1 !='\0'){
        //cout<< (char)*p1-32<< endl;
        //printf("\n%c", *p1-32);
        *p2=*p1-32; //parse min to may.
        p1++;
        p2++;
    } *p2=0;
        cout<< cadena2<< endl;
     //printf("\n%s\n", cadena2);

}
