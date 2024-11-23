/*
 * Copyright (c) 2024 Aditya Kumar Gupta(22BCS11354)
 * All rights reserved.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class PayBill extends JFrame implements ActionListener {
    private JTextField customerIdField, amountField;
    private JButton payButton;

    public PayBill() {
        setTitle("Pay Bill");
        setSize(400, 200);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        JLabel customerIdLabel = new JLabel("Customer ID:");
        customerIdField = new JTextField(10);
        customerIdField.addActionListener(this); // Listen for Enter key

        JLabel amountLabel = new JLabel("Amount to Pay:");
        amountField = new JTextField(10);
        amountField.setEditable(false); // Initially, amount field is not editable

        payButton = new JButton("Pay");
        payButton.addActionListener(this);
        payButton.setEnabled(false); // Initially, Pay button is disabled

        panel.add(customerIdLabel);
        panel.add(customerIdField);
        panel.add(amountLabel);
        panel.add(amountField);
        panel.add(payButton);

        add(panel);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == customerIdField) {
            String customerId = customerIdField.getText();
            Double billAmount = CalculateBill.getBillAmount(customerId);
            if (billAmount != null) {
                amountField.setText(String.format("%.2f", billAmount));
                payButton.setEnabled(true); // Enable the Pay button
            } else {
                JOptionPane.showMessageDialog(this, "No bill found for the entered Customer ID.");
                amountField.setText(""); // Clear the amount field
                payButton.setEnabled(false); // Disable the Pay button
            }
        } else if (e.getSource() == payButton) {
            String customerId = customerIdField.getText();
            double amountToPay = Double.parseDouble(amountField.getText());
            processPayment(customerId, amountToPay);
        }
    }

    private void processPayment(String customerId, double amount) {
        try {
            // Open the specified URL in the default browser
            Desktop.getDesktop().browse(new URI("https://drive.google.com/file/d/115rnUCq5vCi6KKZMPbBKyMTkFAotYxWx/view"));
            // Display a success message
            JOptionPane.showMessageDialog(this, "Payment of $" + amount + " for Customer ID " + customerId + " processed successfully!");
        } catch (IOException | URISyntaxException ex) {
            // Handle exception if URL cannot be opened
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error processing payment.");
        }
    }
}
/*
 * Copyright (c) 2024 Aditya Kumar Gupta(22BCS11354)
 * All rights reserved.
 */