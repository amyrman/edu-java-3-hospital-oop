package edu.lernia.labb3;

public class Patient {
    private final String name;
    private String diagnosis;

// Two constructors
// Four member methods
// Code can only be changed in this class
// Has to output according to assignment log

// constructors
    Patient(String name) {
        this.name = name;
    }

    Patient(String name, String diagnosis) {
        this.name = name;
        this.diagnosis = diagnosis;
    }

// member methods
    boolean isSick() {
        return diagnosis != null;
    }

    void takeMedication(Medicine medicine) {
        if(medicine.getTreatmentName() == diagnosis) {
            diagnosis = null;
        }
    }
    
// getters and setters
    String getName() {
        return name;
    }
    
    String getSickness() {
        return diagnosis;
    }

}