package Presentation;

import Metier.Professeur;
import Metier.Projet;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class Modelpr extends AbstractTableModel {
    private ArrayList<Projet> list;
    public Modelpr(ArrayList<Projet> list) {
        super();
        this.list = list;
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return Projet.getAttribut().length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        return list.get(rowIndex).get(columnIndex);
    }
    @Override
    public String getColumnName(int i){
        return Projet.getAttribut()[i];
    }
    @Override
    public Class getColumnClass(int i ) {
        switch (i){
            case 0 : return Integer.class;
            case 1 : return String.class;
            case 2 : return String.class;
            case 3 : return String.class;
            case 4 : return String.class;
            case 5: return Integer.class;
            case 6 : return String.class;

        }
        return Object.class;
    }
    @Override
    public  boolean isCellEditable(int ligne, int colonne){
        return true;
    }

}



