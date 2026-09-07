package hospital;

public class PatientVisitHistory {

    private PatientHistoryNode head;

    // Find a patient's history
    private PatientHistory findPatientHistory(int patientId) {

        PatientHistoryNode current = head;

        while (current != null) {

            if (current.history.getPatientId() == patientId) {
                return current.history;
            }

            current = current.next;
        }

        return null;
    }

    // Add a new visit to the patient's history
    public void addVisit(Visit visit) {

        PatientHistory history =
                findPatientHistory(visit.getPatientId());

        if (history == null) {

            history = new PatientHistory(visit.getPatientId());

            PatientHistoryNode newNode =
                    new PatientHistoryNode(history);

            newNode.next = head;
            head = newNode;
        }

        history.addVisit(visit);

        System.out.println("Visit added successfully.");
    }

    // Search a visit for a specific patient
    public Visit searchVisit(int patientId, int visitId) {

        PatientHistory history =
                findPatientHistory(patientId);

        if (history == null) {
            return null;
        }

        return history.searchVisit(visitId);
    }

    // Remove a visit from a specific patient's history
    public void removeVisit(int patientId, int visitId) {

        PatientHistory history =
                findPatientHistory(patientId);

        if (history == null) {

            System.out.println("Visit not found.");
            return;
        }

        boolean removed = history.removeVisit(visitId);

        if (removed) {
            System.out.println("Visit removed successfully.");
        } else {
            System.out.println("Visit not found.");
        }
    }

    // Display a specific patient's visit history
    public void displayPatientHistory(int patientId) {

        PatientHistory history =
                findPatientHistory(patientId);

        System.out.println("PATIENT VISIT HISTORY");
        System.out.println("========================");

        if (history == null) {

            System.out.println(
                "No visit history found for Patient ID: " + patientId
            );

            return;
        }

        history.displayHistory();
    }

    // Display all patients' visit histories
    public void displayHistory() {

        if (head == null) {

            System.out.println("Visit history is empty.");
            return;
        }

        PatientHistoryNode current = head;

        System.out.println("ALL PATIENT VISIT HISTORIES");
        System.out.println("========================");

        while (current != null) {

            System.out.println(
                "Patient ID: " + current.history.getPatientId()
            );

            System.out.println("-------------------------");

            current.history.displayHistory();

            current = current.next;
        }
    }
}
