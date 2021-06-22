%Integrantes:
%Ricardo Juarez Tepos A01650943
%Pedro Rangel Palacios A01650939
%Alejandro Hernandez A01650390
%Aldo Ponce de la Cruz A01651119

arch= "DataCovidMex.xlsx"; %Definimos el archivo de excel de donde sacaremos los datos
infe = xlsread(arch,'B2:B58'); %En esta linea escribimos el nombre del archivo y las celdas donde se encuentran nuestros valores de y
minfe=infe.';% Es importante que tengamos el archivo en la misma carpeta que nuestro codigo

%Definimos todas nuestras variables
n=length(minfe);
sumdex=0;
sumdey=0;
sumx3y=0;
sumx4y=0;
sumx5y=0;
sumx8=0;
sumx9=0;
sumx10=0;
sumx2=0;
sumx3=0;
sumx4=0;
sumx5=0;
sumx6=0;
sumx7=0;
sumxy=0;
sumx2y=0;
s1=0;
s2=0;
s3=0;
s4=0;
s5=0;

%En este ciclo hacemos todas sumas que ocuparemos en nuestras matrices
for i=1:length(minfe)
    %suma de x
    sumdex=sumdex+i;
    %suma de y
    sumdey=sumdey+minfe(i);
    %suma de x por y
    sumxy=sumxy+(i*minfe(i));
    %suma de x cuadrada
    sumx2=sumx2+(i^2);
    %Suma de x al cubo
    sumx3=sumx3+(i^3);
    %suma de x a la cuarta potencia
    sumx4=sumx4+(i^4);
    %Suma de x a la quinta potencia
    sumx5=sumx5+(i^5);
    %Suma de x a la sexta potencia
    sumx6=sumx6+(i^6);
    %Suma de x a la septima potencia
    sumx7=sumx7+(i^7);
    %Suma de x a la octava potencia
    sumx8=sumx8+(i^8);
    %Suma de x a la novena potencia
    sumx9=sumx9+(i^9);
    %suma de x a la decima potencia
    sumx10=sumx10+(i^10);
    %suma de x cuadrada por y
    sumx2y=sumx2y+((i^2)*minfe(i));
    %Suma de x al cubo por y
    sumx3y=sumx3y+((i^3)*minfe(i));
    %Suma de x a la cuarta por y
    sumx4y=sumx4y+((i^4)*minfe(i));
    %Suma de x a la quinta por y
    sumx5y=sumx5y+((i^5)*minfe(i));
end

%primer grado


%Funcion coeficiente 1
a11=((n*sumxy)-(sumdex*sumdey))/((n*sumx2)-(sumdex^2));
%Funcion coeficiente 0
a10=(sumdey/i)-(a11*sumdex/i);
%Polinomio 1
p1=@(q) a10+a11*q;

for i=1: length(minfe)
    z=(minfe(i)-(sumdey/57)).^2;
    s1=s1+(minfe(i)-a10-a11*i)^2;
end
%desviaci�n estandar polinomio 1
de1=sqrt(z/(n-1));
%Error estandar polinomio 1
es1=sqrt(s1/(i-2));
%coeficiente de determinaci�n polinomio 1
cd1=(z-s1)/z; 
%Coeficiente de correlaci�n polinomio 1
cc1=sqrt(cd1);

%Imprimimos la grafica del primer polinomio 
subplot(4,2,1)
plot(1:i,minfe,"-",1:57,p1(1:i),"*")
title("Aproximaci�n polinomio 1")
legend({'Crecimiento de infectados', 'Aproximaci�n del polinomio'},'Location','northwest')
grid on
xlabel("D�as")
ylabel("N�mero de infectados")

%segundo grado

%Matriz a del polinomio 2
ma2=[n sumdex sumx2; sumdex sumx2 sumx3; sumx2 sumx3 sumx4];
%Matriz b del polinomio 2
mb2=[sumdey sumxy sumx2y].';
%Obtenemos los coeficientes del polinomio 2
x2=(ma2^-1)*(mb2);
%polinomio 2
p2=@(e) x2(1)+(x2(2)*e)+(x2(3)*e.^2);

%Imprimimos la grafica del polinomio 2
subplot(4,2,2)
plot(1:i,minfe,"-",1:57,p2(1:i),"*")
title("Aproximaci�n polinomio 2")
legend({'Crecimiento de infectados', 'Aproximaci�n del polinomio'},'Location','northwest')
grid on
xlabel("D�as")
ylabel("N�mero de infectados")


for  i=1: length(minfe)
    s2=s2+(minfe(i)-x2(1)-x2(2)*i-x2(3)*i^2)^2;
