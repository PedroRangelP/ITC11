%Integrantes:
%Ricardo Juarez Tepos A01650943
%Pedro Rangel Palacios A01650939
%Alejandro Hernandez A01650390
%Aldo Ponce de la Cruz A01651119

close all; clc;

%Solicitar al usuario el número del problema que desea ver
fprintf("PROYECTO 1\n");
seleccion = input("Ingrese el numero del problema: ");
fprintf("--------------------------------------------------------\n");
switch seleccion
    case 1
        Problema1();
    case 2
        Problema2();
    case 3
        Problema3();
    case 4
        Problema4()
    otherwise
        disp("Opcion no valida")
end


%****************%
%   PROBLEMA 1   %
%****************%
function Problema1()
    %Descripcion del problema
    fprintf("Agregar descripcion\n");
    fprintf("--------------------------------------------------------\n");
    
    %Codigo del problema
end


%****************%
%   PROBLEMA 2   %
%****************%
function Problema2()
    %Descripción del problema
    fprintf("Si usted compra un equipo de $23,500.00 sin pago incial,\n");
    fprintf("y $6,500.00 por año durante 5 años. ¿Qué tasa de interes\n");
    fprintf("esta usted pagando?\n");
    fprintf("--------------------------------------------------------\n");
    
    %Código del problema
    P = 23500;
    A = 6500;
    n = 5;
    Es = 0.5;
    f = @(i) ((P*i*((1+i)^n)) / (((1+i)^n)-1)) - A;
    
    %Tabla donde se almacenan los resultados
    T = ["Iteraciones" "Raiz estimada" "Ea"];
    
    %Intervalo inicial donde se buscara la raiz
    xl = -2;
    xu = 1;
    
    %El error aprox es infinito, pero disminuira conforme pasen las
    %iteraciones
    Ea = inf;
    i = 1;
    xrAnt = 0;
    
    %Iteraciones mientras el error aprox sea menor al error relativo
    while Ea > Es
        xr(i) = xu-((f(xu)*(xl-xu))/(f(xl)-f(xu)));
        
        %Evaluciones para determinar si que el sub-intervalo esta en la
        %raiz
        if f(xl)*f(xr(i)) < 0
            xu = xr(i);
        elseif f(xl) * f(xr(i)) > 0
            xl = xr(i);
        else
            break;
        end
        %Determinar error aprox
        Ea = abs((xr(i)-xrAnt)/xr(i))*100;
        xrAnt = xr(i);
        
        %Agregamos los valores a la tabla
        R = [i xr(i) Ea];
        T = [T;R];
        
        i = i + 1;
    end
    
    %Imprimir resultado en la consola
    fprintf("La tasa de interes es de ");
    disp(xr(i-1))
    
    %Imprimir tabla en la consola
    fprintf("\nTabla de resultados: \n");
    disp(T)
    
    %Graficamos la ecuación
    intervalo = [-2, 1];
    fplot(f, intervalo)
    warning('off','last')
    grid on
    hold on
    plot(xr(i-1),0,'r*')
    xlabel('i')
    ylabel('f(i)')
    title("Tasa de interes")
end


%****************%
%   PROBLEMA 3   %
%****************%
function Problema3()
    %Descripción del problema
    fprintf("Agregar descripción\n");
    fprintf("--------------------------------------------------------\n");
    
    %Código del problema
end


%****************%
%   PROBLEMA 4   %
%****************%
function Problema4()
    %Descripción del problema
    fprintf("Agregar descripción\n");
    fprintf("--------------------------------------------------------\n");
    
    %Código del problema
end