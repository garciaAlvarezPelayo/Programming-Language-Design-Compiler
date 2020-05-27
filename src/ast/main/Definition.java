package ast.main;

public interface Definition extends ASTNode{

    public String getName();
    public void setName(String name);
    public Type getType();
    public void setType(Type type);
    public int getScope();
    public void setScope(int scope);
}
