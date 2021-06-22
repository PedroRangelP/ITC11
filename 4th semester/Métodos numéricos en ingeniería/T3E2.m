%Integrantes:
%Ricardo Juárez Tepos A01650943
%Pedro Rangel Palacios A01650939
%Alejandro Hernández A01650390
%Aldo Ponce de la Cruz A01651119

close all; clc;

%Ecuaciones:
% 2*x1 -6*x2 -1*x3 = -38.....(1)
% -3*x1 -1*x2 +7*x3 = -34....(2)
% -8*x1 +1*x2 -2*x3 = -20....(3)

x1 = @(x2, x3) (-38+6*x2+x3)/2;
x11 = @(x2, x3) (-34+x2-7*x3)/-3;
x111 = @(x2, x3) (-20-x2+2*x3)/-8;

min = [-10 -10];
max = [25 10];
paso = 0.5;
[x2,x3] = meshgrid(min(1):paso:max(1),min(2):paso:max(2));

%Método gráfico
mesh(x1(x2,x3),x2,x3,'EdgeColor','r')
hold on
mesh(x11(x2,x3),x2,x3,'EdgeColor','g')
mesh(x111(x2,x3),x2,x3,'EdgeColor','b')
xlabel("Eje x1")
ylabel("Eje x2")
zlabel("Eje x3")
plot3(4,8,-2, 'o', 'MarkerSize', 8, 'MarkerFaceColor', 'm', 'MarkerEdgeColor', 'm')
legend("Plano x1","Plano x11","Plano x111","x1 = 4, x2 = 8, x3 = -2")
