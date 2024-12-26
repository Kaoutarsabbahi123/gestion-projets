package Presentation;
import Metier.Gestionnaires.Gestionnaire_labo;
import Metier.laboratoire;
import Presentation.tools.ShadowButton;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class labo_admin   extends JFrame implements ActionListener{


        private JLabel LabelLabo;
        private JLabel LabelNom;
        private JLabel Labelemail;
        private JLabel LabelNtel;
        private JLabel LabelAdrs;


        private JTextField TextLabo;
        private JTextField TextNom;
        private JTextField TextEmail;
        private JTextField TextAdresse;
        private JTextField TextNtel;



        private ShadowButton Valider;
        private ShadowButton Supprimer;
        private ShadowButton modifier;
        private JButton retour;
        private ShadowButton Afficher;

        private Gestionnaire_labo gest=new Gestionnaire_labo();
        private String[] columns;
        private Object[][] rows;
        private ArrayList<laboratoire> list;
        private Modellabo listlabo;
        private DefaultTableModel tablemodel;
        private JTable table;
        private JFrame frame=new JFrame() ;
        ImageIcon icon2 = new ImageIcon(this.getClass().getResource("/education (3).png"));
        Icon icon= new ImageIcon("C:\\back.png");
        Color c=new Color(0, 176, 255);
        public void initialiser() {
            LabelLabo = new JLabel("N° Laboratoire :");
            LabelNom = new JLabel("Nom laboratoire :");
            LabelAdrs= new JLabel("Adresse :");
            LabelNtel= new JLabel("N° de telephone :");
            Labelemail= new JLabel("Email :");

            TextLabo = new JTextField();
            TextNom = new JTextField();
            TextAdresse = new JTextField();
            TextNtel= new JTextField();
            TextEmail= new JTextField();

            Valider = new ShadowButton("Valider", Color.decode("#1EEF28"), Color.decode("#01EEF28"));
            Supprimer = new ShadowButton("Supprimer",Color.decode("#FF0000"), Color.decode("#FF0000"));

            modifier = new ShadowButton("Modifier",c, c);

            Afficher = new ShadowButton("Afficher", c, c);
            retour=new JButton(icon);

            tablemodel = new DefaultTableModel();
        }
        public void dessiner() {
            JPanel panel=new JPanel();
            panel.setLayout(null);

            LabelLabo.setBounds(200,30,100,70);
            LabelNom.setBounds(200,60,150,70);
            LabelAdrs.setBounds(200,90,70,70);
            LabelNtel.setBounds(200,120,130,70);
            Labelemail.setBounds(200,150,70,70);

            TextLabo.setBounds(310,55,200,20);
            TextNom.setBounds(310,85,200,20);
            TextAdresse.setBounds(310,115,200,20);
            TextNtel.setBounds(310,145,200,20);
            TextEmail.setBounds(310,175,200,20);
            Valider.setBounds(100,290,100,30);

            Valider.setBounds(110, 250, 100, 30);
            Valider.setBackground(Color.decode("#0CB414"));
            Supprimer.setBounds(240, 250, 100, 30);
            Supprimer.setBackground(Color.decode("#FF0000"));
            modifier.setBounds(370, 250, 100, 30);
            modifier.setBackground(c);
            Afficher.setBounds(500, 250, 100, 30);
            Afficher.setBackground(c);

            retour.setBounds(0,2,31,31);
            retour.setOpaque(false);
            retour.setContentAreaFilled(false);
            retour.setBorderPainted(false);

            frame.setLayout(new BorderLayout());
            frame.setSize(900, 500);

            panel.add(LabelLabo);
            panel.add(TextLabo);
            panel.add(LabelNom);
            panel.add(TextNom);
            panel.add(LabelAdrs);
            panel.add(TextAdresse);
            panel.add(LabelNtel);
            panel.add(TextNtel);
            panel.add(Labelemail);
            panel.add(TextEmail);




            panel.add(retour);
            panel.add(Valider);
            panel.add(Supprimer);
            panel.add(modifier);
            panel.add(Afficher);
            this.add(panel);
        }
        public labo_admin() {
            this.setTitle("Laboratoire");
            this.initialiser();
            this.dessiner();
            this.setMinimumSize(new Dimension(700,450));
            setIconImage(icon2.getImage());
            Valider.addActionListener(this);
            Supprimer.addActionListener(this);
            modifier.addActionListener(this);
            Afficher.addActionListener(this);
            retour.addActionListener( this);
            this.setVisible(true);

        }
        public void ClearField(){
            TextLabo.setText(null);
            TextLabo.setText(null);
            TextNom.setText(null);
            TextEmail.setText(null);
            TextNtel.setText(null);
            TextAdresse.setText(null);
        }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Valider) {
            if (gest.existe_labo(Integer.valueOf(TextLabo.getText())) == 0) {
                laboratoire l = new laboratoire(TextNom.getText(), Integer.valueOf(TextLabo.getText()), TextEmail.getText(),
                        TextNtel.getText(), TextAdresse.getText());
                boolean test = gest.ajout_labo(l);
                if (test) {
                    ClearField();
                    JOptionPane.showMessageDialog(null, "Ajout avec succés");
                } else {
                    JOptionPane.showMessageDialog(null, "échec", "Message d'erreur",
                            JOptionPane.ERROR_MESSAGE);
                }

            }else{
                JOptionPane.showMessageDialog(null, "Laboratoire déjà existe", "Message d'erreur",
                        JOptionPane.ERROR_MESSAGE);
            }

        }
        if (e.getSource() == Supprimer) {
            int  Id =Integer.valueOf(JOptionPane.showInputDialog("Donnez Numéro du laboratoire à supprimer "));
            boolean test =gest.sup_labo(Id);
            if (test) {
                JOptionPane.showMessageDialog(null, "Supression avec succés");
            } else {
                JOptionPane.showMessageDialog(null, "échec", "Message d'erreur",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
        if (e.getSource() == modifier) {
            if (gest.existe_labo(Integer.valueOf(TextLabo.getText())) == 1) {
                laboratoire l = new laboratoire(TextNom.getText(), Integer.valueOf(TextLabo.getText()), TextEmail.getText(),
                        TextNtel.getText(), TextAdresse.getText());
                boolean test = gest.modif_labo(l);
                if (test) {
                    ClearField();
                    JOptionPane.showMessageDialog(null, "Modifie avec succés");
                } else {
                    JOptionPane.showMessageDialog(null, "échec", "Message d'erreur",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
            else {
                JOptionPane.showMessageDialog(null, "le laboratoire que vouz pouvez modifier" +
                                "n'existe pas", "Message d'erreur",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
        if (e.getSource() == Afficher) {
            list = gest.getAllLabo();
            listlabo=new Modellabo(list);
            String[] columns = new String[]{listlabo.getColumnName(0),
                    listlabo.getColumnName(1),
                    listlabo.getColumnName(2),listlabo.getColumnName(3),
                    listlabo.getColumnName(4)
            };
            Object[][] rows = new Object[listlabo.getRowCount()]
                    [listlabo.getColumnCount()];
            for (int i = 0; i < listlabo.getRowCount(); i++) {
                for (int j = 0; j < listlabo.getColumnCount(); j++) {
                    rows[i][j] = listlabo.getValueAt(i, j);
                }
            }
            tablemodel.setDataVector(rows, columns);
            tablemodel.fireTableDataChanged();
            table = new JTable(tablemodel);
            frame.add(new JScrollPane(table),BorderLayout.CENTER);
            frame.show();
        }
        if(e.getSource()==retour){
            this.setVisible(false);
            Admin ad=new Admin();
        }
    }
    }
