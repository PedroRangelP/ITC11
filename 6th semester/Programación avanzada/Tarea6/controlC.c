/*
  Ignacio Alvarado Reyes A01656149
  Pedro Rangel Palacios A01650939
*/
#include<stdio.h>
#include<unistd.h>
#include<stdlib.h>
#include<signal.h>
#include <stdbool.h>

/* Define el manejador que será llamado luego de recibir un ctrl-c (SIGINT) */
void control_c(int sig_sum);
bool one = false;
bool two = false;
void alarma(int sig_num) {
  printf("\nEl temporizador expiró\n");
  one=false;
  //two=false;
}

void control_c(int signum){
  if(one == false){
    one=true;
  }else{
    two=true;
  }
  if(two){
    exit(1);
  }
  signal(SIGALRM, alarma);
  alarm(5);
  printf("Vuelve a digitar Control-C para terminar\n");
}

int main() {
  // Registrar el manejador de señal
  signal(SIGINT, control_c);
  while(1){
    if(one){
      printf("Esperando terminación \n");
    }else{
      printf("Procesando cosas \n");
    }
    
    sleep(1);
  }
  return EXIT_SUCCESS;
}