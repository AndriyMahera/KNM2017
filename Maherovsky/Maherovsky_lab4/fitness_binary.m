function [ result ] = fitness_binary( x_bin )

a=2;
b=-5;
c=47;
d=-3;

x=bi2de(x_bin)-10;

result = a+b*x+c*x^2+d*x^3;


if(x>20)
    result=100;
end

end