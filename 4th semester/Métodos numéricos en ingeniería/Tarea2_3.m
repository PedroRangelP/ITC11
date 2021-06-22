%Integrantes:
%Ricardo Juárez Tepos A01650943
%Pedro Rangel Palacios A01650939
%Alejandro Hernández A01650390
%Aldo Ponce de la Cruz A01651119

clear all; close all; clc;

%Valores dados
x = [1, 1.5, 1.6, 2.5, 3.5, 3.7, 4.8, 5.5, 6];
y = [0.6767, 0.3734, 0.3261, 0.08422, 0.01596, 0.00598, 0.00158, -0.1589, -0.5789];
n = length(x);

%Gráfica valores dados
subplot(2,1,1)
plot(x(1:end),y,'-o')
grid on
xlabel('X')
ylabel('Y')
legend('f(x)','fontsize',12,'location','best')

%Tamaño de paso
deltaH = 0.1;
h = 1:deltaH:6;
%m = length(h);

j = 1;

for i=2:n-1
    i2 = x(i+1);
    
    while h(j) < i2
        df(j) = y(i-1)*((2*h(j)-x(i)-x(i+1))/((x(i-1)-x(i))*(x(i-1)-x(i+1))))+...
                y(i)*((2*h(j)-x(i-1)-x(i+1))/((x(i)-x(i-1))*(x(i)-x(i+1))))+...
                y(i+1)*((2*h(j)-x(i-1)-x(i))/((x(i+1)-x(i-1))*(x(i+1)-x(i))));
        j = j+1;
    end 
end

%for i=2:m
%    j = fixedIndex(h(i), x); 
%    df(i) = y(j-1)*((2*h(i)-x(j)-x(j+1))/((x(j-1)-x(j))*(x(j-1)-x(j+1))))+...
%            y(j)*((2*h(i)-x(j-1)-x(j+1))/((x(j)-x(j-1))*(x(j)-x(j+1))))+...
%            y(j+1)*((2*h(i)-x(j-1)-x(j))/((x(j+1)-x(j-1))*(x(j+1)-x(j))));
%end

subplot(2,1,2)
%plot(h(1:end-1),df,h,df,'*','linewidth',1.25)
plot(h(1:end-1),df,'-*')
grid on
xlabel('X')
ylabel('Y')
legend("f '(x)",'fontsize',12,'location','best')

%Determinar el índice Xi
function j = fixedIndex(value, array)
    for k=1:length(array)
        if (value >= array(k)) && (value < array(k+1))
            j = k;
        end
    end
end
