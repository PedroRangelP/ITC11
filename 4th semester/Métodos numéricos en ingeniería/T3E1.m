%Integrantes:
%Ricardo Juárez Tepos A01650943
%Pedro Rangel Palacios A01650939
%Alejandro Hernández A01650390
%Aldo Ponce de la Cruz A01651119

close all; clc;

A=[2,0,5;0,1,1;8,3,0];
A2=[40;10;20];
 
det(A);

B=A;
C=A;
D=A;
 
B(:,1)=A2;
C(:,2)=A2;
D(:,3)=A2;
 
det(B);
det(C);
det(D);
 
x1=det(B)/det(A);
x2=det(C)/det(A);
x3=det(D)/det(A);

fprintf("Regla de Cramer:\n");
fprintf("x1 = %f\n", x1);
fprintf("x2 = %f\n", x2);
fprintf("x3 = %f\n", x3);