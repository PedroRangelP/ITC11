close all; clc;

P = 23500;
    A = 6500;
    n = 5;
    Es = 0.5;    
    f = @(i) (P*((i*((1+1)^n))/(((1+i)^n)-1)))-A;
    
    %Intervalo
    xl = 1;
    xu = 2;
    
    if f(xl) * f(xu) > 0
        error('El intervalo inicial no contiene una raíz')
    end
    
    Ea = inf;
    i = 1;
    xrAnt = 0;
    
    while Ea > Es
        xr(i) = xu-((f(xu)*(xl-xu))/(f(xl)-f(xu)));
        
        if f(xl)*f(xr(i)) < 0
            xu = xr(i);
        elseif f(xl) * f(xr(i)) > 0
            xl = xr(i);
        else
            break;
        end
        Ea = abs((xr(i)-xrAnt)/xr(i))*100;
        xrAnt = xr(i);
        i = i + 1;
    end
    
    fprintf("Tasa de interés: ");
    disp(xr(i-1))