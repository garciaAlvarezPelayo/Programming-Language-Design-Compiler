package visitor;

import ast.definitions.FuncDefinition;
import ast.definitions.VarDefinition;
import ast.expressions.*;
import ast.main.Program;
import ast.statements.*;
import ast.types.*;

public interface Visitor<TP,TR> {
    public TR visit(Program program, TP param);

    public TR visit(FuncDefinition funcDefinition, TP param);
    public TR visit(VarDefinition varDefinition, TP param);

    public TR visit(AritmeticOperator aritmeticOperator, TP param);
    public TR visit(CastType castType, TP param);
    public TR visit(CharacterLiteral characterLiteral, TP param);
    public TR visit(FieldAccess fieldAccess, TP param);
    public TR visit(FuncInv funcInv, TP param);
    public TR visit(Indexing indexing, TP param);
    public TR visit(IntLiteral intLiteral, TP param);
    public TR visit(LogicalComparator logicalComparator, TP param);
    public TR visit(LogicalDoor logicalDoor, TP param);
    public TR visit(RealLiteral realLiteral, TP param);
    public TR visit(UnaryMinus unaryMinus, TP param);
    public TR visit(UnaryNegation unaryNegation, TP param);
    public TR visit(Variable variable, TP param);

    public TR visit(Assigment assigment, TP param);
    public TR visit(IfElse ifElse, TP param);
    public TR visit(Read read, TP param);
    public TR visit(Return sReturn, TP param);
    public TR visit(While swhile, TP param);
    public TR visit(Write write, TP param);

    public TR visit(ArrayType arrayType, TP param);
    public TR visit(CharType charType, TP param);
    public TR visit(DoubleType doubleType, TP param);
    public TR visit(ErrorType errorType, TP param);
    public TR visit(FuncType funcType, TP param);
    public TR visit(IntType intType, TP param);
    public TR visit(RecordField recordField, TP param);
    public TR visit(StructType structType, TP param);
    public TR visit(VoidType voidType, TP param);
}
