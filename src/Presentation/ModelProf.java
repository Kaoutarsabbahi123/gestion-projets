package Presentation;
import Metier.Professeur;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
public class ModelProf extends AbstractTableModel{
     private ArrayList<Professeur> list;
    public ModelProf(ArrayList<Professeur> list) {
        super();
        this.list = list;
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return Professeur.getAttribut().length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        return list.get(rowIndex).get(columnIndex);
    }
    @Override
    public String getColumnName(int i){
        return Professeur.getAttribut()[i];
    }
    @Override
    public Class getColumnClass(int i ) {
        switch (i){
            case 0 : return Integer.class;
            case 1 : return String.class;
            case 2 : return String.class;
            case 3 : return String.class;
            case 4 : return String.class;
            case 5: return String.class;
            case 6 : return String.class;
            case 7: return String.class;
            case 8: return Integer.class;
            case 9 : return Integer.class;
            case 10: return Integer.class;
        }
        return Object.class;
    }
    @Override
    public  boolean isCellEditable(int ligne, int colonne){
        return true;
    }

    }

