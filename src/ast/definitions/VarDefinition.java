package ast.definitions;

import ast.main.AbstractDefinition;
import ast.main.Statement;
import ast.main.Type;
import visitor.Visitor;

public class VarDefinition extends AbstractDefinition implements Statement{

	private int offset;

	public VarDefinition(int line, int column, Type type, String name) {
		super(line, column, type, name);
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	@Override
	public String toString() {
		return "VarDefinition{" +
				"offset=" + offset +
				"} " + super.toString();
	}

	@Override
	public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
		return visitor.visit(this, param);
	}
}
