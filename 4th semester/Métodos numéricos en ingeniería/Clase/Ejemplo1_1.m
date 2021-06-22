clear all; 
close all; clc;

c=12.5; %coeficiente de arrastre [m/s]
m=68.1; %masa del sujeto [k]
g=9.8;
dt=1;
t=0:dt:100;
Vaprox(1)=0;
Vexac=((g*m)/c)*(1-exp(-(c/m)*t));
n=length(t);
for i=2:n
   Vaprox(i)=Vaprox(i-1)+(g-(c/m)*Vaprox(i-1))*dt;
   %Vaprox(i)=Vaprox(i-1)+(9.8-12.5/68.1*Vaprox(i-1))*(t(i)-t(i-1)); 
end
figure(1)
plot(t,Vexac,'--',t,Vaprox,'c','linewidth',2)
grid on
xlabel('Tiempo [s]')
ylabel('Velocidad [m/s]','fontsize',18)
title('Método 1')
legend('Sol. analítica','Sol. Aprox.')

R=[t(2:n)' Vexac(2:n)' Vaprox(2:n)' abs(Vexac(2:n)-Vaprox(2:n))' abs((Vexac(2:n)-Vaprox(2:n))./Vexac(2:n))']