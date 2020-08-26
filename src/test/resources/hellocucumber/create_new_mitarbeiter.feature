Feature: Create new Mitarbeiter


  Scenario Outline: Mitarbeiter-Name is too short
    Given a name "<vorname>"
    And an invalid surname "<nachname>"
    And a valid amount of fachgebiete "<fachgebiete>"
    Then the verwaltung should create a new Mitarbeiter
    And the verwaltung should throw an error

    Examples:
      | vorname | nachname | fachgebiete |
      | John | N | C |
      | Enrico | F | JAVA |
      | Isaac | N | DESIGN, CSHARP |

  Scenario Outline: Mitarbeiter has more than three Fachgebiete
    Given a name "<vorname>"
    And a valid surname "<nachname>"
    And more than three fachgebiete "<fachgebiete>"
    Then the verwaltung should create a new Mitarbeiter
    And the verwaltung should throw an error

    Examples:
      | vorname | nachname | fachgebiete |
      | John | Neumann | C, DESIGN, CSHARP, R |
      | Enrico | Fermi | C, JAVA, DESIGN, PYTHON |
      | Isaac | Newton | DESIGN, C, CPLUSPLUS, RUBY |

  Scenario Outline: Mitarbeiter has no Fachgebiete
    Given a name "<vorname>"
    And a valid surname "<nachname>"
    And zero fachgebiete
    Then the verwaltung should create a new Mitarbeiter
    And the verwaltung should throw an error

    Examples:
      | vorname | nachname |
      | John | Neumann |
      | Enrico | Fermi |
      | Isaac | Newton |

  Scenario Outline: Mitarbeiter-Name is allowed and Mitarbeiter-Fachgebiete <= 3 and >=1
    Given a name "<vorname>"
    And a valid surname "<nachname>"
    And a valid amount of fachgebiete "<fachgebiete>"
    Then the verwaltung should create a new Mitarbeiter
    And its name should be "<vorname>"
    And its surname should be "<nachname>"
    And its fachgebiete should be "<fachgebiete>"

    Examples:
      | vorname | nachname | fachgebiete |
      | John | Neumann | JAVA |
      | Enrico | Fermi | C, JAVA |
      | Isaac | Newton | DESIGN, C |
