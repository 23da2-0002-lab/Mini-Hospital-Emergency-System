package hospital;

public class TreatmentNode {

    Treatment treatment;
    TreatmentNode next;

    public TreatmentNode(Treatment treatment) {
        this.treatment = treatment;
        this.next = null;
    }
}
