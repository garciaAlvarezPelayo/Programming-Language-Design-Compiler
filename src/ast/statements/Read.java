package ast.statements;

import ast.main.AbstractASTNode;
import ast.main.Expression;
import ast.main.Statement;
import visitor.Visitor;

public class Read extends AbstractASTNode implements Statement{

	private Expression exp;

	public Read(int line, int column, Expression exp) {
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
		return "Read{" +
				"exp=" + exp +
				"} " + super.toString();
	}
}
