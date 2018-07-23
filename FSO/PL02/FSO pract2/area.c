#include <stdio.h>
float getarea(float radio){
    return radio*radio;
}

int main() {   
    float area, radio;
    radio = 10;   
    area = getarea(radio);
}