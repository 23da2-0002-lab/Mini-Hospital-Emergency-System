# Mini Hospital Emergency Management System

## Project Description

This project is a Java-based Mini Hospital Emergency Management System developed using basic data structures.

The system helps manage patient records, emergency patients, treatment history, and previous patient visits.

## Data Structures Used

### 1. Binary Search Tree (BST)
The Binary Search Tree is used to store patient records using Patient ID as the key.

Operations:
- Add patient
- Search patient
- Delete patient
- Display patients in ascending order

### 2. Queue
A Queue is used to manage emergency patients.

Operations:
- Add emergency patient
- Treat next emergency patient
- Display waiting patients
- FIFO (First In, First Out)

### 3. Stack
A Stack is used to store completed treatment records.

Operations:
- Add treatment
- Remove latest treatment
- Display treatment history
- LIFO (Last In, First Out)

### 4. Singly Linked List
A separate Singly Linked List is maintained for each patient's previous hospital visits.

Operations:
- Add visit
- Search visit
- Remove visit
- Display patient visit history

## Patient Information

Each patient record contains:

- Patient ID
- Patient Name
- Age
- Contact Number
- Medical Condition

## Treatment Information

Each treatment record contains:

- Treatment ID
- Patient ID
- Treatment Date
- Doctor Name
- Treatment Details

## Visit Information

Each visit record contains:

- Visit ID
- Patient ID
- Visit Date
- Doctor Name
- Diagnosis
- Treatment

## Technologies Used

- Java
- Eclipse IDE
- Git
- GitHub

## Project Structure

```text
MiniHospitalEmergencySystem
│
├── src
│   └── hospital
│       ├── Patient.java
│       ├── PatientNode.java
│       ├── PatientBST.java
│       ├── QueueNode.java
│       ├── EmergencyQueue.java
│       ├── Treatment.java
│       ├── TreatmentNode.java
│       ├── TreatmentStack.java
│       ├── Visit.java
│       ├── VisitNode.java
│       ├── PatientHistory.java
│       ├── PatientHistoryNode.java
│       ├── PatientVisitHistory.java
│       └── HospitalSystem.java
│
└── README.md