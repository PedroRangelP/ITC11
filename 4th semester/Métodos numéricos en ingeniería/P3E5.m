%Integrantes:
%Ricardo Juárez Tepos A01650943
%Pedro Rangel Palacios A01650939
%Alejandro Hernández A01650390
%Aldo Ponce de la Cruz A01651119

clear all; close all; clc;

simpson1 = [0, 0, 0, 0, 0, 0, 0];
simpson2 = [0, 0, 0, 0, 0, 0, 0];
fuerzaEnProfundidad = [0, 0, 0, 0, 0, 0, 0];

%Datos iniciales dados por el problema
p = 10;    %densidad del agua
g = 9.8;   %gravedad
D = 60;    %elevacion del fondo de la presa a la superficie del agua
w = [122, 130, 135, 160, 175, 190, 200]; %Anchos de la presa en distintas elevaciones
e = [0, 10, 20, 30, 40, 50, 60]; %Elevaciones de la presa

%Ecuacion para calcular la fuerza total ft
F1 = @(z) p * g * w(z) * (D - e(z));
%Ecuacion para calcular la Linea de accion d
F2 = @(z) p * g * e(z) * w(z) * (D - e(z));

%Regla de simpson, aplicacion multiple
a = 0;  %Limite de integracion inferior
b = 60; %Limite de integracion superior
n = 6;  %En este caso n es 6 para las profundidades que el problema requiere

%Iteraciones para aplicar la formula 
%I ≈ (b-a) * ((f(x0) + 4f(x1) + 2f(x2) + ... + f(xn))/(3n))
for i=1 : length(w)
    if(i==1)
        simpson1(i) = simpson1(i) + F1(i);
        simpson2(i) = simpson2(i) + F2(i);
    elseif(i==length(w))
        simpson1(i) = simpson1(i-1) + F1(i);
        simpson2(i) = simpson2(i-1) + F2(i);
    elseif(mod(i, 2) == 0)
        simpson1(i) = simpson1(i-1) + 4 * F1(i);
        simpson2(i) = simpson2(i-1) + 4 * F2(i);
    else
        simpson1(i) = simpson1(i-1) + 2 * F1(i);
        simpson2(i) = simpson2(i-1) + 2 * F2(i);
    end
end

%Fuerza total en la presa
fuerzaTotal = ((b-a) * sum(simpson1)) / (3*n);
d = (((b-a) * sum(simpson2)) / (3*n)) / fuerzaTotal;

fprintf("Fuerza total en la presa: " + fuerzaTotal+ " kg/m^3");
fprintf("\nLinea de accion: " + d);

%Fuerza en cada profundidad
for i=1 : length(simpson1)
    fuerzaEnProfundidad(i) = ((b-a) * sum(simpson1(i))) / (3*n);
end

figure(1)
plot(e, fuerzaEnProfundidad,'linewidth', 2)
xlabel('Profundidad [m]')
ylabel('Fuerza total [kg/m^3]')
title('Fuerza total en funcion de las elevaciones de la presa')
grid on