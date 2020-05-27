package code_generation;

import ast.definitions.FuncDefinition;
import ast.definitions.VarDefinition;
import ast.main.Definition;
import ast.main.Program;
import ast.main.Statement;
import ast.types.FuncType;
import ast.types.RecordField;
import ast.types.StructType;
import visitor.AbstractVisitor;

public class OffsetVisitor extends AbstractVisitor<Void, Void> {

    @Override
    public Void visit(Program program, Void param) {
        int position = 0;
        for (Definition each : program.getDefs()) {
            if(each instanceof VarDefinition){
                ((VarDefinition) each).setOffset(position);
                position += each.getType().numberOfBytes();
            }
            each.accept(this, null);
        }
        return null;
    }

    @Override
    public Void visit(FuncType funcType, Void param) {
        funcType.getReturnType().accept(this, null);
        int position = 4;
        for (int i = funcType.getParams().size()-1; i >= 0; i--){
            funcType.getParams().get(i).setOffset(position);
            position += funcType.getParams().get(i).getType().numberOfBytes();
            funcType.getParams().get(i).accept(this, null);
        }
        return null;
    }

    @Override
    public Void visit(FuncDefinition funcDefinition, Void param) {
        funcDefinition.getType().accept(this, null);
        int position = 0;
        for (Statement each : funcDefinition.getStatements()) {
            if(each instanceof VarDefinition){
                position += ((VarDefinition) each).getType().numberOfBytes();
                ((VarDefinition) each).setOffset(-1*position);
            }
            each.accept(this, null);
        }
        return null;
    }

    @Override
    public Void visit(StructType structType, Void param) {
        int position = 0;
        for (RecordField each : structType.getRecords()) {
            each.setOffset(position);
            position += each.getType().numberOfBytes();
            each.accept(this, null);
        }
        return null;
    }
}
