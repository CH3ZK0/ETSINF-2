#include <iostream>
#include <cstring>
#include <string>
#include <stdio.h>
using namespace std;
const int Constant1=96;
const int Constant2=96;
 	

 char  cad1[Constant1] = { };
 char  cad2[Constant2] = { };
//using namespace std;
int main(int argc, const char *argv[]) 
{ 
   for( int i = 0; i < argc; i++ ){
  
    //printf( "arg %d: %s\n", i, argv[i] );
    if( strcmp(argv[i], "-c") == 0){
        printf( "Argumento %d: %s\n", i, argv[i] );
    }else if( strcmp(argv[i], "-E") == 0){
        printf( "Argumento %d: %s\n", i, argv[i] );
    }else if( strcmp(&argv[i][1], "i") == 0){
        //char *token;
        //char *sep = " ";
        //token = strtok(argv, sep);
        printf( "Argumento %d: %s\n", i, argv[i] );
    }
    
   }
    
}
