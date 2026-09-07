package hospital;

public class EmergencyQueue {

    private QueueNode front;
    private QueueNode rear;

    // Enqueue - Add patient to the queue
    public void enqueue(Patient patient) {

        QueueNode newNode = new QueueNode(patient);

        if (rear == null) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }

        System.out.println("Patient added to emergency queue.");
    }

    // Dequeue - Remove patient from the queue
    public Patient dequeue() {

        if (front == null) {
            System.out.println("Queue is empty.");
            return null;
        }

        Patient patient = front.patient;

        front = front.next;

        if (front == null) {
            rear = null;
        }

        return patient;
    }

    // Display all waiting patients
    public void displayQueue() {

        if (front == null) {
            System.out.println("Queue is empty.");
            return;
        }

        QueueNode current = front;

        System.out.println("EMERGENCY WAITING QUEUE");
        System.out.println("========================");

        while (current != null) {

            current.patient.displayPatient();
            System.out.println("-------------------------");

            current = current.next;
        }
    }
}