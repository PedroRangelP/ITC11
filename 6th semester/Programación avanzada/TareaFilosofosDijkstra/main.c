/*
  Ignacio Alvarado Reyes A01656149
  Pedro Rangel Palacios A01650939
*/
#include <pthread.h>
#include <stdlib.h>
#include <stdbool.h>
#include <unistd.h>
#include <stdio.h>

#define CANTIDAD_FIDEOS 5;

typedef struct palillo {
  int id;
  bool ocupado;
  pthread_mutex_t mutex;
}Palillo;

typedef struct filosofo {
  int id;
  int fideos;
  Palillo *derecho;
  Palillo *izquierdo;
}Filosofo;

pthread_mutex_t mutex = PTHREAD_MUTEX_INITIALIZER;

void *comer(void *filosofo) {
  Filosofo *f = (Filosofo*) filosofo;
  
  usleep(rand() % 300000);
  while(f->fideos > 0) {
    printf("El filosofo %d tiene hambre\n", f->id);
    pthread_mutex_lock(&f->derecho->mutex);
    pthread_mutex_lock(&f->izquierdo->mutex);
    printf("El filosofo %d tomo los palillos %d y %d\n", f->id, f->derecho->id,f->izquierdo->id);
    
    printf("El filosofo %d se está comiendo el fideo %d\n", f->id,f->fideos);
    f->fideos--;
    usleep(rand() % 300000);
    printf("El filosofo %d terminó de comer el fideo %d, suelta los palillos\n", f->id,(f->fideos) + 1);
    pthread_mutex_unlock(&f->derecho->mutex);
    pthread_mutex_unlock(&f->izquierdo->mutex);
  }
  return NULL;
}

int main(void) {
  pthread_t filosofos[5];
  pthread_attr_t attr;
  pthread_attr_init(&attr);
  pthread_attr_setdetachstate(&attr, PTHREAD_CREATE_JOINABLE);
  pthread_attr_setscope(&attr, PTHREAD_SCOPE_SYSTEM);

  Palillo *p1 = (Palillo*) malloc(sizeof(Palillo));
  Palillo *p2 = (Palillo*) malloc(sizeof(Palillo));
  Palillo *p3 = (Palillo*) malloc(sizeof(Palillo));
  Palillo *p4 = (Palillo*) malloc(sizeof(Palillo));
  Palillo *p5 = (Palillo*) malloc(sizeof(Palillo));
  Filosofo *f1 = (Filosofo*) malloc(sizeof(Filosofo));
  Filosofo *f2 = (Filosofo*) malloc(sizeof(Filosofo));
  Filosofo *f3 = (Filosofo*) malloc(sizeof(Filosofo));
  Filosofo *f4 = (Filosofo*) malloc(sizeof(Filosofo));
  Filosofo *f5 = (Filosofo*) malloc(sizeof(Filosofo));

  p1->id = 1;
  p2->id = 2;
  p3->id = 3;
  p4->id = 4;
  p5->id = 5;
  p1->mutex = mutex;
  p2->mutex = mutex;
  p3->mutex = mutex;
  p4->mutex = mutex;
  p5->mutex = mutex;

  f1->id = 1;
  f1->fideos = CANTIDAD_FIDEOS;
  f1->derecho = p1;
  f1->izquierdo = p2;

  f2->id = 2;
  f2->fideos = CANTIDAD_FIDEOS;
  f2->derecho = p2;
  f2->izquierdo = p3;
  
  f3->id = 3;
  f3->fideos = CANTIDAD_FIDEOS;
  f3->derecho = p3;
  f3->izquierdo = p4;

  f4->id = 4;
  f4->fideos = CANTIDAD_FIDEOS;
  f4->derecho = p4;
  f4->izquierdo = p5;

  f5->id = 5;
  f5->fideos = CANTIDAD_FIDEOS;
  f5->derecho = p5;
  f5->izquierdo = p1;

  pthread_create(&filosofos[0], &attr, comer, (void*)f1);
  pthread_create(&filosofos[1], &attr, comer, (void*)f2);
  pthread_create(&filosofos[2], &attr, comer, (void*)f3);
  pthread_create(&filosofos[3], &attr, comer, (void*)f4);
  pthread_create(&filosofos[4], &attr, comer, (void*)f5);
  
  pthread_join(filosofos[0], NULL);
  pthread_join(filosofos[1], NULL);
  pthread_join(filosofos[2], NULL);
  pthread_join(filosofos[3], NULL);
  pthread_join(filosofos[4], NULL);

  return 0;
}