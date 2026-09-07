package hospital;

public class Treatment {

    private int treatmentId;
    private int patientId;
    private String treatmentDate;
    private String doctorName;
    private String treatmentDetails;

    public Treatment(int treatmentId, int patientId,
                     String treatmentDate, String doctorName,
                     String treatmentDetails) {

        this.treatmentId = treatmentId;
        this.patientId = patientId;
        this.treatmentDate = treatmentDate;
        this.doctorName = doctorName;
        this.treatmentDetails = treatmentDetails;
    }

    public int getTreatmentId() {
        return treatmentId;
    }

    public int getPatientId() {
        return patientId;
    }

    public String getTreatmentDate() {
        return treatmentDate;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public String getTreatmentDetails() {
        return treatmentDetails;
    }

    public void displayTreatment() {

        System.out.println("Treatment ID      : " + treatmentId);
        System.out.println("Patient ID        : " + patientId);
        System.out.println("Treatment Date    : " + treatmentDate);
        System.out.println("Doctor Name       : " + doctorName);
        System.out.println("Treatment Details : " + treatmentDetails);
    }
}
