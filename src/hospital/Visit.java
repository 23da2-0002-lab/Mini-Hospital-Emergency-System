package hospital;

public class Visit {

    private int visitId;
    private int patientId;
    private String visitDate;
    private String doctorName;
    private String diagnosis;
    private String treatment;

    public Visit(int visitId, int patientId, String visitDate,
                 String doctorName, String diagnosis, String treatment) {

        this.visitId = visitId;
        this.patientId = patientId;
        this.visitDate = visitDate;
        this.doctorName = doctorName;
        this.diagnosis = diagnosis;
        this.treatment = treatment;
    }

    public int getVisitId() {
        return visitId;
    }

    public int getPatientId() {
        return patientId;
    }

    public String getVisitDate() {
        return visitDate;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public String getTreatment() {
        return treatment;
    }

    public void displayVisit() {

        System.out.println("Visit ID       : " + visitId);
        System.out.println("Patient ID     : " + patientId);
        System.out.println("Visit Date     : " + visitDate);
        System.out.println("Doctor Name    : " + doctorName);
        System.out.println("Diagnosis      : " + diagnosis);
        System.out.println("Treatment      : " + treatment);
    }
}