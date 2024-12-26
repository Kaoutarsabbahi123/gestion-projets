package Presentation;

import Metier.Filiere;


import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class Modelfil extends AbstractTableModel {
    private ArrayList<Filiere> list;
    public Modelfil(ArrayList<Filiere> list) {
        super();
        this.list = list;
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return Filiere.getAttribut().length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        return list.get(rowIndex).get(columnIndex);
    }
    @Override
    public String getColumnName(int i){
        return Filiere.getAttribut()[i];
    }
    @Override
    public Class getColumnClass(int i ) {
        switch (i){
            case 0 : return Integer.class;
            case 1 : return String.class;
            case 2 : return Integer.class;


        }
        return Object.class;
    }
    @Override
    public  boolean isCellEditable(int ligne, int colonne){
        return true;
    }

}



