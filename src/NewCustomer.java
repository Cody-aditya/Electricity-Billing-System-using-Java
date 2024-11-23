/*
 * Copyright (c) 2024 Aditya Kumar Gupta(22BCS11354)
 * All rights reserved.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class NewCustomer extends JFrame implements ActionListener {
    JTextField customerIdField, nameField, addressField, phoneField, emailField;
    JButton addButton;

    private static Map<String, String[]> customerData = new HashMap<>();

    public NewCustomer() {
        setTitle("Add New Customer");
        setSize(400, 300);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2));

        JLabel customerIdLabel = new JLabel("Customer ID:");
        customerIdField = new JTextField(10);

        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField(10);

        JLabel addressLabel = new JLabel("Address:");
        addressField = new JTextField(10);

        JLabel phoneLabel = new JLabel("Phone:");
        phoneField = new JTextField(10);

        JLabel emailLabel = new JLabel("Email:");
        emailField = new JTextField(10);

        addButton = new JButton("Add Customer");
        addButton.addActionListener(this);

        panel.add(customerIdLabel);
        panel.add(customerIdField);
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(addressLabel);
        panel.add(addressField);
        panel.add(phoneLabel);
        panel.add(phoneField);
        panel.add(emailLabel);
        panel.add(emailField);
        panel.add(addButton);

        add(panel);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            String customerId = customerIdField.getText();
            String name = nameField.getText();
            String address = addressField.getText();
            String phone = phoneField.getText();
            String email = emailField.getText();
            addCustomer(customerId, name, address, phone, email);
            JOptionPane.showMessageDialog(this, "New customer added successfully!");
            clearFields();
        }
    }

    private void addCustomer(String customerId, String name, String address, String phone, String email) {
        String[] customerDetails = {name, address, phone, email};
        customerData.put(customerId, customerDetails);
    }

    private void clearFields() {
        customerIdField.setText("");
        nameField.setText("");
        addressField.setText("");
        phoneField.setText("");
        emailField.setText("");
    }
/*
 * Copyright (c) 2024 Aditya Kumar Gupta(22BCS11354)
 * All rights reserved.
 */
    // Getter method to retrieve customer data by Customer ID
    public static String[] getCustomerDetails(String customerId) {
        return customerData.get(customerId);
    }
}
