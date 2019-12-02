package bsu.rfe.java.group10.lab3.anufriev;

import java.awt.Color; import java.awt.Component;
import java.awt.FlowLayout;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import java.util.Formatter;

public class GornerTableCellRenderer implements TableCellRenderer {
    private JPanel panel = new JPanel();
    private JLabel label = new JLabel();
    // Ищем ячейки, строковое представление которых совпадает с needle
    private String needle = null;
    private String needleX = null;
    private String needleY = null;


    private DecimalFormat formatter = (DecimalFormat)NumberFormat.getInstance();

    public GornerTableCellRenderer()
    {
        // Показывать только 5 знаков после запятой
        formatter.setMaximumFractionDigits(5);
        // Не использовать группировку
        formatter.setGroupingUsed(false);

        DecimalFormatSymbols dottedDouble = formatter.getDecimalFormatSymbols();
        dottedDouble.setDecimalSeparator('.');
        formatter.setDecimalFormatSymbols(dottedDouble);
        // Разместить надпись внутри панели
        panel.add(label);
        // Установить выравнивание надписи по левому краю панели
        panel.setLayout(new FlowLayout(FlowLayout.LEFT));

    }


    public Component getTableCellRendererComponent(JTable table, Object
            value, boolean isSelected, boolean hasFocus, int row, int col) {
        // Преобразовать число в строку с помощью форматировщика
        String formattedDouble = formatter.format(value);

        // Установить текст надписи равным строковому представлению числа
        label.setText(formattedDouble);

        if(Math.ceil(Double.parseDouble(formattedDouble)%2) == 1)
        {
            panel.setBackground(Color.RED);
        }
        else {
            panel.setBackground(Color.white);
        }



        return panel;

    }

    public String getNeedleX() {
        return needleX;
    }


    public void setNeedleX(String needleX) {
        this.needleX = needleX;
    }


    public String getNeedleY() {
        return needleY;
    }


    public void setNeedleY(String needleY) {
        this.needleY = needleY;
    }


    public void setNeedle(String needle)
    {
        this.needle = needle;
    }

    public void setNeedle1(String needleX, String needleY)
    {
        this.needleX = needleX;
        this.needleY = needleY;
    }
}
