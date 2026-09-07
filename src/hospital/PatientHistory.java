package hospital;

public class PatientHistory {

    private int patientId;
    private VisitNode head;

    public PatientHistory(int patientId) {
        this.patientId = patientId;
        this.head = null;
    }

    public int getPatientId() {
        return patientId;
    }

    // Add visit to this patient's linked list
    public boolean addVisit(Visit visit) {

        VisitNode current = head;

        // Check for duplicate Visit ID
        while (current != null) {

            if (current.visit.getVisitId() == visit.getVisitId()) {

                System.out.println("Visit ID already exists for this patient.");
                return false;
            }

            current = current.next;
        }

        VisitNode newNode = new VisitNode(visit);

        if (head == null) {

            head = newNode;

        } else {

            current = head;

            while (current.next != null) {
                current = current.next;
            }

            current.next = newNode;
        }

        return true;
    }

    // Search visit in this patient's linked list
    public Visit searchVisit(int visitId) {

        VisitNode current = head;

        while (current != null) {

            if (current.visit.getVisitId() == visitId) {
                return current.visit;
            }

            current = current.next;
        }

        return null;
    }

    // Remove visit from this patient's linked list
    public boolean removeVisit(int visitId) {

        if (head == null) {
            return false;
        }

        // Remove first visit
        if (head.visit.getVisitId() == visitId) {

            head = head.next;
            return true;
        }

        VisitNode current = head;

        while (current.next != null) {

            if (current.next.visit.getVisitId() == visitId) {

                current.next = current.next.next;
                return true;
            }

            current = current.next;
        }

        return false;
    }

    // Display this patient's visit history
    public void displayHistory() {

        if (head == null) {

            System.out.println(
                "No visit history found for Patient ID: " + patientId
            );

            return;
        }

        VisitNode current = head;

        while (current != null) {

            current.visit.displayVisit();
            System.out.println("-------------------------");

            current = current.next;
        }
    }
}
