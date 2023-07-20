package УПLab5v11;

import java.security.InvalidParameterException;

public class GameNode {
    String name;
    String type;
    String producer;
    String number;

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getProducer() {
        return producer;
    }

    public String getNumber() {
        return number;
    }

    GameNode(String _type, String _name, String _producer, String _number) {
        type = _type;
        name = _name;
        producer = _producer;
        number = _number;
    }

    GameNode(String record) {
        String[] params = record.split(",");
        if (params.length != 4) {
            throw new InvalidParameterException("Недопустимая запись");
        }
        type = params[0];
        name = params[1];
        producer = params[2];
        number = params[3];
    }

    @Override
    public String toString() {
        return type + "," + name + "," + producer + "," + number;
    }

}
