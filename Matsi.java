/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MatjaEpeshes;

import java.text.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Matsi extends JPanel implements ActionListener {

    private JLabel hyrjaL;
    private JLabel hyrjaLG;
    private JLabel bmiK;
    private JTextField hyrjaP;
    private JTextField hyrjaG;
    private JTextField rezultati;
    private JButton butoni;
    private JPanel pHyrja, pHyrja1, komponentet;

    public Matsi() {

        hyrjaL = new JLabel("Shkruani peshen: ");
        hyrjaLG = new JLabel("Shkruani gjatesine: ");
        hyrjaP = new JTextField(15);
        hyrjaG = new JTextField(15);
        bmiK = new JLabel("Indexi i mases se trupit");
        rezultati = new JTextField("Rezultati: ");
        butoni = new JButton("Kalkulo");
        pHyrja = new JPanel();
        pHyrja1 = new JPanel();
        komponentet = new JPanel();
        komponentet.setLayout(new BoxLayout(komponentet, BoxLayout.Y_AXIS));
        pHyrja.add(hyrjaL);
        pHyrja.add(hyrjaP);
        pHyrja1.add(hyrjaLG);
        pHyrja1.add(hyrjaG);
        komponentet.add(pHyrja);
        komponentet.add(pHyrja1);
        komponentet.add(butoni);
        komponentet.add(rezultati);
        butoni.addActionListener(this);
        add(komponentet);
        

    }

//    public void shtoLlojKonvertimi(BMI b) {
//        cboKonvertimet.addItem(b);//shto ne JCombobox nje konvertues
//    }
    public void actionPerformed(ActionEvent e) {

//        if (!hyrjaP.getText().equals("")&&!hyrjaG.getText().equals("")) {
//            int indeksiIZgjedhur = cboKonvertimet.getSelectedIndex();
//            BMI b = cboKonvertimet.getItemAt(indeksiIZgjedhur);
       try{
           DecimalFormat formatuesi = new DecimalFormat("0.00");
        double pesha = Double.parseDouble(hyrjaP.getText());
        double gjatsia = Double.parseDouble(hyrjaG.getText());
        double BMI = pesha / Math.pow(gjatsia, 2);
       
        
        if (BMI < 18.5) {
            rezultati.setText("Pergjigja juaj eshte: " + formatuesi.format(BMI) + " Underweight");
        } else if (BMI >= 18.5 && BMI <= 24.9) {
            rezultati.setText("Pergjigja juaj eshte: " + formatuesi.format(BMI) + " Normal weight");
        } else if (BMI >= 25 && BMI <= 29.9) {
            rezultati.setText("Pergjigja juaj eshte: " + formatuesi.format(BMI) + " Overweight");
        } else {
            rezultati.setText("Pergjigja juaj eshte: " + formatuesi.format(BMI) + " Obesity");
        }
        }catch(BMIException ex){
            ex.printStackTrace();
    }catch(NumberFormatException ex){
       JOptionPane.showMessageDialog(null," Gabim, Nuk lejohet te shkruhen shkronja ", "Gabim ", JOptionPane.ERROR_MESSAGE);
       }
    }
    
    

    public static void main(String[] args) {

        Matsi m = new Matsi();

        JFrame frame = new JFrame();
        frame.add(m);
        frame.setTitle("BMI Calculator");
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
