package ast.types;

import ast.main.AbstractASTNode;
import ast.main.AbstractType;
import ast.main.Expression;
import ast.main.Type;
import visitor.Visitor;

public class ArrayType extends AbstractType {

	private Type type;
	public int size;

	public ArrayType(int line, int column, Type type, int size) {
		super(line, column);
		this.type = type;
		this.size = size;
	}

	public ArrayType UpdateArray() {
		if(this.getType() instanceof ArrayType) {
			Type l = getLastType();
			ArrayType b = getBeforeLastType();
			this.type = l;
			b.setType(this);
			return b;
		}
		return this;
	}

	private Type getLastType() {
		Type t = this.type;
		while(t instanceof ArrayType) {
			t = ((ArrayType) t).getType();
		}
		return t;
	}

	private ArrayType getBeforeLastType() {
		Type t = this.type;
		while(t instanceof ArrayType) {
			ArrayType a = (ArrayType) t;
			t = a.getType();
			if(!(a.getType() instanceof ArrayType))
				return a;
		}
		return null;
	}

	public Type getType() {
		return this.type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
		return visitor.visit(this, param);
	}

	@Override
	public String toString() {
		return "ArrayType{" +
				"type=" + type +
				", size=" + size +
				"} " + super.toString();
	}

	@Override
	public Type squareBrackets(Type type, Expression leftExp) {
		if(type instanceof IntType)
			return this.getType();
		if(type instanceof ErrorType)
			return type;
		return new ErrorType(leftExp.getLine(), leftExp.getColumn(), "the type of the expression between squeareBrackets must be a intType and it is " + type);
	}

	@Override
	public int numberOfBytes() {
		return size*this.getType().numberOfBytes();
	}

	@Override
	public String reservedWord() {
		return ("[" + getSize() + "," + getType().reservedWord() + "]");
	}
}
