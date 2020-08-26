import java.io.*;
import java.util.Set;

public class Verwaltung {

    public static String destination = "./serialized";

    public static void serialize(Mitarbeiter mitarbeiter) throws IOException {
        File file = new File(destination + "/" + mitarbeiter.getId() + ".txt");
        if(file.exists()){
            throw new IllegalArgumentException("File exists - would be overwritten.");
        }
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
        objectOutputStream.writeObject(mitarbeiter);
        objectOutputStream.flush();
        objectOutputStream.close();
    }

    public static Mitarbeiter deserialize(int id) throws IOException, ClassNotFoundException {
        File file = new File(destination + "/" + id + ".txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
        Mitarbeiter temp = (Mitarbeiter) objectInputStream.readObject();
        // check if Mitarbeiter has been tampered with
        return createMitarbeiter(temp.vorname, temp.nachname, temp.fachgebiete);
    }

    public static Mitarbeiter createMitarbeiter(String vorname, String nachname){
        // delegate call to Mitarbeiter
        return new Mitarbeiter(vorname, nachname);
    }

    public static Mitarbeiter createMitarbeiter(String vorname, String nachname, Set<Fachgebiet> fachgebiete){
        // delegate call to Mitarbeiter
        return new Mitarbeiter(vorname, nachname, fachgebiete);
    }
}
