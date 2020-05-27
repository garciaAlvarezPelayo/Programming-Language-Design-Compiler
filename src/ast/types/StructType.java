package ast.types;

import java.util.ArrayList;
import java.util.List;

import ast.main.AbstractType;
import ast.main.Expression;
import ast.main.Type;
import visitor.Visitor;

public class StructType extends AbstractType {

	private List<RecordField> records;

	public StructType(int line, int column, List<RecordField> records) {
		super(line, column);
		this.records = records;
		checkErrors();
	}

	private void checkErrors() {
		for (int i = 0; i < records.size(); i++) {
			for (int j = i+1; j < records.size(); j++)
				if(records.get(i).getName().equals(records.get(j).getName())) {
					new ErrorType(records.get(j).getLine(), records.get(j).getColumn(), "the element " + records.get(j).getName() + " is declared more than ones");
				}
		}
	}

	public List<RecordField> getRecords() {
		return records;
	}

	public void setRecords(List<RecordField> records) {
		this.records = records;
	}

	public RecordField getField(String field){
		for (RecordField each : getRecords()) {
			if(each.getName().equals(field))
				return each;
		}

		return null;
	}

	@Override
	public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
		return visitor.visit(this, param);
	}

	@Override
	public String toString() {
		return "StructType{" +
				"records=" + records +
				"} " + super.toString();
	}

	@Override
	public Type dot(String c, Expression exp) {
		RecordField field = this.getField(c);
		if(field!=null)
			return field.getType();
		return new ErrorType(exp.getLine(), exp.getColumn(), c + " is not a field of the struct");
	}

	@Override
	public int numberOfBytes() {
		int sumBytes = 0;
		for (RecordField each : getRecords()) {
			sumBytes += each.getType().numberOfBytes();
		}
		return sumBytes;
	}

	@Override
	public String reservedWord() {
		StringBuilder sb = new StringBuilder();
		sb.append("record(");
		for (int i = 0; i < getRecords().size(); i++) {
			sb.append(getRecords().get(i).reservedWord());
			if(i!=getRecords().size()-1)
				sb.append("x");
		}
		sb.append(")");
		return sb.toString();
	}
}
