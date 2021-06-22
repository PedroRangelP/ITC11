clear all;
close all
clc;

disp("Metodo de Newton Raphson")
disp(" ")

%Descripcion

disp("El problema dice que hay una viga uniforma sujeta a una carga distribuida") 
disp("linealmente creciente, usando el metodo de Newton-Raphson determinar el") 
disp("punto de deflexion maxima.")
disp(" ")
disp("Usando la siguiente foormla podemos resoverlo: y=((w/120*E*I*L)*(-x^5+2*L^2*x^3-L^4*x))")

%Pedimos valores

L=input("Introduzca la longitud de la viga en cm:");
w=input("Introduzca la fuerza inicial aplicada sobre la viga en kN/cm:");

%Definimos las variables con los datos del problema

E=50000*10^3; %Modulo de elasticidad
I=30000; %Momento de inercia
x=100:20:L; %Definimos el eje x, este inicia en 100 y acaba hasta la longitud de la tabla

%Definimos las funciones
fd=@(x) (w*(-5*x.^4+6*L^2*x.^2-L^4));
fdd=@(x)(w*(-20*x.^3+12*L^2*x));

%Graficamos las derivadas de la funcion para que se muestre una posible interseccion
plot(x,fd(x),".-","MarkerFaceColor","b")
grid on
title('Deflexionn Maxima')
xlabel('Deflexion de la viga [cm]','fontsize',14)
ylabel('Carga aplicada sobre la viga [kN]','fontsize',14)
hold on
plot(x,fdd(x),".-","MarkerFaceColor","r")

%Definimos el valor inicial de x, el cual sera distinto dependiendo de la deflexiion de la viga
xi(1)=200;
ea(1)=0;%Fijamos a nuestro error normalizado como cero solo para la primera interacion
iteraciones=6;
for i=2:iteraciones
    xi(i)=xi(i-1)-(fd(xi(i-1))/fdd(xi(i-1)));%Formula Newton Raphson
    pause(1)
    plot(xi(i),0,'*',"MarkerSize",10)%Graficamos las raíces obtenidas en cada iteración
    legend('Primera derivada',"Segunda derivada",'Aprox. raices')
    ea(i)=abs((xi(i)-xi(i-1))/xi(i))*100;%Calculamos el error normalizado en cada iteración
end

it=0:1:iteraciones-1;%Definimos una variable que contenga el numero de iteraciones realizadas
data=[it' xi' ea']%Creamos una matriz que contenga todos los datos que deseamos presentar en la tabla
disp('Iteraciones     Xi       Ea')