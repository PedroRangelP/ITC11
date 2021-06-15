#define MAXLEN_WORD 50

typedef struct record1 {
  char word[MAXLEN_WORD];
  int ptr;
  struct record1 *next;
} record1;

typedef struct recordbinary1 {
  char word[MAXLEN_WORD];
  int ptr;
} recordbinary1;

typedef struct record2 {
  int line;
  int next;
} record2;