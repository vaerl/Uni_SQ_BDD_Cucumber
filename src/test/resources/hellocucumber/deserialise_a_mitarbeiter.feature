Feature: Deserialise a Mitarbeiter


  Scenario Outline: DES: valid Mitarbeiter exists
    Given a name "<vorname>"
    And a valid surname "<nachname>"
    And a valid amount of fachgebiete "<fachgebiete>"
    Then the verwaltung should create a new Mitarbeiter
    And its name should be "<vorname>"
    And its surname should be "<nachname>"
    And its fachgebiete should be "<fachgebiete>"
    Then the verwaltung should serialize the mitarbeiter
    Then the verwaltung should deserialize the Mitarbeiter
    And its name should be "<vorname>"
    And its surname should be "<nachname>"
    And its fachgebiete should be "<fachgebiete>"

    Examples:
      | vorname | nachname | fachgebiete |
      | John | Neumann | C, JAVA |
      | Enrico | Fermi | C |
      | Isaac | Newton | JAVA |

  Scenario Outline: DES: Mitarbeiter does not exist
    Given a name "<vorname>"
    And a valid surname "<nachname>"
    And a valid amount of fachgebiete "<fachgebiete>"
    Then the verwaltung should create a new Mitarbeiter
    And its name should be "<vorname>"
    And its surname should be "<nachname>"
    And its fachgebiete should be "<fachgebiete>"
    Then the tester sould remove all previous files
    Then the verwaltung should deserialize the Mitarbeiter
    And the verwaltung should throw an error

    Examples:
      | vorname | nachname | fachgebiete |
      | John | Neumann | C, JAVA |
      | Enrico | Fermi | C |
      | Isaac | Newton | JAVA |

  Scenario Outline: DES: Mitarbeiter an has invalid surname
    Given a name "<vorname>"
    And a valid surname "<nachname>"
    And a valid amount of fachgebiete "<fachgebiete>"
    Then the verwaltung should create a new Mitarbeiter
    And its name should be "<vorname>"
    And its surname should be "<nachname>"
    And its fachgebiete should be "<fachgebiete>"
    Then the tester should invalidate the surname
    Then the verwaltung should serialize the mitarbeiter
    Then the verwaltung should deserialize the Mitarbeiter
    And the verwaltung should throw an error

    Examples:
      | vorname | nachname | fachgebiete |
      | John | Neumann | C, JAVA |
      | Enrico | Fermi | C |
      | Isaac | Newton | JAVA |

  Scenario Outline: DES: Mitarbeiter has no fachgebiete
    Given a name "<vorname>"
    And a valid surname "<nachname>"
    And a valid amount of fachgebiete "<fachgebiete>"
    Then the verwaltung should create a new Mitarbeiter
    And its name should be "<vorname>"
    And its surname should be "<nachname>"
    And its fachgebiete should be "<fachgebiete>"
    Then the tester should remove all fachgebiete
    Then the verwaltung should serialize the mitarbeiter
    Then the verwaltung should deserialize the Mitarbeiter
    And the verwaltung should throw an error

    Examples:
      | vorname | nachname | fachgebiete |
      | John | Neumann | C, JAVA |
      | Enrico | Fermi | C |
      | Isaac | Newton | JAVA |

  Scenario Outline: DES: Mitarbeiter has too many fachgebiete
    Given a name "<vorname>"
    And a valid surname "<nachname>"
    And a valid amount of fachgebiete "<fachgebiete>"
    Then the verwaltung should create a new Mitarbeiter
    And its name should be "<vorname>"
    And its surname should be "<nachname>"
    And its fachgebiete should be "<fachgebiete>"
    Then the tester should invalidate the surname
    Then the verwaltung should serialize the mitarbeiter
    Then the verwaltung should deserialize the Mitarbeiter
    And the verwaltung should throw an error

    Examples:
      | vorname | nachname | fachgebiete |
      | John | Neumann | C, JAVA |
      | Enrico | Fermi | C |
      | Isaac | Newton | JAVA |
