import java.io.Serializable;
import java.util.Set;

public class MitarbeiterTest extends Mitarbeiter implements Serializable {

    public MitarbeiterTest(String vorname, String nachname, Set<Fachgebiet> fachgebiete){
        this.setVorname(vorname);
        this.setNachname(nachname);
        this.setFachgebiete(fachgebiete);
    }

    @Override
    public void setNachname(String nachname) {
       this.nachname = nachname;
    }

    @Override
    public void setFachgebiete(Set<Fachgebiet> fachgebiete) {
        this.fachgebiete = fachgebiete;
    }
}
