import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class A1123328_exercise1{
    static JFrame frm = new JFrame("Dice Simulator");
    static JPanel pne = new JPanel(new BorderLayout());

    static JLabel lab = new JLabel("Rolled 0 Times, Total 0, Average 0.00 ", JLabel.CENTER);
    static JLabel downlab = new JLabel("-", JLabel.CENTER);
    static JButton btn = new JButton("Roll Dice");
    static Random rand = new Random();
    static int nTimes = 0;
    static int Total = 0; 

    public static void main(String args[]){
        downlab.setFont(new Font("Times New Romans",Font.BOLD,60));

        btn.addActionListener(e ->{
            int result = rand.nextInt(6) + 1;

            nTimes++;
            Total += result;
            double average = (double)Total/nTimes;
            downlab.setText(String.valueOf(result));

            if(result == 6){
                downlab.setForeground(new Color(0, 128, 0));
            }else if(result == 1){
                downlab.setForeground(new Color(255,0,0));
            }else{
                downlab.setForeground(new Color(0,0,0));
            }

            lab.setText(String.format("Rolled %d Times, Total %d, Average %.2f ",nTimes,Total,average));
        });

        
        frm.setSize(400,320);
        pne.add(lab, BorderLayout.NORTH);
        pne.add(downlab, BorderLayout.CENTER);
        pne.add(btn, BorderLayout.SOUTH);
        frm.add(pne);

        frm.setLocationRelativeTo(null);;
        frm.setVisible(true);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}