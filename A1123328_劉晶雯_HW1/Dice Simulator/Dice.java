import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Dice {

    static JFrame frm = new JFrame("Dice Simulator");
    static JPanel pne = new JPanel(new BorderLayout());

    static JLabel lab = new JLabel(
        "Rolled 0 Times, Total 0, Average 0.00",
        JLabel.CENTER
    );

    static JLabel downlab = new JLabel("-", JLabel.CENTER);
    static JButton btn = new JButton("Roll Dice");

    static Random rand = new Random();

    static int nTimes = 0;
    static int total = 0;

    public static void main(String[] args) {

        // Dice number: 60pt
        downlab.setFont(new Font("Times New Roman", Font.BOLD, 60));

        // Roll Dice button
        btn.addActionListener(e -> {

            // Generate random number from 1 to 6
            int result = rand.nextInt(6) + 1;

            // Update statistics
            nTimes++;
            total += result;

            double average = (double) total / nTimes;

            // Display dice number
            downlab.setText(String.valueOf(result));

            // Change text color
            if (result == 6) {
                downlab.setForeground(Color.GREEN);
            } else if (result == 1) {
                downlab.setForeground(Color.RED);
            } else {
                downlab.setForeground(Color.BLACK);
            }

            // Update information at the top
            lab.setText(String.format(
                "Rolled %d Times, Total %d, Average %.2f",
                nTimes, total, average
            ));
        });

        // Window size
        frm.setSize(400, 320);

        // Add components
        pne.add(lab, BorderLayout.NORTH);
        pne.add(downlab, BorderLayout.CENTER);
        pne.add(btn, BorderLayout.SOUTH);

        frm.add(pne);

        // Open window in the center
        frm.setLocationRelativeTo(null);

        // Close program when window is closed
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Show window
        frm.setVisible(true);
    }
}