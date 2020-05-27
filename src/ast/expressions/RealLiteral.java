package ast.expressions;
import ast.main.AbstractASTNode;
import ast.main.AbstractExpression;
import ast.main.Expression;
import visitor.Visitor;

public class RealLiteral extends AbstractExpression implements Expression {

	private double value;

	public RealLiteral(int line, int column, double value) {
		super(line, column);
		this.value = value;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	@Override
	public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
		return visitor.visit(this, param);
	}

	@Override
	public String toString() {
		return "RealLiteral{" +
				"value=" + value +
				"} " + super.toString();
	}
}
