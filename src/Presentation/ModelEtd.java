package Presentation;
import Metier.Etudiant;
import Metier.Filiere;
import Metier.Professeur;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class ModelEtd extends AbstractTableModel{
    private ArrayList<Etudiant> list;

    public ModelEtd(ArrayList<Etudiant> list) {
        this.list = list;
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return Etudiant.getAttribut().length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return list.get(rowIndex).get(columnIndex);
    }
    @Override
    public  boolean isCellEditable(int ligne, int colonne){
        return true;
    }
    @Override
    public String getColumnName(int i){
        return Etudiant.getAttribut()[i];
    }
    @Override
    public Class getColumnClass(int i ) {
        switch (i){
            case 0 : return Integer.class;
            case 1 : return String.class;
            case 2 : return String.class;
            case 3 : return String.class;
            case 4 : return Integer.class;
            case 5: return String.class;
            case 6 : return Integer.class;

        }
        return Object.class;
    }
}
