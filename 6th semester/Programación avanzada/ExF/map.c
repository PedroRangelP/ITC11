/*
  Ignacio Alvarado Reyes A01656149
  Pedro Rangel Palacios A01650939
*/
#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <string.h>
#include <unistd.h>
#include "split.h"

const char *delims = " \t\n\"'`,.;:?!*-_()[]30";

void map1(FILE *f, int startline) {
  char buffer[MAXLEN_LINE];
  char *word;
  int line = startline;

  while (fgets(buffer, MAXLEN_LINE, f) != NULL) {
    word = strtok(buffer, delims);
    while (word != NULL) {
      for (int i = 0; i < strlen(word); ++i) {
        if (islower(word[i])) word[i] = toupper(word[i]);
      }
      printf("%s,%d\n", word, line);
      fflush(stdout);
      word = strtok(NULL, delims);
    }
    line++;
  }
}

void map2(FILE *f, int startline) {
  char buffer[MAXLEN_LINE];
  char *word;
  int line = startline;
  
  while (fgets(buffer, MAXLEN_LINE, f) != NULL) {
    word = strtok(buffer, delims);
    while (word != NULL) {
      for (int i = 0; i < strlen(word); ++i) {
        if (islower(word[i])) word[i] = toupper(word[i]);
      }
      printf("%s,%d\n", word, line);
      fflush(stdout);
      word = strtok(NULL, delims);
    }
    line++;
  }
}

int main(void) {
  split("alice.txt");

  if(fork() != 0)  {
    FILE *f = fopen(PART1, "r");
    map1(f, 1);
    remove(PART1);
  }
  else {
    FILE *f = fopen(PART2, "r");
    map2(f, SPLIT_LINE);
    remove(PART2);
  }
  
  return 0;
}