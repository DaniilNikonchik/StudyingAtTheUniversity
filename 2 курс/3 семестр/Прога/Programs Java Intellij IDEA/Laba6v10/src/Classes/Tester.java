package Classes;

import java.io.Serializable;

public class Tester extends Worker implements Serializable {
    private static final long serialVersionUID = 1L;
    public Tester( String name ) {
        super( name, Worker.Type.Tester);
    }
    public Tester() {}
}

