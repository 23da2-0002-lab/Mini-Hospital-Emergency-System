package hospital;

public class TreatmentStack {

    private TreatmentNode top;

    // Push - Add treatment to stack
    public void push(Treatment treatment) {

        TreatmentNode newNode = new TreatmentNode(treatment);

        newNode.next = top;
        top = newNode;

        System.out.println("Treatment added to history.");
    }

    // Pop - Remove most recent treatment
    public Treatment pop() {

        if (top == null) {
            System.out.println("Stack is empty.");
            return null;
        }

        Treatment treatment = top.treatment;
        top = top.next;

        return treatment;
    }

    // Display all treatment records
    public void displayStack() {

        if (top == null) {
            System.out.println("Stack is empty.");
            return;
        }

        TreatmentNode current = top;

        System.out.println("TREATMENT HISTORY");
        System.out.println("========================");

        while (current != null) {

            current.treatment.displayTreatment();
            System.out.println("-------------------------");

            current = current.next;
        }
    }
}