/*
  Ignacio Alvarado Reyes A01656149
  Pedro Rangel Palacios A01650939
*/
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <sys/wait.h>
#include <pthread.h>
#define HILOS 2
#define WORDS 8
#define MAX_LEN 25

typedef struct parametros {
  char* palabras[WORDS];
  char palabra[MAX_LEN];
  int inicio;
  int fin;
  int quien;
}parametros;

int counter=0;
pthread_mutex_t lock = PTHREAD_MUTEX_INITIALIZER;

int busca(char **palabras, char * palabra, int inicio, int fin, int quien) {
  int veces = 0;
  for(int i = inicio; i < fin; i++) {
    if(strcmp(palabra, palabras[i]) == 0) {
      veces++;
      printf("El proceso %d encontró la palabra %s\n", quien, palabra);
    }
  }
  return veces;
}

void *handler(void *arg){
  parametros *param = (parametros *) arg;
  pthread_mutex_lock(&lock); 
  int temp = counter;
  temp+=busca(param->palabras, param->palabra, param->inicio, param->fin ,param->quien);
  counter = temp;
  pthread_mutex_unlock(&lock); 
  return 0;
}

int main() {
  char *palabras[WORDS] = {"hola", "adios","no-se", "hola", "hola", "hola","aa", "hola"};
  int tamanio = sizeof(palabras)/sizeof(char*);
  int mitad = tamanio/2;
  pthread_t hilos[HILOS];
  pthread_attr_t threadAtt;
  pthread_attr_init(&threadAtt);
  pthread_attr_setdetachstate(&threadAtt, PTHREAD_CREATE_JOINABLE);
  pthread_attr_setscope(&threadAtt, PTHREAD_SCOPE_SYSTEM);

  for (int i=0;i<HILOS; i++) {
    parametros *params = malloc(sizeof(parametros));
    for(int j=0;j<tamanio;j++){
      params->palabras[j] = palabras[j];     
    }
    strcpy(params->palabra,"hola");
    if(i==0){
      params->inicio= 0;
      params->fin= mitad;
      params->quien= 1;
    }else if(i==1){
      params->inicio= mitad;
      params->fin= tamanio;
      params->quien= 2;
    }
    int thread = pthread_create(&hilos[i], &threadAtt, handler, (void *) params);
    if (thread != 0) {
      printf("No se pudo crear el hilo %d\n",i);
      exit(EXIT_FAILURE);
    }
  }
  for (int k=0;k<HILOS;k++) {
    int thread = pthread_join(hilos[k], NULL);
    if (thread != 0) {
      printf("No se pudo crear el hilo %d\n",k);
      exit(EXIT_FAILURE);
    }
  }
  printf("El total de veces que se encontró la palabra fue %d\n",counter);
  return 0;
}

