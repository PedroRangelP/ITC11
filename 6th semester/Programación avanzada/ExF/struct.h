#define MAXLEN_WORD 50
#define MAXSIZE 1645

typedef struct entry{
  char word[MAXLEN_WORD];
  int lines[MAXSIZE];
} Entry;