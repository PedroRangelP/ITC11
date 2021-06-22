%Integrantes:
%Ricardo Juárez Tepos A01650943
%Pedro Rangel Palacios A01650939
%Alejandro Hernández A01650390
%Aldo Ponce de la Cruz A01651119

close all; clc;

deltaX = 0.5;

x = 0.5 : deltaX : 5;
valorExacto = sqrt(x);

for i=1:10
    orden1(i) = sqrt(x(i)) + 1/(2*sqrt(x(i)) ) * x(i);
    orden2(i) = orden1(i) + -1/(4*(x(i))^(3/2)) * (x(i)^2)/factorial(2);
    orden3(i) = orden2(i) +  3/(8*(x(i))^(5/2)) * (x(i)^3)/factorial(3);
end

figure(1)
title('sqrt x', 'fontsize', 18)
plot(x, valorExacto, x, orden1, x, orden2, x, orden3, 'linewidth', 2)
grid on
xlabel('Eje x')
ylabel('Eje y')
legend('Valor exacto', 'Orden 1', 'Orden 2', 'Orden 3', 'location', 'best')