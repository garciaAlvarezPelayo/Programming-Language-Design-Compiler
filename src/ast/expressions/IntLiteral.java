package ast.expressions;
import ast.main.AbstractASTNode;
import ast.main.AbstractExpression;
import ast.main.Expression;
import visitor.Visitor;

public class IntLiteral extends AbstractExpression implements Expression {

	private int value;

	public IntLiteral(int line, int column, int value) {
		super(line, column);
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
		return visitor.visit(this, param);
	}

	@Override
	public String toString() {
		return "IntLiteral{" +
				"value=" + value +
				"} " + super.toString();
	}
}
