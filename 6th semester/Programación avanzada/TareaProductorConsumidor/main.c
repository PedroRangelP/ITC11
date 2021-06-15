/*
  Ignacio Alvarado Reyes A01656149
  Pedro Rangel Palacios A01650939
*/
#include <pthread.h>
#include <stdlib.h>
#include <stdio.h>
#include <unistd.h>

#define PRODUCERS 2
#define CONSUMERS 2
#define STACK_SIZE 200

int vacio = STACK_SIZE;
int lleno = 0;
int in_idx = 0;
int out_idx = 0;
char stack[STACK_SIZE];

pthread_mutex_t mutex;

void *producer(void *id) {   
  for(int i = 0; i < STACK_SIZE; i++) {
    if (vacio > 0) {
      pthread_mutex_lock(&mutex);
      int empty_temp = vacio;
      empty_temp--;
      vacio = empty_temp;

      stack[in_idx] = 'A' + (rand() % 26);
      printf("Producer %d: %c\n", *((int *)id), stack[in_idx]);
      in_idx = (in_idx + 1) % STACK_SIZE;

      int full_temp = lleno;
      full_temp++;
      lleno = full_temp;
      pthread_mutex_unlock(&mutex);
    }
    usleep(rand() % 300000);
  }

}

void *consumer(void *id) {   
  for(int i = 0; i < STACK_SIZE; i++) {
    if (lleno > 0) {
      pthread_mutex_lock(&mutex);
      int full_temp = lleno;
      full_temp--;
      lleno = full_temp;

      printf("Consumer %d: %c\n", *((int *)id), stack[out_idx]);
      out_idx = (out_idx + 1) % STACK_SIZE;

      int empty_temp = vacio;
      empty_temp++;
      vacio = empty_temp;
      pthread_mutex_unlock(&mutex);
    }
    usleep(rand() % 300000);
  }

}

int main() {   
  pthread_t producers[PRODUCERS];
  pthread_t consumers[CONSUMERS];
  pthread_mutex_init(&mutex, NULL);

  pthread_attr_t attr;
  pthread_attr_init(&attr);
  pthread_attr_setdetachstate( &attr, PTHREAD_CREATE_JOINABLE );
  pthread_attr_setscope( &attr, PTHREAD_SCOPE_SYSTEM );

  int numberUno=1;
  int numberDos=2;
  pthread_create(&producers[0], &attr, (void *)producer, (void *)&numberUno);
  pthread_create(&producers[1], &attr, (void *)producer, (void *)&numberDos);
  sleep(1);
  pthread_create(&consumers[0], &attr, (void *)consumer, (void *)&numberUno);
  pthread_create(&consumers[1], &attr, (void *)consumer, (void *)&numberDos);
  sleep(2);

  for(int i = 0; i < PRODUCERS; i++) {
    pthread_join(producers[i], NULL);
  }
  for(int i = 0; i < CONSUMERS; i++) {
    pthread_join(consumers[i], NULL);
  }

  return 0;
}