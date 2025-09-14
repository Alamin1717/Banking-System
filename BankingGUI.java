package bankingapp;

import javax.swing.*;
import java.awt.*;

public class BankingGUI extends JFrame {
    private BankSystem bank;

    public BankingGUI() {
        bank = new BankSystem();
        setTitle("Banking App");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
// Use BorderLayout for the frame
setLayout(new BorderLayout());

// Create a panel to hold buttons in a vertical grid
JPanel buttonPanel = new JPanel(new GridLayout(5, 1, 10, 10));
buttonPanel.setPreferredSize(new Dimension(200, 250)); // Adjust size as needed

// Create buttons
JButton createBtn = new JButton("Create Account");
JButton depositBtn = new JButton("Deposit");
JButton withdrawBtn = new JButton("Withdraw");
JButton balanceBtn = new JButton("Check Balance");
JButton transBtn = new JButton("View Transactions");

// Add buttons to panel
buttonPanel.add(createBtn);
buttonPanel.add(depositBtn);
buttonPanel.add(withdrawBtn);
buttonPanel.add(balanceBtn);
buttonPanel.add(transBtn);

// Add panel to center of frame
add(buttonPanel, BorderLayout.CENTER);

// Optional: center the window on screen
setLocationRelativeTo(null);



        // Create Account
        createBtn.addActionListener(e -> {
            JTextField nameField = new JTextField();
            JTextField accNumField = new JTextField();
            JTextField depositField = new JTextField();

            Object[] fields = {
                    "Name:", nameField,
                    "Account Number:", accNumField,
                    "Initial Deposit:", depositField
            };

            int option = JOptionPane.showConfirmDialog(null, fields, "Create Account", JOptionPane.OK_CANCEL_OPTION);
            if (option == JOptionPane.OK_OPTION) {
                String name = nameField.getText();
                String accNum = accNumField.getText();
                double deposit = Double.parseDouble(depositField.getText());
                bank.createAccount(name, accNum, deposit);
                JOptionPane.showMessageDialog(null, "Account Created Successfully!");
            }
        });

        // Deposit
        depositBtn.addActionListener(e -> {
            String accNum = JOptionPane.showInputDialog("Enter Account Number:");
            Account acc = bank.getAccount(accNum);
            if (acc != null) {
                double amount = Double.parseDouble(JOptionPane.showInputDialog("Enter Deposit Amount:"));
                acc.deposit(amount);
                JOptionPane.showMessageDialog(null, "Deposit Successful!");
            } else {
                JOptionPane.showMessageDialog(null, "Account Not Found!");
            }
        });

        // Withdraw
        withdrawBtn.addActionListener(e -> {
            String accNum = JOptionPane.showInputDialog("Enter Account Number:");
            Account acc = bank.getAccount(accNum);
            if (acc != null) {
                double amount = Double.parseDouble(JOptionPane.showInputDialog("Enter Withdraw Amount:"));
                if (acc.withdraw(amount)) {
                    JOptionPane.showMessageDialog(null, "Withdraw Successful!");
                } else {
                    JOptionPane.showMessageDialog(null, "Insufficient Balance!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Account Not Found!");
            }
        });

        // Check Balance
        balanceBtn.addActionListener(e -> {
            String accNum = JOptionPane.showInputDialog("Enter Account Number:");
            Account acc = bank.getAccount(accNum);
            if (acc != null) {
                JOptionPane.showMessageDialog(null, "Balance: " + acc.getBalance());
            } else {
                JOptionPane.showMessageDialog(null, "Account Not Found!");
            }
        });

        // View Transactions
        transBtn.addActionListener(e -> {
            String accNum = JOptionPane.showInputDialog("Enter Account Number:");
            Account acc = bank.getAccount(accNum);
            if (acc != null) {
                StringBuilder sb = new StringBuilder();
                for (Transaction t : acc.getTransactions()) {
                    sb.append(t.toString()).append("\n");
                }
                JOptionPane.showMessageDialog(null, sb.toString(), "Transactions", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Account Not Found!");
            }
        });

        setVisible(true);
    }
}
