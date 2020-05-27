package semantic;

import ast.main.Definition;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SymbolTable {

    private int scope = 0;
    private List<Map<String, Definition>> st;

    public SymbolTable(){
        this.st = new ArrayList<Map<String, Definition>>();
        this.st.add(new HashMap<String, Definition>());
    }

    public void set(){
        this.st.add(new HashMap<String, Definition>());
        this.scope++;
    }

    public void reset(){
        this.st.remove(this.st.get(this.scope));
        this.scope--;
    }

    public boolean insert(Definition node){
        Map<String, Definition> currentTable = this.st.get(scope);
        if(!currentTable.containsKey(node.getName())){
            node.setScope(this.scope);
            currentTable.put(node.getName(), node);
            return true;
        }
        return false;
    }

    public Definition find(String id){
        Definition def = null;
        for (int i = this.scope; i >= 0; i--) {
            Map<String, Definition> currentTable = this.st.get(i);
            def = currentTable.get(id);
            if(currentTable.get(id)!=null)
                return currentTable.get(id);
        }
        return def;
    }

    public Definition findInCurrentScope(String id){
        Map<String, Definition> currentTable = this.st.get(scope);
        return currentTable.get(id);
    }
}
