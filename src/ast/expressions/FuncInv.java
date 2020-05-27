package ast.expressions;

import java.util.ArrayList;
import java.util.List;

import ast.main.AbstractASTNode;
import ast.main.AbstractExpression;
import ast.main.Expression;
import ast.main.Statement;
import visitor.Visitor;

public class FuncInv extends AbstractExpression implements Expression, Statement{
	
	private Variable var;
	private List<Expression> expressions;
	
	public FuncInv(int line, int column, Variable var, List<Expression> expressions) {
		super(line, column);
		this.var = var;
		this.expressions = new ArrayList<Expression>(expressions);
	}

	public void setExpressions(List<Expression> expressions){
		this.expressions=new ArrayList<Expression>(expressions);
	}

	public Variable getVar() {
		return var;
	}

	public void setVar(Variable var) {
		this.var = var;
	}

	public List<Expression> getExpressions() {
		return expressions;
	}

	@Override
	public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
		return visitor.visit(this, param);
	}

	@Override
	public String toString() {
		return "FuncInv{" +
				"var=" + var +
				", expressions=" + expressions +
				"} " + super.toString();
	}
}
