clear all; close all; clc;
x1=[1 3 4 9 2];
x2=[35 36 39 44 40];
y=[245.7 329.8 365.7 398.2 286.1];
n=length(y);
A=[n sum(x1) sum(x2);...
sum(x1) sum(x1.^2) sum(x1.*x2);...
sum(x2) sum(x1.*x2) sum(x2.^2)];
B=[sum(y);sum(x1.*y);sum(x2.*y)];
C=inv(A)*B;
a0=C(1); a1=C(2); a2=C(3);
paso=5;
f=@(x1,x2) a0+a1.*x1+a2.*x2;
bmin = [0 0]; %minimo de busqueda
bmax = [100 100]; %maximo de busqueda
[xfx,yfx] = meshgrid(bmin(1):paso:bmax(1),bmin(2):paso:bmax(2));
surf(xfx,yfx, f(xfx,yfx));
xlabel('x1'); ylabel('x2'); zlabel('y')