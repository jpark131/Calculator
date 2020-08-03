
public class OpFactory {
	public Operation getOp(String op) {
		Operation operation;
		switch(op) {
		case "+": 
			operation = new Add();
			break;
		case "-":
			operation = new Sub();
			break;
		case "*":
			operation = new Mult();
			break;
		case "/":
			operation = new Div();
			break;
		case "logleft":
			operation = new LogLeft();
			break;
		case "logright":
			operation = new LogRight();
			break;
		default:
			operation = new Operation();
			break;
		}
		return operation;
	}
}
