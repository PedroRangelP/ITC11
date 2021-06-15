/*
  Ignacio Alvarado Reyes A01656149
  Pedro Rangel Palacios A01650939
*/

#include <stdio.h>

void diamond(int n){
  int middle = n/2;
  int spaces = n-2;
  int stars = 1;
  for(int i=0; i<middle; i++){
    for(int j=0; j<stars; j++) printf("*");
    for(int j=0; j<spaces; j++) printf(" ");
    for(int j=0; j<stars; j++)  printf("*");
    spaces-=2;
    stars+=1;
    printf("\n");
  }

  for(int i=0; i<n; i++) printf("*");
  printf("\n");

  stars = middle;
  spaces = 1;
  for(int i=0; i<middle; i++){
    for(int j=0; j<stars; j++) printf("*");
    for(int j=0; j<spaces; j++) printf(" ");
    for(int j=0; j<stars; j++)  printf("*");
    spaces+=2;
    stars-=1;
    printf("\n");
  }
}

int main(void) {
  int n;
  printf("Niveles (impar): ");
  scanf("%d", &n);
  diamond(n);
  return 0;
}