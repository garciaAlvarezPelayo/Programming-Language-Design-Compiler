package error_handler;

import ast.types.ErrorType;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class ErrorHandler {

    private List<ErrorType> errors = new ArrayList<ErrorType>();
    private static ErrorHandler e;

    private ErrorHandler() {}

    public static ErrorHandler getSingletonInstance() {
        if (e == null)
            e = new ErrorHandler();
        return e;
    }

    public boolean anyError(){
        if(this.errors.size()==0)
            return false;
        return true;
    }

    public void addError(ErrorType error) {
        this.errors.add(error);
    }

    public void showErrors(PrintStream print){
        if(anyError()){
            for (ErrorType each : this.errors) {
                print.println(each);
            }
        }
    }
}
