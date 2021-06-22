%Integrantes:
%Ricardo Juárez Tepos A01650943
%Pedro Rangel Palacios A01650939
%Alejandro Hernández A01650390
%Aldo Ponce de la Cruz A01651119

close all; clc;

% Metodo gráfico, podemos obsevar que las intersecciones
% ocurren en x1 = 10 y x2 = 14.5

x1 = 5:0.5:15;

x2a = 0.5*x1 + 9.5;
x2b = (1.02*x1 + 18.8)/2;

plot(x1,x2a,'-*',x1,x2b,'-+')
grid on
xlabel('x_1')
ylabel('x_2')
legend('0.5x_1 + 9.5','(1.02x_1 + 18.8)/2')


%Método de eliminación de incógnitas
A = [0.5 -1; 1.02 -2];
B = [-9.5; -18.8];

    %Determinante
detA = A(1,1)*A(2,2)-A(1,2)*A(2,1);

    %Regla de Cramer
elimX1 = det([B A(:,2)])/detA;
elimX2 = det([A(:,1) B])/detA;

fprintf("Método de eliminación de incógnitas:\n");
fprintf("x1 = %f\n", elimX1);
fprintf("x2 = %f\n", elimX2);


