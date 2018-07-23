#include <iostream>
#include <cstring>
#include <string>
#include <stdio.h>
using namespace std;
const int Tamany=5;
 	

 
//using namespace std;
int main() 
{ 
   // Puntero a caracter para copiar las cadenas
    char *p1, *p2;
   //A) Definirlas variables cadena y cadena2 
    char  cadena[Tamany] ;
    char  cadena2[Tamany];
   //B) Leer cadena de consola 
      scanf("%[^\n]s", cadena);
     
   //C)Convertir a mayúsculas
    p1 = cadena;
    p2 = cadena2;
    while (*p1 !='\0'){
	//if(*p1 >= 97 && <= 122){
		*p2=*p1-32;
	}    else{


}  
	 
	*p2=*p1-32;
        p1++;
        p2++;
    } *p2=0;
        cout<< cadena2<< endl;

}
