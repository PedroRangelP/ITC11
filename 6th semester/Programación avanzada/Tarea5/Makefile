#Ignacio Alvarado Reyes A01656149
#Pedro Rangel Palacios A01650939

#First we´ll call the instructions for making the flip.man
man: flip flip.1
	nroff -man flip.1 > flip.man
#We believe that the final result of this makefile, flip, will result from compiling flip.o and getopt.o that result from the compilation of the files available
flip: flip.o getopt.o
	gcc -s -o flip flip.o getopt.o
#We compile flip.c with it´s flip.h file that contains the definitions for different functions and macros
flip.o: flip.c flip.h
	gcc -DBSD -DNDEBUG -O -c flip.c
#Then we compile the getopt.c file and create its .o file. Now we have enough files to compile flip
getopt.o: getopt.c
	gcc -DBSD -DNDEBUG -O -c getopt.c



