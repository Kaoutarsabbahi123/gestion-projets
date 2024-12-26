package Presentation;

import Metier.Filiere;
import Metier.Gestionnaires.Gestionnaire_fil;
import Presentation.tools.ShadowButton;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class filiere_admi extends JFrame implements ActionListener {

    private JLabel LabelID;
    private JLabel Labelnomfil;
    private JLabel Labelnumdep;
    private JTextField Textfil;
    private JTextField Textdep;
    private JTextField TextID;

    private JButton Valider;
    private JButton Supprimer;
    private JButton modifier;
    private JButton retour;
    private JButton Afficher;
    private JFrame frame=new JFrame();
    private Gestionnaire_fil gest_fil=new Gestionnaire_fil();
    private String[] columns;
    private Object[][] rows;
    private ArrayList<Filiere> list;
    private Modelfil listfilp;
    private DefaultTableModel tablemodel;
    private JTable table;
    ImageIcon icon2 = new ImageIcon(this.getClass().getResource("/education (3).png"));
    Icon icon= new ImageIcon("C:\\back.png");
    Color c=new Color(0, 176, 255);
    public void initialiser() {
        LabelID = new JLabel("Id :");
        Labelnomfil = new JLabel("Nom filière :");
        Labelnumdep = new JLabel("Num département :");

        TextID = new JTextField();
        Textfil = new JTextField();
        Textdep = new JTextField();

        Valider= new ShadowButton("Valider",Color.decode("#0CB414"),Color.decode("#0CB414"));
        Supprimer = new ShadowButton("Supprimer",Color.decode("#FF0000"),Color.decode("#FF0000"));
        modifier = new ShadowButton("Modifier",c,c);
        Afficher=new ShadowButton("Afficher",c,c);
        retour=new JButton(icon);
        tablemodel = new DefaultTableModel(rows, columns);
    }
    public void dessiner() {
        JPanel panel=new JPanel();
        panel.setLayout(null);
        LabelID.setBounds(130,60,70,70);
        Labelnomfil.setBounds(130,90,100,70);
        Labelnumdep.setBounds(130,120,130,70);

        TextID.setBounds(330,85,200,20);
        Textfil.setBounds(330,115,200,20);
        Textdep.setBounds(330,145,200,20);

        Valider.setBounds(65,270,100,30);
        Valider.setBackground(Color.decode("#0CB414"));
        Supprimer.setBounds(195,270,100,30);
        Supprimer.setBackground(Color.decode("#FF0000"));
        modifier.setBounds(325,270,100,30);
        modifier.setBackground(c);
        Afficher.setBounds(455,270,100,30);
        Afficher.setBackground(c);

        retour.setBounds(0,2,31,31);
        retour.setOpaque(false);
        retour.setContentAreaFilled(false);
        retour.setBorderPainted(false);

        panel.add(LabelID);
        panel.add(TextID);
        panel.add(Labelnomfil);
        panel.add(Textfil);
        panel.add(Labelnumdep);
        panel.add(Textdep);

        panel.add(retour);
        panel.add(Valider);
        panel.add(Supprimer);
        panel.add(modifier);
        panel.add(Afficher);
        this.add(panel);
    }
    public filiere_admi() {
        this.setTitle("Filière");
        this.setMinimumSize(new Dimension(650,450));
        this.initialiser();
        this.dessiner();
        setIconImage(icon2.getImage());
        Valider.addActionListener(this);
        Supprimer.addActionListener(this);
        modifier.addActionListener(this);
        Afficher.addActionListener(this);
        retour.addActionListener( this);
        this.setVisible(true);

    }
    private void clearFields(){
        Textdep.setText(null);
        Textfil.setText(null);
        TextID.setText(null);
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Valider) {
            if (gest_fil.existe(Integer.valueOf(TextID.getText())) == 0) {
                Filiere f = new Filiere(Integer.valueOf(TextID.getText()), Textfil.getText(), Integer.valueOf(
                        Textdep.getText()));
                boolean test = gest_fil.ajout_fil(f);
                if (test) {
                    clearFields();
                    JOptionPane.showMessageDialog(null, "Ajout avec succés");
                } else {
                    JOptionPane.showMessageDialog(null, "échec", "Message d'erreur",
                            JOptionPane.ERROR_MESSAGE);
                }

            }
            else{
                JOptionPane.showMessageDialog(null, "Filière déjà existe", "Message d'erreur",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
        if (e.getSource() == Supprimer) {
            int  Id =Integer.valueOf(JOptionPane.showInputDialog("Donnez Numéro du filière à supprimer "));
            boolean test = gest_fil.sup_fil(Id);
            if (test) {
                JOptionPane.showMessageDialog(null, "Supression avec succés");
            } else {
                JOptionPane.showMessageDialog(null, "échec", "Message d'erreur",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
        if (e.getSource() == modifier) {
            if (gest_fil.existe(Integer.valueOf(TextID.getText())) == 1){
                Filiere f=new Filiere(Integer.valueOf(TextID.getText()),Textfil.getText(),Integer.valueOf(
                    Textdep.getText()));
            boolean test = gest_fil.modif_fil(f);
            if (test) {
                clearFields();
                JOptionPane.showMessageDialog(null, "Modifie avec succés");
            } else {
                JOptionPane.showMessageDialog(null, "échec", "Message d'erreur",
                        JOptionPane.ERROR_MESSAGE);
            }
            }else {
                JOptionPane.showMessageDialog(null, "la filière que vous pouvez modifer " +
                                "n'existe pas", "Message d'erreur",
                        JOptionPane.ERROR_MESSAGE);
            }

        }
        if (e.getSource() == Afficher) {
            list = gest_fil.getAll_fil();
            listfilp=new Modelfil(list);
            String[] columns = new String[]{listfilp.getColumnName(0),
                    listfilp.getColumnName(1),
                    listfilp.getColumnName(2)};
            Object[][] rows = new Object[listfilp.getRowCount()]
                    [listfilp.getColumnCount()];
            for (int i = 0; i < listfilp.getRowCount(); i++) {
                for (int j = 0; j < listfilp.getColumnCount(); j++) {
                    rows[i][j] = listfilp.getValueAt(i, j);
                }
            }
            frame.setLayout(new BorderLayout());
            tablemodel.setDataVector(rows,columns);
            tablemodel.fireTableDataChanged();
            table = new JTable(tablemodel);
            table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            frame.add(new JScrollPane(table),BorderLayout.CENTER);
            frame.setSize(900, 500);
            frame.show();
        }
        if(e.getSource()==retour){
            this.setVisible(false);
            Admin ad=new Admin();
        }
    }

}

