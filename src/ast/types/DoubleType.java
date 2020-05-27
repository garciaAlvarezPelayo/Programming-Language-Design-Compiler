package ast.types;

import ast.main.AbstractType;
import ast.main.Expression;
import ast.main.Type;
import visitor.Visitor;

public class DoubleType extends AbstractType {

	private static final int DOUBLE_BYTE_SIZE = 4;

	public DoubleType(int line, int column) {
		super(line, column);
	}

	@Override
	public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
		return visitor.visit(this, param);
	}

	@Override
	public String toString() {
		return "DoubleType{} " + super.toString();
	}

	@Override
	public Type unaryMinus(Expression exp) {
		return this;
	}

	@Override
	public boolean isBuiltinType() {
		return true;
	}

	@Override
	public boolean equivalent(Type type) {
		return type instanceof DoubleType;
	}

	@Override
	public int numberOfBytes() {
		return DOUBLE_BYTE_SIZE;
	}

	@Override
	public char getSuffix() {
		return 'f';
	}

	@Override
	public String reservedWord() {
		return "double";
	}

	@Override
	public String convertTo(Type to) {
		if(to instanceof DoubleType)
			return "";
		if(to instanceof CharType)
			return "f2i\n\ti2b";
		if(to instanceof IntType)
			return "f2i";
		throw new IllegalArgumentException("You can not convert from " + this + " to " + to);
	}
}
