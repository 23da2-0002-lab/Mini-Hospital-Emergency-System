package hospital;

public class PatientBST {

    private PatientNode root;

    // Insert patient
    public boolean insert(Patient patient) {

        if (root == null) {
            root = new PatientNode(patient);
            return true;
        }

        return insertRecursive(root, patient);
    }

    private boolean insertRecursive(PatientNode current, Patient patient) {

        if (patient.getPatientId() < current.patient.getPatientId()) {

            if (current.left == null) {
                current.left = new PatientNode(patient);
                return true;
            }

            return insertRecursive(current.left, patient);

        } else if (patient.getPatientId() > current.patient.getPatientId()) {

            if (current.right == null) {
                current.right = new PatientNode(patient);
                return true;
            }

            return insertRecursive(current.right, patient);

        } else {

            return false;
        }
    }

    // Search patient
    public Patient search(int patientId) {

        PatientNode current = root;

        while (current != null) {

            if (patientId == current.patient.getPatientId()) {
                return current.patient;
            }

            if (patientId < current.patient.getPatientId()) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        return null;
    }

    // In-order traversal
    public void inOrder() {

        if (root == null) {
            System.out.println("No patients found.");
            return;
        }

        inOrderRecursive(root);
    }

    private void inOrderRecursive(PatientNode current) {

        if (current != null) {

            inOrderRecursive(current.left);

            current.patient.displayPatient();
            System.out.println("-------------------------");

            inOrderRecursive(current.right);
        }
    }

    // Delete patient
    public boolean delete(int patientId) {

        if (search(patientId) == null) {
            return false;
        }

        root = deleteRecursive(root, patientId);
        return true;
    }

    private PatientNode deleteRecursive(PatientNode current, int patientId) {

        if (patientId < current.patient.getPatientId()) {

            current.left = deleteRecursive(current.left, patientId);

        } else if (patientId > current.patient.getPatientId()) {

            current.right = deleteRecursive(current.right, patientId);

        } else {

            // Case 1: No child
            if (current.left == null && current.right == null) {
                return null;
            }

            // Case 2: Only right child
            if (current.left == null) {
                return current.right;
            }

            // Case 3: Only left child
            if (current.right == null) {
                return current.left;
            }

            // Case 4: Two children
            PatientNode successor = findMin(current.right);

            current.patient = successor.patient;

            current.right = deleteRecursive(
                    current.right,
                    successor.patient.getPatientId()
            );
        }

        return current;
    }

    private PatientNode findMin(PatientNode current) {

        while (current.left != null) {
            current = current.left;
        }

        return current;
    }
}