clear all; close all; clc;

x = 0.5;
Vexac = exp(x);
n = 3;
Ee = 0.5*10^(2-n);
i = 1;
Vaprox(i) = 1;
Vaprox(i+1) = Vaprox(i)+x^(i)/factorial(i);
Ev(i)=abs((Vexac-Vaprox(i))/Vexac)*100;
Ea(i)=abs((Vaprox(i+1)-Vaprox(i))/Vaprox(i+1))*100;

while Ea(i)>Ee
    i=i+1;
    Vaprox(i+1) = Vaprox(i)+x^(i)/factorial(i);
    Ev(i)=abs((Vexac-Vaprox(i))/Vexac)*100;
    Ea(i)=abs((Vaprox(i+1)-Vaprox(i))/Vaprox(i+1))*100;
end
