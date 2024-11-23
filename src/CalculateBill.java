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

public class CalculateBill extends JFrame implements ActionListener {
    private JTextField customerIdField, unitsField;
    private JButton calculateBtn;
    private static Map<String, Integer> unitsConsumedData = new HashMap<>();
    private static Map<String, Double> billAmountData = new HashMap<>();

    public CalculateBill() {
        setTitle("Calculate Bill");
        setSize(300, 200);

        JPanel panel = new JPanel();
        JLabel customerIdLabel = new JLabel("Customer ID:");
        customerIdField = new JTextField(10);
        JLabel unitsLabel = new JLabel("Enter units consumed:");
        unitsField = new JTextField(10);
        calculateBtn = new JButton("Calculate");
        calculateBtn.addActionListener(this);

        panel.add(customerIdLabel);
        panel.add(customerIdField);
        panel.add(unitsLabel);
        panel.add(unitsField);
        panel.add(calculateBtn);

        add(panel);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
/*
 * Copyright (c) 2024 Aditya Kumar Gupta(22BCS11354)
 * All rights reserved.
 */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == calculateBtn) {
            String customerId = customerIdField.getText();
            try {
                int unitsConsumed = Integer.parseInt(unitsField.getText());
                double billAmount = calculateBillAmount(unitsConsumed);
                unitsConsumedData.put(customerId, unitsConsumed);
                billAmountData.put(customerId, billAmount);
                JOptionPane.showMessageDialog(this, "Bill calculated successfully!");
                clearFields();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter a valid number of units.");
            }
        }
    }

    private double calculateBillAmount(int unitsConsumed) {
        double billAmount = 0.0;
        double baseRate = 10.0; // Base rate for electricity connection
        double perUnitRate = 0.5; // Per unit rate

        if (unitsConsumed <= 100) {
            billAmount = baseRate + (unitsConsumed * perUnitRate);
        } else if (unitsConsumed <= 200) {
            billAmount = baseRate + (100 * perUnitRate) + ((unitsConsumed - 100) * (perUnitRate * 1.5));
        } else {
            billAmount = baseRate + (100 * perUnitRate) + (100 * (perUnitRate * 1.5)) + ((unitsConsumed - 200) * (perUnitRate * 2));
        }

        return billAmount;
    }

    private void clearFields() {
        customerIdField.setText("");
        unitsField.setText("");
    }

    // Getter methods to retrieve units consumed and bill amount by Customer ID
    public static Integer getUnitsConsumed(String customerId) {
        return unitsConsumedData.get(customerId);
    }

    public static Double getBillAmount(String customerId) {
        return billAmountData.get(customerId);
    }
}
/*
 * Copyright (c) 2024 Aditya Kumar Gupta(22BCS11354)
 * All rights reserved.
 */