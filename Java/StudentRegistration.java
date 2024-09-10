
package priyansh_project;

/*
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StudentRegistration extends JFrame {
    private JComboBox<String> streamComboBox, yearComboBox, divisionComboBox;
    private JTextField numberOfStudentsField;

    public StudentRegistration() {
        setTitle("Student Registration");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.LEFT)); // Left-aligned flow layout

        // Stream Combo Box
        String[] streams = {"BSC IT", "BA", "BMS", "BMM"};
        streamComboBox = new JComboBox<>(streams);
        streamComboBox.setPreferredSize(new Dimension(150, 25));
        add(new JLabel("Select Stream:"));
        add(streamComboBox);

        // Year Combo Box
        String[] years = {"F.Y.", "S.Y.", "T.Y."};
        yearComboBox = new JComboBox<>(years);
        yearComboBox.setPreferredSize(new Dimension(150, 25));
        add(new JLabel("Select Year:"));
        add(yearComboBox);

        // Division Combo Box
        String[] divisions = {"A", "B", "C"};
        divisionComboBox = new JComboBox<>(divisions);
        divisionComboBox.setPreferredSize(new Dimension(150, 25));
        add(new JLabel("Select Division:"));
        add(divisionComboBox);

        // Number of Students Input Box
        numberOfStudentsField = new JTextField(10);
        add(new JLabel("Number of Students:"));
        add(numberOfStudentsField);

        // Allot Buttons on a New Line
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        for (int i = 1; i <= 8; i++) {
            JButton allotButton = new JButton("Allot Room No : " + i);
            buttonPanel.add(allotButton);
            allotButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Method called when any allot button is clicked
                    allotButtonClicked();
                }
            });
        }
        add(buttonPanel);
    }

    private void allotButtonClicked() {
        // Get selected values
        String stream = (String) streamComboBox.getSelectedItem();
        String year = (String) yearComboBox.getSelectedItem();
        String division = (String) divisionComboBox.getSelectedItem();
        String numberOfStudents = numberOfStudentsField.getText();

        // Process the selected values (You can define your logic here)
        System.out.println("Stream: " + stream);
        System.out.println("Year: " + year);
        System.out.println("Division: " + division);
        System.out.println("Number of Students: " + numberOfStudents);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new StudentRegistration().setVisible(true);
            }
        });
    }
}


*/

