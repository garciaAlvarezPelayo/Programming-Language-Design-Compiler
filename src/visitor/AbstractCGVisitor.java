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
import code_generation.AddressCGVisitor;
import code_generation.CodeGenerator;
import code_generation.ValueCGVisitor;

public abstract class AbstractCGVisitor<TP,TR> implements Visitor<TP,TR> {

    private CodeGenerator cg;

    public AbstractCGVisitor(CodeGenerator cg) {
        this.cg = cg;
    }

    public CodeGenerator getCg() {
        return cg;
    }

    public void setCg(CodeGenerator cg) {
        this.cg = cg;
    }

    @Override
    public TR visit(Program program, TP param) {
        throw new IllegalStateException("You can not execute this code function with " + program);
    }

    @Override
    public TR visit(FuncDefinition funcDefinition, TP param) {
        throw new IllegalStateException("You can not execute this code function with " + funcDefinition);
    }

    @Override
    public TR visit(VarDefinition varDefinition, TP param) {
        throw new IllegalStateException("You can not execute this code function with " + varDefinition);
    }

    @Override
    public TR visit(AritmeticOperator aritmeticOperator, TP param) {
        throw new IllegalStateException("You can not execute this code function with " + aritmeticOperator);
    }

    @Override
    public TR visit(CastType castType, TP param) {
        throw new IllegalStateException("You can not execute this code function with " + castType);
    }

    @Override
    public TR visit(CharacterLiteral characterLiteral, TP param) {
        throw new IllegalStateException("You can not execute this code function with " + characterLiteral);
    }

    @Override
    public TR visit(FieldAccess fieldAccess, TP param) {
        throw new IllegalStateException("You can not execute this code function with " + fieldAccess);
    }

    @Override
    public TR visit(FuncInv funcInv, TP param) {
        throw new IllegalStateException("You can not execute this code function with " + funcInv);
    }

    @Override
    public TR visit(Indexing indexing, TP param) {
        throw new IllegalStateException("You can not execute this code function with " + indexing);
    }

    @Override
    public TR visit(IntLiteral intLiteral, TP param) {
        throw new IllegalStateException("You can not execute this code function with " + intLiteral);
    }

    @Override
    public TR visit(LogicalComparator logicalComparator, TP param) {
        throw new IllegalStateException("You can not execute this code function with " + logicalComparator);
    }

    @Override
    public TR visit(LogicalDoor logicalDoor, TP param) {
        throw new IllegalStateException("You can not execute this code function with " + logicalDoor);
    }

    @Override
    public TR visit(RealLiteral realLiteral, TP param) {
        throw new IllegalStateException("You can not execute this code function with " + realLiteral);
    }

    @Override
    public TR visit(UnaryMinus unaryMinus, TP param) {
        throw new IllegalStateException("You can not execute this code function with " + unaryMinus);
    }

    @Override
    public TR visit(UnaryNegation unaryNegation, TP param) {
        throw new IllegalStateException("You can not execute this code function with " + unaryNegation);
    }

    @Override
    public TR visit(Variable variable, TP param) {
        throw new IllegalStateException("You can not execute this code function with " + variable);
    }

    @Override
    public TR visit(Assigment assigment, TP param) {
        throw new IllegalStateException("You can not execute this code function with " + assigment);
    }

    @Override
    public TR visit(IfElse ifElse, TP param) {
        throw new IllegalStateException("You can not execute this code function with " + ifElse);
    }

    @Override
    public TR visit(Read read, TP param) {
        throw new IllegalStateException("You can not execute this code function with " + read);
    }

    @Override
    public TR visit(Return sReturn, TP param) {
        throw new IllegalStateException("You can not execute this code function with " + sReturn);
    }

    @Override
    public TR visit(While swhile, TP param) {
        throw new IllegalStateException("You can not execute this code function with " + swhile);
    }

    @Override
    public TR visit(Write write, TP param) {
        throw new IllegalStateException("You can not execute this code function with " + write);
    }

    @Override
    public TR visit(ArrayType arrayType, TP param) {
        throw new IllegalStateException("You can not execute this code function with " + arrayType);
    }

    @Override
    public TR visit(CharType charType, TP param) {
        throw new IllegalStateException("You can not execute this code function with " + charType);
    }

    @Override
    public TR visit(DoubleType doubleType, TP param) {
        throw new IllegalStateException("You can not execute this code function with " + doubleType);
    }

    @Override
    public TR visit(ErrorType errorType, TP param) {
        throw new IllegalStateException("You can not execute this code function with " + errorType);
    }

    @Override
    public TR visit(FuncType funcType, TP param) {
        throw new IllegalStateException("You can not execute this code function with " + funcType);
    }

    @Override
    public TR visit(IntType intType, TP param) {
        throw new IllegalStateException("You can not execute this code function with " + intType);
    }

    @Override
    public TR visit(RecordField recordField, TP param) {
        throw new IllegalStateException("You can not execute this code function with " + recordField);
    }

    @Override
    public TR visit(StructType structType, TP param) {
        throw new IllegalStateException("You can not execute this code function with " + structType);
    }

    @Override
    public TR visit(VoidType voidType, TP param) {
        throw new IllegalStateException("You can not execute this code function with " + voidType);
    }
}
