/*
 * Copyright (c) 2024 Aditya Kumar Gupta(22BCS11354)
 * All rights reserved.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GenerateBill extends JFrame implements ActionListener {
    private JTextField customerIdField;
    private JTextArea billTextArea;
    private JButton generateBtn;

    public GenerateBill() {
        setTitle("Generate Bill");
        setSize(400, 300);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JPanel topPanel = new JPanel(new FlowLayout());
        JLabel customerIdLabel = new JLabel("Enter Customer ID:");
        customerIdField = new JTextField(10);
        generateBtn = new JButton("Generate");
        generateBtn.addActionListener(this);

        topPanel.add(customerIdLabel);
        topPanel.add(customerIdField);
        topPanel.add(generateBtn);

        billTextArea = new JTextArea();
        billTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(billTextArea);

        panel.add(topPanel, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);

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
        if (e.getSource() == generateBtn) {
            String customerId = customerIdField.getText();
            Integer unitsConsumed = CalculateBill.getUnitsConsumed(customerId);
            Double billAmount = CalculateBill.getBillAmount(customerId);
            if (unitsConsumed != null && billAmount != null) {
                String billDetails = generateBill(customerId, unitsConsumed, billAmount);
                billTextArea.setText(billDetails);
            } else {
                JOptionPane.showMessageDialog(this, "Customer ID not found or bill not calculated.");
            }
        }
    }

    private String generateBill(String customerId, int unitsConsumed, double billAmount) {
        StringBuilder bill = new StringBuilder();
        bill.append("Bill for Customer ID: ").append(customerId).append("\n");
        bill.append("------------------------------\n");
        bill.append("Units Consumed: ").append(unitsConsumed).append("\n");
        bill.append("Amount Due: $").append(String.format("%.2f", billAmount)).append("\n");
        bill.append("------------------------------\n");
        bill.append("Thank you for using our services!\n");
        return bill.toString();
    }
}
/*
 * Copyright (c) 2024 Aditya Kumar Gupta(22BCS11354)
 * All rights reserved.
 */
