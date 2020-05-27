package ast.types;

import ast.main.AbstractType;
import ast.main.Expression;
import ast.main.Type;
import visitor.Visitor;

public class CharType extends AbstractType{

	private static final int CHAR_BYTE_SIZE = 1;

	public CharType(int line, int column) {
		super(line, column);
	}

	@Override
	public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
		return visitor.visit(this, param);
	}

	@Override
	public String toString() {
		return "CharType{} " + super.toString();
	}

	@Override
	public Type arithmetic(Type type, Expression leftExp) {
		if(type instanceof CharType)
			return new IntType(leftExp.getLine(), leftExp.getColumn());
		if(type instanceof ErrorType)
			return type;
		return new ErrorType(leftExp.getLine(), leftExp.getColumn(), "You can not do a arithmetic operation with " + type);
	}

	@Override
	public Type unaryMinus(Expression exp) {
		return new IntType(exp.getLine(), exp.getColumn());
	}

	@Override
	public boolean isBuiltinType() {
		return true;
	}

	@Override
	public boolean equivalent(Type type) {
		return type instanceof CharType;
	}

	@Override
	public int numberOfBytes() {
		return CHAR_BYTE_SIZE;
	}

	@Override
	public char getSuffix() {
		return 'b';
	}

	@Override
	public String reservedWord() {
		return "char";
	}

	@Override
	public String convertTo(Type to) {
		if(to instanceof CharType)
			return "";
		if(to instanceof DoubleType)
			return "b2i\n\ti2f";
		if(to instanceof IntType)
			return "b2i";
		throw new IllegalArgumentException("You can not convert from " + this + " to " + to);
	}
}
