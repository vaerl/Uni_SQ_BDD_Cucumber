import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class Steps {

    String vorname;
    String nachname;
    Set<Fachgebiet> fachgebiete;
    Exception exception;

    Mitarbeiter created;

    // Mitarbeiter-Attribute
    @Given("a name {string}")
    public void a_name(String string) {
        this.vorname = string;
    }

    @Given("an invalid surname {string}")
    public void an_invalid_surname(String string) {
        this.vorname = string;
    }

    @Given("a valid amount of fachgebiete {string}")
    public void a_valid_amount_of_fachgebiete(String string) {
        this.fachgebiete = getSet(string);
    }

    @Given("a valid surname {string}")
    public void a_valid_surname(String string) {
        this.nachname = string;
    }

    @Given("more than three fachgebiete {string}")
    public void more_than_three_fachgebiete(String string) {
        this.fachgebiete = getSet(string);
    }

    @Given("zero fachgebiete")
    public void zero_fachgebiete() {
        this.fachgebiete = new HashSet<>();
    }

    @Then("its name should be {string}")
    public void its_name_should_be(String string) {
        assertEquals(created.vorname, string);
    }

    @Then("its surname should be {string}")
    public void its_surname_should_be(String string) {
        assertEquals(created.nachname, string);
    }

    @Then("its fachgebiete should be {string}")
    public void its_fachgebiete_should_be(String string) {
        Set<Fachgebiet> input = getSet(string);
        assertEquals(created.fachgebiete.size(), input.size());
        for (Fachgebiet fachgebiet : created.fachgebiete) {
            assertTrue(input.contains(fachgebiet));
        }
    }

    // Verwaltungs-Schritte
    @Then("the verwaltung should throw an error")
    public void the_verwaltung_should_throw_an_error() {
        assertNotNull(exception);
    }

    @Then("the verwaltung should create a new Mitarbeiter")
    public void the_verwaltung_should_create_a_new_mitarbeiter() {
        try{
            this.created = Verwaltung.createMitarbeiter(vorname, nachname, fachgebiete);
        } catch (Exception exception){
            this.exception = exception;
        }
    }

    @Then("the verwaltung should serialize the mitarbeiter")
    public void the_verwaltung_should_serialize_the_mitarbeiter() {
        try {
            Verwaltung.serialize(created);
        } catch (Exception exception) {
            this.exception = exception;
        }
    }

    @Then("the verwaltung should deserialize the Mitarbeiter")
    public void the_verwaltung_should_deserialize_the_mitarbeiter() {
        try {
            Verwaltung.deserialize(created.getId());
        } catch (Exception exception) {
            this.exception = exception;
        }
    }

    // Tester-Schritte
    @Then("the tester should invalidate the surname")
    public void the_tester_should_invalidate_the_surname() {
        this.created = Tester.invalidateSurname(created);
    }

    @Then("the tester should remove all fachgebiete")
    public void the_tester_should_remove_all_fachgebiete() {
        this.created = Tester.removeAllFachgebiete(created);
    }

    @Then("the tester sould remove all previous files")
    public void theTesterSouldRemoveAllPreviousFiles() {
        Tester.clearExistingFiles();
    }

    // Helper-Methods
    public Set<Fachgebiet> getSet(String string){
        HashSet<Fachgebiet>  res = new HashSet<>();
        for (String s: string.split(",")){
            res.add(Fachgebiet.valueOf(s.toUpperCase().trim()));
        }
        return res;
    }


}
