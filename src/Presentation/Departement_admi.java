package Presentation;
import Metier.Gestionnaires.Gestionnaire_dep;
import Metier.Departement;
import Presentation.Modeldep;
import Presentation.tools.ShadowButton;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
public class Departement_admi extends JFrame implements ActionListener{
    private JLabel LabelID;
    private JLabel Labelemail;
    private JLabel Labelnomdep;
    private JTextField Textemail;
    private JTextField Textdep;
    private JTextField TextID;

    private JButton Valider;
    private JButton Supprimer;
    private JButton modifier;
    private JButton retour;
    private JButton Afficher;
    private JFrame frame=new JFrame();
    private Gestionnaire_dep d=new Gestionnaire_dep();
    private String[] columns;
    private Object[][] rows;
    private ArrayList<Departement> list;
    private Modeldep listdep;
    private DefaultTableModel tablemodel;
    private JTable table;

    ImageIcon icon2 = new ImageIcon(this.getClass().getResource("/education (3).png"));
    Icon icon= new ImageIcon("C:\\back.png");
    Color c=new Color(0, 176, 255);
    public void initialiser() {
        LabelID = new JLabel("Id :");
        Labelemail = new JLabel("Email :");
        Labelnomdep = new JLabel("Nom département :");



        TextID = new JTextField();
        Textdep = new JTextField();
        Textemail= new JTextField();


        Valider= new ShadowButton("Valider",Color.decode("#0CB414"),Color.decode("#0CB414"));
        Supprimer = new ShadowButton("Supprimer",Color.decode("#FF0000"),Color.decode("#FF0000"));
        modifier = new ShadowButton("Modifier",c,c);
        Afficher=new ShadowButton("Afficher",c,c);
        retour=new JButton(icon);
        tablemodel = new DefaultTableModel();
    }
    public void dessiner() {
        JPanel panel=new JPanel();
        panel.setLayout(null);
        LabelID.setBounds(130,60,70,70);
        Labelemail.setBounds(130,120,100,70);
        Labelnomdep.setBounds(130,90,130,70);

        TextID.setBounds(330,85,200,20);
        Textdep.setBounds(330,145,200,20);
        Textemail.setBounds(330,115,200,20);


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
        panel.add(Labelemail);
        panel.add(Textemail);
        panel.add(Labelnomdep);
        panel.add(Textdep);

        panel.add(retour);
        panel.add(Valider);
        panel.add(Supprimer);
        panel.add(modifier);
        panel.add(Afficher);
        this.add(panel);
    }
    public Departement_admi() {
        this.setTitle("Département");
        this.initialiser();
        this.dessiner();
        this.setMinimumSize(new Dimension(650,450));
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
        Textemail.setText(null);
        TextID.setText(null);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Valider) {
            if (d.existe_dep(Integer.valueOf(TextID.getText())) == 0) {
                Departement dep = new Departement(Integer.valueOf(TextID.getText()), Textdep.getText(),
                        Textemail.getText());
                boolean test = d.ajout_dep(dep);
                if (test) {
                    clearFields();
                    JOptionPane.showMessageDialog(null, "Ajout avec succés");
                } else {
                    JOptionPane.showMessageDialog(null, "échec", "Message d'erreur",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
            else {
                JOptionPane.showMessageDialog(null, "Département déjà existe", "Message d'erreur",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
        if (e.getSource() == Supprimer) {
            int  Id =Integer.valueOf(JOptionPane.showInputDialog("Donnez Numéro du département à supprimer "));
            boolean test = d.sup_dep(Id);
            if (test) {
                JOptionPane.showMessageDialog(null, "Supression avec succés");
            } else {
                JOptionPane.showMessageDialog(null, "échec", "Message d'erreur",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
        if (e.getSource() == modifier) {
            if (d.existe_dep(Integer.valueOf(TextID.getText())) == 0) {
                Departement dep = new Departement(Integer.valueOf(TextID.getText()), Textdep.getText(),
                        Textemail.getText());
                boolean test = d.modif_dep(dep);
                if (test) {
                    clearFields();
                    JOptionPane.showMessageDialog(null, "Modifie avec succés");
                } else {
                    JOptionPane.showMessageDialog(null, "échec", "Message d'erreur",
                            JOptionPane.ERROR_MESSAGE);
                }
            }else {
                JOptionPane.showMessageDialog(null, "le département que vous pouvez modifier" +
                                "n'existe pas", "Message d'erreur",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
        if (e.getSource() == Afficher) {
            list = d.getAllDep();
            listdep= new Modeldep(list);
            String[] columns = new String[]{listdep.getColumnName(0),
                    listdep.getColumnName(1),
                    listdep.getColumnName(2)};
            Object[][] rows = new Object[listdep.getRowCount()]
                    [listdep.getColumnCount()];
            for (int i = 0; i < listdep.getRowCount(); i++) {
                for (int j = 0; j < listdep.getColumnCount(); j++) {
                    rows[i][j] = listdep.getValueAt(i, j);
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

