package code_generation;

import ast.definitions.FuncDefinition;
import ast.definitions.VarDefinition;
import ast.expressions.FuncInv;
import ast.main.Definition;
import ast.main.Expression;
import ast.main.Program;
import ast.main.Statement;
import ast.statements.*;
import ast.types.FuncType;
import ast.types.VoidType;
import visitor.AbstractCGVisitor;

import java.util.List;

public class ExecuteCGVisitor extends AbstractCGVisitor<Integer[], Void> {

    private ValueCGVisitor value;
    private AddressCGVisitor address;

    public ExecuteCGVisitor(CodeGenerator cg) {
        super(cg);
        this.value = new ValueCGVisitor(cg, new AddressCGVisitor(cg));
        this.address = new AddressCGVisitor(cg);
    }

    @Override
    public Void visit(Program program, Integer[] param) {
        List<Definition> vd = program.getVarDefinitions();
        List<Definition> fd = program.getFuncDefinitions();

        getCg().inputMessage();
        for (Definition each : vd) {
            each.accept(this, null);
        }

        getCg().mainCall();

        for (Definition each : fd) {
            each.accept(this, null);
        }
        return null;
    }

    @Override
    public Void visit(Write write, Integer[] param) {
        getCg().writeMessage();
        write.getExp().accept(value, null);
        getCg().out(write.getExp().getExpressionType());
        return null;
    }

    @Override
    public Void visit(Read read, Integer[] param) {
        getCg().readMessage();
        read.getExp().accept(address, null);
        getCg().in(read.getExp().getExpressionType());
        getCg().store(read.getExp().getExpressionType());
        return null;
    }

    @Override
    public Void visit(Assigment assigment, Integer[] param) {
        assigment.getLeftExp().accept(address, null);
        assigment.getRightExp().accept(value, null);
        getCg().store(assigment.getLeftExp().getExpressionType());
        return null;
    }

    @Override
    public Void visit(VarDefinition varDefinition, Integer[] param) {
        getCg().varDefinitionMessage(varDefinition);
        return null;
    }

    @Override
    public Void visit(FuncDefinition funcDefinition, Integer[] param) {
        getCg().writeLineMessage(funcDefinition.getLine());
        getCg().FuncLabelMessage(funcDefinition.getName());
        funcDefinition.getType().accept(this, null);
        getCg().localVariablesMessage();
        for (VarDefinition each : funcDefinition.getVarDefinitions()) {
            each.accept(this, null);
        }
        getCg().enter(funcDefinition.getBytesLocals());
        Integer[] ret = {funcDefinition.getBytesReturn(), funcDefinition.getBytesLocals(), funcDefinition.getBytesParams()};
        for (Statement each : funcDefinition.getStatementsNotDefinitions()) {
            getCg().writeLineMessage(each.getLine());
            each.accept(this, ret);
        }
        if(funcDefinition.getBytesReturn()==0)
            getCg().ret(funcDefinition.getBytesReturn(), funcDefinition.getBytesLocals(), funcDefinition.getBytesParams());
        return null;
    }

    @Override
    public Void visit(FuncType funcType, Integer[] param) {
        getCg().paramMessage();
        for (VarDefinition each : funcType.getParams()) {
            each.accept(this, null);
        }
        return null;
    }

    @Override
    public Void visit(While swhile, Integer[] param) {
        getCg().whileMessage();
        int labelNumber = getCg().getLabels(2);
        getCg().labelMessage(labelNumber);
        swhile.getExp().accept(value, null);
        getCg().jzLabel(labelNumber+1);
        getCg().bodyWhileMessage();
        for (Statement each : swhile.getStatements()) {
            getCg().writeLineMessage(each.getLine());
            each.accept(this, param);
        }
        getCg().jpmLabel(labelNumber);
        getCg().labelMessage(labelNumber+1);
        return null;
    }

    @Override
    public Void visit(IfElse ifElse, Integer[] param) {
        getCg().ifMessage();
        int labelNumber = getCg().getLabels(2);
        ifElse.getExp().accept(value, null);
        getCg().jzLabel(labelNumber);
        getCg().ifBodyMessage();
        for (Statement each : ifElse.getStatIf()) {
            getCg().writeLineMessage(each.getLine());
            each.accept(this, param);
        }
        getCg().jpmLabel(labelNumber+1);
        getCg().labelMessage(labelNumber);
        getCg().elseBodyMessage();
        for (Statement each : ifElse.getStatElse()) {
            getCg().writeLineMessage(each.getLine());
            each.accept(this, param);
        }
        getCg().labelMessage(labelNumber+1);
        return null;
    }

    @Override
    public Void visit(FuncInv funcInv, Integer[] param) {
        for (Expression each : funcInv.getExpressions()) {
            each.accept(value, null);
        }
        getCg().call(funcInv.getVar().getName());
        if(!(((FuncType)funcInv.getVar().getExpressionType()).getReturnType() instanceof VoidType))
            getCg().pop((((FuncType) funcInv.getVar().getExpressionType()).getReturnType().getSuffix()));

        return null;
    }

    @Override
    public Void visit(Return sReturn, Integer[] param) {
        getCg().returnMessage();
        sReturn.getExp().accept(value, null);
        getCg().ret(param[0], param[1], param[2]);
        return null;
    }
}
