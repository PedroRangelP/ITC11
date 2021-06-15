/*
  Ignacio Alvarado Reyes A01656149
  Pedro Rangel Palacios A01650939
*/
#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <string.h>
#include "struct.h"

int searchWord(FILE *f1, int left, int right, char *word) {
  Entry entry;

  if(right >= 1 && left<right) {
    int mid = (left+(right-1))/2;
    fseek(f1, sizeof(Entry)*mid, SEEK_SET);
    fread(&entry, sizeof(Entry), 1, f1);
    
    if(strcmp(entry.word, word) == 0) {
      int line;
      int idx = 0;

      line = entry.lines[idx];
      printf("Lines:");
      while (line != -1) {
        printf(" %d,", line);
        idx++;
        line = entry.lines[idx];
      }
      printf("\n");
      return 0;
    }
    if(strcmp(entry.word, word) > 0) {
      return searchWord(f1, left, mid, word);
    }
    return searchWord(f1, mid+1, right, word);
  }
  return -1;
}

int main() {
  FILE *f1 = fopen("File1", "rb+");

  Entry entry;

  char search[MAXLEN_WORD];
  printf("-- Search word: "); scanf("%s", search);
  for (int i = 0; i < strlen(search); ++i) {
    if (islower(search[i])) search[i] = toupper(search[i]);
  }

  fseek(f1, sizeof(Entry), SEEK_END);
  size_t size = ftell(f1) / sizeof(Entry);
  int entries = (int)size;
  int result = searchWord(f1, 0, entries-1, search);

  if (result != 0) printf("-- Word not found!\n");
  
  fclose(f1);
  return 0;
}
