
public class Sub extends Operation{
	public double calculate(String left, String right) {
		return Double.parseDouble(left) - Double.parseDouble(right);
	}
}
