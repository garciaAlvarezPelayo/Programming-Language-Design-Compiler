package ast.main;


import ast.definitions.VarDefinition;
import visitor.Visitor;

import java.util.ArrayList;

public abstract class AbstractASTNode implements ASTNode{

	private int line;
	private int column;

	public AbstractASTNode(int line, int column) {
		this.line = line;
		this.column = column;
	}

	@Override
	public int getLine() {
		return line;
	}

	@Override
	public int getColumn() {
		return column;
	}

	@Override
	public String toString() {
		/*return "AbstractASTNode{" +
				"line=" + line +
				", column=" + column +
				'}';*/
		return "";
	}
}
