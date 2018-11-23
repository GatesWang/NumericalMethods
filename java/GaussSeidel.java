import java.util.*;

public class GaussSeidel {
	private ArrayList<ArrayList<Double>> system;
	private ArrayList<Double> x0;
	private double error;
	private int i = 0;
	
	public GaussSeidel(ArrayList<ArrayList<Double>> system) {
		this.system = system;
		this.error = 0;
		this.x0 = new ArrayList<Double>();
		
		for(int i=0; i<system.size(); i++) {
			x0.add(1.0);
		}
	}
	public double iteration() {
		if(i>=system.size()) {
			i = 0;
		}
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
		error = Math.abs(x0.get(i) - (sum/denominator));
		x0.set(i, sum/denominator);
		System.out.println(x0);
		i++;
		return error;
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
		
		GaussSeidel gaussSeidel = new GaussSeidel(system);
		double threshold = .0001;
		double error;
		
		do {
			error = gaussSeidel.iteration();
			System.out.println(error);
		}while(error > threshold);
	}

}
