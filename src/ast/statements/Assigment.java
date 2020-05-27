package ast.statements;

import ast.main.AbstractASTNode;
import ast.main.Expression;
import ast.main.Statement;
import visitor.Visitor;

public class Assigment extends AbstractASTNode implements Statement{

	private Expression leftExp;
	private Expression rightExp;
	
	public Assigment(int line, int column, Expression exp1, Expression exp2) {
		super(line, column);
		this.leftExp = exp1;
		this.rightExp = exp2;
	}

	public Expression getLeftExp() {
		return leftExp;
	}

	public void setLeftExp(Expression leftExp) {
		this.leftExp = leftExp;
	}

	public Expression getRightExp() {
		return rightExp;
	}

	public void setRightExp(Expression rightExp) {
		this.rightExp = rightExp;
	}

	@Override
	public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
		return visitor.visit(this, param);
	}

	@Override
	public String toString() {
		return "Assigment{" +
				"exp1=" + leftExp +
				", exp2=" + rightExp +
				"} " + super.toString();
	}
}
