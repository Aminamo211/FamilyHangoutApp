import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.Locale;

public class CreateEvent extends JFrame implements ActionListener {
    JMenuBar menubar;
    JMenu Createmenu;
    JMenu Viewmenu;
    JMenu Searchmenu;
    JMenu Deletemenu;
    JMenu Exitmenu;
    JMenu Editmenu;


    JMenuItem searchNameItem;
    JMenuItem searchLocationItem;
    JMenuItem searchDateItem;

    JMenuItem viewEventsItem;


    JButton button;

    JTextField eventNameField;
    JTextField locationField;
    JTextField eventDateField;
    JTextField familyMemberField;


    EventManager eventManager;


    CreateEvent() {
        eventManager = new EventManager();

        eventManager.loadEvents();


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 600);
        this.setLayout(new FlowLayout());

        menubar = new JMenuBar();

        Createmenu = new JMenu("Create");
        Viewmenu = new JMenu("View");
        Searchmenu = new JMenu("Search");
        Deletemenu = new JMenu("Delete");
        Exitmenu = new JMenu("Exit");
        Editmenu = new JMenu("Edit");

        searchNameItem = new JMenuItem("Search Name");
        searchLocationItem = new JMenuItem("Search Location");
        searchDateItem = new JMenuItem("Search Date");

        viewEventsItem = new JMenuItem("View Events");


        searchNameItem.addActionListener(this);
        searchLocationItem.addActionListener(this);
        searchDateItem.addActionListener(this);

        viewEventsItem.addActionListener(this);

        Searchmenu.add(searchNameItem);
        Searchmenu.add(searchLocationItem);
        Searchmenu.add(searchDateItem);

        Viewmenu.add(viewEventsItem);


        menubar.add(Createmenu);
        menubar.add(Viewmenu);
        menubar.add(Searchmenu);
        menubar.add(Deletemenu);
        menubar.add(Editmenu);
        menubar.add(Exitmenu);

        eventNameField = new JTextField(15);
        eventNameField.setPreferredSize(new Dimension(200, 40));


        locationField = new JTextField(15);
        locationField.setPreferredSize(new Dimension(200, 40));

        eventDateField = new JTextField(15);
        eventDateField.setPreferredSize(new Dimension(200, 40));

        familyMemberField = new JTextField(15);
        familyMemberField.setPreferredSize(new Dimension(200, 40));

        addPlaceholder(eventNameField, "Event Name");
        addPlaceholder(locationField, "Location");
        addPlaceholder(eventDateField, "Date");
        addPlaceholder(familyMemberField, "Family Member");

        button = new JButton("Submit");
        button.addActionListener(this);
        this.setJMenuBar(menubar);


        this.add(eventNameField);
        this.add(locationField);
        this.add(eventDateField);
        this.add(familyMemberField);
        this.add(button);


