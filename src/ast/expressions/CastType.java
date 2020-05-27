package ast.expressions;

import ast.main.AbstractExpression;
import ast.main.Expression;
import ast.main.Type;
import visitor.Visitor;

public class CastType extends AbstractExpression implements Expression {
	
	private Type typeToCast;
	private Expression exp;
	
	public CastType(int line, int column, Type type, Expression exp) {
		super(line, column);
		this.typeToCast = type;
		this.exp = exp;
	}

	public Type getTypeToCast() {
		return typeToCast;
	}

	public void setTypeToCast(Type typeToCast) {
		this.typeToCast = typeToCast;
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
		return "CastType{" +
				"type=" + typeToCast +
				", exp=" + exp +
				"} " + super.toString();
	}
}
