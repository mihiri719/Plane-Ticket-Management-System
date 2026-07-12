# ✈️ Plane Ticket Management System

> A console-based airline ticket booking system built in Java using core OOP principles and file handling — no database required.

## 📖 Project Description

This is a Java console application that simulates an airline ticket booking system. It allows flights to be managed and tickets to be booked, without relying on any external database — all data is stored in memory using `ArrayList`, with bookings additionally persisted to a local text file.

## ✨ Features

- ➕ Add new flights
- 📋 View all available flights
- 🔍 Search flights by destination
- ❌ Delete a flight
- 🎟️ Book a ticket with passenger name and seat number
- 🚫 Duplicate seat booking prevention
- 📄 View all bookings
- 🖨️ Generate and print a formatted ticket
- 💾 Bookings automatically saved to `bookings.txt`

## 🛠️ Tech Stack

![Java](https://img.shields.io/badge/-Java-007396?style=flat&logo=java&logoColor=white)

- Core Java (OOP: inheritance, encapsulation)
- `ArrayList` for in-memory data storage
- `FileWriter` for persisting bookings to file
- `Scanner` for console input

## 🏗️ Project Structure
com.airline
├── Main.java        # Menu-driven entry point
├── Flight.java       # Flight details (ID, number, source, destination, price)
├── Booking.java       # Booking details linking passenger to a flight & seat
├── Ticket.java        # Generates and prints a formatted ticket
├── Seat.java          # Seat reservation status
├── User.java           # Base class with login credentials
├── Admin.java          # Extends User — admin menu (flight management)
└── Customer.java       # Extends User — customer menu (booking management)

## 🚀 How to Run

```bash
git clone https://github.com/mihiri719/Plane-Ticket-Management-System.git
cd Plane-Ticket-Management-System
javac com/airline/*.java
java com.airline.Main
```

## 📌 Note

`User`, `Admin`, and `Customer` classes are included as a foundation for role-based login (admin vs. customer menus), but are not yet wired into `Main.java`'s flow — a planned next step is to add a login screen that routes to the appropriate menu based on user type.

## 🔮 Future Improvements

- [ ] Integrate `Admin`/`Customer` login into the main menu
- [ ] Add ticket cancellation
- [ ] Add seat availability check using the `Seat` class
- [ ] Replace file storage with a real database (MySQL/SQLite)
