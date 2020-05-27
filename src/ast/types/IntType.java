package ast.types;

import ast.main.AbstractType;
import ast.main.Expression;
import ast.main.Type;
import visitor.Visitor;

public class IntType extends AbstractType {

	private static final int INT_BYTE_SIZE = 2;

	public IntType(int line, int column) {
		super(line, column);
	}

	@Override
	public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
		return visitor.visit(this, param);
	}

	@Override
	public String toString() {
		return "IntType{} " + super.toString();
	}

	@Override
	public Type logical(Type type, Expression leftExp) {
		if(type instanceof ErrorType)
			return type;
		if(type.isBoolean())
			return this;
		return new ErrorType(leftExp.getLine(), leftExp.getColumn(), "You can not do a logical operation with " + type);
	}

	@Override
	public Type unaryMinus(Expression exp) {
		return this;
	}

	@Override
	public Type unaryNegation(Expression exp) {
		return this;
	}

	@Override
	public boolean isBoolean() {
		return true;
	}

	@Override
	public boolean isBuiltinType() {
		return true;
	}

	@Override
	public boolean equivalent(Type type) {
		return type instanceof IntType;
	}

	@Override
	public int numberOfBytes() {
		return INT_BYTE_SIZE;
	}

	@Override
	public char getSuffix() {
		return 'i';
	}

	@Override
	public String reservedWord() {
		return "int";
	}

	@Override
	public String convertTo(Type to) {
		if(to instanceof IntType)
			return "";
		if(to instanceof DoubleType)
			return "i2f";
		if(to instanceof CharType)
			return "i2b";
		throw new IllegalArgumentException("You can not convert from " + this + " to " + to);
	}
}
