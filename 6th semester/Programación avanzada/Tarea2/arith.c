/*
  Ignacio Alvarado Reyes A01656149
  Pedro Rangel Palacios A01650939
*/
#include <stdio.h>
#include <string.h>
#include <stdbool.h>

#define MAX_LENGTH 1010
#define MAXNUM_LENGTH 510

void expression(char exp[]);
char what(char a[]);

int max (int a, int b){
  if (a > b) return a; 
  else return b;
}

void suma (short int *uno, int unoLeng, short int *dos, int dosLeng, char op){
  short int ops[MAX_LENGTH];
  memset(ops, 0, sizeof(ops));
  int maxLeng = max(unoLeng, dosLeng);
  int opLeng = maxLeng;

  for (int i = 0; i < opLeng; i++) {
		ops[i] += uno[i] + dos[i];
		if (ops[i] >= 10) {
			ops[i] -= 10;
			ops[i + 1] ++;
		}
	}
  
  if(ops[opLeng]>0) opLeng++;
  if(opLeng > max(unoLeng, dosLeng+1)) {
    printf(" ");
  }
  for (int i = 0; i < dosLeng + 1 - unoLeng; i++){
    printf(" ");
  }
  for (int i = unoLeng - 1; i >= 0; i--){
    printf("%d",uno[i]);
  }
  printf("\n");

  if (opLeng > max(unoLeng, dosLeng + 1)) {
    printf(" ");
  }
  for (int i = 0; i < unoLeng - dosLeng - 1; i++) {
    printf(" ");
  }
  printf("%c", op);
  for (int i = dosLeng - 1; i >= 0; i--) {
    printf("%d",dos[i]);
  }
  printf("\n");

  if (opLeng > max(unoLeng, dosLeng + 1)) {
    printf("-");
  }
  for (int i = 0; i < max(unoLeng, dosLeng + 1); i++) {
    printf("-");
  }
  printf("\n");
   
  if ((opLeng == maxLeng) && (dosLeng + 1 > unoLeng)){
     printf(" ");
  }
  for (int i = opLeng - 1; i >= 0; i--){
    printf("%d",ops[i]);
  }
  printf("\n");
}

void resta(short int *uno, int unoLeng, short int *dos, int dosLeng, char op){
  short int ops[MAX_LENGTH];
  memset(ops, 0, sizeof(ops));
  int maxLeng = max(unoLeng, dosLeng);
  int opLeng = maxLeng;

  for (int i = 0; i < maxLeng; i++) {
		ops[i] += uno[i] - dos[i];
			if (ops[i] < 0) {
				ops[i] += 10;
				ops[i + 1] --;
		}
	}

  for (int i = maxLeng - 1; i >= 0; i--) if (ops[i] != 0) {
		opLeng = i + 1;
		break;
	}

	for (int i = 0; i < dosLeng + 1 - unoLeng; i++) {
    printf(" ");
  }
	for (int i = unoLeng - 1; i >= 0; i--) {
    printf("%d",uno[i]);
  }

	printf("\n");

  for (int i = 0; i < unoLeng - dosLeng - 1; i++){
    printf(" ");
  }
  printf("%c",op);
	for (int i = dosLeng - 1; i >= 0; i--){
    printf("%d",dos[i]);
  } 
	printf("\n");

  for (int i = 0; i < max(unoLeng, dosLeng + 1) - max(opLeng, dosLeng + 1); i++) {
    printf(" ");
  }
	for (int i = 0; i < max(opLeng, dosLeng + 1); i++){
     printf("-");
  }
	printf("\n");
  
  for (int i = 0; i < max(unoLeng, dosLeng + 1) - opLeng; i++){
     printf(" ");
  }
	for (int i = opLeng - 1; i >= 0; i--){
     printf("%d", ops[i]);
  }
	printf("\n");
}

