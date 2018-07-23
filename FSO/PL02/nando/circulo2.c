#include <stdio.h>
#include "area.h"
#define PI 3.1416
main(void){
	float radio;
	radio=10;
	
	printf("Area del circulo de radio %f es %f\n", radio, area(radio));
}
