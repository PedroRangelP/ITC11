#define PART1 "part1.txt"
#define PART2 "part2.txt"
#define MAXLEN_LINE 100
#define SPLIT_LINE 1801

void split(char *filename) {
  FILE *f = fopen(filename, "r");
  FILE *p1 = fopen(PART1, "w");
  FILE *p2 = fopen(PART2, "w");
  char buffer[MAXLEN_LINE];
  int line = 1;

  while (fgets(buffer, MAXLEN_LINE, f) != NULL) {
    if(line < SPLIT_LINE)
      fprintf(p1,"%s", buffer);
    else
      fprintf(p2,"%s", buffer);

    line++;
  }

  fclose(f);
  fclose(p1);
  fclose(p2);
}