/*


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class StudentRegistration extends JFrame {
    private JComboBox<String> streamComboBox, yearComboBox, divisionComboBox;
    private JTextField numberOfStudentsField;

    public StudentRegistration() {
        setTitle("Student Registration");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.LEFT)); // Left-aligned flow layout

        // Stream Combo Box
        String[] streams = {"BSC IT", "BA", "BMS", "BMM"};
        streamComboBox = new JComboBox<>(streams);
        streamComboBox.setPreferredSize(new Dimension(150, 25));
        add(new JLabel("Select Stream:"));
        add(streamComboBox);

        // Year Combo Box
        String[] years = {"F.Y.", "S.Y.", "T.Y."};
        yearComboBox = new JComboBox<>(years);
        yearComboBox.setPreferredSize(new Dimension(150, 25));
        add(new JLabel("Select Year:"));
        add(yearComboBox);

        // Division Combo Box
        String[] divisions = {"A", "B", "C"};
        divisionComboBox = new JComboBox<>(divisions);
        divisionComboBox.setPreferredSize(new Dimension(150, 25));
        add(new JLabel("Select Division:"));
        add(divisionComboBox);

        // Number of Students Input Box
        numberOfStudentsField = new JTextField(10);
        add(new JLabel("Number of Students:"));
        add(numberOfStudentsField);

        // Allot Buttons on a New Line
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        for (int i = 1; i <= 8; i++) {
            JButton allotButton = new JButton("Allot Button " + i);
            buttonPanel.add(allotButton);
            allotButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Method called when any allot button is clicked
                    allotButtonClicked();
                }
            });
        }
        add(buttonPanel);

        // Show Allocation Button
        JButton showAllocationButton = new JButton("Show Allocation");
        showAllocationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Method called when Show Allocation button is clicked
                showAllocationWindow();
            }
        });
        add(showAllocationButton);
    }

    private void allotButtonClicked() {
        // Get selected values
        String stream = (String) streamComboBox.getSelectedItem();
        String year = (String) yearComboBox.getSelectedItem();
        String division = (String) divisionComboBox.getSelectedItem();
        String numberOfStudents = numberOfStudentsField.getText();

        // Process the selected values (You can define your logic here)
        System.out.println("Stream: " + stream);
        System.out.println("Year: " + year);
        System.out.println("Division: " + division);
        System.out.println("Number of Students: " + numberOfStudents);
    }

    private void showAllocationWindow() {
        JFrame allocationFrame = new JFrame("Allocation Data");
        allocationFrame.setSize(600, 400);
        allocationFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Create columns names
        String[] columnNames = {"Stream", "Year", "Division", "Number of Students"};

        // Create a new table model
        DefaultTableModel model = new DefaultTableModel();

        // Add columns to the model
        for (String columnName : columnNames) {
            model.addColumn(columnName);
        }

        // Fetch data from the database and populate the table
        fetchData(model);

        // Create a JTable with the model
        JTable table = new JTable(model);

        // Add the table to a scroll pane
        JScrollPane scrollPane = new JScrollPane(table);
        allocationFrame.add(scrollPane);

        // Make the frame visible
        allocationFrame.setVisible(true);
    }

    private void fetchData(DefaultTableModel model) {
        // Connection parameters
        String url = "jdbc:mysql://localhost:3306/priyansh_project";
        String user = "root";
        String password = "";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            String sql = "SELECT stream, class_name, divison, no_of_students FROM students";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            // Process the result set and populate the table
            while (resultSet.next()) {
                String stream = resultSet.getString("stream");
                String year = resultSet.getString("class_name");
                String division = resultSet.getString("divison");
                int numberOfStudents = resultSet.getInt("no_of_students");

                // Add a row to the table model
                model.addRow(new Object[]{stream, year, division, numberOfStudents});
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new StudentRegistration().setVisible(true);
            }
        });
    }
}

*/



