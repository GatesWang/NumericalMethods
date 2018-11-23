import java.util.*;

public class Jacobi {
	private ArrayList<ArrayList<Double>> system;
	private ArrayList<Double> x0;
	private ArrayList<Double> x1;
	private ArrayList<Double> error; 
	
	public Jacobi(ArrayList<ArrayList<Double>> system) {
		this.system = system;
		x0 = new ArrayList<Double>();
		x1 = new ArrayList<Double>();
		error = new ArrayList<Double>();
		
		for(int i=0; i<system.size(); i++) {
			x0.add(1.0);
		}
	}
	
	public double iteration() {
		for(int i=0; i<system.size(); i++) {
			ArrayList<Double> equation = system.get(i);
			double denominator = 1;
			double sum = 0;
			for(int j=0; j<equation.size()-1; j++) {
				if(j==i) {
					denominator = equation.get(j);
				}
				else {
					sum -= equation.get(j) * x0.get(j);
				}
			}
			sum += equation.get(equation.size()-1);
			if(x1.size() != x0.size()) {
				x1.add(sum/denominator);
			}
			else {
				x1.set(i, sum/denominator);
			}
		}
		for(int i=0; i<x1.size(); i++ ){
			if(error.size() != x0.size()) {
				error.add(x0.get(i) - x1.get(i));
			}
			else {
				error.set(i, x0.get(i) - x1.get(i));
			}
		}
		for(int i=0; i<x1.size(); i++ ){
			x0.set(i, x1.get(i));
		}
		System.out.println(x1);
		double errorMagnitude = 0;
		for(Double d: error) {
			errorMagnitude += d*d;
		}
		return Math.sqrt(errorMagnitude);
	}
		
	public static void main(String[] args) {
		ArrayList<Double> equation1 = new ArrayList<Double>();
		ArrayList<Double> equation2 = new ArrayList<Double>();
		ArrayList<Double> equation3 = new ArrayList<Double>();
		
		equation1.add(10.0);
		equation1.add(1.0);
		equation1.add(3.0);
		equation1.add(4.0);
		
		equation2.add(2.0);
		equation2.add(4.0);
		equation2.add(1.0);
		equation2.add(1.0);
		
		equation3.add(3.0);
		equation3.add(1.0);
		equation3.add(8.0);
		equation3.add(5.0);
		
		ArrayList<ArrayList<Double>> system = new ArrayList<ArrayList<Double>>();
		system.add(equation1);
		system.add(equation2);
		system.add(equation3);
		
		Jacobi jacobi = new Jacobi(system);
		double threshold = .0001;
		double error;
		do {
			error = jacobi.iteration();
			System.out.println(error);
		}while(error > threshold);
	}

}
