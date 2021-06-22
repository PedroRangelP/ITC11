%Integrantes:
%Ricardo Juárez Tepos A01650943
%Pedro Rangel Palacios A01650939
%Alejandro Hernández A01650390
%Aldo Ponce de la Cruz A01651119

clear all; close all; clc;

%Valores dados
t = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, ...
    16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30];
V = [0.00, 8.96, 16.42, 22.63, 27.80, 32.10, 35.68, 38.66, 41.14, 43.20, 44.92, ...
    46.35, 47.54, 48.53, 49.35, 50.04, 50.61, 51.09, 51.48, 51.81, 52.08, 52.31, ...
    52.50, 52.66, 52.79, 52.90, 52.99, 53.07, 53.13, 53.18, 53.23];

h1 = 2;
h2 = 1;
x1 = 0:h1:30;
x2 = 0:h2:30;

%Diferencia dividida hacia atrás de h1
for i=2:length(x1)
    index = x1(i)+1;
    dfh1(i-1) = backward(V(index), V(index-2), h1);
end

%Diferencia dividida hacia atrás de h2
for i=2:length(x2)
    index = x2(i)+1;
    dfh2(i-1) = backward(V(index), V(index-1), h2);
end

%Richardson
j=2;
for i=1:length(dfh1)
   dfr(i)=(4/3)*dfh2(j)-(1/3)*dfh1(i);
   j=j+2;
end

figure
plot(x1(2:end),dfh1,'*',x2(2:end),dfh2,'+',x1(2:end),dfr,'o')
xlabel('Time [s]')
ylabel('Aceleration [m/s^2]')
legend('h1','h2','Extrapolación Richardson','location','best')

function df = backward(y1, y2, h)
    df = (y1-y2)/h;
end