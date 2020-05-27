package code_generation;

import ast.expressions.*;
import ast.main.Expression;
import ast.types.CharType;
import visitor.AbstractCGVisitor;

public class ValueCGVisitor extends AbstractCGVisitor<Void, Void> {

    private AddressCGVisitor address;

    public ValueCGVisitor(CodeGenerator cg, AddressCGVisitor addressCGVisitor) {
        super(cg);
        this.address = addressCGVisitor;
    }

    @Override
    public Void visit(IntLiteral intLiteral, Void param) {
        getCg().pushInt(intLiteral.getValue());
        return null;
    }

    @Override
    public Void visit(RealLiteral realLiteral, Void param) {
        getCg().pushDouble(realLiteral.getValue());
        return null;
    }

    @Override
    public Void visit(CharacterLiteral characterLiteral, Void param) {
        getCg().pushChar(characterLiteral.getValue());
        return null;
    }

    @Override
    public Void visit(Variable variable, Void param) {
        variable.accept(address, null);
        getCg().load(variable.getExpressionType());
        return null;
    }

    @Override
    public Void visit(AritmeticOperator aritmeticOperator, Void param) {
        if(aritmeticOperator.getLeftExp().getExpressionType() instanceof CharType){
            aritmeticOperator.getLeftExp().accept(this, null);
            getCg().convert(aritmeticOperator.getLeftExp().getExpressionType(), aritmeticOperator.getExpressionType());
            aritmeticOperator.getRightExp().accept(this, null);
            getCg().convert(aritmeticOperator.getRightExp().getExpressionType(), aritmeticOperator.getExpressionType());
        } else{
            aritmeticOperator.getLeftExp().accept(this, null);
            aritmeticOperator.getRightExp().accept(this, null);
        }
        getCg().aritmetic(aritmeticOperator.getOperator(), aritmeticOperator.getExpressionType());
        return null;
    }

    @Override
    public Void visit(LogicalComparator logicalComparator, Void param) {
        logicalComparator.getLeftExp().accept(this, null);
        logicalComparator.getRightExp().accept(this, null);
        getCg().compare(logicalComparator.getOperator(), logicalComparator.getExpressionType());
        return null;
    }

    @Override
    public Void visit(LogicalDoor logicalDoor, Void param) {
        logicalDoor.getLeftExp().accept(this, null);
        logicalDoor.getRightExp().accept(this, null);
        getCg().logical(logicalDoor.getOperator());
        return null;
    }

    @Override
    public Void visit(UnaryNegation unaryNegation, Void param) {
        unaryNegation.getExp().accept(this, null);
        getCg().not();
        return null;
    }

    @Override
    public Void visit(CastType castType, Void param) {
        castType.getExp().accept(this, null);
        getCg().convert(castType.getExp().getExpressionType(), castType.getTypeToCast());
        return null;
    }

    @Override
    public Void visit(UnaryMinus unaryMinus, Void param) {
        getCg().push(unaryMinus.getExp().getExpressionType().getSuffix(), 0);
        if(unaryMinus.getExp().getExpressionType() instanceof CharType){
            unaryMinus.getExp().accept(this, null);
            getCg().convert(unaryMinus.getExp().getExpressionType(), unaryMinus.getExpressionType());
        } else{
            unaryMinus.getExp().accept(this, null);
        }
        getCg().sub(unaryMinus.getExpressionType().getSuffix());
        return null;
    }

    @Override
    public Void visit(FieldAccess fieldAccess, Void param) {
        fieldAccess.accept(address, null);
        getCg().load(fieldAccess.getExpressionType());
        return null;
    }

    @Override
    public Void visit(Indexing indexing, Void param) {
        indexing.accept(address, null);
        getCg().load(indexing.getExpressionType());
        return null;
    }

    @Override
    public Void visit(FuncInv funcInv, Void param) {
        for (Expression each : funcInv.getExpressions()) {
            each.accept(this, null);
        }
        getCg().call(funcInv.getVar().getName());
        return null;
    }
}