end
%desviaci�n estandar polinomio 2
de2=sqrt(z/(n-1));
%Error estandar polinomio 2
es2=sqrt(s2/(i-3));
%coeficiente de determinaci�n polinomio 2
cd2=(z-s2)/z; 
%Coeficiente de correlaci�n polinomio 2
cc2=sqrt(cd2);

%Tercer grado

%Se usa el mismo procedimiento que en el polinomio 2
ma3=[n sumdex sumx2 sumx3; sumdex sumx2 sumx3 sumx4;
    sumx2 sumx3 sumx4 sumx5; sumx3 sumx4 sumx5 sumx6];
mb3=[sumdey sumxy sumx2y sumx3y].';
x3=(ma3^-1)*(mb3);
p3=@(e) x3(1)+(x3(2)*e)+(x3(3)*e.^2)+(x3(4)*e.^3);

%imprimimos la grafica del polinomio 3
subplot(4,2,3)
plot(1:i,minfe,"-",1:57,p3(1:i),"*")
title("Aproximaci�n polinomio 3")
legend({'Crecimiento de infectados', 'Aproximaci�n del polinomio'},'Location','northwest')
grid on
xlabel("D�as")
ylabel("N�mero de infectados")

for  i=1: length(minfe)
    s3=s3+(minfe(i)-x3(1)-x3(2)*i-(x3(3)*i^2)-(x3(4)*i^3))^2;
end
%desviaci�n estandar polinomio 3
de3=sqrt(z/(n-1));
%Error estandar polinomio 3
es3=sqrt(s3/(i-4));
%coeficiente de determinaci�n polinomio 3
cd3=(z-s3)/z; 
%Coeficiente de correlaci�n polinomio 3
cc3=sqrt(cd3);

%Cuarto grado

%Se sigue el mismo procedimiento que en el polinomio 2
ma4=[n sumdex sumx2 sumx3 sumx4; sumdex sumx2 sumx3 sumx4 sumx5;
    sumx2 sumx3 sumx4 sumx5 sumx6; sumx3 sumx4 sumx5 sumx6 sumx7;
    sumx4 sumx5 sumx6 sumx7 sumx8];
mb4=[sumdey sumxy sumx2y sumx3y sumx4y].';
x4=(ma4^-1)*(mb4);
p4=@(e) x4(1)+(x4(2)*e)+(x4(3)*e.^2)+(x4(4)*e.^3)+(x4(5)*e.^4);

%Imprimimos la grafica del polinomio 4
subplot(4,2,4)
plot(1:i,minfe,"-",1:57,p4(1:i),"*")
title("Aproximaci�n polinomio 4")
legend({'Crecimiento de infectados', 'Aproximaci�n del polinomio'},'Location','northwest')
grid on
xlabel("D�as")
ylabel("N�mero de infectados")

for  i=1: length(minfe)
    s4=s4+(minfe(i)-x4(1)-x4(2)*i-(x4(3)*i^2)-(x4(4)*i^3)-(x4(5)*i^4))^2;
end
%desviaci�n estandar polinomio 4
de4=sqrt(z/(n-1));
%Error estandar polinomio 4
es4=sqrt(s4/(i-5));
%coeficiente de determinaci�n polinomio 4
cd4=(z-s4)/z; 
%Coeficiente de correlaci�n polinomio 4
cc4=sqrt(cd4);

%Quinto grado

%Se sigue el mismo procedimiento que en el polinomio 2
ma5=[n sumdex sumx2 sumx3 sumx4 sumx5; sumdex sumx2 sumx3 sumx4 sumx5 sumx6;
    sumx2 sumx3 sumx4 sumx5 sumx6 sumx7; sumx3 sumx4 sumx5 sumx6 sumx7 sumx8;
    sumx4 sumx5 sumx6 sumx7 sumx8 sumx9; sumx5 sumx6 sumx7 sumx8 sumx9 sumx10];
mb5=[sumdey sumxy sumx2y sumx3y sumx4y sumx5y].';
x5=(ma5^-1)*(mb5);
p5=@(e) x5(1)+(x5(2)*e)+(x5(3)*e.^2)+(x5(4)*e.^3)+(x5(5)*e.^4)+(x5(6)*e.^5);

%Imprimimos la grafica del polinomio 5
subplot(4,2,5)
plot(1:i,minfe,"-",1:57,p5(1:i),"*")
title("Aproximaci�n polinomio 5")
legend({'Crecimiento de infectados', 'Aproximaci�n del polinomio'},'Location','northwest')
grid on
xlabel("D�as")
ylabel("N�mero de infectados")

for  i=1: length(minfe)
    s5=s5+(minfe(i)-x5(1)-x5(2)*i-(x5(3)*i^2)-(x5(4)*i^3)-(x5(5)*i^4)-(x5(6)*i^5))^2;
