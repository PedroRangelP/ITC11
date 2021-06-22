%Integrantes:
%Ricardo Juarez Tepos A01650943
%Pedro Rangel Palacios A01650939
%Alejandro Hernandez A01650390
%Aldo Ponce de la Cruz A01651119

close all; clc;

%**********************%
%  DATOS DEL PROBLEMA  %
%**********************%
%Y = distancia desde uno de los margenes [m]
Y = [0 2 4 5 6 9];
%H = profundidad [m]
H = [0.5 1.3 1.25 1.7 1 0.25];
%U = velocidad del agua [m/s]
U = [0.03 0.06 0.05 0.12 0.11 0.02];


%************************************%
%  AREA SECCION TRANSVERSAL Ac[m^2]  %
%************************************%
%{
Integral para los primeros dos segmentos (0-2) (2-4)
usando regla de Simpson 1/3
%}
Ac1 = ReglaSimpson13(Y(1), Y(3), H(1), H(2), H(3));

%{
Integral para los siguientes dos segmentos (4-5) (5-6)
usando regla de Simpson 1/3
%}
Ac2 = ReglaSimpson13(Y(3), Y(5), H(3), H(4), H(5));

%{
Integral para el ultimo segmento (6-9)
usando regla del Trapecio
%}
Ac3 = ReglaSimpsonTrapecio(Y(5), Y(6), H(5), H(6));

%Integral total
Ac = Ac1 + Ac2 + Ac3;
fprintf("RESULTADOS:\n");
fprintf("Area Seccion Transversal (Ac) = " + num2str(Ac) + " m^2");


%***************************%
%  FLUJO PROMEDIO Q[m^3/s]  %
%***************************%
%{
Integral para los primeros dos segmentos (0-2) (2-4)
usando regla de Simpson 1/3
%}
Q1 = ReglaSimpson13(Y(1), Y(3), U(1)*H(1), U(2)*H(2), U(3)*H(3));

%{
Integral para los siguientes dos segmentos (4-5) (5-6)
usando regla de Simpson 1/3
%}
Q2 = ReglaSimpson13(Y(3), Y(5), U(3)*H(3), U(4)*H(4), U(5)*H(5));

%{
Integral para el ultimo segmento (6-9)
usando regla del Trapecio
%}
Q3 = ReglaSimpsonTrapecio(Y(5), Y(6), U(5)*H(5), U(6)*H(6));

%Integral total
Q = Q1 + Q2 + Q3;
fprintf("\nFlujo Promedio (Q) = " + num2str(Q) + " m^3/s");


figure(1)
subplot(2,1,1)
area(Y, H, 'FaceColor', [0.48 0.49 0.49])
xlabel('Distancia [m]')
ylabel('Profundidad [m]')
title('Area Seccion Transversal - Ac[m^2]')
grid on

subplot(2,1,2)
area(Y, H.*U , 'FaceColor', [0.2 0.59 0.86])
xlabel('Distancia [m]')
ylabel('Profundidad [m] * Velocidad [m/s]')
title('Flujo Promedio - Q[m^3/s]')
grid on


%*********************%
%  REGLAS DE SIMPSON  %
%*********************%
%Regla Simpson 1/3
function I = ReglaSimpson13(a, b, fx0, fx1, fx2)
    I = (b-a)*((fx0 + 4*fx1 + fx2)/6);
end

%Regla Simpson Trapecio
function I = ReglaSimpsonTrapecio(a, b, fx0, fx1)
    I = (b-a)*((fx0 + fx1)/2);
end

