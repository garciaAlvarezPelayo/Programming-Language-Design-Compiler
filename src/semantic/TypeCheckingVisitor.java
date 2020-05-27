package semantic;

import ast.definitions.FuncDefinition;
import ast.expressions.*;
import ast.main.Expression;
import ast.main.Statement;
import ast.main.Type;
import ast.statements.*;
import ast.types.*;
import visitor.AbstractVisitor;

public class TypeCheckingVisitor extends AbstractVisitor<Type, Void> {
    @Override
    public Void visit(AritmeticOperator aritmeticOperator, Type param) {
        aritmeticOperator.getLeftExp().accept(this, null);
        aritmeticOperator.getRightExp().accept(this, null);
        aritmeticOperator.setLvalue(false);
        aritmeticOperator.setExpressionType(aritmeticOperator.getLeftExp().getExpressionType().arithmetic(aritmeticOperator.getRightExp().getExpressionType(), aritmeticOperator.getLeftExp()));
        return null;
    }

    @Override
    public Void visit(CastType castType, Type param) {
        castType.getExp().accept(this,null);
        castType.setLvalue(false);
        castType.setExpressionType(castType.getTypeToCast().cast(castType.getExp().getExpressionType(), castType.getExp()));
        return null;
    }

    @Override
    public Void visit(CharacterLiteral characterLiteral, Type param) {
        characterLiteral.setLvalue(false);
        characterLiteral.setExpressionType(new CharType(characterLiteral.getLine(), characterLiteral.getColumn()));
        return null;
    }

    @Override
    public Void visit(FieldAccess fieldAccess, Type param) {
        fieldAccess.getExp().accept(this, null);
        fieldAccess.setLvalue(true);
        fieldAccess.setExpressionType(fieldAccess.getExp().getExpressionType().dot(fieldAccess.getField(), fieldAccess.getExp()));
        return null;
    }

    @Override
    public Void visit(FuncInv funcInv, Type param) {
        funcInv.getVar().accept(this, null);
        for (Expression each : funcInv.getExpressions()) {
            each.accept(this, null);
        }
        funcInv.setLvalue(false);
        funcInv.setExpressionType(funcInv.getVar().getExpressionType().parenthesis(funcInv.getExpressions().stream().map(arg->arg.getExpressionType()).toArray(Type[]::new), funcInv.getVar()));
        return null;
    }

    @Override
    public Void visit(Indexing indexing, Type param) {
        indexing.getLeftExp().accept(this,null);
        indexing.getRightExp().accept(this, null);
        indexing.setLvalue(true);
        indexing.setExpressionType(indexing.getLeftExp().getExpressionType().squareBrackets(indexing.getRightExp().getExpressionType(), indexing.getLeftExp()));
        return null;
    }

    @Override
    public Void visit(IntLiteral intLiteral, Type param) {
        intLiteral.setLvalue(false);
        intLiteral.setExpressionType(new IntType(intLiteral.getLine(), intLiteral.getColumn()));
        return null;
    }

    @Override
    public Void visit(LogicalComparator logicalComparator, Type param) {
        logicalComparator.getLeftExp().accept(this, null);
        logicalComparator.getRightExp().accept(this, null);
        logicalComparator.setLvalue(false);
        logicalComparator.setExpressionType(logicalComparator.getLeftExp().getExpressionType().compare(logicalComparator.getRightExp().getExpressionType(), logicalComparator.getLeftExp()));
        return null;
    }

    @Override
    public Void visit(LogicalDoor logicalDoor, Type param) {
        logicalDoor.getLeftExp().accept(this, null);
        logicalDoor.getRightExp().accept(this, null);
        logicalDoor.setLvalue(false);
        logicalDoor.setExpressionType(logicalDoor.getLeftExp().getExpressionType().logical(logicalDoor.getRightExp().getExpressionType(), logicalDoor.getLeftExp()));
        return null;
    }

    @Override
    public Void visit(RealLiteral realLiteral, Type param) {
        realLiteral.setLvalue(false);
        realLiteral.setExpressionType(new DoubleType(realLiteral.getLine(), realLiteral.getColumn()));
        return null;
    }

    @Override
    public Void visit(UnaryMinus unaryMinus, Type param) {
        unaryMinus.getExp().accept(this, null);
        unaryMinus.setLvalue(false);
        unaryMinus.setExpressionType(unaryMinus.getExp().getExpressionType().unaryMinus(unaryMinus.getExp()));
        return null;
    }

    @Override
    public Void visit(UnaryNegation unaryNegation, Type param) {
        unaryNegation.getExp().accept(this, null);
        unaryNegation.setLvalue(false);
        unaryNegation.setExpressionType(unaryNegation.getExp().getExpressionType().unaryNegation(unaryNegation.getExp()));
        return null;
    }

    @Override
    public Void visit(Variable variable, Type param) {
        variable.setLvalue(true);
        if(variable.getDefinition()!=null)
            variable.setExpressionType(variable.getDefinition().getType());
        else
            variable.setExpressionType(new ErrorType(variable.getLine(), variable.getColumn(), variable + " has not been declared"));
        return null;
    }

    @Override
    public Void visit(Assigment assigment, Type param) {
        assigment.getLeftExp().accept(this, null);
        assigment.getRightExp().accept(this, null);
        if(!assigment.getLeftExp().getLvalue())
            new ErrorType(assigment.getLine(), assigment.getColumn(), "Lvalue required");

        assigment.getLeftExp().getExpressionType().assignment(assigment.getRightExp().getExpressionType(), assigment.getLeftExp());
        return null;
    }

    @Override
    public Void visit(Read read, Type param) {
        read.getExp().accept(this, null);
        if(!read.getExp().getLvalue())
            new ErrorType(read.getLine(), read.getColumn(), "Lvalue required");
        return null;
    }

    @Override
    public Void visit(IfElse ifElse, Type param) {
        ifElse.getExp().accept(this, null);
        for (Statement each : ifElse.getStatIf()) {
            each.accept(this, param);
        }
        for (Statement each : ifElse.getStatElse()) {
            each.accept(this, param);
        }
        ifElse.getExp().getExpressionType().condition(ifElse.getExp());
        return null;
    }

    @Override
    public Void visit(While swhile, Type param) {
        swhile.getExp().accept(this, null);
        for (Statement each : swhile.getStatements()) {
            each.accept(this, param);
        }
        swhile.getExp().getExpressionType().condition(swhile.getExp());
        return null;
    }

    @Override
    public Void visit(FuncDefinition funcDefinition, Type param) {
        funcDefinition.getType().accept(this, null);
        for (Statement each:funcDefinition.getStatements()) {
            each.accept(this, ((FuncType)funcDefinition.getType()).getReturnType());
        }
        return null;
    }

    @Override
    public Void visit(Return sReturn, Type param) {
        sReturn.getExp().accept(this, null);
        if(!param.equivalent(sReturn.getExp().getExpressionType()))
            new ErrorType(sReturn.getLine(), sReturn.getColumn(), "type mismatch with the return type of the function");
        return null;
    }
}
