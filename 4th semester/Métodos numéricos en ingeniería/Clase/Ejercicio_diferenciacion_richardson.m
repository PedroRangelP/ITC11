clear
clc
close all

A=@(x) -0.1*x.^4-0.15*x.^3-0.5*x.^2-0.25*x+1.2;
dA=@(x) -0.4*x.^3-0.45*x.^2-x-0.25;
h1=0.5;
h2=0.25;
x1=0:h1:5;
x2=0:h2:5;

y1=A(x1);
y2=A(x2);

plot(x1,y1,'o',x2,y2,'*')

for i=2:length(y1)
   dfh1(i-1)=(y1(i)-y1(i-1))/h1; 
end

for i=2:length(y2)
   dfh2(i-1)=(y2(i)-y2(i-1))/h2; 
end
j=2;
for i=1:length(dfh1)
   dfr(i)=(4/3)*dfh2(j)-(1/3)*dfh1(i);
   j=j+2;
end

figure
plot(x2,dA(x2),x1(2:end),dfh1,'*',x2(2:end),dfh2,'+',x1(2:end),dfr,'.')
legend('real','h1','h2','Richardson','location','best')