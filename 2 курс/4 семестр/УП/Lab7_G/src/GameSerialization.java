
import java.io.*;

public class GameSerialization {
    GameLibrary culinaryGuide;

    public GameSerialization(GameLibrary culinaryGuide) {
        this.culinaryGuide = culinaryGuide;
    }


    public void save(File fileToSave) throws IOException {
        FileOutputStream fos = new FileOutputStream(fileToSave.getPath());
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(culinaryGuide);
        oos.close();
        fos.close();
    }

    public GameLibrary load(File fileToSave) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(fileToSave.getPath());
        ObjectInputStream ois = new ObjectInputStream(fis);
        culinaryGuide = (GameLibrary) ois.readObject();
        ois.close();
        fis.close();

        return culinaryGuide;
    }
}
