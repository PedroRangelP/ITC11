%Integrantes:
%Ricardo Juárez Tepos A01650943
%Pedro Rangel Palacios A01650939
%Alejandro Hernández A01650390
%Aldo Ponce de la Cruz A01651119

close all; clc;

%Ecuaciones:
% 3*x1 + 1*x2 + 2*x3 = 850.....(1)
% 1*x1 + 2*x2 + 4*x3 = 1200....(2)
% 2*x1 + 1*x2 + 1*x3 = 550.....(3)


%Matriz A
A = [3 1 2; 1 2 4; 2 1 1];
[m n] = size(A);

%Vector B
B = [850; 1200; 550];

%Unir Matriz A con Vector B para formar una Matriz C
C = [A B];

%Eliminación hacia adelante
for k=1:n-1
    for i=k+1:n
        factor = C(i,k)/C(k,k);
        C(i,k:n+1) = C(i,k:n+1)-factor*C(k,k:n+1);
    end
end

%Sustitución hacia atrás
x = zeros(n,1);
x(n) = C(n,n+1)/C(n,n);
xn = ['x' num2str(n) ' = ' num2str(x(n))];

fprintf("Método de Gauss Simple:\n");
disp(xn)

for i=n-1:-1:1
    x(i) = (C(i,n+1)-C(i,i+1:n)*x(i+1:n))/C(i,i);
    xs = ['x' num2str(i) ' = ' num2str(x(i))];
    disp(xs)
end