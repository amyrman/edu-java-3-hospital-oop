package edu.lernia.labb3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PatientTest {

    @Test
    void createSickPatient() {
        /* Provided a name and a disease, make sure both are stored in the class */

        // Create a patient
        String name = "Tommy Test";
        String sickness = "Slime Disease";
        Patient p = new Patient(name, sickness);

        // Make sure name and sickness matches
        assertEquals(name, p.getName(), "Name isn't stored correctly");
        assertEquals(sickness, p.getSickness(), "Sickness isn't stored correctly");
    }

    @Test
    void createHealthyPatient() {
        /* Provided only a name, make sure it's stored in the class */

        // Create a patient, without a sickness
        String name = "Tommy Test";
        Patient p = new Patient(name);

        // Make sure name matches, and sickness is null
        assertEquals(name, p.getName(), "Name isn't stored correctly");
        assertNull(p.getSickness(), "Sickness is not null");
    }

    @Test
    void createNullDiseasePatient() {
        /* Make sure we can send in null as a sickness */

        // Create a patient
        String name = "Tommy Test";
        Patient p = new Patient(name, null);

        // Make sure name matches, and sickness is null
        assertEquals(name, p.getName(), "Name isn't stored correctly");
        assertNull(p.getSickness(), "Sickness is not null");
    }

    @Test
    void sickPatientGetsCured() {
        /* If we give a sick patient the right medicine, he/she should be cured */

        // Create a patient
        String name = "Tommy Test";
        String sickness = "Slime Disease";
        Patient p = new Patient(name, sickness);

        // Make sure patient is sick, and the sickness string is stored
        assertTrue(p.isSick(), "Patient should be sick, but isn't");
        assertEquals(sickness, p.getSickness(), "Sickness doesn't match");

        // Create a medicine and make patient take it
        p.takeMedication(new Medicine(sickness));

        // Make sure patient is now cured
        assertFalse(p.isSick(), "Patient should be healthy, but isn't");
        assertNull(p.getSickness(), "Sickness is not null");
    }

    @Test
    void takeWrongMedicationDoesNothing() {
        /* If we give a patient the wrong medication, he/she should still be sick */

        // Create a patient
        String name = "Tommy Test";
        String sickness = "Slime Disease";
        Patient p = new Patient(name, sickness);

        // Make sure patient is sick, and the sickness string is stored
        assertTrue(p.isSick(), "Patient should be sick, but isn't");
        assertEquals(sickness, p.getSickness(), "Sickness doesn't match");

        // Create a medicine and make patient take it
        p.takeMedication(new Medicine("placebo")); // Wrong medication!

        // Make sure patient is still sick
        assertTrue(p.isSick(), "Patient should still be sick, but was cured");
        assertEquals(sickness, p.getSickness(), "Patient sickness was changed");
    }

}