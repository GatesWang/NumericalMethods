function [solutions] = neville(b)
if ~isvector(b)
	error('b must be a vector');
end
len = (length(b)-1)/2;
x = zeros(1,len);
y = zeros(1,len);
x_index = 1;
y_index = 1;
x0 = b(length(b))
for i = 2:2*len
    if mod(i,2) == 0
      x(x_index) = b(i);
      x_index+=1;
    end  
    if mod(i,2) == 1
      y(y_index) = b(i);
      y_index+=1;
    end 
end

%declare matrix
A = zeros(len, len);
for i = 1:len
    A(i,i) = b(i); 
end

%start calculations
for col = 2:len+1
  for next_diagonal = 0:len-col
      a = A(2 + next_diagonal, col + next_diagonal)*(x(2 + next_diagonal)-x0);
      b = A(1 + next_diagonal,col + next_diagonal-1)*(x(1 + next_diagonal)-x0);
      A(1 + next_diagonal, col + next_diagonal) =  (a-b)/( x(2 + next_diagonal) - x(1 + next_diagonal));
  end 
end

end
