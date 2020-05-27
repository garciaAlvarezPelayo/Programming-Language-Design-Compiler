package ast.main;

import ast.expressions.Variable;

public interface Type extends ASTNode{
    public Type arithmetic(Type type, Expression leftExp);
    public Type squareBrackets(Type type, Expression leftExp);
    public Type parenthesis(Type[] param, Variable var);
    public Type dot(String c, Expression exp);
    public boolean equivalent(Type type);
    public Type cast(Type type, Expression exp);
    public Type compare(Type type, Expression leftExp);
    public Type logical(Type type, Expression leftExp);
    public boolean isBoolean();
    public Type unaryMinus(Expression exp);
    public Type unaryNegation(Expression exp);
    public boolean isBuiltinType();
    public int numberOfBytes();
    public void assignment(Type type, Expression leftExp);
    public void condition(Expression exp);
    public char getSuffix();
    public String reservedWord();
    public String convertTo(Type to);
}
