%Integrantes:
%Ricardo Juarez Tepos A01650943
%Pedro Rangel Palacios A01650939
%Alejandro Hernandez A01650390
%Aldo Ponce de la Cruz A01651119

close all; clc;

%Solicitar al usuario el numero del problema que desea ver
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
    fprintf(['Metodo de biseccion\n\n'...
        'En este problema estamos resolviendo la ecuación de Manning para un canal rectangular abierto.' ...
        '\nDonde 𝑄 = caudal [𝑚^3/𝑠], 𝑆 = pendiente [m/m], 𝐻= profundidad [m] y ' ...
        '𝑛 = coeficiente de rugosidad de Manning.' ...
        '\nDatos iniciales: Q=5, S=0.0002, B=20 y n=0.03.' ...
        '\nObjetivo: Encontrar H con hi = 0m y hu = 5m a través del método de bisección.\n'])
    fprintf("--------------------------------------------------------\n");

    %Codigo del problema
    %Ecuación con los datos iniciales sustituidos
    H = @(h) (sqrt(0.0002)*(20*h).^(5/3))/(0.03*(20 + 2*h).^(2/3))-5;
    
    %Matriz donde almacenaremos número de iteración, raíz estimada y error
    %aproximado
    M = [];
    
    %Intervalo inicial donde vamos a buscar la raíz
    hi = 0;
    hu = 5;
    
    %Se hace una comprobación en caso de que el intervalo inicial no sea válido
    if H(hi) * H(hu) > 0
       error('El intervalo inicial no contiene una raíz')
    end
    
    %El error aproximado es infinito porque vamos a ir disminuyendolo conforme
    %pasen las iteraciones
    Ea = inf;
    Es = 0.05;
    i = 1;
    
    %El valor de la h anterior para calcular el Error aproximado
    prevH = 0;
    
    %Haremos iteraciones mientras el error aproximado sea mayor al establecido
    while Ea > Es
        hr(i) = (hi+hu)/2;
        
        if H(hi) * H(hr(i)) < 0
            hu = hr(i);
        elseif H(hi) * H(hr(i)) > 0
            hi = hr(i);
        else
            break;
        end
        Ea = abs((hr(i)-prevH) / hr(i)) * 100;
        prevH = hr(i);
        
        %Agregamos los valores a la matriz
        A = [i hr(i) Ea];
        M = [M;A];
        
        i = i + 1;
    end
    
    %Imprimiendo los resultados
    resultado = hr(end);
    fprintf("\nResultado: " + resultado + "m de profundidad, encontrado después" + ...
        " de " + length(hr) + " iteraciones.\n\n")
    fprintf("Iteración" + " Valor-estimado" + " Error-aproximado\n");
    disp(M)
    
    %Intervalo en el que vamos a graficar la ecuación
    intervalo = [0, 5];
    
    %Graficamos la ecuación
    fplot(H, intervalo)
    warning('off','last')
    grid on
    xlabel('h')
    ylabel('f(h)')
    title("Ecuación de Manning")
    
    %Marcamos la raíz encontrada en la gráfica
    hold on
    plot(resultado, 0, 'r*')
    legend('Valores dados', "Raíz")
end