        this.setVisible(true);


    }

    public void addPlaceholder(JTextField field, String placeholder) {
        field.setText(placeholder);
        field.setForeground(Color.GRAY);

        field.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (field.getText().equals(placeholder)) {
                    field.setText("");
                    field.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (field.getText().isEmpty()) {
                    field.setText(placeholder);
                    field.setForeground(Color.GRAY);
                }

            }
        });


    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            String eventName = eventNameField.getText();
            if (eventName.isEmpty() || eventName.equals("Event Name")) {
                JOptionPane.showMessageDialog(
                        this,
                        "Please enter an event name.",
                        "Error",
                        JOptionPane.PLAIN_MESSAGE
                );
                return;
            }

            String location = locationField.getText();
            if (location.isEmpty() || location.equals("Location")) {
                JOptionPane.showMessageDialog(
                        this,
                        "Please enter a location.",
                        "Error",
                        JOptionPane.PLAIN_MESSAGE
                );
                return;
            }

            String eventDate = eventDateField.getText();
            if (eventDate.isEmpty() || eventDate.equals("Date")) {
                JOptionPane.showMessageDialog(
                        this,
                        "Please enter a date.",
                        "Error",
                        JOptionPane.PLAIN_MESSAGE
                );
                return;
            }

            String familyMemberText = familyMemberField.getText();
            if (familyMemberText.isEmpty() || familyMemberText.equals("Family Member")) {
                JOptionPane.showMessageDialog(
                        this,
                        "Please enter the number of family member.",
                        "Error",
                        JOptionPane.PLAIN_MESSAGE
                );
                return;
            }

            try {
                int familyMemberNumber =
                        Integer.parseInt(familyMemberText);

                if (familyMemberNumber == 0) {
                    JOptionPane.showMessageDialog(
                            this,
                            "Number of family cannot be zero ",
                            "Error",
                            JOptionPane.PLAIN_MESSAGE
                    );
                    return;
                }
                if (familyMemberNumber < 0) {
                    JOptionPane.showMessageDialog(
                            this,
                            "Number of family cannot be negative",
                            "Error",
                            JOptionPane.PLAIN_MESSAGE
                    );
                    return;
                }


                // calls the constructor in Event.java
                Event event = new Event(
                        eventName,
                        location,
                        eventDate,
                        familyMemberNumber);
                //
                eventManager.addEvent(event);
                eventManager.saveEvents();


                System.out.println("Event saved");

            } catch (NumberFormatException error) {
                JOptionPane.showMessageDialog(
                        this,
                        "Please enter a valid number.",
                        "Error",
                        JOptionPane.PLAIN_MESSAGE

                );
            }
        }


            if (e.getSource() == searchNameItem) {
                String name = JOptionPane.showInputDialog(
                        this,
                        "Enter event name",
                        "Searach Name",
                        JOptionPane.PLAIN_MESSAGE
                );

                if (name != null && !name.isEmpty()) {
                    eventManager.searchName(name);

                }
            }


            if (e.getSource() == searchLocationItem) {
                String searchlocation = JOptionPane.showInputDialog(
                        this,
                        "Enter event location",
                        "Search Location",
                        JOptionPane.PLAIN_MESSAGE);

                if (searchlocation != null && !searchlocation.isEmpty()) {
                    eventManager.searchLocation(searchlocation);

                }
            }
            if (e.getSource() == searchDateItem) {
                String date = JOptionPane.showInputDialog(
                        this,
                        "Enter event date",
                        "Search Date",
                        JOptionPane.PLAIN_MESSAGE);

                if (date != null && !date.isEmpty()) {
                    eventManager.searchDate(date);
                    System.out.println(date.isEmpty());
                }
            }

            if (e.getSource() == viewEventsItem) {
                showEventsWindow();
            }

    }


            public void showEventsWindow () {
                JDialog eventWindow = new JDialog(this, "All Events", true);

                JPanel allEventsPanel = new JPanel();
                allEventsPanel.setLayout(new BoxLayout(allEventsPanel, BoxLayout.Y_AXIS));

                for (Event event : eventManager.getEvents()) {
                    JPanel oneEventPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

                    JTextArea eventInfo = new JTextArea(event.toString());
                    eventInfo.setEditable(false);

                    JButton editButton = new JButton("✏ Edit");
                    JButton deleteButton = new JButton("Delete");


                    editButton.addActionListener(new ActionListener() {


                        @Override
                        public void actionPerformed(ActionEvent e) {
                            int answer = JOptionPane.showConfirmDialog(
                                    eventWindow,
                                    "Do you want to edit this event?",
                                    "Edit event",
                                    JOptionPane.YES_NO_OPTION,
                                    JOptionPane.PLAIN_MESSAGE
                            );
                            if (answer == JOptionPane.YES_OPTION) {

                                JPanel editPanel = new JPanel(new GridLayout(4, 2));

                                JTextField editNameField = new JTextField(event.eventName);
                                JTextField editlocationField = new JTextField(event.location);
                                JTextField editEventDateField = new JTextField(event.eventDate);
                                JTextField editFamilyMemberField = new JTextField(
                                        String.valueOf(event.familyMemberNumber)
                                );
                                editPanel.add(new JLabel("Event name:"));
                                editPanel.add(editNameField);

                                editPanel.add(new JLabel("Location:"));
                                editPanel.add(editlocationField);

                                editPanel.add(new JLabel("Date:"));
                                editPanel.add(editEventDateField);

                                editPanel.add(new JLabel("Family Members:"));
                                editPanel.add(editFamilyMemberField);

                                int saveChoice = JOptionPane.showConfirmDialog(
                                        eventWindow,
                                        editPanel,
                                        "Edit Event",
                                        JOptionPane.OK_CANCEL_OPTION,
                                        JOptionPane.PLAIN_MESSAGE
                                );
                                if (saveChoice == JOptionPane.OK_OPTION) {
                                    event.eventName = editNameField.getText();
                                    event.location = editlocationField.getText();
                                    event.eventDate = editEventDateField.getText();
                                    event.familyMemberNumber = Integer.parseInt(editFamilyMemberField.getText());


                                    eventWindow.dispose();
                                    showEventsWindow();
                                }

                            }
                        }
                    });

                    deleteButton.addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent e) {

                            int answer = JOptionPane.showConfirmDialog(
                                    eventWindow,
                                    "Do you want to delete this event?",
                                    "Delete Event",
                                    JOptionPane.YES_NO_OPTION,
                                    JOptionPane.PLAIN_MESSAGE
                            );

                            if (answer == JOptionPane.YES_OPTION) {

                                eventManager.deleteEvent(event);

                                // Remove this event row from the screen
                                allEventsPanel.remove(oneEventPanel);

                                // Refresh the panel
                                allEventsPanel.revalidate();
                                allEventsPanel.repaint();
                            }
                            eventManager.deleteEvent(event);

                            eventManager.saveEvents();
                        }
                    });

                    oneEventPanel.add(eventInfo);
                    oneEventPanel.add(editButton);
                    oneEventPanel.add(deleteButton);

                    // Put the row into the main panel
                    allEventsPanel.add(oneEventPanel);
                }

                eventWindow.add(new JScrollPane(allEventsPanel));
                eventWindow.pack();
                eventWindow.setSize(500, 400);
                eventWindow.setLocationRelativeTo(this);
                eventWindow.setVisible(true);
            }
}













