%Integrantes:
%Ricardo Juárez Tepos A01650943
%Pedro Rangel Palacios A01650939
%Alejandro Hernández A01650390
%Aldo Ponce de la Cruz A01651119

clear all; close all; clc;

%Given values

deltaX = 0.1;

time = 0 : deltaX : 2;
meters = [1, 0.71, 0.238, -0.209, -0.481, -0.522, -0.371, ...
    -0.124, 0.109,  0.251, 0.273, 0.194, 0.065, -0.057, ...
    -0.131, -0.142, -0.101, -0.034, 0.03, 0.068, 0.074];

timeLength = length(time);

figure(1)
plot(time, meters, 'linewidth', 2)
grid on
xlabel('Time [s]')
ylabel('Distance [m]')
legend('Given values', 'location', 'best')

%finite differences with high accuracy to estimate velocity

%forward
for i = 1 : length(meters) - 2
    forward(i) = (-meters(i+2) + 4*meters(i+1) -3*meters(i))/(2*deltaX);
end

%backward
for i = 3 : length(meters)
    backward(i-2) = (3*meters(i) - 4*meters(i-1) + meters(i-2))/(2*deltaX);
end

%centered
for i = 3 : length(meters) - 2
    centered(i-2) = (-meters(i+2) + 8*meters(i+1) - 8*meters(i-1) + ...
        meters(i-2))/(12*deltaX);
end

%Estimations plot

figure(2)
plot(time(1:timeLength-2), forward, ...
    time(3:timeLength), backward, ...
    time(3:timeLength-2), centered, 'linewidth', 2)
grid on
xlabel('Time [s]')
ylabel('Velocity [m/s]')
legend('Estimated (forward)', 'Estimated (backward)', ...
    'Estimated (centered)', 'location', 'best')
