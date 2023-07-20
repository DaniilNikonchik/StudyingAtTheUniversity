package Classes;

import java.io.*;

public class Connector {

    private final String filename;

    public Connector(String filename) {
        this.filename = filename;
    }

    public void write(Worker[] band) throws IOException {
        FileOutputStream fos = new FileOutputStream(filename);
        try (ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeInt(band.length);
            for (Worker band1 : band) {
                oos.writeObject(band1);
            }
            oos.flush();
        }
    }

    public Worker[] read() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(filename);
        try (ObjectInputStream oin = new ObjectInputStream(fis)) {
            int length = oin.readInt();
            Worker[] result = new Worker[length];
            for (int i = 0; i < length; i++) {
                result[i] = (Worker) oin.readObject();
            }
            return result;
        }
    }
}
