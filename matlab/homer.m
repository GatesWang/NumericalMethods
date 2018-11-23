function [value, derivative] = homer(x)
if ~isvector(x)
	error('Input must be a vector');
end
number_terms = x(1)+1;
number = x(end);
coeffcients = x(2:end-1);

%calculate values
values = zeros(1,number_terms);
values(1) = coeffcients(1);
for i = 2:number_terms
	values(i) = (values(i-1) * number) + coeffcients(i);
	%disp(values(i));
end

%calculate derivative
derivative_values = zeros(1,number_terms -1);
derivative_values(1) = values(1);
for i = 2:number_terms
	derivative_values(i) = (derivative_values(i-1) * number) + values(i);
	%disp(derivative_values(i));
end

value = values(number_terms);
derivative = derivative_values(number_terms-1);

end
