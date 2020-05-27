package ast.main;

import ast.expressions.Variable;
import ast.types.ErrorType;
import error_handler.ErrorHandler;

public abstract class AbstractType extends AbstractASTNode implements Type {

    public AbstractType(int line, int column) {
        super(line, column);
    }

    @Override
    public Type arithmetic(Type type, Expression leftExp) {
        if(type instanceof ErrorType)
            return type;
        if(this.equivalent(type))
            return type;
        return new ErrorType(leftExp.getLine(), leftExp.getColumn(), "You can not do arithmetic with " + this);
    }

    @Override
    public Type squareBrackets(Type type, Expression leftExp) {
        return new ErrorType(leftExp.getLine(), leftExp.getColumn(), "You can not do squareBrakets with " + this);
    }

    @Override
    public Type parenthesis(Type[] param, Variable var) {
        return new ErrorType(var.getLine(), var.getColumn(), "You can not do parenthesis with " + this);
    }

    @Override
    public Type dot(String c, Expression exp) {
        return new ErrorType(exp.getLine(), exp.getColumn(), "You can not do dot with " + this);
    }

    @Override
    public Type cast(Type type, Expression exp) {
        if(type instanceof ErrorType)
            return type;
        if(type.isBuiltinType())
            return this;
        return new ErrorType(exp.getLine(), exp.getColumn(), "You can not do cast with " + this);
    }

    @Override
    public Type compare(Type type, Expression leftExp) {
        if(type instanceof ErrorType)
            return type;
        if(this.equivalent(type))
            return type;
        return new ErrorType(leftExp.getLine(), leftExp.getColumn(), "You can not compare with " + this);
    }

    @Override
    public Type logical(Type type, Expression leftExp) {
        return new ErrorType(leftExp.getLine(), leftExp.getColumn(), "You can not do a logical operation with " + this);
    }

    @Override
    public Type unaryMinus(Expression exp) {
        return new ErrorType(exp.getLine(), exp.getColumn(), "You can not do a unaryMinus with " + this);
    }

    @Override
    public Type unaryNegation(Expression exp) {
        return new ErrorType(exp.getLine(), exp.getColumn(), "You can not do a negate with " + this);
    }

    @Override
    public void assignment(Type type, Expression leftExp) {
        if(!this.equivalent(type))
            new ErrorType(leftExp.getLine(), leftExp.getColumn(), "You can not assign a " + type + " to " + this);
    }

    @Override
    public void condition(Expression exp) {
        if(!this.isBoolean())
            new ErrorType(exp.getLine(), exp.getColumn(), "the condition must be a boolean type and it is " + exp.getExpressionType());
    }

    @Override
    public int numberOfBytes() {
        throw new IllegalStateException("You can not know the number of bytes");
    }

    @Override
    public char getSuffix() {
        throw new IllegalStateException("There is no suffix for that type");
    }

    @Override
    public String reservedWord() {
        throw new IllegalStateException("There is no reserve word for that type");
    }

    @Override
    public String convertTo(Type to) {
        throw new IllegalStateException("You can not convert this type to " + to);
    }

    @Override
    public boolean equivalent(Type type) {
        return false;
    }

    @Override
    public boolean isBoolean() {
        return false;
    }

    @Override
    public boolean isBuiltinType() {
        return false;
    }
}
