%Integrantes:
%Ricardo Juárez Tepos A01650943
%Pedro Rangel Palacios A01650939
%Alejandro Hernández A01650390
%Aldo Ponce de la Cruz A01651119

close all; clc;

%Ecuaciones:
% DA + 2*PA -1/2*PB = 17.........(1)
% DB -1/2*PA +3*PB = 20..........(2)
% -DA -1/3*DB +PA = 2............(3)
% -1/4*DA -1/2*DB +PB = 2........(4)

%Matriz A
A = [1 0 2 -1/2; 0 1 -1/2 3; -1 -1/3 1 0; -1/4, -1/2 0 1];

%Vector B
B = [17; 20; 2; 2];

%Calcular valores de equilibrio
C = inv(A)*B;

fprintf("Valores de equilibrio:\n");
fprintf("DA = %f\n", C(1,1));
fprintf("DB = %f\n", C(2,1));
fprintf("PA = %f\n", C(3,1));
fprintf("PB = %f\n", C(4,1));