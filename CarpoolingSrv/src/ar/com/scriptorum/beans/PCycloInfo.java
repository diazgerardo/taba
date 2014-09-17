package ar.com.scriptorum.beans;



public class PCycloInfo implements PersistentEntity {

    private static final long serialVersionUID = 1L;
    Long id;
   
    @Override
    public long getId() {
        return this.id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

}
