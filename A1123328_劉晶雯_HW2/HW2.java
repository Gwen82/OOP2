import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HW2 extends JFrame {
    static HW2 frm = new HW2();
    static JPanel toppne = new JPanel();
    static JPanel pne = new JPanel();
    static JPanel bottompne = new JPanel();

    static JTextField text1 = new JTextField(10);
    static JTextField text2 = new JTextField(10);
    
    public static void main(String args[]){
        frm.setTitle("Unit Converter");
        BorderLayout border = new BorderLayout();
        frm.setLayout(border);
        frm.setSize(480,280);

        //North --- Types
        String[] type = {"Length", "Weight", "Temperature"};
        JComboBox<String> typeBox = new JComboBox<>(type); 
        toppne.add(typeBox);
        frm.add(toppne, BorderLayout.NORTH);

        //Center --- Source and Target
        String[] length = {"Meters", "Centimeters", "Inches", "Feet"};
        JComboBox<String> source = new JComboBox<>(length);
        JComboBox<String> result = new JComboBox<>(length);


        pne.add(text1);
        pne.add(source);
        pne.add(text2);
        pne.add(result);
        frm.add(pne, BorderLayout.CENTER);

        typeBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selected = (String) typeBox.getSelectedItem();
                source.removeAllItems();
                result.removeAllItems();
                
                if(selected.equals("Length")){
                    String[] units = {"Meters", "Centimeters", "Inches", "Feet"};
                    
                    for(String unit : units){
                        source.addItem(unit);
                        result.addItem(unit);
                    }
                }else if(selected.equals("Weight")){
                    String[] units = {"Kilograms", "Grams", "Pounds", "Ounces"};

                    for(String unit : units){
                        source.addItem(unit);
                        result.addItem(unit);
                    }
                }else{
                    String[] units = {"Celcius", "Fahrenheit", "Kelvin"};

                    for(String unit : units){
                        source.addItem(unit);
                        result.addItem(unit);
                    }
                }
            }
        });    
        
        //North --- Converter
        JButton btn = new JButton("Convert");

        bottompne.add(btn);
        frm.add(bottompne, BorderLayout.SOUTH);

        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                Double value = Double.parseDouble(text1.getText());
                Double answer = value;

                String from = (String) source.getSelectedItem();
                String to = (String) result.getSelectedItem();
                String type = (String) typeBox.getSelectedItem();

                if(type.equals("Length")){
                    if(from.equals("Meters")){
                        answer = value;
                    }else if(from.equals("Centimeters")){
                        answer = value/100;
                    }else if(from.equals("Inches")){
                        answer = value*0.0254;
                    }else{
                        answer = value*0.3048;
                    }

                    if(to.equals("Centimeters")){
                        answer = answer*100;
                    }else if(to.equals("Inches")){
                        answer = answer/0.0254;
                    }else if(to.equals("Feet")){
                        answer = answer/0.3048;
                    }
                }
                else if(type.equals("Weight")){
                    if(from.equals("Kilograms")){
                        answer = value;
                    }else if(from.equals("Grams")){
                        answer = value / 1000;
                    }else if(from.equals("Pounds")){
                        answer = value * 0.453592;
                    }else{
                        answer = value * 0.0283495;
                    }

                    if(to.equals("Grams")){
                        answer = answer * 1000;
                    }else if(to.equals("Pounds")){
                        answer = answer / 0.453592;
                    }else if(to.equals("Ounces")){
                        answer = answer / 0.0283495;
                    }
                }
                else{
                    if(from.equals("Fahrenheit")){
                        answer = (value - 32)*5/9;
                    }else if(from.equals("Kelvin")){
                        answer = value - 273.15;
                    }else{
                        answer = value;
                    }

                    if(to.equals("Fahrenheit")){
                        answer = answer * 5/9 + 32;
                    }else if(to.equals("Kelvin")){
                        answer = value + 273.15;
                    }
                }

                text2.setText(String.valueOf(answer));
            }
        });


        frm.setVisible(true);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
