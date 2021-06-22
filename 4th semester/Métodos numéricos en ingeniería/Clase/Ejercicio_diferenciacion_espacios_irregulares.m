clear 
close 
clc

x=[0 2 5 6 9 13 15 19 25 26 27 30 33];
n=length(x);
y=[0 16.40 32.06 35.64 43.15 48.47 49.98 51.75...
    52.84 52.93 53.01 53.17 53.26];

c=12.5;
m=68.1;
g=9.81;
df=@(t) g*exp(-(c*t)/m);
a=df(x);

subplot(2,1,1)
plot(x,y,'*')
grid on
xlabel('Tiempo [s]')
ylabel('Velocidad [m/s]')

for i=2:n-1
      dif(i-1)=dif_irreg(x(i),x(i-1),x(i),x(i+1),y(i-1),y(i),y(i+1));
end

subplot(2,1,2)
plot(x,a,x(2:end-1),dif,'*')
grid on
xlabel('Tiempo [s]')
ylabel('Aceleración [m/s^2]')