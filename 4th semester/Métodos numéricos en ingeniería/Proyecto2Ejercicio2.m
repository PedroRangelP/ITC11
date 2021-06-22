%Mauricio Tlacaelel Olvera Campos A01656726
%Fernando Jose Garcia Cisneros A016557033
%Carlos Emilio Vega Martinez A01656258
%Alejandro Jaime Fernandez A01655035
clear all; close all; clc;
fprintf('El siguiente codigo utiliza el metodo de Regresion por minimos cuadrados con multiples \nvariables para obtener varios modelos y posteriormente seleccionar el mas adecuado\n \n')
fprintf('El modelo intenta relacionar las valiables independientes Temperatura y Concentracion \nde Sustrato con la variable independiente cantidad de Ethanol\n')
data=xlsread('C:\Users\mauol\Documents\Proyecto2.xlsx')%Importar datos de Excel
T=data(:,1); %Primera valiable independiente T (Temperatura)
S=data(:,2); %Segunda variable independiente S (substrato)
E=data(:,3); %Variable dependiente E (Ethanol)
n=length(T) %obtener el numero de experimentos realizados
x=1:1:n; 

%Modelo polinomio grado 1
Z=[ones(n,1) T S]; %Matriz Z
A=(Z'*Z)^-1*(Z'*E)
Yest=Z*A; %Valores sestimados de Ethanol

%Modelo polinomio grado 2
Z2=[ones(n,1) T S T.^2 S.^2]; %Matriz Z
A2=(Z2'*Z2)^-1*(Z2'*E)
Yest2=Z2*A2; %Valores sestimados de Ethanol

%Modelo polinomio grado 3
Z3=[ones(n,1) T S T.^2 S.^2 T.^3 S.^3]; %Matriz Z
A3=(Z3'*Z3)^-1*(Z3'*E)
Yest3=Z3*A3;%Valores sestimados de Ethanol

%Modelo propuesto en el articulo
Zp=[ones(n,1) T S T.*S T.^2 S.^2]; %Matriz Z
Ap=(Zp'*Zp)^-1*(Zp'*E)
Yestp=Zp*Ap;%Valores sestimados de Ethanol

subplot(2,1,1) 
plot(x,E,x,Yest,x,Yest2,x,Yest3,x,Yestp,'linewidth',1) 
title(['Datos reales vs modelos obtenidos'])
xlabel('run') 
ylabel('Ethanol') 
legend('Real','Modelo 1','Modelo 2','Modelo 3','Modelo Propuesto en articulo') 
grid on

subplot(2,1,2) 
plot(E,Yest,'x')
hold on
plot(E,Yest2,'o')
hold on
plot(E,Yest3,'+')
hold on
plot(E,Yestp,'*')
ryyest=corrcoef(Yest,E); 
ryyest=ryyest(1,2); 
ryyest2=corrcoef(Yest2,E); 
ryyest2=ryyest2(1,2);
ryyest3=corrcoef(Yest3,E); 
ryyest3=ryyest3(1,2);
ryyestp=corrcoef(Yestp,E); 
ryyestp=ryyestp(1,2);
xlabel('Datos reales') 
ylabel('Modelos') 
title([' r1=',num2str(ryyest),'  r2=',num2str(ryyest2),'  r3=',num2str(ryyest3),'  rp= ',num2str(ryyestp)])
legend('Modelo 1','Modelo 2','Modelo 3','Modelo Propuesto en articulo') 

paso=.1; 
f=@(x1,x2) A3(1)+A3(2).*x1+A3(3).*x2+A3(4).*x1.^2+A3(5).*x2.^2+A3(6).*x1.^3+A3(7).*x2.^3;
bmin = [22 130]; %minimo de busqueda 
bmax = [45 180]; %maximo de busqueda 
[xfx,yfx] = meshgrid(bmin(1):paso:bmax(1),bmin(2):paso:bmax(2));
figure 
surf(xfx,yfx, f(xfx,yfx)); 
title(['Modelo mas adecuado: Tercer Grado'])
xlabel('Temperatura [C]'); 
ylabel('Substrate [g]'); 
zlabel('Ethanol [g/L]')

disp(['La  función  obtenida  del  mejor  modelo  estimado  con  regresión  por  mínimos  cuadrados es '])
disp(['F(T,S)=102.9247+1.3383*T-5.9154*S-0.2101*T^2+0.0515*S^2+4.9011E-4*T^3-1.3761E-4*S^3'])
disp(['El coeficiente de determinación del mejor modelo obtenido es: ',num2str(ryyest3)])

