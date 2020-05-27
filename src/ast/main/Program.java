package ast.main;
import ast.definitions.FuncDefinition;
import ast.definitions.VarDefinition;
import visitor.Visitor;

import java.util.ArrayList;
import java.util.List;

public class Program extends AbstractASTNode{

	private List<Definition> defs;

	public Program(int line, int column, List<Definition> defs) {
		super(line, column);
		this.defs = new ArrayList<Definition>(defs);
	}

	public List<Definition> getDefs() {
		return defs;
	}

	public void setDefs(ArrayList<Definition> defs) {
		this.defs = new ArrayList<Definition>(defs);
	}

	public List<Definition> getVarDefinitions(){
		List<Definition> result = new ArrayList<>();
		for (Definition each : getDefs()) {
			if(each instanceof VarDefinition)
				result.add(each);
		}
		return result;
	}

	public List<Definition> getFuncDefinitions(){
		List<Definition> result = new ArrayList<>();
		for (Definition each : getDefs()) {
			if(each instanceof FuncDefinition)
				result.add(each);
		}
		return result;
	}

	@Override
	public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
		return visitor.visit(this, param);
	}

	@Override
	public String toString() {
		return "Program{" +
				"defs=" + defs +
				"} " + super.toString();
	}
}
