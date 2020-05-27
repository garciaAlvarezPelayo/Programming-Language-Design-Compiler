package code_generation;

import ast.definitions.VarDefinition;
import ast.expressions.FieldAccess;
import ast.expressions.Indexing;
import ast.expressions.Variable;
import ast.types.StructType;
import visitor.AbstractCGVisitor;
import visitor.Visitor;

public class AddressCGVisitor extends AbstractCGVisitor<Void, Void> {

    private ValueCGVisitor value;

    public AddressCGVisitor(CodeGenerator cg) {
        super(cg);
        this.value = new ValueCGVisitor(cg, this);
    }

    @Override
    public Void visit(Variable variable, Void param) {
        VarDefinition def = (VarDefinition) variable.getDefinition();
        getCg().pushAddress(def);
        return null;
    }

    @Override
    public Void visit(FieldAccess fieldAccess, Void param) {
        fieldAccess.getExp().accept(this, null);
        getCg().pushInt(((StructType)fieldAccess.getExp().getExpressionType()).getField(fieldAccess.getField()).getOffset());
        getCg().add('i');
        return null;
    }

    @Override
    public Void visit(Indexing indexing, Void param) {
        indexing.getLeftExp().accept(this, null);
        indexing.getRightExp().accept(value, null);
        getCg().pushInt(indexing.getExpressionType().numberOfBytes());
        getCg().mul('i');
        getCg().add('i');
        return null;
    }
}
