/*
  Ignacio Alvarado Reyes A01656149
  Pedro Rangel Palacios A01650939
*/
#include <stdio.h>

int residuo(int a, int b) {return a-(a/b*b);}

int main(void) {
  int divisor;
  int dividendo;
  printf("Dividendo: ");
  scanf("%d", &dividendo);
  printf("Divisor: ");
  scanf("%d", &divisor);
  printf("El residuo es: %d", residuo(dividendo, divisor));
  return 0;
}