package ast.statements;

import java.util.ArrayList;
import java.util.List;

import ast.main.AbstractASTNode;
import ast.main.Expression;
import ast.main.Statement;
import visitor.Visitor;

public class While extends AbstractASTNode implements Statement{
	
	private Expression exp;
	private List<Statement> statements;
	
	public While(int line, int column, Expression exp, List<Statement> statements) {
		super(line, column);
		this.exp = exp;
		this.statements = new ArrayList<Statement>(statements);
	}

	public Expression getExp() {
		return exp;
	}

	public void setExp(Expression exp) {
		this.exp = exp;
	}

	public List<Statement> getStatements() {
		return statements;
	}

	public void setStatements(List<Statement> statements) {
		this.statements = statements;
	}

	@Override
	public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
		return visitor.visit(this, param);
	}

	@Override
	public String toString() {
		return "While{" +
				"exp=" + exp +
				", statements=" + statements +
				"} " + super.toString();
	}
}
