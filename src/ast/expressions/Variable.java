package ast.expressions;
import ast.main.AbstractASTNode;
import ast.main.AbstractExpression;
import ast.main.Definition;
import ast.main.Expression;
import visitor.Visitor;

public class Variable extends AbstractExpression implements Expression {

	private String name;
	private Definition definition;

	public Variable(int line, int column, String name) {
		super(line, column);
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Definition getDefinition() {
		return definition;
	}

	public void setDefinition(Definition definition) {
		this.definition = definition;
	}

	@Override
	public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
		return visitor.visit(this, param);
	}

	@Override
	public String toString() {
		return "Variable{" +
				"name='" + name + '\'' +
				", definition=" + definition +
				"} " + super.toString();
	}
}
