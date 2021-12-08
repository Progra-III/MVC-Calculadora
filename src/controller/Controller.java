package controller;
import model.Model;
import view.View;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {

    Model model;
    View view;

    public Controller(Model model, View view)
    {
        this.model = model;
        this.view = view;
        view.addButtonListener(new CalculatorListener());
    }


    private class CalculatorListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String valor = e.getActionCommand();
            if (valor.equals("calcular"))
            {
                int n1, n2, r;
                String operando;
                try {
                    n1 = view.getNumero1();
                    n2 = view.getNumero2();
                    operando = view.getOperando();

                    model.setOperador1(n1);
                    model.setOperador2(n2);
                    model.setOperando(operando);

                    r = model.ejecutaOperacion();
                    view.setResultado(r);

                } catch (NumberFormatException exception) {
                    view.displayErrorMessage("Solo se aceptan numeros");
                } catch (ArithmeticException exception) {
                    view.displayErrorMessage("Invalido dividir por 0");
                }
            }
            else
                if(valor.equals("limpiar"))
                {
                    view.limpiarVentana();
                }
        }
    }
}
