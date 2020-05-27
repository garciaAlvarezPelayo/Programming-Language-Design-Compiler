package ast.expressions;

import ast.main.AbstractASTNode;
import ast.main.AbstractExpression;
import ast.main.Expression;
import visitor.Visitor;

public class UnaryNegation extends AbstractExpression implements Expression {

	private Expression exp;
	
	public UnaryNegation(int line, int column, Expression exp) {
		super(line, column);
		this.exp = exp;
	}

	public Expression getExp() {
		return exp;
	}

	public void setExp(Expression exp) {
		this.exp = exp;
	}

	@Override
	public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
		return visitor.visit(this, param);
	}

	@Override
	public String toString() {
		return "UnaryNegation{" +
				"exp=" + exp +
				"} " + super.toString();
	}
}
