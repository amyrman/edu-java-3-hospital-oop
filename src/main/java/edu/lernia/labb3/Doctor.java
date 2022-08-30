package edu.lernia.labb3;

class Doctor {
    private String name;

    Doctor(String name) {
        this.name = name;
    }

    public String testPatient(Patient patient) {
        if(patient.isSick()) {
            System.out.println("Dr. " + name + " tested patient " + patient.getName() + " positive for " + patient.getSickness() + ".");
            return patient.getSickness();
        } else {
            System.out.println("Dr. " + name + " tested patient " + patient.getName() + ", patient is healthy.");
            return null;
        }
    }

    public void treatPatient(Patient patient, Medicine medicine) {
        System.out.println("Dr. " + name + " treated patient " + patient.getName() + " for " + medicine.getTreatmentName() + ".");
        patient.takeMedication(medicine);
        if(patient.isSick()) {
            System.out.println(patient.getName() + " is still sick.");
        } else {
            System.out.println(patient.getName() + " is now healthy.");
        }
    }

    public Medicine fetchCorrectMedication(String sickness) {
        Medicine result = new Medicine(sickness);
        System.out.println("Dr. " + name + " fetched medication for " + result.getTreatmentName());
        return result;
    }
}
