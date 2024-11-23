/*
 * Copyright (c) 2024 Aditya Kumar Gupta(22BCS11354)
 * All rights reserved.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.HashMap;

public class Home extends JFrame implements ActionListener {
    JButton calculateBillBtn, customerDetailsBtn, generateBillBtn, newCustomerBtn, payBillBtn;

    public Home() {
        setTitle("Electricity Billing System");
        setSize(400, 300);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1));

        newCustomerBtn = new JButton("New Customer");
        calculateBillBtn = new JButton("Calculate Bill");
        customerDetailsBtn = new JButton("Customer Details");
        generateBillBtn = new JButton("Generate Bill");
        payBillBtn = new JButton("Pay Bill");

        calculateBillBtn.addActionListener(this);
        customerDetailsBtn.addActionListener(this);
        generateBillBtn.addActionListener(this);
        newCustomerBtn.addActionListener(this);
        payBillBtn.addActionListener(this);

        panel.add(newCustomerBtn);
        panel.add(calculateBillBtn);
        panel.add(customerDetailsBtn);
        panel.add(generateBillBtn);
        panel.add(payBillBtn);

        add(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
/*
 * Copyright (c) 2024 Aditya Kumar Gupta(22BCS11354)
 * All rights reserved.
 */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == calculateBillBtn) {
            CalculateBill calculateBill = new CalculateBill();
        } else if (e.getSource() == customerDetailsBtn) {
            CustomerDetails customerDetails = new CustomerDetails();
        } else if (e.getSource() == generateBillBtn) {
            GenerateBill generateBill = new GenerateBill();
        } else if (e.getSource() == newCustomerBtn) {
            NewCustomer newCustomer = new NewCustomer();
        } else if (e.getSource() == payBillBtn) {
            PayBill payBill = new PayBill();
        }
    }
/*
 * Copyright (c) 2024 Aditya Kumar Gupta(22BCS11354)
 * All rights reserved.
 */
    public static void main(String[] args) {
        // Prompt for login credentials
        String username = JOptionPane.showInputDialog("Enter username:");
        String password = JOptionPane.showInputDialog("Enter password:");

        // Hardcoded credentials for simplicity
        if (username.equals("Aditya11354") && password.equals("@di354")) {
            // If login successful, show the main application window
            new Home();
        } else {
            // If login failed, show error message and exit
            JOptionPane.showMessageDialog(null, "Invalid username or password!");
            System.exit(0);
        }
    }
}
/*
 * Copyright (c) 2024 Aditya Kumar Gupta(22BCS11354)
 * All rights reserved.
 */