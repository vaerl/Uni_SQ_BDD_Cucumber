import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Mitarbeiter m = new Mitarbeiter("Uwe", "Mey");
        m.addFachgebiet(Fachgebiet.ANALYSE);
        m.addFachgebiet(Fachgebiet.C);
        System.out.println("Before serialization:");
        System.out.println(m);
        Verwaltung.serialize(m);

        System.out.println("After serialization:");
        System.out.println(Verwaltung.deserialize(m.getId()));
    }
}
