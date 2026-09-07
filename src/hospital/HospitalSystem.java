package hospital;

import java.util.Scanner;

public class HospitalSystem {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        PatientBST patientBST = new PatientBST();
        EmergencyQueue emergencyQueue = new EmergencyQueue();
        TreatmentStack treatmentStack = new TreatmentStack();
        PatientVisitHistory visitHistory = new PatientVisitHistory();

        boolean running = true;

        while (running) {

            System.out.println();
            System.out.println("========================================");
            System.out.println("      MINI HOSPITAL EMERGENCY SYSTEM");
            System.out.println("========================================");
            System.out.println("1. Add Patient");
            System.out.println("2. Search Patient");
            System.out.println("3. Delete Patient");
            System.out.println("4. Display All Patients");
            System.out.println("----------------------------------------");
            System.out.println("5. Add Emergency Patient");
            System.out.println("6. Treat Next Emergency Patient");
            System.out.println("7. Display Emergency Queue");
            System.out.println("----------------------------------------");
            System.out.println("8. Add Treatment");
            System.out.println("9. Remove Latest Treatment");
            System.out.println("10. Display Treatment History");
            System.out.println("----------------------------------------");
            System.out.println("11. Add Patient Visit");
            System.out.println("12. Search Patient Visit");
            System.out.println("13. Remove Patient Visit");
            System.out.println("14. Display Patient Visit History");
            System.out.println("----------------------------------------");
            System.out.println("15. Exit");
            System.out.println("========================================");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:

                    System.out.println();
                    System.out.println("ADD NEW PATIENT");
                    System.out.println("========================");

                    System.out.print("Enter Patient ID: ");
                    int patientId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Patient Name: ");
                    String patientName = scanner.nextLine();

                    System.out.print("Enter Age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Contact Number: ");
                    String contactNumber = scanner.nextLine();

                    System.out.print("Enter Medical Condition: ");
                    String medicalCondition = scanner.nextLine();

                    Patient patient = new Patient(
                            patientId,
                            patientName,
                            age,
                            contactNumber,
                            medicalCondition
                    );

                    boolean added = patientBST.insert(patient);

                    if (added) {
                        System.out.println("Patient added successfully.");
                    } else {
                        System.out.println(
                                "Patient ID already exists. Patient was not added."
                        );
                    }

                    break;

                case 2:

                    System.out.println();
                    System.out.println("SEARCH PATIENT");
                    System.out.println("========================");

                    System.out.print("Enter Patient ID: ");
                    int searchId = scanner.nextInt();

                    Patient foundPatient = patientBST.search(searchId);

                    if (foundPatient != null) {
                        foundPatient.displayPatient();
                    } else {
                        System.out.println("Patient not found.");
                    }

                    break;

                case 3:

                    System.out.println();
                    System.out.println("DELETE PATIENT");
                    System.out.println("========================");

                    System.out.print("Enter Patient ID: ");
                    int deleteId = scanner.nextInt();

                    boolean deleted = patientBST.delete(deleteId);

                    if (deleted) {
                        System.out.println("Patient deleted successfully.");
                    } else {
                        System.out.println("Patient not found.");
                    }

                    break;

                case 4:

                    System.out.println();
                    System.out.println("ALL PATIENTS");
                    System.out.println("========================");

                    patientBST.inOrder();

                    break;

                case 5:

                    System.out.println();
                    System.out.println("ADD EMERGENCY PATIENT");
                    System.out.println("========================");

                    System.out.print("Enter Patient ID: ");
                    int emergencyId = scanner.nextInt();

                    Patient emergencyPatient = patientBST.search(emergencyId);

                    if (emergencyPatient != null) {
                        emergencyQueue.enqueue(emergencyPatient);
                    } else {
                        System.out.println("Patient not found.");
                    }

                    break;

                case 6:

                    System.out.println();
                    System.out.println("TREAT NEXT EMERGENCY PATIENT");
                    System.out.println("========================");

                    Patient nextPatient = emergencyQueue.dequeue();

                    if (nextPatient != null) {
                        System.out.println("Patient sent for treatment:");
                        nextPatient.displayPatient();
                    }

                    break;

                case 7:

                    System.out.println();
                    emergencyQueue.displayQueue();

                    break;

                case 8:

                    System.out.println();
                    System.out.println("ADD TREATMENT");
                    System.out.println("========================");

                    System.out.print("Enter Treatment ID: ");
                    int treatmentId = scanner.nextInt();

                    System.out.print("Enter Patient ID: ");
                    int treatmentPatientId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Treatment Date: ");
                    String treatmentDate = scanner.nextLine();

                    System.out.print("Enter Doctor Name: ");
                    String doctorName = scanner.nextLine();

                    System.out.print("Enter Treatment Details: ");
                    String treatmentDetails = scanner.nextLine();

                    Treatment treatment = new Treatment(
                            treatmentId,
                            treatmentPatientId,
                            treatmentDate,
                            doctorName,
                            treatmentDetails
                    );

                    if (patientBST.search(treatmentPatientId) == null) {

                        System.out.println("Patient not found. Treatment was not added.");

                    } else {

                        treatmentStack.push(treatment);
                    }

                    break;

                case 9:

                    System.out.println();
                    System.out.println("REMOVE LATEST TREATMENT");
                    System.out.println("========================");

                    Treatment completedTreatment = treatmentStack.pop();

                    if (completedTreatment != null) {
                        System.out.println("Removed treatment:");
                        completedTreatment.displayTreatment();
                    }

                    break;

                case 10:

                    System.out.println();
                    treatmentStack.displayStack();

                    break;

                case 11:

                    System.out.println();
                    System.out.println("ADD PATIENT VISIT");
                    System.out.println("========================");

                    System.out.print("Enter Patient ID: ");
                    int visitPatientId = scanner.nextInt();

                    System.out.print("Enter Visit ID: ");
                    int visitId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Visit Date: ");
                    String visitDate = scanner.nextLine();

                    System.out.print("Enter Doctor Name: ");
                    String visitDoctor = scanner.nextLine();

                    System.out.print("Enter Diagnosis: ");
                    String diagnosis = scanner.nextLine();

                    System.out.print("Enter Treatment: ");
                    String visitTreatment = scanner.nextLine();

                    Visit visit = new Visit(
                            visitId,
                            visitPatientId,
                            visitDate,
                            visitDoctor,
                            diagnosis,
                            visitTreatment
                    );

                    visitHistory.addVisit(visit);

                    break;

                case 12:

                    System.out.println();
                    System.out.println("SEARCH PATIENT VISIT");
                    System.out.println("========================");

                    System.out.print("Enter Patient ID: ");
                    int searchPatientId = scanner.nextInt();

                    System.out.print("Enter Visit ID: ");
                    int searchVisitId = scanner.nextInt();

                    Visit foundVisit = visitHistory.searchVisit(
                            searchPatientId,
                            searchVisitId
                    );

                    if (foundVisit != null) {
                        foundVisit.displayVisit();
                    } else {
                        System.out.println("Visit not found.");
                    }

                    break;

                case 13:

                    System.out.println();
                    System.out.println("REMOVE PATIENT VISIT");
                    System.out.println("========================");

                    System.out.print("Enter Patient ID: ");
                    int removePatientId = scanner.nextInt();

                    System.out.print("Enter Visit ID: ");
                    int removeVisitId = scanner.nextInt();

                    visitHistory.removeVisit(
                            removePatientId,
                            removeVisitId
                    );

                    break;

                case 14:

                    System.out.println();
                    System.out.println("DISPLAY PATIENT VISIT HISTORY");
                    System.out.println("========================");

                    System.out.print("Enter Patient ID: ");
                    int historyPatientId = scanner.nextInt();

                    visitHistory.displayPatientHistory(historyPatientId);

                    break;

                case 15:

                    System.out.println();
                    System.out.println("Thank you for using the");
                    System.out.println("Mini Hospital Emergency System.");
                    System.out.println("System closed.");

                    running = false;

                    break;

                default:

                    System.out.println(
                            "Invalid choice. Please enter a number from 1 to 15."
                    );
            }
        }

        scanner.close();
    }
}