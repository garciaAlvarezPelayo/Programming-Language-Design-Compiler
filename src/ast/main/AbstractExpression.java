package ast.main;

public abstract class AbstractExpression extends AbstractASTNode implements Expression{

    private boolean lvalue;
    private Type expressionType;

    public AbstractExpression(int line, int column) {
        super(line, column);
    }

    @Override
    public void setLvalue(boolean lvalue) {
        this.lvalue = lvalue;
    }

    @Override
    public boolean getLvalue() {
        return lvalue;
    }

    @Override
    public Type getExpressionType() {
        return expressionType;
    }

    @Override
    public void setExpressionType(Type expressionType) {
        this.expressionType = expressionType;
    }
}
