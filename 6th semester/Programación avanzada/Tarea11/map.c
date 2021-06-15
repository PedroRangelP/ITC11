/*
  Ignacio Alvarado Reyes A01656149
  Pedro Rangel Palacios A01650939
*/
#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <string.h>
#include <unistd.h>

#define MAXLEN_LINE 100
const char *delims = " \t\n\"'`,.;:?!*-_()[]30";

void map1(FILE *f) {
  char buffer[MAXLEN_LINE];
  char *word;

  while (fgets(buffer, MAXLEN_LINE, f) != NULL) {
    word = strtok(buffer, delims);
    while (word != NULL) {
      for (int i = 0; i < strlen(word); ++i) {
        if (islower(word[i])) word[i] = toupper(word[i]);
      }
      printf("%s,1\n", word);
      fflush(stdout);
      word = strtok(NULL, delims);
    }
  }
  
}

void map2(FILE *f) {
  char buffer[MAXLEN_LINE];
  char *word;
  
  while (fgets(buffer, MAXLEN_LINE, f) != NULL) {
    word = strtok(buffer, delims);
    while (word != NULL) {
      for (int i = 0; i < strlen(word); ++i) {
        if (islower(word[i])) word[i] = toupper(word[i]);
      }
      printf("%s,1\n", word);
      fflush(stdout);
      word = strtok(NULL, delims);
    }
  }
}

int main(void) {
  if(fork() != 0)  {
    FILE *file1 = fopen("alice1.txt", "r");
    map1(file1);
    fclose(file1);
  }
  else {
    FILE *file2 = fopen("alice2.txt", "r");
    map2(file2);
    fclose(file2);
  }
  
  return 0;
}