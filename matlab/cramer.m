function [solutions] = cramer(A, b)
if ~isvector(b)
	error('b must be a vector');
end
if ~ismatrix(A)
	error('A must be a matrix');
end
[m1, n1] = size(A);
[m2, n2] = size(b);

if n1~=m2
	error('dimensions of A and b must match');
end
detA = det(A);
determinants = zeros(1,length(b));
solutions = zeros(1,length(b));
%do first and last first one
temp = repmat(A,1,1);
temp = [b, A(:, 2:n1)];
determinants(1) = det(temp);
solutions(1) = determinants(1)/detA;

temp = repmat(A,1,1);
temp = [A(:, 1:n1-1), b];
determinants(n1) = det(temp);
solutions(n1) = determinants(n1)/detA;

for i = 2:length(b)-1
	disp(i)
	temp = repmat(A,1,1);
	temp = [A(:, 1:i-1), b, A(:, i+1:n1)];
	disp(temp);
	solutions(i) = det(temp)/detA;
end
end
