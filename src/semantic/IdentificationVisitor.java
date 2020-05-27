package semantic;

import ast.definitions.FuncDefinition;
import ast.definitions.VarDefinition;
import ast.expressions.Variable;
import ast.main.Definition;
import ast.main.Statement;
import ast.types.ErrorType;
import visitor.AbstractVisitor;

public class IdentificationVisitor extends AbstractVisitor<Void, Void> {

    private SymbolTable table = new SymbolTable();

    @Override
    public Void visit(FuncDefinition funcDefinition, Void param) {
        if(!table.insert(funcDefinition))
            new ErrorType(funcDefinition.getLine(), funcDefinition.getColumn(), funcDefinition.getName() + " has already been defined");
        table.set();
        funcDefinition.getType().accept(this, null);
        for (Statement each : funcDefinition.getStatements()) {
            each.accept(this, null);
        }
        table.reset();
        return null;
    }

    @Override
    public Void visit(VarDefinition varDefinition, Void param) {
        if(!table.insert(varDefinition))
            new ErrorType(varDefinition.getLine(), varDefinition.getColumn(), varDefinition.getName() + " has already been defined");
        varDefinition.getType().accept(this, null);
        return null;
    }

    @Override
    public Void visit(Variable variable, Void param) {
        Definition def = table.find(variable.getName());
        if(def!=null)
            variable.setDefinition(def);
        return null;
    }
}
