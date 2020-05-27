package ast.types;

import java.util.ArrayList;
import java.util.List;

import ast.definitions.VarDefinition;
import ast.expressions.Variable;
import ast.main.AbstractType;
import ast.main.Type;
import visitor.Visitor;

public class FuncType extends AbstractType {

	private Type returnType;
	private List<VarDefinition> params;
	
	public FuncType(int line, int column, Type type, List<VarDefinition> params) {
		super(line, column);
		this.returnType = type;
		this.params = new ArrayList<VarDefinition>(params);
	}

	public FuncType(int line, int column, Type type) {
		super(line, column);
		this.returnType = type;
		this.params = new ArrayList<VarDefinition>();
	}

	public Type getReturnType() {
		return returnType;
	}

	public void setReturnType(Type returnType) {
		this.returnType = returnType;
	}

	public List<VarDefinition> getParams() {
		return params;
	}

	public void setParams(List<VarDefinition> params) {
		this.params = params;
	}

	@Override
	public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
		return visitor.visit(this, param);
	}

	@Override
	public String toString() {
		return "FuncType{" +
				"type=" + returnType +
				", vars=" + params +
				"} " + super.toString();
	}

	@Override
	public Type parenthesis(Type[] param, Variable var) {
		if(param.length!=this.getParams().size())
			return new ErrorType(var.getLine(), var.getColumn(), var + " has not the same number of parameters");
		for (int i = 0; i < this.getParams().size(); i++) {
			if(param[i] instanceof ErrorType)
				return param[i];
			else if(!param[i].equivalent(this.getParams().get(i).getType()))
				return new ErrorType(param[i].getLine(), param[i].getColumn(), param[i] + " type mismatch");
		}
		return this.getReturnType();
	}
}