void multi(short int *uno, int unoLeng, short int *dos, int dosLeng, char op){
  short int r[MAX_LENGTH];
	memset(r, 0, sizeof(r));

	int LMax = max(unoLeng, dosLeng);
	int rLen = LMax;


	bool sers = true;
  	int r2[MAXNUM_LENGTH][MAX_LENGTH];

    memset(r2, 0, sizeof(r2));

			for (int i = 0; i < dosLeng; i++) 
				for (int j = 0; j < unoLeng; j++) {
					r2[i][j + i] += uno[j] * dos[i];
					if (r2[i][j + i] >= 10) {
						r2[i][j + i + 1] += r2[i][j + i] / 10;
						r2[i][j + i] %= 10;
					}
				}
		
			for (int i = 0; i < dosLeng; i++) 
				for (int j = 0; j < unoLeng + 1; j++)
					r[j + i] += r2[i][j + i];
			for (int i = 0; i < unoLeng + dosLeng - 1; i++) if (r[i] >= 10) {
				r[i + 1] += r[i] / 10;
				r[i] %= 10;
			}
			for (int i = unoLeng + dosLeng - 1; i >= 0; i--) if (r[i] != 0) {
				rLen = i + 1;
				break;
			}
			
			int n = rLen - max(unoLeng, dosLeng + 1);
			
			for (int i = 0; i < n; i++) printf(" ");
			for (int i = 0; i < dosLeng + 1 - unoLeng; i++) printf(" ");
			for (int i = unoLeng - 1; i >= 0; i--) printf("%d",uno[i]);

			printf("\n");
			
			for (int i = 0; i < n; i++) printf(" ");
			for (int i = 0; i < unoLeng - dosLeng - 1; i++) printf(" ");
			printf("%c",op);
			for (int i = dosLeng - 1; i >= 0; i--) printf("%d",dos[i]);

			printf("\n");
			
			for (int i = 0; i < n - 1; i++) printf(" ");

			int r1_len = 0;

			for (int i = unoLeng; i >= 0; i--) if (r2[0][i] > 0) {
				r1_len = i + 1;
				break;
			}

			if ( (r1_len <= max(unoLeng, dosLeng + 1)) && (n > 0) ) printf(" ");
			for (int i = 0; i < unoLeng - max(dosLeng + 1, r1_len); i++) printf(" ");
			for (int i = 0; i < max(r1_len, dosLeng + 1); i++) printf("-");

			printf("\n");
			
			if (dosLeng > 1) {
				for (int i = 0; i < dosLeng; i++) {
					int tempLeng = rLen;
					if ( (rLen == LMax) && (dosLeng + 1 > unoLeng) ) tempLeng++;
					sers = true;
					for (int j = tempLeng - 1; j >= i + 1; j--) {
						if ((sers) && (r2[i][j] != 0)) sers = false;
						if (!sers) printf("%d",r2[i][j]); else printf(" ");
					}
					printf("%d",r2[i][i]);

					printf("\n");
				}

				if ( (rLen == LMax) && (dosLeng + 1 > unoLeng) ) printf(" ");
				for (int i = 0; i < rLen; i++) printf("-");
				printf("\n");
			}

			
			if ( (rLen == LMax) && (dosLeng + 1 > unoLeng) ) printf(" ");
			for (int i = rLen - 1; i >= 0; i--) printf("%d",r[i]);
			printf("\n");
}

int main(void){
  int n;
  scanf("%d", &n);

  char ops[n][MAX_LENGTH];
  for(int i=0; i<n; i++) {
    scanf("%s", ops[i]);
  }
  for(int i=0; i<n; i++) {
    expression(ops[i]);
  }
  return 0;
}



void expression(char exp[]){
  int n = strlen(exp);
  char op = what(exp);
  int len = strlen(exp);
  char Suno [MAXNUM_LENGTH];
  char Sdos [MAXNUM_LENGTH];
  short int uno [MAXNUM_LENGTH];
  short int dos [MAXNUM_LENGTH];
  memset(Suno, 0, sizeof(Suno));
  memset(Sdos, 0, sizeof(Sdos));
  memset(uno, 0, sizeof(uno));
  memset(dos, 0, sizeof(dos));

  for (int i = 0; i < len; i++) {
    if (op == exp[i]){
      strncpy(Suno, exp, i);
      strncpy(Sdos, exp + i + 1, len - i - 1);
      break;
    } 
  }
  

  int unoLeng = strlen(Suno);
  int dosLeng = strlen(Sdos);

  for (int i = unoLeng - 1; i >= 0; i--) {
    uno[unoLeng - i - 1] = (int)Suno[i] - '0'; 
  }
  for (int i = dosLeng - 1; i >= 0; i--) {
    dos[dosLeng - i - 1] = (int)Sdos[i] - '0';
  }

  switch (op){
    case '+':
      suma(uno, unoLeng, dos, dosLeng, op);
      break;
    case '-':
    resta(uno, unoLeng, dos, dosLeng, op);
      break;
    case '*':
      multi(uno, unoLeng, dos, dosLeng, op);
      break;
  }

  printf("\n");
}

char what(char a[]){
  int n = 0;
  while(a[n] != '\0'){
    if(a[n] == '+') return '+';
    else if(a[n] == '-') return '-';
    else if(a[n] == '*') return '*';
    else n++;
  }
  return 'a';
}


