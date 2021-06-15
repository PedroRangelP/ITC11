/*
  Ignacio Alvarado Reyes A01656149
  Pedro Rangel Palacios A01650939
*/
#include <stdio.h>
#include <string.h>
#include <stdlib.h>

#define MAXLEN_WORD 50

int main(void) {
  const char *fileName = "output.txt";
  FILE *file = fopen(fileName, "w");
  
  char entry[MAXLEN_WORD];
  char reduceKey[MAXLEN_WORD];
  int reduceValue = 0;
  strcpy(reduceKey, "");

  while(scanf("%[^\n]%*c",entry) == 1) {
    char *key = strtok(entry, ",");
    int value = atoi(strtok(NULL, ","));

    if(strcmp(reduceKey, "") == 0) {
      strcpy(reduceKey, key);
      reduceValue = value;
    }else {
      if(strcmp(reduceKey, key) == 0) {
        reduceValue += value;
      }else {  
        
        fprintf(file, "%s,%d\n", reduceKey, reduceValue);
        //printf("%s,%d\n", reduceKey, reduceValue);
        strcpy(reduceKey, key);
        reduceValue = value;
      }
    }
  }
  fprintf(file, "%s,%d\n", reduceKey, reduceValue);
  //printf("%s,%d\n", reduceKey, reduceValue);
  printf("-- Final output saved in %s\n", fileName);
  
  fclose(file);
  return(0);
}