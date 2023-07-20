package Classes;

import java.io.Serializable;

public class Programmer extends Worker implements Serializable {
    private static final long serialVersionUID = 1L;
    public Programmer( String name ) {
        super(name, Worker.Type.Programmer);
    }
    public Programmer() {}
}
