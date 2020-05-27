package ast.expressions;
import ast.main.AbstractASTNode;
import ast.main.AbstractExpression;
import ast.main.Expression;
import visitor.Visitor;

public class LogicalDoor extends AbstractExpression implements Expression {
	
	private String operator;
	private Expression leftExp;
	private Expression rightExp;
	
	public LogicalDoor(int line, int column, String operator, Expression exp1, Expression exp2) {
		super(line, column);
		this.operator = operator;
		this.leftExp = exp1;
		this.rightExp = exp2;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public Expression getLeftExp() {
		return leftExp;
	}

	public void setLeftExp(Expression leftExp) {
		this.leftExp = leftExp;
	}

	public Expression getRightExp() {
		return rightExp;
	}

	public void setRightExp(Expression rightExp) {
		this.rightExp = rightExp;
	}

	@Override
	public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
		return visitor.visit(this, param);
	}

	@Override
	public String toString() {
		return "LogicalDoor{" +
				"operator='" + operator + '\'' +
				", exp1=" + leftExp +
				", exp2=" + rightExp +
				"} " + super.toString();
	}
}
