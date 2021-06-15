/*
  Ignacio Alvarado Reyes A01656149
  Pedro Rangel Palacios A01650939
*/
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <stdbool.h>

#define NOMBRE_LEN 50

typedef struct persona{
  char nombre[NOMBRE_LEN];
  int edad;
  struct persona *siguiente;
} Persona;

void insertar(Persona *persona, Persona** raiz){
  //Insertar raiz
  if(*raiz == NULL){
    *raiz = persona;
    return;
  }
  
  //Insertar a la izquierda
  if(strcmp(persona->nombre, (*raiz)->nombre) < 0){
    persona->siguiente = *raiz;
    *raiz = persona;
    return;
  }

  Persona *temp1 = *raiz;
  Persona *temp2 = temp1->siguiente;

  //Insertar en el centro
  while(temp2 != NULL){
    if(strcmp(persona->nombre, temp1->nombre) > 0 && strcmp(persona->nombre, temp2->nombre) < 0){
      persona->siguiente = temp2;
      temp1->siguiente = persona;
      return;
    }else{
      temp1 = temp2;
      temp2 = temp2->siguiente;
    }
  }

  //Insertar a la derecha
  temp1->siguiente = persona;
}

void imprimir(Persona *raiz){
  Persona * p = raiz;

  if(p == NULL){
     printf("-- Lista vacia\n");
    return;
  }
  while (p != NULL){
    printf("* Nombre: %s, Edad: %d\n", p->nombre, p->edad);
    p = p->siguiente;
  }
}

void crear(Persona** raiz){
  Persona *p;
  p = (Persona *) malloc(sizeof(Persona));
  char nombre[NOMBRE_LEN];
  int edad;

  printf("Nombre: "); scanf("%s", nombre);
  printf("Edad: "); scanf("%d", &edad);
  strcpy(p->nombre, nombre);
  p->edad = edad;
  p->siguiente = NULL;
  insertar(p, raiz);
  printf("-- Persona creada\n");
}

void borrar(Persona **raiz){
  if(*raiz == NULL){
    printf("-- Lista vacia\n");
    return;
  }

  char nombre_eliminar[NOMBRE_LEN];

  printf("Nombre: "); scanf("%s", nombre_eliminar);

  if(strcmp(nombre_eliminar, (*raiz)->nombre) == 0){
    Persona *p = *raiz;
    *raiz = (*raiz)->siguiente;
    free(p);
    printf("-- Persona borrada\n");
    return;
  }

  Persona *temp1 = *raiz;
  Persona *temp2 = temp1->siguiente;

  while(temp2 != NULL){
    if(strcmp(nombre_eliminar, temp2->nombre) == 0){
      temp1->siguiente = temp2->siguiente;
      free(temp2);
      printf("-- Persona borrada\n");
      return;
    }else{
      temp1 = temp2;
      temp2 = temp2->siguiente;
    }
  }

  if(temp2 == NULL) printf("-- Persona no encontrada\n");
}

void actualizar (Persona **raiz){
  if(*raiz == NULL){
    printf("-- Lista vacia\n");
    return;
  }

  char nombre_actualizar[NOMBRE_LEN];
  int edad_actualizar;

  printf("Nombre: "); scanf("%s", nombre_actualizar);

  Persona *p = *raiz;

  while(p != NULL && strcmp(nombre_actualizar, p->nombre) != 0){
    p = p->siguiente;
  }
  if(p != NULL){
    printf("Nueva edad: "); scanf("%d", &edad_actualizar);
    p->edad = edad_actualizar;
    printf("-- Edad actualizada\n");
  }else{
    printf("-- Persona no encontrada\n");
  }
}

int main(void) {
  Persona * raiz = NULL;
  int opcion = 0;

  printf("------- M E N U -------\n");
  printf("1 - Crear persona\n2 - Actualizar edad\n3 - Borrar persona\n4 - Imprimir lista\n5 - Salir\n");
  printf("-----------------------\n");

  while(opcion != 5){
    printf("\n-- Ingrese opcion: "); scanf("%d", &opcion);
    switch(opcion){
      case 1:
        crear(&raiz);
        break;
      case 2:
        actualizar(&raiz);
        break;
      case 3:
        borrar(&raiz);
        break;
      case 4:
        imprimir(raiz);
        break;
      case 5:
        break;
      default:
        printf("-- Ingrese una opcion valida\n");
    }
  }
  return 0;
}