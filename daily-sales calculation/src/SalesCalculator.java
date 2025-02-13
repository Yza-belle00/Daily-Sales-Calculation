import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


// GUI Application
public class SalesCalculator {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Sales Calculator");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(6, 2));

        JLabel phoneLabel = new JLabel("Phone Price:");
        JTextField phonePriceField = new JTextField("500.0");
        JLabel phoneQtyLabel = new JLabel("Quantity:");
        JTextField phoneQtyField = new JTextField("10");

        JLabel repairLabel = new JLabel("Repair Price Per Hour:");
        JTextField repairPriceField = new JTextField("50.0");
        JLabel repairHoursLabel = new JLabel("Hours:");
        JTextField repairHoursField = new JTextField("5");

        JButton calculateButton = new JButton("Calculate Total");
        JTextArea resultArea = new JTextArea();
        resultArea.setEditable(false);

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double phonePrice = Double.parseDouble(phonePriceField.getText());
                int phoneQty = Integer.parseInt(phoneQtyField.getText());
                double repairPrice = Double.parseDouble(repairPriceField.getText());
                int repairHours = Integer.parseInt(repairHoursField.getText());

                PhoneSale phoneSale = new PhoneSale(phonePrice, phoneQty);
                RepairService repairService = new RepairService(repairPrice, repairHours);

                resultArea.setText("Total Sales:\n" +
                        "Phone: ₱" + phoneSale.calculateTotal() + "\n" +
                        "Repair: ₱" + repairService.calculateTotal());
            }
        });

        frame.add(phoneLabel);
        frame.add(phonePriceField);
        frame.add(phoneQtyLabel);
        frame.add(phoneQtyField);
        frame.add(repairLabel);
        frame.add(repairPriceField);
        frame.add(repairHoursLabel);
        frame.add(repairHoursField);
        frame.add(calculateButton);
        frame.add(resultArea);

        frame.setVisible(true);
    }
}