%****************%
%   PROBLEMA 2   %
%****************%
function Problema2()
    %Descripcion del problema
    fprintf("Si usted compra un equipo de $23,500.00 sin pago incial,\n");
    fprintf("y $6,500.00 por año durante 5 años. ¿Qué tasa de interes\n");
    fprintf("esta usted pagando?\n");
    fprintf("--------------------------------------------------------\n");
    
    %Codigo del problema
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
    %Descripcion del problema
    fprintf("Metodo de Newton Raphson\n\n" + ...
        "El problema dice que hay una viga uniforma sujeta a una carga\n" + ...
        "distribuida linealmente creciente, usando el metodo de Newton-Raphson\n" + ...
        "determinar el punto de deflexion maxima.\n" + ...
        "Usando la siguiente formula podemos resoverlo: y=((w/120*E*I*L)*(-x^5+2*L^2*x^3-L^4*x))\n");
    fprintf("--------------------------------------------------------\n");

    
    %Codigo del problema
    %Pedimos valores
    
    L=input("Introduzca la longitud de la viga en cm:");
    w=input("Introduzca la fuerza inicial aplicada sobre la viga en kN/cm:");
    
    %Definimos las variables con los datos del problema
    
    E=50000*10^3; %Modulo de elasticidad
    I=30000; %Momento de inercia
    x=100:20:L; %Definimos el eje x, este inicia en 100 y acaba hasta lalongitud de la tabla
    
    %Definimos las funciones
    fd=@(x) (w*(-5*x.^4+6*L^2*x.^2-L^4));
    fdd=@(x)(w*(-20*x.^3+12*L^2*x));
    
    %Graficamos las derivadas de la funcion para que se muestre una posible
    %interseccion
    plot(x,fd(x),".-","MarkerFaceColor","b")
    grid on
    title('Deflexionn Maxima')
    xlabel('Deflexion de la viga [cm]','fontsize',14)
    ylabel('Carga aplicada sobre la viga [kN]','fontsize',14)
    hold on
    plot(x,fdd(x),".-","MarkerFaceColor","r")
    
    %Definimos el valor inicial de x, el cual sera distinto dependiendo de la deflexiion de la viga
    xi(1)=200;
    ea(1)=0;%Fijamos a nuestro error normalizado como cero solo para la primera interacion
    iteraciones=6;
    for i=2:iteraciones
        xi(i)=xi(i-1)-(fd(xi(i-1))/fdd(xi(i-1)));%Formula Newton Raphson
        pause(1)
        plot(xi(i),0,'*',"MarkerSize",10)%Graficamos las raíces obtenidas en cada iteración
        legend('Primera derivada',"Segunda derivada",'Aprox. raices')
        ea(i)=abs((xi(i)-xi(i-1))/xi(i))*100;%Calculamos el error normalizado en cada iteración
    end
    
    it=0:1:iteraciones-1;%Definimos una variable que contenga el numero de iteraciones realizadas
    data=[it' xi' ea']%Creamos una matriz que contenga todos los datos que deseamos presentar en la tabla
    disp('Iteraciones     Xi       Ea')
end


%****************%
%   PROBLEMA 4   %
%****************%
function Problema4()
    %Descripcion del problema
    disp("Tenemos un circuito con un circuito con una resistencia, un inductor y un capacitor en paralelo. Para expresar la impedancia del sistema se emplean las leyes de Kirchhoff, as�: 1/Z = sqrt((1/(R^2))+( x*(C)-(1/( x*L)))^2Donde ?= impedancia (?) y x = frecuencia angular. Se encontrara la x que dara la impendencia deseada, con del m�todo de la secante con los valores iniciales de ?o=1 y ?i=5, y los par�metros siguientes: R=225 ?, C=0.6x10?6 F y L=0.5 H. ")
    
    %Codigo del problema
    
    %Guardamos la funcion con los valores sustituidos en una variable
    f = str2sym("sqrt((1/(225^2))+(x*(0.6*10^-6)-(1/(x*0.5)))^2)");
    
    prompt = 'Cual es la impendencia deseada? ';
    z = input(prompt);
    
    %Debido a que la funcion nos da como resultado 1/Z ese es el resultado
    %contra el que debemos comparar
    Zresult = 1/z;
    
    %Valores iniciales de las x
    Xm1 = 1;
    Xini = 5;
    
    %Counter para guardar cada iteracion en esa posicion del array
    counter = 1;
    
    %Guardamos el valor de la sustitucion con la X inicial para poder crear un
    %loop que itera la funcion hasta que se llega a la impendencia deseada
    fx = subs(f,Xini);
    while fx>=Zresult 
        
    
    
    %se vuelve a asignar la variable de la sustitucion en x con los nuevos
    %valores para ver si es necesario repetir el proceso
    fx = subs(f,Xini);
    
    %Esta es la funcion del metodo de la secante, guarda el resultado dentro de
    %la funcion xp1
    Xp1 = Xini - ((subs(f,Xini)*(Xm1-Xini))/((Xini-Xm1)*(subs(f,Xini))));
    
    Ea = abs((Xp1-Xini)/Xp1)*100;
    
    %Se estructuran los datos y se crea la tabla donde se guardan
    EaStruct = double(Ea);
    FxStruct = double(fx);
    A(:,:,counter) = [Xini EaStruct FxStruct;]; 
    X(counter) = [Xini];
    Y(counter)= [FxStruct];
    
    %aumentamos los valores 
    Xm1 = Xini;
    Xini = Xp1;
    counter = counter + 1;
    end
    
    
    %Se grafican los resultados
    plot(X,Y);
    hold on
    plot(Xini,FxStruct, 'r*')
    xlabel('Xi Velocidad angular (rad/s)')
    ylabel('f(Xi) Impendencia (OHMS)')
    title('M�todo de la Secante | Impendencia')
    
    fprintf("f( x) es igual a %f Ohms y la x es igual a ", fx  );
    fprintf( "%f rad/s", Xp1);
end