# Family Hangout App

## Description

Family Hangout App is a Java Swing application designed to help families organize and manage their events and hangouts.

Users can create events, view saved events, search for events, edit event information, and delete events.

Event information is saved so that users can access their events again after closing and reopening the application.

## Features

* Create a new family event
* View all events
* Search events by name
* Search events by location
* Search events by date
* Edit an existing event
* Delete an event
* Save events
* Load previously saved events
* Display error messages for invalid input

## Event Information

Each event contains:

* Event name
* Location
* Event date
* Number of family members

## Technologies Used

* Java
* Java Swing
* ArrayList
* File reading and writing
* ActionListener
* Exception handling

## Main Classes

### `Event.java`

Represents an individual family event.

It stores the event name, location, date, and number of family members.

### `EventManager.java`

Manages the events in the application.

It handles:

* Adding events
* Storing events in an `ArrayList`
* Searching for events
* Deleting events
* Saving events
* Loading events

### `CreateEvent.java`

Contains the graphical user interface (GUI) for the application.

The GUI uses Java Swing components including:

* `JFrame`
* `JPanel`
* `JButton`
* `JTextField`
* `JTextArea`
* `JMenuBar`
* `JMenu`
* `JMenuItem`
* `JDialog`
* `JOptionPane`

User actions are handled using `ActionListener`.

## How to Run

1. Clone or download the repository.
2. Open the project in a Java IDE such as IntelliJ IDEA.
3. Make sure Java is installed.
4. Run the main class.
5. Use the application to create and manage family events.

## Input Validation

The application checks user input before creating an event.

For example:

* Event name cannot be empty.
* Location cannot be empty.
* Date cannot be empty.
* Number of family members must be a valid number.
* Number of family members must be greater than zero.

If invalid information is entered, the application displays an error message using `JOptionPane`.

## Data Storage

Currently, event information is saved to a file so that events are not lost when the application closes.

When the application starts, it reads the saved data and loads the previous events.

Database support is planned for a future version of the application.

## Purpose

The purpose of the Family Hangout App is to practice Java programming concepts while building an application that helps families organize their events.

The project demonstrates object-oriented programming, GUI development, event handling, collections, file handling, and error handling.

## Author

**Amina Mohamed**
