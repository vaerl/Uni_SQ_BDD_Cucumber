Feature: Serialise a Mitarbeiter


  Scenario Outline: SE: Mitarbeiter does not exist
    Given a name "<vorname>"
    And a valid surname "<nachname>"
    And a valid amount of fachgebiete "<fachgebiete>"
    Then the verwaltung should create a new Mitarbeiter
    And its name should be "<vorname>"
    And its surname should be "<nachname>"
    And its fachgebiete should be "<fachgebiete>"
    Then the tester sould remove all previous files
    Then the verwaltung should serialize the mitarbeiter

    Examples:
      | vorname | nachname | fachgebiete |
      | John | Neumann | C, JAVA |
      | Enrico | Fermi | C |
      | Isaac | Newton | JAVA |

  Scenario Outline: SE: Mitarbeiter exists
    Given a name "<vorname>"
    And a valid surname "<nachname>"
    And a valid amount of fachgebiete "<fachgebiete>"
    Then the verwaltung should create a new Mitarbeiter
    And its name should be "<vorname>"
    And its surname should be "<nachname>"
    And its fachgebiete should be "<fachgebiete>"
    Then the verwaltung should serialize the mitarbeiter
    And the verwaltung should throw an error

    Examples:
      | vorname | nachname | fachgebiete |
      | John | Neumann | C, JAVA |
      | Enrico | Fermi | C |
      | Isaac | Newton | JAVA |
