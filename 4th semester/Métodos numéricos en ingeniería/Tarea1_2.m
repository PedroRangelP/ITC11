%Integrantes:
%Ricardo Juárez Tepos A01650943
%Pedro Rangel Palacios A01650939
%Alejandro Hernández A01650390
%Aldo Ponce de la Cruz A01651119

clear all; close all; clc;

E=24; %Voltaje [Vdc]
L=0.5; %Inductacia [H]
R=5; %Resistencia

h=0.02;
t=0:h:0.6;
Iaprox(1)=0;
Iexac=(E/R)*(1-exp(-(R/L)*t));
n=length(t)-1;

for i=1:n
    m = ((E/L)-(R/L)*Iaprox(i));
    Iaprox(i+1) = Iaprox(i)+m*h;
end

figure(1)
plot(t,Iexac,'--',t,Iaprox,'linewidth', 2)
grid on
xlabel('Tiempo [s]')
ylabel('Corriente [A]')
title('Corriente del circuito')
legend('Corriente exac.','Corriente aprox.','location','best')