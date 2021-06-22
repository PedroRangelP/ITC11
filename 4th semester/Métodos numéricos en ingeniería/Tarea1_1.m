%Integrantes:
%Ricardo Juárez Tepos A01650943
%Pedro Rangel Palacios A01650939
%Alejandro Hernández A01650390
%Aldo Ponce de la Cruz A01651119

clear all;
close all; clc;

x = input("Enter the value of x: ");
n = input('Select the exercise number: ');
switch n
    case 1
        f = str2sym("3*cos(x)");
    case 2
        f = str2sym("5*sin(x)");
    case 3
        f = str2sym("ln(x)");
    otherwise
        disp('Not found')
end
n = 3;
f0 = subs(f,0);
for i = 1:n
    f0 = f0 + subs(diff(f,i),0)*x^i/factorial(i);
end
disp(f0);