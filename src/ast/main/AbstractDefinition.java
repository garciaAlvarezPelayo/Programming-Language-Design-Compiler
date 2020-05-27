package ast.main;
public abstract class AbstractDefinition extends AbstractASTNode implements Definition{
	
	private Type type;
	private String name;
	private int scope;

	public AbstractDefinition(int line, int column, Type type, String name) {
		super(line, column);
		this.type = type;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScope() {
		return scope;
	}

	public void setScope(int scope) {
		this.scope = scope;
	}

	@Override
	public String toString() {
		return "AbstractDefinition{" +
				"type=" + type +
				", name='" + name + '\'' +
				", scope=" + scope +
				"} " + super.toString();
	}
}
