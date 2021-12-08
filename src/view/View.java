package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class View extends JFrame
{
    JPanel panelNum;
    JPanel panelSelect;
    JTextField txtNum1, txtNum2, txtResultado;
    JRadioButton radioSuma, radioResta, radioDivide, radioMultiplica;
    JButton btnCalcular;
    JButton btnLimpieza;

    public  int getNumero1()
    {
        return  Integer.parseInt(txtNum1.getText());
    }

    public  int getNumero2()
    {
        return  Integer.parseInt(txtNum2.getText());
    }

    public void setResultado(int valor)
    {
        txtResultado.setText(Integer.toString(valor));
    }

    public void limpiarVentana()
    {
        txtNum1.setText(" ");
        txtNum2.setText(" ");
        txtResultado.setText(" ");
    }

    public void addButtonListener(ActionListener ac)
    {
        btnCalcular.addActionListener(ac);
        btnLimpieza.addActionListener(ac);
    }

    public void displayErrorMessage(String errorMessage)
    {
        JOptionPane.showMessageDialog(this, errorMessage, "Error de formato!", JOptionPane.ERROR_MESSAGE);

    }

    public View() throws HeadlessException
    {
        setTitle("Calculadora");
        setSize(300,300);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addComponents();
        add(panelNum, BorderLayout.CENTER);
        add(panelSelect, BorderLayout.EAST);
        setVisible(true);
    }

    private void addComponents()
    {
        panelNum = new JPanel();
        panelSelect = new JPanel();

        panelNum.setLayout(new GridLayout(4,2));
        panelNum.setBorder(new EmptyBorder(10, 10, 10, 10));

        panelSelect.setLayout(new GridLayout(4,1));
        panelSelect.setBorder(new EmptyBorder(10, 10, 10, 10));

        panelNum.add(new JLabel("Numero 1:"));
        txtNum1 = new JTextField();
        txtNum1.setToolTipText("Aqui debe introducir un numero");//Despliega un mensaje cuando el mouse se posa sobre el "TextField"
        panelNum.add(txtNum1);

        panelNum.add(new JLabel("Numero 2:"));
        txtNum2 = new JTextField();
        txtNum2.setToolTipText("Aqui debe introducir un numero");
        panelNum.add(txtNum2);

        panelNum.add(new JLabel("Resultado:"));
        txtResultado = new JTextField();
        txtResultado.setEditable(false);//Tambien sirve el setEnable(false)
        txtResultado.setBackground(Color.white);
        panelNum.add(txtResultado);

        //panelNum.add(new JLabel(" "));
        btnCalcular = new JButton("Calcular");
        btnCalcular.setActionCommand("calcular");
        btnLimpieza = new JButton("Limpiar");
        btnLimpieza.setActionCommand("limpiar");
        panelNum.add(btnLimpieza);
        panelNum.add(btnCalcular);

        radioSuma = new JRadioButton("Sumar");
        radioResta = new JRadioButton("Restar");
        radioDivide = new JRadioButton("Dividir");
        radioMultiplica = new JRadioButton("Multiplicar");

        ButtonGroup bgroup = new ButtonGroup();
        bgroup.add(radioSuma);
        bgroup.add(radioResta);
        bgroup.add(radioDivide);
        bgroup.add(radioMultiplica);

        radioSuma.setSelected(true);
        panelSelect.add(radioSuma);
        panelSelect.add(radioResta);
        panelSelect.add(radioDivide);
        panelSelect.add(radioMultiplica);
    }

    public String getOperando()
    {
        if(radioSuma.isSelected())
        {
            return "+";
        }
        else
            if(radioResta.isSelected())
            {
                return "-";
            }
            else
                if(radioDivide.isSelected())
                {
                    return "/";
                }
                else {
                    return "*";
                }
    }
}




