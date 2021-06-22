clear 
close 
clc

f=@(x) -0.1*x.^4+0.15*x.^3+1.5*x.^2+0.25*x+5;
df=@(x) -0.4*x.^3+0.45*x.^2+3*x+0.25;
h=0.25;
x=0:h:5;
y=f(x);

subplot(2,1,1)
plot(x,y,'-*')
grid on
axis([0 5 0 17])
xlabel('Tiempo [s]')
ylabel('Desplazamiento [m]')
%dif. hacia adelante
for i=1:length(y)-1
   dy(i)=(y(i+1)-y(i))/h;
end
%dif. hacia adelante con alta exactitud
for i=1:length(y)-2
   dya(i)=(-y(i+2)+4*y(i+1)-3*y(i))/(2*h);
end
subplot(2,1,2)
plot(x,df(x),x(1:end-1),dy,'-*',x(1:end-2),dya,'-o')
grid on
axis([0 5 -20 7])
xlabel('Tiempo [s]')
ylabel('Velocidad [m/s]')
legend('real','forward','f.high ex')