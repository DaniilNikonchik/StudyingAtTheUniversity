package Classes;

import java.io.Serializable;

public class Analyst extends Worker implements Serializable {
    private static final long serialVersionUID = 1L;
    public Analyst( String name ) {
        super( name, Worker.Type.Analyst);
    }
    public Analyst() {}
}

