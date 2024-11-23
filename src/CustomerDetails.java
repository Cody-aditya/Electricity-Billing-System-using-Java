
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

public class CustomerDetails extends JFrame implements ActionListener {
    private JTextField customerIdField;
    private JTextArea detailsArea;
    private JButton showDetailsButton;

    public CustomerDetails() {
        setTitle("Customer Details");
        setSize(400, 300);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new FlowLayout());
        JLabel customerIdLabel = new JLabel("Enter Customer ID:");
        customerIdField = new JTextField(10);
        showDetailsButton = new JButton("Show Details");
        showDetailsButton.addActionListener(this);

        inputPanel.add(customerIdLabel);
        inputPanel.add(customerIdField);
        inputPanel.add(showDetailsButton);

        detailsArea = new JTextArea();
        detailsArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(detailsArea);

        panel.add(inputPanel, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);

        add(panel);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == showDetailsButton) {
            String customerId = customerIdField.getText();
            StringBuilder details = new StringBuilder();
            
            // Fetch and display bill details
            Double billAmount = CalculateBill.getBillAmount(customerId);
            if (billAmount != null) {
                details.append("Bill Details:\n");
                details.append("Customer ID: ").append(customerId).append("\n");
                details.append("Bill Amount: $").append(String.format("%.2f", billAmount)).append("\n\n");
            } else {
                details.append("No bill found for the entered Customer ID.\n\n");
            }
            
            // Fetch and display new customer details
            String[] customerDetails = NewCustomer.getCustomerDetails(customerId);
            if (customerDetails != null) {
                details.append("New Customer Details:\n");
                details.append("Customer ID: ").append(customerId).append("\n");
                details.append("Name: ").append(customerDetails[0]).append("\n");
                details.append("Address: ").append(customerDetails[1]).append("\n");
                details.append("Phone: ").append(customerDetails[2]).append("\n");
                details.append("Email: ").append(customerDetails[3]).append("\n");
            } else {
                details.append("No new customer details found for the entered Customer ID.");
            }

            detailsArea.setText(details.toString());
        }
    }
}
/*
 * Copyright (c) 2024 Aditya Kumar Gupta(22BCS11354)
 * All rights reserved.
 */