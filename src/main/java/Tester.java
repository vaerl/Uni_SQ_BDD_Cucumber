import java.io.File;
import java.util.HashSet;
import java.util.Objects;

public class Tester {

    public static Mitarbeiter invalidateSurname(Mitarbeiter mitarbeiter){
        MitarbeiterTest mitarbeiterTest = new MitarbeiterTest(mitarbeiter.vorname, mitarbeiter.nachname, mitarbeiter.fachgebiete);
        mitarbeiterTest.setNachname("A");
        return mitarbeiterTest;
    }

    public static Mitarbeiter removeAllFachgebiete(Mitarbeiter mitarbeiter){
        MitarbeiterTest mitarbeiterTest = new MitarbeiterTest(mitarbeiter.vorname, mitarbeiter.nachname, mitarbeiter.fachgebiete);
        mitarbeiterTest.setFachgebiete(new HashSet<>());
        return mitarbeiterTest;
    }

    public static void clearExistingFiles(){
        for (File file: Objects.requireNonNull(new File(Verwaltung.destination).listFiles())) {
            file.delete();
        }
    }
}
