package Classes;

import java.io.Serializable;

public class Manager extends Worker implements Serializable {
    private static final long serialVersionUID = 1L;
    public Manager( String name ) {
        super( name, Worker.Type.Manager);
    }
    public Manager() {}
}
