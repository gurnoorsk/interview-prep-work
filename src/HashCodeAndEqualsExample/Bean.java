package HashCodeAndEqualsExample;

import java.util.Objects;

public class Bean {
    private int id;
    private String name;

    public Bean(int id,String name){
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString(){
        return "Id : "+id+" name : "+name;
    }

    @Override
    public boolean equals(Object o){
        if(this == o)return true;
        if(o == null || getClass() != o.getClass()) return false;
        Bean b = (Bean)o;
        return id == b.id && Objects.equals(name,b.name);

    }

    @Override
    public int hashCode(){
        return Objects.hash(id,name);
    }
}
