/*
  Ignacio Alvarado Reyes A01656149
  Pedro Rangel Palacios A01650939
*/

#include <stdio.h>

void square(int n) {
  for(int i=0; i<n; i++){
    for(int j=0; j<n; j++) printf("*");
    printf("\n");
  }
}

int main(void) {
  int n;
  printf("Niveles: ");
  scanf("%d", &n);
  square(n);
  return 0;
}