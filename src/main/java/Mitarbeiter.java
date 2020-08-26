import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Mitarbeiter implements Serializable {
    static final long serialVersionUID = 458076069326042941L;
    int id;
    int idGenerator = 100;
    String vorname;
    String nachname;
    Set<Fachgebiet> fachgebiete;

    public Mitarbeiter(String vorname, String nachname) {
        this.vorname = vorname;
        this.setNachname(nachname);
        this.id = idGenerator++;
        fachgebiete = new HashSet<>();
    }

    public Mitarbeiter(String vorname, String nachname, Set<Fachgebiet> fachgebiete) {
       this(vorname, nachname);
       this.setFachgebiete(fachgebiete);
    }

    public Mitarbeiter() { // nur für Serialisierung
        fachgebiete = new HashSet<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        if (nachname == null || nachname.length() < 2) {
            throw new IllegalArgumentException("Nachname mit mindestens zwei Zeichen!");
        }
        this.nachname = nachname;
    }

    public Set<Fachgebiet> getFachgebiete() {
        return fachgebiete;
    }

    public void setFachgebiete(Set<Fachgebiet> fachgebiete) {
        if(fachgebiete.size() > 3){
            throw new IllegalArgumentException("Maximal 3 Fachgebiete!");
        }
        if(fachgebiete.size() < 1){
            throw new IllegalArgumentException("Mindestens 1 Fachgebiet!");
        }
        this.fachgebiete = fachgebiete;
    }

    public void addFachgebiet(Fachgebiet f) {
        if (fachgebiete.size() > 3) {
            throw new IllegalArgumentException("Maximal 3 Fachgebiete!");
        }
        fachgebiete.add(f);
    }

    public void removeFachgebiet(Fachgebiet f) {
        if(fachgebiete.size() < 1){
            throw new IllegalArgumentException("Mindestens 1 Fachgebiet!");
        }
        fachgebiete.remove(f);
    }

    public boolean hatFachgebiet(Fachgebiet f) {
        return fachgebiete.contains(f);
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Mitarbeiter other = (Mitarbeiter) obj;
        return (id == other.id);
    }

    @Override
    public String toString() {
        StringBuilder erg = new StringBuilder(vorname + " " + nachname + " (" + id + ")[ ");
        for (Fachgebiet f : fachgebiete){
            if(f.equals(fachgebiete.stream().reduce((a, b) -> b).orElse(null))){
                erg.append(f);
                break;
            }
            erg.append(f).append(", ");
        }
        erg.append("]");
        return erg.toString();
    }
}