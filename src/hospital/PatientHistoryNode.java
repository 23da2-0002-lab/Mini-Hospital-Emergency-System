package hospital;

public class PatientHistoryNode {

    PatientHistory history;
    PatientHistoryNode next;

    public PatientHistoryNode(PatientHistory history) {

        this.history = history;
        this.next = null;
    }
}


