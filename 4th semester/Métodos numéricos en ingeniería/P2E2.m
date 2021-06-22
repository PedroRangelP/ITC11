%Integrantes:
%Ricardo Juarez Tepos A01650943
%Pedro Rangel Palacios A01650939
%Alejandro Hernandez A01650390
%Aldo Ponce de la Cruz A01651119

close all; clc;
fprintf("PROYECTO 2\nResgresion Minimos Cuadrados Lineales Multiples\n\n");

%************************************%
%  Importar datos del archivo Excel  %
%************************************%

name = 'Ex.xlsx';

%Determinar el numero de datos
data = xlsread(name);
n = size(data);
x = (1:n(1))';

%Verificar max 3 variables independientes
if n(2)-1>3
    error('ERROR: El archivo debe contener maximo 3 variables independientes')
end

%Variable dependiente
Y = data(:, n(2));


%********************************************************%
%  Matriz [Z] - Valores de las variables independientes  %
%********************************************************%
%{
1 variables
1er orden y = a0 + a1x1
2do orden y = a0 + a1x1 + a2x1^2
3er orden y = a0 + a1x1 + a2x1^2 + a3x1^3

2 variables
1er orden y = a0 + a1x1 + a2x2
2do orden y = a0 + a1x1 + a2x1^2 + a3x2 + a4x2^2
3er orden y = a0 + a1x1 + a2x1^2 + a3x1^3 + a4x2 + a5x2^2 + a6x2^3

3 variables
1er orden y = a0 + a1x1 + a2x2 + a3x3
2do orden y = a0 + a1x1 + a2x1^2 + a3x2 + a4x2^2 + a5x3 + a6x3^2
3er orden y = a0 + a1x1 + a2x1^2 + a3x1^3 + a4x2 + a5x2^2 + a6x2^3 + a7x3 + a8x3^2 + a9x3^3
%}


Z1 = [ones(n(1), 1)]; %Orden 1
Z2 = [ones(n(1), 1)]; %Orden 2
Z3 = [ones(n(1), 1)]; %Orden 3
for i = 1:n(2)-1
    temp = data(:,i);
    Z1 = [Z1 temp];
    Z2 = [Z2 temp temp.^2];
    Z3 = [Z3 temp temp.^2 temp.^3];
end


%**********************************%
%  Datos de los modelos obtenidos  %
%**********************************%
%Matriz [A] - Estimacion de los coeficientes
A1 = (Z1'*Z1)^-1*(Z1'*Y); %Orden 1
A2 = (Z2'*Z2)^-1*(Z2'*Y); %Orden 2
A3 = (Z3'*Z3)^-1*(Z3'*Y); %Orden 3

%Estimacion de la variable dependiente
Yest1 = Z1*A1; %Orden 1
Yest2 = Z2*A2; %Orden 2
Yest3 = Z3*A3; %Orden 3


%********************************************************%
%  Grafica comparativa datos reales y modelos obtenidos  %
%********************************************************%
figure(1)
subplot(2,1,1)
plot(x,Y,'linewidth', 4, 'color','r')
hold on
plot(x,Yest1, 'linewidth', 2,'color','b')
plot(x,Yest2, 'linewidth', 2, 'color','m')
plot(x,Yest3,'linewidth', 2, 'color','g')
legend('Valor real', 'Modelo Orden 1','Modelo Orden 2','Modelo Orden 3')
title('Estimacion variable dependiente')
grid on
hold off


%****************************%
%  Parametros de evaluacion  %
%****************************%
%Suma de residuos^2 respecto a la media
St = sum((Y-mean(Y)).^2);

%Suma de residuos^2 respecto al modelo
Sr1 = sum((Y-Yest1).^2);
Sr2 = sum((Y-Yest2).^2);
Sr3 = sum((Y-Yest3).^2);

%Desviacion estandar
Dstd = sqrt(St/(n(1)-1));

%Error estandar
Estd1 = sqrt(Sr1/(n(1)-2));
Estd2 = sqrt(Sr2/(n(1)-2));
Estd3 = sqrt(Sr3/(n(1)-2));

%Coeficiente de determinacion
R2modelos = [];
R2modelos(1) = (St-Sr1)/St;
R2modelos(2) = (St-Sr2)/St;
R2modelos(3) = (St-Sr3)/St;

%Coeficiente de correlacion
Rmodelo1 = sqrt(R2modelos(1));
Rmodelo2 = sqrt(R2modelos(2));
Rmodelo3 = sqrt(R2modelos(3));

