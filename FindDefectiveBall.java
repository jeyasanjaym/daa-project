import javax.swing.*;
import java.awt.*;

public class FindDefectiveBall extends JFrame {
    JTextField[] weights = new JTextField[5];
    JLabel resultLabel = new JLabel("Result: ");

    public FindDefectiveBall() {
        setTitle("Find Heavier/Lighter Ball - Brute Force");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(12, 1));

        add(new JLabel("Enter weights of 5 balls:"));

        for (int i = 0; i < 5; i++) {
            add(new JLabel("Ball " + (i + 1) + ":"));
            weights[i] = new JTextField();
            add(weights[i]);
        }

        JButton btn = new JButton("Find Defective Ball");
        btn.addActionListener(e -> {
            try {
                double[] w = new double[5];
                for (int i = 0; i < 5; i++)
                    w[i] = Double.parseDouble(weights[i].getText());

                String res = findDefective(w);
                resultLabel.setText(res);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Please enter valid numbers.");
            }
        });

        add(btn);
        add(resultLabel);

        setVisible(true);
    }

    private String findDefective(double[] w) {
        double normalWeight = w[0];
        int defectiveIndex = -1;
        String type = "";

        for (int i = 1; i < w.length; i++) {
            if (w[i] != normalWeight) {
                defectiveIndex = i;
                type = (w[i] > normalWeight) ? "Heavier" : "Lighter";
                break;
            }
        }

        if (defectiveIndex == -1) return "All balls have equal weight. No defective ball found.";
        else return "Defective ball is Ball " + (defectiveIndex + 1) + " and it is " + type + ".";
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(FindDefectiveBall::new);
    }
}