/*
  Ignacio Alvarado Reyes A01656149
  Pedro Rangel Palacios A01650939
*/

#include <stdio.h>

void diamond(int n){
  int middle = n/2;
  int spaces = middle;
  int stars = 1;
  for(int i=0; i<middle; i++){
    for(int j=0; j<spaces; j++) printf(" ");
    for(int j=0; j<stars; j++)  printf("*");
    spaces-=1;
    stars+=2;
    printf("\n");
  }

  for(int i=0; i<=middle; i++){
    for(int j=0; j<spaces; j++) printf(" ");
    for(int j=0; j<stars; j++)  printf("*");
    spaces+=1;
    stars-=2;
    printf("\n");
  }
  printf("\n");
}

int main(void) {
  int n;
  printf("Niveles: ");
  scanf("%d", &n);
  diamond(n);
  return 0;
}