%Tabla donde se guardan los valores
encabezado = ["Orden" "Desv. std." "Error std." "R^2" "R"];
datos = [1 Dstd Estd1 R2modelos(1) Rmodelo1; 2 Dstd Estd2 R2modelos(2) Rmodelo2; 3 Dstd Estd3 R2modelos(3) Rmodelo3];
tabla = [encabezado;datos];
%Mostrar tabla
fprintf("Tabla comparativa de los modelos obtenidos\n");
disp(tabla)


%****************%
%  Mejor Modelo  %
%****************%
%Obtener el mejor modelo en funcion del coeficiente de determinacion
[R2max, index] = max(R2modelos);

%Imprimir en la consola la ecuación del mejor modelo y el coeficiente de determinacion
fprintf("Coeficiente de correlacion del mejor modelo: " + R2max + "\n");
fprintf("Ecuacion del mejor modelo:\n");
%Si primer orden es el mejor
if(index == 1)
    mejorModelo = Yest1;
    if(n(2)-1 == 1)
        %1 variable
        fprintf("y= " + num2str(A1(1)) + "+" + num2str(A1(2)) + "x1");
    elseif(n(2)-1 == 2)
        %2 variables
        %1 2 3
        fprintf("y= " + num2str(A1(1)) + "+" + num2str(A1(2)) + "x1+" + num2str(A1(3)) + "x2");
    else
        %3 variables  
        %1 2 3 4
        fprintf("y= " + num2str(A1(1)) + "+" + num2str(A1(2)) + "x1+" + num2str(A1(3)) + "x2+" + num2str(A1(4)) + "x3");
    end

end
%Si segundo orden es el mejor
if(index == 2)
    mejorModelo = Yest2;
    if(n(2)-1 == 1)
        %1 variable
        fprintf("y= " + num2str(A2(1)) + "+" + num2str(A2(2)) + "x1+" + num2str(A2(3)) + "x1^2"); 
    elseif(n(2)-1 == 2)
        %2 variables
        %1 2 4 3 5
        fprintf("y= " + num2str(A2(1)) + "+" + num2str(A2(2)) + "x1+" + num2str(A2(4)) + "x2+" + + num2str(A2(3)) + "x1^2+" + num2str(A2(5)) + "x2^2");
    else
        %3 variables
        %1 2 4 6 3 5 7
        fprintf("y= " + num2str(A2(1)) + "+" + num2str(A2(2)) + "x1+" + num2str(A2(4)) + "x2+" + num2str(A2(6)) + "x3+" + num2str(A2(3)) + "x1^2+" + num2str(A2(5)) + "x2^2+" + num2str(A2(7)) + "x3^2");
    end

end
%Si tercer orden es el mejor
if(index == 3)
    mejorModelo = Yest3;
    if(n(2)-1 == 1)
        %1 variable
        fprintf("y= " + num2str(A3(1)) + "+" + num2str(A3(2)) + "x1+" + num2str(A3(3)) + "x2+" + num2str(A3(4)) + "x3");
    elseif(n(2)-1 == 2)
        %2 variables
        %1 2 5 3 6 4 7
        fprintf("y= " + num2str(A3(1)) + "+" + num2str(A3(2)) + "x1+" + num2str(A3(5)) + "x2+" + num2str(A3(3)) + "x1^2+" + num2str(A3(6)) + "x2^2+" + num2str(A3(4)) + "x1^3+" + num2str(A3(7)) + "x2^3");
    else
        %3 variables
        %1 2 5 8 3 6 9 4 7 10
        fprintf("y= " + num2str(A3(1)) + "+" + num2str(A3(2)) + "x1+" + num2str(A3(5)) + "x2+" + num2str(A3(8)) + "x3+" + num2str(A3(3)) + "x1^2+" + num2str(A3(6)) + "x2^2+" + num2str(A3(9)) + "x3^2+" + num2str(A3(4)) + "x1^3+" + num2str(A3(7)) + "x2^3+" + num2str(A3(10)) + "x3^3");
    end

end

%Grafica comparativa datos reales y mejor modelo
subplot(2,1,2)
plot(x, Y, 'linewidth', 4)
hold on
plot(x, mejorModelo, 'linewidth', 2)
legend('Valor real', strcat('Modelo Orden ',num2str(index)))
title('Mejor modelo')


%*****************************************************%
%  Gafica de parametros de evaluacion de los Modelos  %
%*****************************************************%

c = categorical({'Orden', 'Desv. std.', 'Error std.', 'R^2', 'R'});

figure(2)
subplot(3,1,1)
bar(c, datos(1, :))
title("Modelo 1")

subplot(3,1,2)
bar(c, datos(2, :))
title("Modelo 2")

subplot(3,1,3)
bar(c, datos(2, :))
title("Modelo 3")