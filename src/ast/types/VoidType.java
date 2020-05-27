package ast.types;

import ast.main.AbstractASTNode;
import ast.main.AbstractType;
import ast.main.Type;
import visitor.Visitor;

public class VoidType extends AbstractType {

	public VoidType(int line, int column) {
		super(line, column);
	}

	@Override
	public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
		return visitor.visit(this, param);
	}

	@Override
	public String toString() {
		return "VoidType{} " + super.toString();
	}

	@Override
	public int numberOfBytes() {
		return 0;
	}
}
