function df=dif_irreg(x,xm1,xi,xp1,ym1,yi,yp1)

df = ym1*(2*x-xi-xp1)/((xm1-xi)*(xm1-xp1))...
    +yi*(2*x-xm1-xp1)/((xi-xm1)*(xi-xp1))...
    +yp1*(2*x-xm1-xi)/((xp1-xm1)*(xp1-xi));

end