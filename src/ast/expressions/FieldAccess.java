package ast.expressions;

import ast.main.AbstractASTNode;
import ast.main.AbstractExpression;
import ast.main.Expression;
import visitor.Visitor;

public class FieldAccess extends AbstractExpression implements Expression {
	
	private String field;
	private Expression exp;
	
	public FieldAccess(int line, int column, String field, Expression exp) {
		super(line, column);
		this.field = field;
		this.exp = exp;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
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
		return "FieldAccess{" +
				"field='" + field + '\'' +
				", exp=" + exp +
				"} " + super.toString();
	}
}
