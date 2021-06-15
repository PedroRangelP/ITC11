/*
  Ignacio Alvarado Reyes A01656149
  Pedro Rangel Palacios A01650939
*/
#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <string.h>
#include "struct.h"

#define MAXLEN_LINE 100

void insertR1(record1 *record, record1** root, int line, FILE *f2) {
  record2 r2;
  r2.line = line;
  r2.next = -1;

  if(*root == NULL) {
    *root = record;
    fwrite(&r2, sizeof(record2), 1, f2);
    return;
  }
  
  if(strcmp(record->word, (*root)->word) < 0) {
    record->next = *root;
    *root = record;
    fwrite(&r2, sizeof(record2), 1, f2);
    return;
  }

  record1 *temp1;
  record1 *temp2;

  temp1 = *root;
  while(temp1 != NULL) {
    if(strcmp(record->word, temp1->word) == 0) {
      int ptro = temp1->ptr;
      int ptrn = record->ptr;

      fseek(f2, sizeof(record2)*ptro, SEEK_SET);
      fread(&r2, sizeof(record2), 1, f2);
      int nextpos = r2.next;

      while(nextpos != -1 ) {
        ptro = nextpos;
        fseek(f2, sizeof(record2)*ptro, SEEK_SET);
        fread(&r2, sizeof(record2), 1, f2);
        nextpos = r2.next;
      }
      
      int lineo = 0;
      if (ptro == 0) {
        fseek(f2, sizeof(record2)*ptro, SEEK_SET);
      }else {
        lineo = r2.line;
        fseek(f2, sizeof(record2)*(ptro-1), SEEK_SET);
        fread(&r2, sizeof(record2), 1, f2);
        r2.line = lineo;
      }
      r2.next = record->ptr;
      fwrite(&r2, sizeof(record2), 1, f2);

      fseek(f2, sizeof(record2)*ptrn, SEEK_SET);
      r2.line = line;
      r2.next = -1;
      fwrite(&r2, sizeof(record2), 1, f2);
      free(record);
      return;
    }
    temp1 = temp1->next;
  }

  temp1 = *root;
  temp2 = temp1->next;
  while(temp2 != NULL) {
    if(strcmp(record->word, temp1->word) > 0 && strcmp(record->word, temp2->word) < 0){
      record->next = temp2;
      temp1->next = record;
      fwrite(&r2, sizeof(record2), 1, f2);
      return;
    }else {
      temp1 = temp2;
      temp2 = temp2->next;
    }
  }

  temp1->next = record;
  fwrite(&r2, sizeof(record2), 1, f2);
}

void createR1(record1** root, char *word, int ptr, int line, FILE *f2) {
  record1 *r1;
  r1= (record1*) malloc(sizeof(record1));

  strcpy(r1->word, word);
  r1->next = NULL;
  r1->ptr = ptr;
  insertR1(r1, root, line, f2);
}

void toBinaryR1(record1 *root) {
  FILE *f1 = fopen("File1", "wb+");
  //FILE *f1txt = fopen("F1.txt", "w");
  
  record1 * r1 = root;
  recordbinary1 rb1;

  if(r1 == NULL) {
    return;
  }
  while (r1 != NULL) {
    rb1.ptr = r1->ptr;
    strcpy(rb1.word, r1 ->word);
    fwrite(&rb1, sizeof(recordbinary1), 1, f1);
    //fprintf(f1txt, "word: %s | ptr: %d\n", rb1.word, rb1.ptr);
    r1 = r1->next;
  }
  fclose(f1);
  //fclose(f1txt);
}

int main (int argc, char **argv) {
  printf("-- Creating inverted index...\n");

  record1 *root = NULL;

  FILE *fp = fopen( "alice.txt", "r");
  FILE *f2 = fopen("File2", "wb+");
  //FILE *f2txt = fopen("F2.txt", "w");

  char buffer[MAXLEN_LINE];
  char *word;
  const char *delims = " \t\n\"'`,.;:?!*-_()[]30";
  int line = 1;
  int ptr = 0;

  while (fgets(buffer, MAXLEN_LINE, fp) != NULL) {
    word = strtok(buffer, delims);
    while (word != NULL) {
      for (int i = 0; i < strlen(word); ++i) {
        if (islower(word[i])) word[i] = toupper(word[i]);
      }
      createR1(&root, word, ptr, line, f2);
      ++ptr;
      word = strtok(NULL, delims);
    }
    ++line;
  }
  toBinaryR1(root);
  
  for(int i=0; i<ptr;i++) {
    fseek(f2, sizeof(record2)*i, SEEK_SET);
    record2 r2;
    fread(&r2, sizeof(record2), 1, f2);
    //fprintf(f2txt, "%d) line: %d | next: %d\n",i, r2.line, r2.next);
  }
  printf("-- Files created!\n");
  fclose(f2);
  //fclose(f2txt);

  return 0;
}