import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class StudentRegistration extends JFrame {
    private JComboBox<String> streamComboBox, yearComboBox, divisionComboBox;
    private JTextField numberOfStudentsField;

    public StudentRegistration() {
        setTitle("Student Registration");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.LEFT)); // Left-aligned flow layout

        // Stream Combo Box
        String[] streams = {"BSC IT", "BA", "BMS", "BMM"};
        streamComboBox = new JComboBox<>(streams);
        streamComboBox.setPreferredSize(new Dimension(150, 25));
        add(new JLabel("Select Stream:"));
        add(streamComboBox);

        // Year Combo Box
        String[] years = {"F.Y.", "S.Y.", "T.Y."};
        yearComboBox = new JComboBox<>(years);
        yearComboBox.setPreferredSize(new Dimension(150, 25));
        add(new JLabel("Select Year:"));
        add(yearComboBox);

        // Division Combo Box
        String[] divisions = {"A", "B", "C"};
        divisionComboBox = new JComboBox<>(divisions);
        divisionComboBox.setPreferredSize(new Dimension(150, 25));
        add(new JLabel("Select Division:"));
        add(divisionComboBox);

        // Number of Students Input Box
        numberOfStudentsField = new JTextField(10);
        add(new JLabel("Number of Students:"));
        add(numberOfStudentsField);

        // Allot Buttons on a New Line
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        for (int i = 1; i <= 8; i++) {
            JButton allotButton = new JButton("Allot Room No : " + i);
            buttonPanel.add(allotButton);
            int roomNumber = i;
            allotButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Method called when any allot button is clicked
                    allotButtonClicked(roomNumber);
                }
            });
        }
        add(buttonPanel);

        // Show Allocation Button
        JButton showAllocationButton = new JButton("Show Allocation");
        showAllocationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Method called when Show Allocation button is clicked
                showAllocationWindow();
            }
        });
        add(showAllocationButton);
    }

    private void allotButtonClicked(int roomNumber) {
        // Get selected values
        String stream = (String) streamComboBox.getSelectedItem();
        String year = (String) yearComboBox.getSelectedItem();
        String division = (String) divisionComboBox.getSelectedItem();
        String numberOfStudentsStr = numberOfStudentsField.getText();
        int numberOfStudents = Integer.parseInt(numberOfStudentsStr); // Convert to integer
        String classAlloted = "Room No " + roomNumber; // Example class allotted

        // Connection parameters
        String url = "jdbc:mysql://localhost:3306/priyansh_project";
        String user = "root";
        String password = "";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            // Check room capacity
            String checkCapacityQuery = "SELECT capacity FROM rooms WHERE room_no = ?";
            PreparedStatement checkCapacityStatement = conn.prepareStatement(checkCapacityQuery);
            checkCapacityStatement.setInt(1, roomNumber);
            ResultSet capacityResultSet = checkCapacityStatement.executeQuery();
            int roomCapacity = 0;
            if (capacityResultSet.next()) {
                roomCapacity = capacityResultSet.getInt("capacity");
            }

            // Check current occupancy of the room
            String checkOccupancyQuery = "SELECT SUM(no_of_students) FROM allot_table WHERE class_alloted = ?";
            PreparedStatement checkOccupancyStatement = conn.prepareStatement(checkOccupancyQuery);
            checkOccupancyStatement.setString(1, classAlloted);
            ResultSet resultSet = checkOccupancyStatement.executeQuery();
            int currentOccupancy = 0;
            if (resultSet.next()) {
                currentOccupancy = resultSet.getInt(1);
            }

            // Check if current occupancy plus new students exceeds room capacity
            if (currentOccupancy + numberOfStudents > roomCapacity) {
                JOptionPane.showMessageDialog(this, classAlloted + " is full. Cannot allot more students.");
                return; // Exit method if room is full
            }

            // Insert data into allot table
            String sql = "INSERT INTO allot_table (stream, class_name, divison, no_of_students, class_alloted) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, stream);
            statement.setString(2, year); // Assuming 'year' corresponds to 'class_name'
            statement.setString(3, division);
            statement.setInt(4, numberOfStudents);
            statement.setString(5, classAlloted);

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Data inserted successfully into allot table!");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void showAllocationWindow() {
        JFrame allocationFrame = new JFrame("Allocation Data");
        allocationFrame.setSize(600, 400);
        allocationFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Create columns names
        String[] columnNames = {"Stream", "Year", "Division", "Number of Students","Room Alloted"};

        // Create a new table model
        DefaultTableModel model = new DefaultTableModel();

        // Add columns to the model
        for (String columnName : columnNames) {
            model.addColumn(columnName);
        }

        // Fetch data from the database and populate the table
        fetchData(model);

        // Create a JTable with the model
        JTable table = new JTable(model);

        // Add the table to a scroll pane
        JScrollPane scrollPane = new JScrollPane(table);
        allocationFrame.add(scrollPane);

        // Make the frame visible
        allocationFrame.setVisible(true);
    }

    private void fetchData(DefaultTableModel model) {
        // Connection parameters
        String url = "jdbc:mysql://localhost:3306/priyansh_project";
        String user = "root";
        String password = "";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            String sql = "SELECT stream, class_name, divison, no_of_students,class_alloted FROM allot_table";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            // Process the result set and populate the table
            while (resultSet.next()) {
                String stream = resultSet.getString("stream");
                String year = resultSet.getString("class_name");
                String division = resultSet.getString("divison");
                int numberOfStudents = resultSet.getInt("no_of_students");
                String class_all = resultSet.getString("class_alloted");

                // Add a row to the table model
                model.addRow(new Object[]{stream, year, division, numberOfStudents,class_all});
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new StudentRegistration().setVisible(true);
            }
        });
    }
}
