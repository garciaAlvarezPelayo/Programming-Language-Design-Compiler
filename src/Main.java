import ast.main.ASTNode;
import code_generation.CodeGenerator;
import code_generation.ExecuteCGVisitor;
import code_generation.OffsetVisitor;
import error_handler.ErrorHandler;
import introspector.model.IntrospectorModel;
import introspector.view.IntrospectorTree;
import parser.*;

import org.antlr.v4.runtime.*;
import semantic.IdentificationVisitor;
import semantic.TypeCheckingVisitor;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class Main {
	
	public static void main(String... args) throws Exception {
		   if (args.length<1) {
		        System.err.println("Please, pass me the input file.");
		        return;
		    }
		   		 			
		 // create a lexer that feeds off of input CharStream
		CharStream input = CharStreams.fromFileName(args[0]);
		CmmLexer lexer = new CmmLexer(input);

		// create a parser that feeds off the tokens buffer
		CommonTokenStream tokens = new CommonTokenStream(lexer); 
		CmmParser parser = new CmmParser(tokens);	
		ASTNode ast = parser.program().ast;

		ast.accept(new IdentificationVisitor(), null);
		ast.accept(new TypeCheckingVisitor(), null);

		if(ErrorHandler.getSingletonInstance().anyError()) {
			ErrorHandler.getSingletonInstance().showErrors(System.out);
			throw new RuntimeException("Semantic errors have been found");
		}

		ast.accept(new OffsetVisitor(), null);
		BufferedWriter output = new BufferedWriter(new FileWriter(new File("output.txt")));
		CodeGenerator cg = new CodeGenerator(input.getSourceName() , output);
		ast.accept(new ExecuteCGVisitor(cg), null);
		output.close();
		IntrospectorModel model = new IntrospectorModel("Program", ast);
		new IntrospectorTree("Program", model);
	}
	

}
