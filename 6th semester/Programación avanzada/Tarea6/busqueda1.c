/*
  Ignacio Alvarado Reyes A01656149
  Pedro Rangel Palacios A01650939
*/
#include <stdio.h>
#include <string.h>
#include <unistd.h>
#include <sys/wait.h>
#include <signal.h>
#include <stdlib.h>

int counter=0;

void handler(int sig){
  ++counter;
}

int busca(char **palabras, char * palabra, int inicio, int fin, char *quien) {
      int veces = 0;
      for(int i = inicio; i < fin; i++) {
        if(strcmp(palabra, palabras[i]) == 0) {
          veces++;
          printf("El proceso %s encontró la palabra %s\n", quien, palabra);
        }
      }
      return veces;
  }

void busca2(char **palabras, char * palabra, int inicio, int fin, char *quien) {
      int veces = 0;
      for(int i = inicio; i < fin; i++) {
        if(strcmp(palabra, palabras[i]) == 0) {
          veces++;
          printf("El proceso %s encontró la palabra %s\n", quien, palabra);
          kill(getppid(),SIGUSR1);
          sleep(1);
        }
      } 
  }

int main() {
  char *palabras[] = {"hola", "adios","no-se", "hola", "hola", "hola","aa", "hola"};
  int tamanio = sizeof(palabras)/sizeof(char*);
  int mitad = tamanio/2;
  
  

  pid_t pid;
  if((pid = fork()) != 0)  { 
    // estamos en el proceso padre
    signal(SIGUSR1, handler);
    int n = busca(palabras, "hola", 0, mitad, "padre");
    int status;
    wait(&status);
    printf("El total de veces que se encontró la palabra fue %d\n", n + counter);
  }
  else {
    busca2(palabras, "hola", mitad, tamanio, "hijo");
    exit(0);
  }
  
  return 0;
}

