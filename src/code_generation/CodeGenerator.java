package code_generation;

import ast.definitions.VarDefinition;
import ast.main.Type;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CodeGenerator {

    private String input;
    private BufferedWriter out;
    private int labels;

    public CodeGenerator(String input, BufferedWriter output) {
        this.out = output;
        this.input = input;
    }

    private void writeLine(String line) {
        try{
            out.write(line);
            out.write("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Labels------------------------------------------------------------------------------------------

    public void FuncLabelMessage(String name) {
        writeLine(name+":");
    }

    public void labelMessage(int labelNumber) {
        writeLine(" label" + labelNumber + ":");
    }

    public void mainCall() {
        writeLine("' Invocation to the main function");
        writeLine("call main");
        writeLine("halt");
    }

    // Comments------------------------------------------------------------------------------------------

    public void writeMessage() {
        writeLine("\t' * Write");
    }

    public void readMessage() {
        writeLine("\t' * Read");
    }

    public void varDefinitionMessage(VarDefinition var) {
        writeLine("\t' * " + var.getType().reservedWord() + " " + var.getName() + " (offset " + var.getOffset() + ")");
    }

    public void localVariablesMessage() {
        writeLine("\t' * Local variables");
    }

    public void inputMessage() {
        writeLine("#source \"" + input + "\"");
    }

    public void writeLineMessage(int line) {
        writeLine("#line\t" + line);
    }

    public void paramMessage() {
        writeLine("\t' * Parameters");
    }

    public void ifMessage() {
        writeLine("\t' * If statement");
    }

    public void ifBodyMessage() {
        writeLine("\t' * Body of the if branch");
    }

    public void elseBodyMessage() {
        writeLine("\t' * Body of the else branch");
    }

    public void whileMessage() {
        writeLine("' * While");
    }

    public void bodyWhileMessage() {
        writeLine("\t' * Body while statement");
    }

    public void returnMessage() {
        writeLine("\t' * Return");
    }

    // Input Output------------------------------------------------------------------------------------------

    public void in(Type expressionType) {
        writeLine("\tin"+expressionType.getSuffix());
    }

    public void out(Type expressionType) {
        writeLine("\tout" + expressionType.getSuffix());
    }

    // Load Store------------------------------------------------------------------------------------------

    public void load(Type expressionType) {
        writeLine("\tload" + expressionType.getSuffix());
    }

    public void store(Type expressionType) {
        writeLine("\tstore"+expressionType.getSuffix());
    }

    // Function operations------------------------------------------------------------------------------------------

    public void call(String funcName) {
        writeLine("\tcall\t" +  funcName);
    }

    public void enter(int bytesLocals) {
        writeLine("\tenter\t" + bytesLocals);
    }

    public void ret(int bytesReturn, int bytesLocals, int bytesParams) {
        writeLine("\tret\t" + bytesReturn + ", " + bytesLocals + ", " + bytesParams);
    }

    // Push Pop------------------------------------------------------------------------------------------

    public void pushAddress(VarDefinition def) {
        if(def.getScope()==0)
            writeLine("\tpusha\t" + def.getOffset());
        else {
            writeLine("\tpush\tbp");
            pushInt(def.getOffset());
            add('i');
        }
    }

    public void push(char suffix, int value) {
        writeLine("\tpush" + suffix + "\t" + value);
    }

    public void pushInt(int value) {
        writeLine("\tpushi\t" + value);
    }

    public void pushDouble(double value) {
        writeLine("\tpushf\t" + value);
    }

    public void pushChar(int value) {
        writeLine("\tpushb\t" + value);
    }

    public void pop(char suffix) {
        writeLine("\tpop" + suffix);
    }

    // Type conversion------------------------------------------------------------------------------------------

    public void convert(Type from, Type to) {
        writeLine("\t"+from.convertTo(to));
    }

    // Aritmetic------------------------------------------------------------------------------------------

    public void aritmetic(String operator, Type expressionType) {
        switch(operator){
            case "+": add(expressionType.getSuffix()); break;
            case "-": sub(expressionType.getSuffix()); break;
            case "/": div(expressionType.getSuffix()); break;
            case "*": mul(expressionType.getSuffix()); break;
            case "%": mod(expressionType.getSuffix()); break;
        }
    }

    public void add(char suffix) {
        writeLine("\tadd" + suffix);
    }

    public void sub(char suffix) {
        writeLine("\tsub" + suffix);
    }

    public void div(char suffix) {
        writeLine("\tdiv" + suffix);
    }

    public void mul(char suffix) {
        writeLine("\tmul" + suffix);
    }

    public void mod(char suffix) {
        writeLine("\tmod" + suffix);
    }

    // Comparison------------------------------------------------------------------------------------------

    public void compare(String operator, Type expressionType) {
        switch(operator){
            case ">": greaterThan(expressionType.getSuffix()); break;
            case "<": lowerThan(expressionType.getSuffix()); break;
            case ">=": greaterEqualThan(expressionType.getSuffix()); break;
            case "<=": lowerEqualThan(expressionType.getSuffix()); break;
            case "==": equalThan(expressionType.getSuffix()); break;
            case "!=": notEqualThan(expressionType.getSuffix()); break;
        }
    }

    public void greaterThan(char suffix) {
        writeLine("\tgt" + suffix);
    }

    public void lowerThan(char suffix) {
        writeLine("\tlt" + suffix);
    }

    public void greaterEqualThan(char suffix) {
        writeLine("\tge" + suffix);
    }

    public void lowerEqualThan(char suffix) {
        writeLine("\tle" + suffix);
    }

    public void equalThan(char suffix) {
        writeLine("\teq" + suffix);
    }

    public void notEqualThan(char suffix) {
        writeLine("\tne" + suffix);
    }

    // Logical------------------------------------------------------------------------------------------

    public void logical(String operator) {
        switch(operator){
            case "&&": and(); break;
            case "||": or(); break;
        }
    }

    public void and() {
        writeLine("\tand");
    }

    public void or() {
        writeLine("\tor");
    }

    public void not() {
        writeLine("\tnot");
    }

    // Jumps------------------------------------------------------------------------------------------

    public int getLabels(int howMany) {
        int temp = this.labels;
        this.labels += howMany;
        return temp;
    }

    public void jzLabel(int labelNumber) {
        writeLine("\tjz\tlabel" + labelNumber);
    }

    public void jpmLabel(int labelNumber) {
        writeLine("\tjmp\tlabel" + labelNumber);
    }
}
