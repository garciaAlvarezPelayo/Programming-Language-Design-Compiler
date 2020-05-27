package ast.main;

public interface Expression extends ASTNode{
    public void setLvalue(boolean lvalue);
    public boolean getLvalue();
    public Type getExpressionType();
    public void setExpressionType(Type expressionType);
}
