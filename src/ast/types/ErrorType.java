package ast.types;

import ast.expressions.Variable;
import ast.main.AbstractASTNode;
import ast.main.AbstractType;
import ast.main.Expression;
import ast.main.Type;
import error_handler.ErrorHandler;
import visitor.Visitor;

public class ErrorType extends AbstractType {

    private String message;

    public ErrorType(int line, int column, String message){
        super(line, column);
        this.message = message;
        ErrorHandler.getSingletonInstance().addError(this);
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }

    @Override
    public String toString() {
        return "ErrorType{" +
                "message='" + message + '\'' +
                "} line: " + getLine() + " column: " + getColumn();
    }

    @Override
    public Type arithmetic(Type type, Expression leftExp) {
        return this;
    }

    @Override
    public Type squareBrackets(Type type, Expression leftExp) {
        return this;
    }

    @Override
    public Type parenthesis(Type[] param, Variable var) {
        return this;
    }

    @Override
    public Type dot(String c, Expression exp) {
        return this;
    }

    @Override
    public Type cast(Type type, Expression exp) {
        return this;
    }

    @Override
    public Type compare(Type type, Expression leftExp) {
        return this;
    }

    @Override
    public Type logical(Type type, Expression leftExp) {
        return this;
    }

    @Override
    public Type unaryMinus(Expression exp) {
        return this;
    }

    @Override
    public Type unaryNegation(Expression exp) {
        return this;
    }

    @Override
    public void assignment(Type type, Expression leftExp) {
    }

    @Override
    public void condition(Expression exp) {
    }
}
