package ast.expressions;
import ast.main.AbstractASTNode;
import ast.main.AbstractExpression;
import ast.main.Expression;
import visitor.Visitor;

public class CharacterLiteral extends AbstractExpression implements Expression {

	private char value;

	public CharacterLiteral(int line, int column, char value) {
		super(line, column);
		this.value = value;
	}

	public char getValue() {
		return value;
	}

	public void setValue(char value) {
		this.value = value;
	}

	@Override
	public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
		return visitor.visit(this, param);
	}
	@Override
	public String toString() {
		return "CharacterLiteral{" +
				"value=" + value +
				"} " + super.toString();
	}
}
