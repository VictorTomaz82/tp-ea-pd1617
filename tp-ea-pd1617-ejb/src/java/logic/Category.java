package logic;

import java.io.Serializable;

public class Category implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    int categoryId;

    String name; //unique
    String description;

    //--- Methods ---
    public Category(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
        @Override
    public String toString() {
        return name+": "+description;
    }

}
