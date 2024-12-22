package bsu.rfe.java.group7.lab3.Zhamoitin.varB4;

import javax.swing.table.AbstractTableModel;

public class GornerTableModel extends AbstractTableModel {

    private Double[] coefficients;
    private Double from;
    private Double to;
    private Double step;

    public GornerTableModel(Double from, Double to, Double step, Double[]
            coefficients) {
        this.from = from;
        this.to = to;
        this.step = step;
        this.coefficients = coefficients;
    }

    public Double getFrom() {
        return from;
    }
    public Double getTo() {
        return to;
    }
    public Double getStep() {
        return step;
    }

    public int getColumnCount() {
        return 3;
    }
    public int getRowCount() {
        return new Double(Math.ceil((to-from)/step)).intValue()+1;
    }



    public Object getValueAt(int row, int col) {
        double x = from + step*row;
        if(col == 0)
        {
            return x;
        }
        else if(col == 1)
        {
            Double result = 0.0;
            result = coefficients[0];
            for(int i = 1; i <coefficients.length; i++)
            {
                result = result*x+coefficients[i];
            }
            return result;
        }
        else
        {
            Double result = 0.0;
            result = coefficients[0];
            for (int i = 1; i < coefficients.length; i++) {
                result = result * x + coefficients[i];
            }

            int integer = result.intValue();
            double frac = result.doubleValue();
            int gcd = FINDGCD(integer, (int)frac*10000);
            if(gcd == 1)
                return true;
            else return false;

        }
    }

    public static int FINDGCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return FINDGCD(b, a % b);
    }

    public Class<?> getColumnClass(int col) {
        if(col == 2) return Boolean.class;
        return Double.class;
    }

    public String getColumnName(int col) {
        switch(col)
        {
            case 0: return "Значение Х";
            case 1: return "Значение многочлена";
            default: return "Взаимно простые?";
        }
    }


}

