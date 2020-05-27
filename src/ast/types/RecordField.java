package ast.types;

import ast.main.AbstractASTNode;
import ast.main.Type;
import visitor.Visitor;

public class RecordField extends AbstractASTNode{

	private Type type;
	private String name;
	private int offset;

	public RecordField(int line, int column, Type type, String name) {
		super(line, column);
		this.name = name;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	@Override
	public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
		return visitor.visit(this, param);
	}



	@Override
	public String toString() {
		return "RecordField{" +
				"type=" + type +
				", name='" + name + '\'' +
				", offset=" + offset +
				"} " + super.toString();
	}

	public String reservedWord() {
		return "(" + getName() + " x " + getType().reservedWord() + ")";
	}
}
