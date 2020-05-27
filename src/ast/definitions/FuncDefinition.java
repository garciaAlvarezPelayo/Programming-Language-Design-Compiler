package ast.definitions;

import java.util.ArrayList;
import java.util.List;

import ast.main.AbstractDefinition;
import ast.main.Definition;
import ast.main.Statement;
import ast.main.Type;
import ast.types.FuncType;
import visitor.Visitor;

public class FuncDefinition extends AbstractDefinition{

	private List<Statement> statements;

	public FuncDefinition(int line, int column, Type type, String name, List<Statement> statements) {
		super(line, column, type, name);
		this.statements = new ArrayList<Statement>(statements);
	}

	public List<Statement> getStatements() {
		return statements;
	}

	public void setStatements(List<Statement> statements) {
		this.statements = statements;
	}

	public List<VarDefinition> getVarDefinitions(){
		List<VarDefinition> result = new ArrayList<>();
		for (Statement each : statements) {
			if(each instanceof VarDefinition)
				result.add((VarDefinition) each);
		}
		return result;
	}

	public int getBytesLocals(){
		if(getVarDefinitions().size()==0)
			return 0;
		return -1*getVarDefinitions().get(getVarDefinitions().size()-1).getOffset();
	}

	public int getBytesParams(){

		return ((FuncType)getType()).getParams().stream().mapToInt(param -> param.getType().numberOfBytes()).sum();
	}

	public int getBytesReturn(){
		return ((FuncType)getType()).getReturnType().numberOfBytes();
	}

	public List<Statement> getStatementsNotDefinitions(){
		List<Statement> result = new ArrayList<>();
		for (Statement each : statements) {
			if(!(each instanceof VarDefinition))
				result.add(each);
		}
		return result;
	}

	@Override
	public String toString() {
		return "FuncDefinition{" +
				"statements=" + statements +
				"} " + super.toString();
	}

	@Override
	public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
		return visitor.visit(this, param);
	}
}
