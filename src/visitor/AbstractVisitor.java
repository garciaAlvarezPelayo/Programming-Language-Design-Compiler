package visitor;

import ast.definitions.FuncDefinition;
import ast.definitions.VarDefinition;
import ast.expressions.*;
import ast.main.Definition;
import ast.main.Expression;
import ast.main.Program;
import ast.main.Statement;
import ast.statements.*;
import ast.types.*;

public abstract class AbstractVisitor<TP,TR> implements Visitor<TP,TR> {
    @Override
    public TR visit(Program program, TP param) {
        for (Definition each : program.getDefs()) {
            each.accept(this, param);
        }
        return null;
    }

    @Override
    public TR visit(FuncDefinition funcDefinition, TP param) {
        funcDefinition.getType().accept(this,param);
        for (Statement each:funcDefinition.getStatements()) {
            each.accept(this, param);
        }
        return null;
    }

    @Override
    public TR visit(VarDefinition varDefinition, TP param) {
        varDefinition.getType().accept(this, param);
        return null;
    }

    @Override
    public TR visit(AritmeticOperator aritmeticOperator, TP param) {
        aritmeticOperator.getLeftExp().accept(this, param);
        aritmeticOperator.getRightExp().accept(this, param);
        return null;
    }

    @Override
    public TR visit(CastType castType, TP param) {
        castType.getExp().accept(this, param);
        castType.getTypeToCast().accept(this, param);
        return null;
    }

    @Override
    public TR visit(CharacterLiteral characterLiteral, TP param) {
        return null;
    }

    @Override
    public TR visit(FieldAccess fieldAccess, TP param) {
        fieldAccess.getExp().accept(this, param);
        return null;
    }

    @Override
    public TR visit(FuncInv funcInv, TP param) {
        funcInv.getVar().accept(this, param);
        for (Expression each:funcInv.getExpressions()) {
            each.accept(this, param);
        }
        return null;
    }

    @Override
    public TR visit(Indexing indexing, TP param) {
        indexing.getLeftExp().accept(this, param);
        indexing.getRightExp().accept(this, param);
        return null;
    }

    @Override
    public TR visit(IntLiteral intLiteral, TP param) {
        return null;
    }

    @Override
    public TR visit(LogicalComparator logicalComparator, TP param) {
        logicalComparator.getLeftExp().accept(this, param);
        logicalComparator.getRightExp().accept(this, param);
        return null;
    }

    @Override
    public TR visit(LogicalDoor logicalDoor, TP param) {
        logicalDoor.getLeftExp().accept(this, param);
        logicalDoor.getRightExp().accept(this, param);
        return null;
    }

    @Override
    public TR visit(RealLiteral realLiteral, TP param) {
        return null;
    }

    @Override
    public TR visit(UnaryMinus unaryMinus, TP param) {
        unaryMinus.getExp().accept(this, param);
        return null;
    }

    @Override
    public TR visit(UnaryNegation unaryNegation, TP param) {
        unaryNegation.getExp().accept(this, param);
        return null;
    }

    @Override
    public TR visit(Variable variable, TP param) {
        return null;
    }

    @Override
    public TR visit(Assigment assigment, TP param) {
        assigment.getLeftExp().accept(this, param);
        assigment.getRightExp().accept(this, param);
        return null;
    }

    @Override
    public TR visit(IfElse ifElse, TP param) {
        ifElse.getExp().accept(this, param);
        for (Statement each:ifElse.getStatIf()) {
            each.accept(this, param);
        }
        for (Statement each:ifElse.getStatElse()) {
            each.accept(this, param);
        }
        return null;
    }

    @Override
    public TR visit(Read read, TP param) {
        read.getExp().accept(this, param);
        return null;
    }

    @Override
    public TR visit(Return sReturn, TP param) {
        sReturn.getExp().accept(this, param);
        return null;
    }

    @Override
    public TR visit(While swhile, TP param) {
        swhile.getExp().accept(this, param);
        for (Statement each:swhile.getStatements()) {
            each.accept(this, param);
        }
        return null;
    }

    @Override
    public TR visit(Write write, TP param) {
        write.getExp().accept(this, param);
        return null;
    }

    @Override
    public TR visit(ArrayType arrayType, TP param) {
        arrayType.getType().accept(this, param);
        return null;
    }

    @Override
    public TR visit(CharType charType, TP param) {
        return null;
    }

    @Override
    public TR visit(DoubleType doubleType, TP param) {
        return null;
    }

    @Override
    public TR visit(ErrorType errorType, TP param) {
        return null;
    }

    @Override
    public TR visit(FuncType funcType, TP param) {
        funcType.getReturnType().accept(this, param);
        for (VarDefinition each:funcType.getParams()) {
            each.accept(this, param);
        }
        return null;
    }

    @Override
    public TR visit(IntType intType, TP param) {
        return null;
    }

    @Override
    public TR visit(RecordField recordField, TP param) {
        recordField.getType().accept(this, param);
        return null;
    }

    @Override
    public TR visit(StructType structType, TP param) {
        for (RecordField each:structType.getRecords()) {
            each.accept(this, param);
        }
        return null;
    }

    @Override
    public TR visit(VoidType voidType, TP param) {
        return null;
    }
}
