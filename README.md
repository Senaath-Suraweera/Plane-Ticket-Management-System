# ✈️ Plane Management Application

A Java-based console application for managing seat reservations, cancellations, ticket generation, and tracking on a small aircraft. Developed using object-oriented principles.

---

## 📋 Features

- View seating plan with availability (O = Available, X = Booked)
- Book a seat by selecting row and seat number
- Cancel an existing seat reservation
- Automatically generate a unique ticket ID and collect passenger details
- Find the first available seat
- Search for a ticket by seat
- Print ticket details with passenger information
- Total of 52 seats across 4 rows (A–D)

---

## 🧾 Seat Configuration

| Row | Seats |
|-----|-------|
| A   | 14    |
| B   | 12    |
| C   | 12    |
| D   | 14    |

---

## 🧑‍💻 Classes Overview

- `PlaneManagement.java` – Main driver class with menu handling.
- `Functions.java` – Contains logic for booking, cancellation, searching, and ticket generation.
- `Seats.java` – Maintains the seating arrangement and seat status.
- `Ticket.java` – Data model for a passenger ticket.
- `Person.java` – Represents a passenger’s personal information.

---

## 🚀 How to Run

### 1. Clone the repository or copy the source files into a folder.

```bash 
git clone https://github.com/your-username/plane-management-app.git
```

### 2. Compile all `.java` files
Make sure all five Java files are in the same directory:
```bash
javac *.java
```

### 3.Run the application
```bash 
java PlaneManagement
```


## Author

- [@Senaath-Suraweera](https://www.github.com/Senaath-Suraweera)