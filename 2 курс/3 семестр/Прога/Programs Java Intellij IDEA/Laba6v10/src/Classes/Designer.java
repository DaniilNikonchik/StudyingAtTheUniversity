package Classes;

import java.io.Serializable;

public class Designer extends Worker implements Serializable {
    private static final long serialVersionUID = 1L;
    public Designer(String name) {
        super(name, Worker.Type.Designer);
    }
    public Designer() {
    }
}

