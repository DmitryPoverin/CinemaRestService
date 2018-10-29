package cinema.service.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public abstract class Entity<K> implements Cloneable {
    protected K id;
    public Entity(K id){
        this.id = id;
    }
    public K getId(){
        return id;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}