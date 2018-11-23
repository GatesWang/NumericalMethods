function [root] = newton_raph_homer(coefficients, x0)
if ~isvector(coefficients)
	error('Input must be a vector');
end

[value, derivative] = homer([length(coefficients)-1 coefficients x0]);
x1 = x0 - (value)/(derivative);
disp(value + " " + derivative);

while abs(x0-x1)>.00001
    x0 = x1;
    [value, derivative] = homer([length(coefficients)-1 coefficients  x1]);
    x1 = x0 - ((value)/(derivative));
    disp(value + " " + derivative);
end
root = x1;
end
