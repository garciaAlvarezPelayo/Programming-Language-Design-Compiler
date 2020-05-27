package ast.statements;

import ast.main.AbstractASTNode;
import ast.main.Expression;
import ast.main.Statement;
import visitor.Visitor;

import java.util.ArrayList;
import java.util.List;

public class IfElse extends AbstractASTNode implements Statement{
	
	private Expression exp;
	private List<Statement> statIf = new ArrayList<Statement>();
	private List<Statement> statElse = new ArrayList<Statement>();
	
	public IfElse(int line, int column, Expression exp, List<Statement> statIf, List<Statement> statElse) {
		super(line, column);
		this.exp = exp;
		this.statIf = new ArrayList<Statement>(statIf);
		this.statElse = new ArrayList<Statement>(statElse);
	}

	public IfElse(int line, int column, Expression exp, List<Statement> statIf) {
		super(line, column);
		this.exp = exp;
		this.statIf = new ArrayList<Statement>(statIf);
	}

	public void setElse(List<Statement> ast) {
		this.statElse = new ArrayList<Statement>(ast);
	}

	public Expression getExp() {
		return exp;
	}

	public void setExp(Expression exp) {
		this.exp = exp;
	}

	public List<Statement> getStatIf() {
		return statIf;
	}

	public void setStatIf(List<Statement> statIf) {
		this.statIf = statIf;
	}

	public List<Statement> getStatElse() {
		return statElse;
	}

	public void setStatElse(List<Statement> statElse) {
		this.statElse = statElse;
	}

	@Override
	public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
		return visitor.visit(this, param);
	}

	@Override
	public String toString() {
		return "IfElse{" +
				"exp=" + exp +
				", stat1=" + statIf +
				", stat2=" + statElse +
				"} " + super.toString();
	}
}