end
%desviaci�n estandar polinomio 5
de5=sqrt(z/(n-1));
%Error estandar polinomio 5
es5=sqrt(s4/(i-5));
%coeficiente de determinaci�n polinomio 5
cd5=(z-s4)/z; 
%Coeficiente de correlaci�n polinomio 5
cc5=sqrt(cd4);
 
%Error estandar de cada polinomio
me=[de1/1000 es1/1000 cd1 cc1; de2/1000 es2/1000 cd2 cc2; de3/1000 es3/1000 cd3 cc3; de4/1000 es4/1000 cd4 cc4
    de5/1000 es5/1000 cd5 cc5]; 
%matriz con desviaci�n estandar, error estandar, coeficiente de determinaci�n y coeficiente de correlaci�n

%Imprimimos la gr�fica de los parametros de cada polinomio
subplot(4,2,6)
plot(1:5,me(:,1),"v", 1:5,me(:,2),"*", 1:5,me(:,3),"o", 1:5,me(:,4),":")
title("Aproximaciones de cada polinomio ")
legend({'Desviaci�n de estandar','Error estandar','Coeficiente de determinaci�n', 'Coeficiente de correlaci�n'},'Location','southeast')
grid on
xlabel("N�mero del polinomio")
ylabel("valor")

mw=max(me(:,3));
ku=find(me(:,3)==mw);%Mediante el coeficiente de determinaci�n obtenemos el polinomio mas exacto
disp(["La siguiente matriz contiene la desviaci�n estandar, el error estandar, coeficiente de determinaci�n y coeficiente de correlaci�n"])
%La matriz da numeros complejos porque al sacar el coeficiente de correlaci�n intenta  sacar la raiz de un numero negativo
me1=me;
%Imprimimos el polinomio m�s exacto junto con su gr�fica
if ku(1)==1
   disp(["El polinomio adecuado es el de primer grado:"])
   disp(["y=",a10,"+",a11,"x"])
   disp(["Coeficiente de correlaci�n (r^2):",me(1,3)])
   subplot(4,2,7)
    plot(1:i,minfe,"-",1:57,p1(1:i),"*")
    title("Mejor polinomio")
    legend({'Crecimiento de infectados', 'Aproximaci�n del polinomio'},'Location','northwest')
    grid on
    xlabel("D�as")
    ylabel("N�mero de infectados")
end

if ku(1)==2
   disp(["El polinomio adecuado es el de segundo grado"])
   disp(["y=",x2(1),"+",x2(2),"x +",x2(3),"x^2"])
   disp(["Coeficiente de correlaci�n (r^2):",me(2,3)])
   subplot(4,2,7)
    plot(1:i,minfe,"-",1:57,p2(1:i),"*")
    title("Mejor polinomio")
    legend({'Crecimiento de infectados', 'Aproximaci�n del polinomio'},'Location','northwest')
    grid on
    xlabel("D�as")
    ylabel("N�mero de infectados")
end

if ku(1)==3
   disp(["El polinomio adecuado es el de tercer grado:"])
   disp(["y=",x3(1),"+",x3(2),"x +",x3(3),"x^2 +",x3(4),"x^3"])
   disp(["Coeficiente de correlaci�n (r^2):",me(3,3)])
   subplot(4,2,7)
    plot(1:i,minfe,"-",1:57,p3(1:i),"*")
    title("Mejor polinomio")
    legend({'Crecimiento de infectados', 'Aproximaci�n del polinomio'},'Location','northwest')
    grid on
    xlabel("D�as")
    ylabel("N�mero de infectados")
end

if ku(1)==4
   disp(["El polinomio adecuado es el de cuarto grado:"])
   disp(["y=",x4(1),"+",x4(2),"x +",x4(3),"x^2 +",x4(4),"x^3 +",x4(5),"x^4"])
   disp(["Coeficiente de correlaci�n (r^2):",me(4,3)])
   subplot(4,2,7)
    plot(1:i,minfe,"-",1:57,p4(1:i),"*")
    title("Mejor polinomio")
    legend({'Crecimiento de infectados', 'Aproximaci�n del polinomio'},'Location','northwest')
    grid on
    xlabel("D�as")
    ylabel("N�mero de infectados")
end

if ku(1)==5
   disp(["El polinomio adecuado es el de quinto grado:"])
   disp(["y=",x5(1),"+",x5(2),"x +",x5(3),"x^2 +",x5(4),"x^3 +",x5(5),"x^4 +",x5(6),"x^5"])
   disp(["Coeficiente de correlaci�n (r^2):",me(5,3)])
   subplot(4,2,7)
    plot(1:i,minfe,"-",1:57,p5(1:i),"*")
    title("Mejor polinomio")
    legend({'Crecimiento de infectados', 'Aproximaci�n del polinomio'},'Location','northwest')
    grid on
    xlabel("D�as")
    ylabel("N�mero de infectados")

end