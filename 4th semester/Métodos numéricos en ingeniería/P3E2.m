%Integrantes:
%Ricardo Juárez Tepos A01650943
%Pedro Rangel Palacios A01650939
%Alejandro Hernández A01650390
%Aldo Ponce de la Cruz A01651119

clear all; close all; clc;

%Datos iniciales dados por el problema
radio = [0, 1.6, 3.2, 4.8, 6.4, 7.47, 7.87, 7.95, 8];
velocidad = [10, 9.69, 9.30, 8.77, 7.95, 6.79, 5.57, 4.89, 0];

%Ecuacion para calcular el flujo de masa
F = @(r, v) 1.2 * v * 2*pi * r;

%Hacemos uso de la regla del trapecio para calcular la integral
%en cada uno de los segmentos del tubo.

for i=2 : length(radio)
    b = radio(i);
    a = radio(i-1);
    
    FB = F(radio(i), velocidad(i));
    %Calculando respecto al radio anterior
    %FA = F(radio(i -1), velocidad(i-1));
    %Calculando desde radio 0 hasta el radio actual
    FA = 0;
    
    %Regla del trapecio
    resultado(i-1) = (b-a) * ((FA + FB)/2); 
end

for i=2 : length(radio)
    fprintf("Flujo de masa con radio " + radio(i) + ": " + resultado(i-1) + " kg/s\n")
end

figure(1)
plot(radio(2:end), resultado, "LineWidth", 2)
grid on
xlabel('Radio [cm]')
ylabel('Flujo de masa [kg/s]')
title("Flujo de masa a lo largo del tubo")