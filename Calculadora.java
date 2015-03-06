/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Calculadora;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author alumno
 */
public class Calculadora extends JFrame {
    
    double o1;
    double o2;
    double r1;
    JButton b1;
    JButton b2;
    JButton b3;
    JButton b4;
    JButton b5; //limpiar
    JTextField t1;
    JTextField t2;
    JTextField t3;
    JLabel l1; // operando 1
    JLabel l2; // operando 2
    JLabel l3; // resultado
    JLabel l4; // limpiar datos
    JScrollPane jsb;
    JTextArea resumen_operaciones;
    static int id;
    String resumen = "";
    StringBuilder s = new StringBuilder();

    public Calculadora() {
        super("Calculadora");
        this.setVisible(true);
        setLayout(new GridLayout(3, 4));
        b1 = new JButton("Suma");
        b2 = new JButton("Resta");
        b3 = new JButton("Multiplicación");
        b4 = new JButton("División");
        b5 = new JButton("Limpiar");
        b1.addActionListener(new OyenteBoton());
        b2.addActionListener(new OyenteBoton());
        b3.addActionListener(new OyenteBoton());
        b4.addActionListener(new OyenteBoton());
        b5.addActionListener(new OyenteBoton());
        b1.setActionCommand("s");
        b2.setActionCommand("r");
        b3.setActionCommand("m");
        b4.setActionCommand("d");
        b5.setActionCommand("l");
        l1 = new JLabel("Operando 1");
        l2 = new JLabel("Operando 2");
        l3 = new JLabel("Resultado");
        l4 = new JLabel("Limpiar Datos");
        t1 = new JTextField(); //campo 1 
        t2 = new JTextField();  //campo 2
        t3 = new JTextField(); //resultado
        
        resumen_operaciones = new JTextArea();
        jsb = new JScrollPane(this.resumen_operaciones);
        t3.setEditable(false);
        this.add(b1);
        this.add(b2);
        this.add(b3);
        this.add(b4);
        this.add(l1);
        this.add(t1);
        this.add(l2);
        this.add(t2);
        this.add(l3);
        this.add(t3);
        this.add(l4);
        this.add(b5);
        
//        this.add(resumen_operaciones);
        this.add(jsb);
        resumen_operaciones.setVisible(true);
        jsb.setVisible(true);
        Container c = this.getContentPane();
        this.setSize(400, 400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
    }
    
    public void sumar() {
        id++;
        String op1 = t1.getText();
        String op2 = t2.getText();
        try {
            o1 = Double.parseDouble(op1);
            o2 = Double.parseDouble(op2);
        } catch (Exception e) {
            t3.setText("DATOS NO VALIDOS");
        }
        r1 = o1 + o2;
        String resultado = Double.toString(r1);
        if (Double.isNaN(r1) || Double.isInfinite(r1)) {
            t3.setText("ERROR");
        } else {
            t3.setText(resultado);
            resumen_operaciones.append("Operación nº " + this.id + " Resultado " + resultado + "\n");
        }
    }
    
    public void restar() {
        id++;
        String op1 = t1.getText();
        String op2 = t2.getText();
        try {
            o1 = Double.parseDouble(op1);
            o2 = Double.parseDouble(op2);
        } catch (Exception e) {
            t3.setText("DATOS NO VALIDOS");
        }
        r1 = o1 - o2;
        String resultado = Double.toString(r1);
        if (Double.isNaN(r1) || Double.isInfinite(r1)) {
            t3.setText("ERROR");
        } else {
            t3.setText(resultado);
            resumen_operaciones.append("Operación nº " + this.id + " Resultado " + resultado + "\n");
            
        }
    }
    
    public void multiplicar() {
        id++;
        String op1 = t1.getText();
        String op2 = t2.getText();
        try {
            o1 = Double.parseDouble(op1);
            o2 = Double.parseDouble(op2);
        } catch (Exception e) {
            t3.setText("DATOS NO VALIDOS");
        }
        r1 = o1 * o2;
        String resultado = Double.toString(r1);
        if (Double.isNaN(r1) || Double.isInfinite(r1)) {
            t3.setText("ERROR");
        } else {
            t3.setText(resultado);
            resumen_operaciones.append("Operación nº " + this.id + " Resultado " + resultado + "\n");
        }
    }
    
    public void dividir() {
        id++;
        String op1 = t1.getText();
        String op2 = t2.getText();
        try {
            o1 = Double.parseDouble(op1);
            o2 = Double.parseDouble(op2);
        } catch (Exception e) {
            t3.setText("DATOS NO VALIDOS");
        }
        r1 = o1 / o2;
        String resultado = Double.toString(r1);
        
        if (Double.isNaN(r1) || Double.isInfinite(r1)) {
            t3.setText("ERROR");
        } else {
            t3.setText(resultado);
            resumen_operaciones.append("Operación nº " + this.id + " Resultado " + resultado + "\n");
        }
        
    }
    
    public void limpiar() {
        t1.setText(null);
        t2.setText(null);
        t3.setText(null);
        resumen_operaciones.setText(null);
        
    }
    
    class OyenteBoton implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            String comando = e.getActionCommand();
            
            if (comando.equals("s")) {
                sumar();
            }
            if (comando.equals("r")) {
                restar();
            }
            if (comando.equals("m")) {
                multiplicar();
            }
            if (comando.equals("d")) {
                dividir();
            }
            if (comando.equals("l")) {
                limpiar();
            }
        }
        
    }
    
}
