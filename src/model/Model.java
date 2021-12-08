package model;

public class Model
{
    private int operador1;
    private int operador2;
    private String operando;

    public Model()
    {}

    public int getOperador1() {
        return operador1;
    }

    public void setOperador1(int operador1) {
        this.operador1 = operador1;
    }

    public int getOperador2() {
        return operador2;
    }

    public void setOperador2(int operador2) {
        this.operador2 = operador2;
    }

    public String getOperando() {
        return operando;
    }

    public void setOperando(String operando) {
        this.operando = operando;
    }

    public int suma()
    {
        return getOperador1() + getOperador2();
    }

    public int resta()
    {
        return getOperador1() - getOperador2();
    }

    public int divide()
    {
        return getOperador1() / getOperador2();
    }

    public int multiplica()
    {
        return getOperador1() * getOperador2();
    }

    public int ejecutaOperacion()
    {
        if("+".equals(operando))
        {
            return suma();
        }
        else
            if("-".equals(operando))
            {
                return resta();
            }
            else
                if("*".equals(operando))
                {
                    return multiplica();
                }
                else
                    if("/".equals(operando))
                    {
                        return divide();
                    }
                    else
                        return 0;
    }


}
