/*
  Ignacio Alvarado Reyes A01656149
  Pedro Rangel Palacios A01650939
*/
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include "struct.h"

void debugOutput(char *word, int lines[]) {
  printf("%s\n[", word);

  for (int i=0; i<MAXSIZE; i++) {
    printf(" %d,", lines[i]);
  }
  printf("]\n");
}

int main(void) {
  FILE *f1 = fopen("File1", "wb+");
  Entry entry;
  
  char buffer[MAXLEN_WORD];
  int idx = 0;
  int lines[MAXSIZE];
  int reset[MAXSIZE];
  strcpy(entry.word, "");

  while(scanf("%[^\n]%*c",buffer) == 1) {
    char *key = strtok(buffer, ",");
    int value = atoi(strtok(NULL, ","));

    if(strcmp(entry.word, "") == 0) {
      strcpy(entry.word, key);
      lines[idx] = value;
    }else {
      if(strcmp(entry.word, key) == 0) {
        lines[idx] = value;
      }else {
        lines[idx] = -1;
        memcpy(entry.lines, lines, sizeof(lines));
        fwrite(&entry, sizeof(Entry), 1, f1);
        //debugOutput(entry.word, lines);

        memcpy(lines, reset, sizeof(reset));
        idx = 0;
        strcpy(entry.word, key);
        lines[idx] = value;
      }
    }
    idx++;
  }
  lines[idx] = -1;
  memcpy(entry.lines, lines, sizeof(lines));
  fwrite(&entry, sizeof(Entry), 1, f1);
  //debugOutput(entry.word, lines);
  
  printf("-- File created!\n");
  
  fclose(f1);
  return(0);
}