clear all;
close all; clc;

c = 12.5; %coeficiente de arrastre [m/s]
m = 68.1; %masa del sujeto [kg]
g = 9.8;
dt = 0.5;
t=0:dt:100;
Vaprox(1) = 0;
Vexac = ((g*m)/c)*(1-exp(-(c/m)*t));
n = length(t);

for i=2:n
    Vaprox(i) = Vaprox(i-1)+(g-(c/m)*Vaprox(i-1))*dt;
end

figure(1)
plot(t,Vexac, '--',t,Vaprox, 'c', 'linewidth', 2)
grid on
xlabel('Tiempo [s]')
ylabel('Velocidad [m/s]')
title('Método 1', 'fontsize', 18)
legend('Sol. análitica','Sol. aprox.', 'location', 'best')

%t Vexac Vaprox Ever Eaprox
R=[t(2:n)' Vexac(2:n)' Vaprox(2:n)' abs(Vexac(2:n)-Vaprox(2:n))' abs((Vexac(2:n)-Vaprox(2:n))./Vexac(2:n))']