package parser;

public class LexerHelper {
	
	public static int lexemeToInt(String str) {
		try {
			return Integer.parseInt(str);
		}
		catch(NumberFormatException e) {
			System.out.println(e);
		}
		return -1;
	}

	// TODO: Implement the lexemeToChar and lexemeToReal methods

	public static double lexemeToReal(String str){
		try{
			return Double.parseDouble(str);
		}catch(NumberFormatException e){
			System.out.println(e);
		}
		return -1;
	}

	public static char lexemeToChar(String str){
		char[] values = str.toCharArray();

		if(values[1]=='\\'){
			if(values[2]=='n'){
				return '\n';
			} else if(values[2]=='t'){
				return '\t';
			} else{
				return (char) Integer.parseInt(str.substring(2, str.length()-1));
			}
		} else{
			return values[1];
		}
	}
	
}
