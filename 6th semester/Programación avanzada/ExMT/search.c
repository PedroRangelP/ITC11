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
  recordbinary1 midb;
  
  if(right >= 1 && left<right) {
    int mid = (left+(right-1))/2;
    fseek(f1, sizeof(recordbinary1)*mid, SEEK_SET);
    fread(&midb, sizeof(recordbinary1), 1, f1);
    
    if(strcmp(midb.word, word) == 0) {
      return mid;
    }
    if(strcmp(midb.word, word) > 0) {
      return searchWord(f1, left, mid, word);
    }
    return searchWord(f1, mid+1, right, word);
    
  }
  return -1;
}

int main() {
  FILE *f1 = fopen("File1", "rb+");
  FILE *f2 = fopen("File2", "rb+");

  recordbinary1 r1b;
  record2 r2;

  char search[MAXLEN_WORD];
  printf("-- Search word: "); scanf("%s", search);
  for (int i = 0; i < strlen(search); ++i) {
    if (islower(search[i])) search[i] = toupper(search[i]);
  }

  fseek(f1, sizeof(recordbinary1), SEEK_END);
  size_t size = ftell(f1) / sizeof(recordbinary1);
  int sizeInt = (int)size;
  int index = searchWord(f1,0,sizeInt-1,search);

  if (index != -1) {
    fseek(f1, sizeof(recordbinary1)*index, SEEK_SET);
    fread(&r1b, sizeof(recordbinary1), 1, f1);
    //printf("PTR: %d\n", r1b.ptr);
    int ptr = r1b.ptr;

    fseek(f2, sizeof(record2)*ptr, SEEK_SET);
    fread(&r2, sizeof(record2), 1, f2);
    int nextpos = r2.next;
    printf("Lines: %d,", r2.line);

    while(nextpos != -1 ) {
      ptr = nextpos;
      fseek(f2, sizeof(record2)*ptr, SEEK_SET);
      fread(&r2, sizeof(record2), 1, f2);
      printf(" %d,", r2.line);
      nextpos = r2.next;
    }
    printf("\n");
  }else {
    printf("-- Word not found!\n");
  }
  
  return 0;
}

