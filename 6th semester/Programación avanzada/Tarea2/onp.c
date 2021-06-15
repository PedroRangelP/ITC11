/*
  Ignacio Alvarado Reyes A01656149
  Pedro Rangel Palacios A01650939
*/
#include <stdio.h>
#include <string.h>

#define MAX_LENGTH 500
#define CASE_CODE strcat(stack, charAdd); stackLength++; strcpy(last, stack);

void stacc(char exp[][MAX_LENGTH], int length);

int main (void){
  int expressions;
  scanf("%d", &expressions);

  char ec[expressions][MAX_LENGTH];
  for(int i=0; i<expressions; i++) scanf("%s", ec[i]);

  stacc(ec, expressions);
  return 0;
}

void stacc(char exp[][MAX_LENGTH], int length) {
  for(int i=0; i<length; i++){
    char ans[MAX_LENGTH] = "";
    char stack[MAX_LENGTH] = "";
    char last[MAX_LENGTH]= "";
    int n = 0;
    int stackLength = 0;

    while(exp[i][n] != '\0') {
      char current = exp[i][n];
      char charAdd[] = {current, '\0'};

      if(current == '+' || current == '-' || current == '/' || current == '*' || current == '^') {
        strcat(stack, charAdd);
        stackLength++;
        strcpy(last, stack);
      }
      else if(current == ')') {
        strcat(ans, (char[2]) {stack[stackLength-1], '\0'});
        char temp[MAX_LENGTH] = "";
        strncpy(temp, stack, stackLength-1);
        stackLength--;
        strcpy(last, temp);
        strcpy(stack, last);
      }else {
        if(current != '(') strcat(ans, charAdd);
      }
      n++;
    }
    printf("%s\n", ans);
  }
}