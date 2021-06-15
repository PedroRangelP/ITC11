/*
  Ignacio Alvarado Reyes A01656149
  Pedro Rangel Palacios A01650939
*/
#include <pthread.h>
#include <semaphore.h>
#include <stdlib.h>
#include <stdio.h>

#define CHAIRS 4
#define CLIENTS 8

sem_t barbero;
sem_t barbero_dormido;
sem_t clientes;
sem_t sillaBarbero;
sem_t sillas;
int sillasDisponibles = CHAIRS;
pthread_mutex_t mutex;
int personas= CLIENTS;

void *barberoStatus(void *args){
  while(personas>0){
    printf("Barbero dormido\n");
    sem_wait(&barbero_dormido);
    if(personas>0){
      printf("El barbero esta cortando el cabello\n");
      sleep(rand() % 5);
      printf("El barbero terminó\n");
      sem_post(&sillaBarbero);
    }
  }
  return NULL;
}

void *cliente(void* client){
  //*((int *)pno)
  sleep(rand() % 15);
  printf("El cliente %d acaba de llegar a la barbería\n\n",*((int *)client));
  
  if(sillasDisponibles>0){
    sillasDisponibles-=1;
    
    //sem_wait(&sillas);
    printf("El cliente %d entró a la sala de espera y se sienta en la silla %d\n",*((int *)client),sillasDisponibles+1);
    sem_wait(&clientes);
    sillasDisponibles++;
    sem_post(&barbero_dormido);
    printf("El cliente %d pasa a la silla del barbero\n", *((int *)client));
    sem_wait(&sillaBarbero);
    //sem_post(&sillas);
    sleep(rand() % 5);
    sem_post(&clientes);
    printf("El cliente %d sale de la barbería\n", *((int *)client));
    sleep(rand() % 5);
  }else{
    printf("El cliente %d deja la barbería porque no encontró lugar\n", *((int *)client));
  }
  personas--;
  //printf("personas restantes %d\n",personas);
}

int main() {   
  
  pthread_t barbero_t, clientes_t[CLIENTS];
  int cliente_id[CLIENTS];
  for (int i = 0; i < CLIENTS; i++) cliente_id[i] = i+1;
  
  sem_init(&barbero, 0, 1);
  sem_init(&barbero_dormido, 0, 0);
  sem_init(&clientes,0,1);
  sem_init(&sillaBarbero, 0, 0);
  //sem_init(&sillas, 0, CHAIRS);
  
  pthread_create(&barbero_t, NULL, barberoStatus, NULL);
  for (int i = 0; i < CLIENTS; i++) {
    pthread_create(&clientes_t[i], NULL, cliente, (void *)&cliente_id[i]);
  }
  sleep(rand() % 2);
  for (int i = 0; i < CLIENTS; i++) {
    pthread_join(clientes_t[i], NULL);
  }
  sem_post(&barbero_dormido);
  pthread_join(barbero_t, NULL);

  
  return 0;
    
}