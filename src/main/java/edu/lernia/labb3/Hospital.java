package edu.lernia.labb3;

public class Hospital {
    private Doctor[] doctors;
    private Patient[] patients;

    private Hospital() {
        initaiteDoctors();
        initaitePatients();
        treatPatients();
    }

    private void initaiteDoctors() {
        doctors = new Doctor[2];
        doctors[0] = new Doctor("Anna");
        doctors[1] = new Doctor("Bertil");
    }

    private void initaitePatients() {
        patients = new Patient[10];
        patients[0] = new Patient("Ali", "Atopiska vinterfötter");
        patients[1] = new Patient("Betty", "Blodförgiftning");
        patients[2] = new Patient("Cecilia", null);
        patients[3] = new Patient("Dennis", "Diskbråck");
        patients[4] = new Patient("Eschwar", "Epikondylit");
        patients[5] = new Patient("Fadel", "Förkylning");
        patients[6] = new Patient("Gunnar", "Gallsten");
        patients[7] = new Patient("Helena");
        patients[8] = new Patient("Isabel", "Insomni");
        patients[9] = new Patient("Jinghua", "Järnbrist");
    }

    private void testAllPatients(Doctor doctor) {
        for(Patient p: patients) {
            doctor.testPatient(p);
        }
    }

    private void treatPatients() {
        testAllPatients(doctors[0]);
        doctors[1].treatPatient(patients[0], doctors[0].fetchCorrectMedication("Atopiska vinterfötter"));
        doctors[0].treatPatient(patients[1], doctors[1].fetchCorrectMedication("Atopiska vinterfötter"));
        doctors[1].treatPatient(patients[4], doctors[0].fetchCorrectMedication("Epikondylit"));
        doctors[0].treatPatient(patients[5], doctors[1].fetchCorrectMedication("Förkylning"));
        doctors[1].treatPatient(patients[7], doctors[0].fetchCorrectMedication("Gallsten"));
        doctors[0].treatPatient(patients[7], doctors[1].fetchCorrectMedication("Halsfluss"));
        doctors[1].treatPatient(patients[9], doctors[0].fetchCorrectMedication("Järnbrist"));
        testAllPatients(doctors[1]);
        doctors[1].treatPatient(patients[1], doctors[0].fetchCorrectMedication("Blodförgiftning"));
        doctors[0].treatPatient(patients[3], doctors[1].fetchCorrectMedication("Diskbråck"));
        doctors[1].treatPatient(patients[6], doctors[0].fetchCorrectMedication("Gallsten"));
        doctors[0].treatPatient(patients[8], doctors[1].fetchCorrectMedication("Insomni"));
        testAllPatients(doctors[0]);
    }

    public static void main(String[] args) {
        new Hospital();
    }
}
