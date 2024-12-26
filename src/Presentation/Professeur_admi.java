package Presentation;
import Metier.Gestionnaires.Gestionnaire_prof;
import Metier.Professeur;
import Presentation.tools.ShadowButton;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Professeur_admi extends JFrame implements ActionListener {
    private JLabel LabelNom;
    private JLabel LabelPrenom;
    private JLabel LabelEmail;
    private JLabel LabelID;
    private JLabel LabelGrade;
    private JLabel LabelEtat;
    private JLabel Labellibelle;
    private JLabel Labelrole;
    private JLabel fil;
    private JLabel labo;
    private JLabel dep;
    private JTextField Textfil;
    private JTextField Textlabo;
    private JTextField Textdep;
    private JTextField TextNom;
    private JTextField TextPrenom;
    private JTextField TextEmail;
    private JTextField TextID;
    private JTextField  TextEtat;
    private JTextField  Textlibelle;
    private JTextField  Textrole;
    private ShadowButton Valider;
    private ShadowButton Supprimer;
    private ShadowButton modifier;
    private ShadowButton Archiver;
    private JButton retour;
    private ShadowButton Afficher;
    private Gestionnaire_prof Prof=new Gestionnaire_prof();
    private String[] columns;
    private Object[][] rows;
    private ArrayList<Professeur> list;
    private ModelProf listProfesseur;
    private DefaultTableModel tablemodel;
    private JTable table;
    private JComboBox grade;
    private JComboBox etat;
    private JComboBox libelle;
    private JComboBox role;
    private JFrame frame=new JFrame();
    ImageIcon icon2 = new ImageIcon(this.getClass().getResource("/education (3).png"));
    Icon icon= new ImageIcon("C:\\back.png");
    Color c=new Color(0, 176, 255);
    public void initialiser() {
        LabelID = new JLabel("Id :");
        LabelNom = new JLabel("Nom :");
        LabelPrenom = new JLabel("Prenom :");
        LabelEmail = new JLabel("Email :");
        LabelGrade = new JLabel("Grade :");
        LabelEtat=new JLabel("Etat :");
        Labellibelle=new JLabel("Libelle :");
        Labelrole=new JLabel("Role :");
        fil=new JLabel("Num_filiére :");
        dep=new JLabel("Num_département :");
        labo=new JLabel("Num_laboratoire :");
        TextID = new JTextField();
        TextNom = new JTextField();
        TextPrenom = new JTextField();
        TextEmail = new JTextField();
        String s1[]={"PES","PH"};
        grade=new JComboBox(s1);

        String s2[]={"Archive","Active"};
        etat=new JComboBox(s2);

        String s3[]={"Professeur","Chef de filière","Chef de département"};
        libelle=new JComboBox(s3);

        String s4[]={"Responsable","Membre"};
        role=new JComboBox(s4);

        Textfil=new JTextField();
        Textdep=new JTextField();
        Textlabo=new JTextField();
        Valider= new ShadowButton("Valider",Color.decode("#0CB414"),Color.decode("#0CB414"));
        Supprimer = new ShadowButton("Supprimer",Color.decode("#FF0000"),Color.decode("#FF0000"));
        Archiver = new ShadowButton("Archiver",c,c);
        modifier = new ShadowButton("Modifier",c,c);
        Afficher=new ShadowButton("Afficher",c,c);
        retour=new JButton(icon);
        tablemodel = new DefaultTableModel();
    }
    public void dessiner() {
        JPanel panel=new JPanel();
        panel.setLayout(null);
        LabelID.setBounds(200,30,70,70);
        LabelNom.setBounds(200,60,70,70);
        LabelPrenom.setBounds(200,90,70,70);
        LabelEmail.setBounds(200,120,70,70);
        LabelGrade.setBounds(200,150,70,70);
        LabelEtat.setBounds(200,180,70,70);
        Labellibelle.setBounds(200,210,70,70);
        Labelrole.setBounds(200,240,70,70);
        fil.setBounds(200,270,170,70);
        dep.setBounds(200,300,170,70);
        labo.setBounds(200,330,170,70);
        TextID.setBounds(350,55,200,20);
        TextNom.setBounds(350,85,200,20);
        TextPrenom.setBounds(350,115,200,20);
        TextEmail.setBounds(350,145,200,20);

        grade.setBounds(350,175,200,20);
        grade.setBackground(Color.white);

        etat.setBounds(350,205,200,20);
        etat.setBackground(Color.white);

        libelle.setBounds(350,235,200,20);
        libelle.setBackground(Color.white);

        role.setBounds(350,265,200,20);
        role.setBackground(Color.white);
        Textfil.setBounds(350,295,200,20);
        Textdep.setBounds(350,325,200,20);
        Textlabo.setBounds(350,355,200,20);
        Valider.setBounds(60,410,100,30);
        Valider.setBackground(Color.decode("#0CB414"));
        Supprimer.setBounds(190,410,100,30);
        Supprimer.setBackground(Color.decode("#FF0000"));
        Archiver.setBounds(320,410,100,30);
        Archiver.setBackground(c);
        modifier.setBounds(450,410,100,30);
        modifier.setBackground(c);
        Afficher.setBounds(580,410,100,30);
        Afficher.setBackground(c);

        retour.setBounds(0,2,31,31);
        retour.setOpaque(false);
        retour.setContentAreaFilled(false);
        retour.setBorderPainted(false);
        panel.add(LabelID);
        panel.add(TextID);
        panel.add(LabelNom);
        panel.add(TextNom);
        panel.add(LabelPrenom);
        panel.add(TextPrenom);
        panel.add(LabelEmail);
        panel.add(TextEmail);
        panel.add(LabelGrade);
        panel.add(grade);
        panel.add(Labellibelle);
        panel.add(libelle);
        panel.add(LabelEtat);
        panel.add(etat);
        panel.add(Labelrole);
        panel.add(role);
        panel.add(fil);
        panel.add(Textfil);
        panel.add(dep);
        panel.add(Textdep);
        panel.add(labo);
        panel.add(Textlabo);
        panel.add(retour);
        panel.add(Valider);
        panel.add(Supprimer);
        panel.add(Archiver);
        panel.add(modifier);
        panel.add(Afficher);
        this.add(panel);
    }
    public Professeur_admi() {
        this.setTitle("Professeur");
        this.initialiser();
        this.dessiner();
        this.setMinimumSize(new Dimension(750,550));
        setIconImage(icon2.getImage());
        Valider.addActionListener(this);
        Supprimer.addActionListener(this);
        Archiver.addActionListener(this);
        modifier.addActionListener(this);
        Afficher.addActionListener(this);
        retour.addActionListener( this);
        this.setVisible(true);
    }
    private void clearFields(){
        Textfil.setText(null);
        Textlabo.setText(null);
        TextEmail.setText(null);
        TextID.setText(null);
        TextPrenom.setText(null);
        TextNom.setText(null);
        TextEmail.setText(null);
        Textdep.setText(null);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Valider) {
            if(Prof.existe_prof(Integer.valueOf(TextID.getText()))==0) {
                Professeur p = new Professeur(Integer.valueOf(TextID.getText()), TextNom.getText()
                        , TextPrenom.getText(), TextEmail.getText()
                        , String.valueOf(grade.getSelectedItem()), String.valueOf(etat.getSelectedItem()),
                        String.valueOf(libelle.getSelectedItem())
                        , String.valueOf(role.getSelectedItem()), Integer.valueOf(Textdep.getText()),
                        Integer.valueOf(Textlabo.getText()), Integer.valueOf(Textfil.getText()));
                boolean test = Prof.ajout_prof(p);
                if (test) {
                    clearFields();
                    JOptionPane.showMessageDialog(null, "Ajout avec succés");
                } else {
                    JOptionPane.showMessageDialog(null, "échec", "Message d'erreur",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "professeur déjà existe", "Message d'erreur",
                        JOptionPane.ERROR_MESSAGE);
            }

        }
        if (e.getSource() == Supprimer) {
            int Id = Integer.valueOf(JOptionPane.showInputDialog("Donnez l'Id du Professeur à supprimé "));
            boolean test = Prof.sup_prof(Id);
            if (test) {
                JOptionPane.showMessageDialog(null, "Supression avec succés");
            } else {
                JOptionPane.showMessageDialog(null, "échec", "Message d'erreur",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
        if (e.getSource() == Archiver) {
            int Id = Integer.valueOf(JOptionPane.showInputDialog("Donnez l'Id du Professeur à archivé "));
            boolean test = Prof.archive(Id);
            if (test) {
                JOptionPane.showMessageDialog(null, "Archive avec succés");
                JOptionPane.showMessageDialog(null, "échec", "Message d'erreur", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "échec", "Message d'erreur", JOptionPane.ERROR_MESSAGE);

            }
        }
        if (e.getSource() == modifier) {
            if(Prof.existe_prof(Integer.valueOf(TextID.getText()))==1) {
                Professeur p = new Professeur(Integer.valueOf(TextID.getText()), TextNom.getText()
                        , TextPrenom.getText(), TextEmail.getText()
                        , String.valueOf(grade.getSelectedItem()), String.valueOf(etat.getSelectedItem()),
                        String.valueOf(libelle.getSelectedItem())
                        , String.valueOf(role.getSelectedItem()), Integer.valueOf(Textdep.getText()),
                        Integer.valueOf(Textlabo.getText()), Integer.valueOf(Textfil.getText()));
                boolean test = Prof.modif_prof(p);
                if (test) {
                    clearFields();
                    JOptionPane.showMessageDialog(null, "Modifie avec succés");
                } else {
                    JOptionPane.showMessageDialog(null, "échec", "Message d'erreur",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "le Professeur que vous pouvez modifier " +
                                "n'existe pas", "Message d'erreur",
                        JOptionPane.ERROR_MESSAGE);
            }

        }
        if (e.getSource() == Afficher) {
            list = Prof.get_prof();
            listProfesseur = new ModelProf(list);
            String[] columns = new String[]{listProfesseur.getColumnName(0),
                    listProfesseur.getColumnName(1),
                    listProfesseur.getColumnName(2),
                    listProfesseur.getColumnName(3),
                    listProfesseur.getColumnName(4),
                    listProfesseur.getColumnName(5),
                    listProfesseur.getColumnName(6),
                    listProfesseur.getColumnName(7),
                    listProfesseur.getColumnName(8),
                    listProfesseur.getColumnName(9),
                    listProfesseur.getColumnName(10)};
            Object[][] rows = new Object[listProfesseur.getRowCount()]
                    [listProfesseur.getColumnCount()];
            for (int i = 0; i < listProfesseur.getRowCount(); i++) {
                for (int j = 0; j < listProfesseur.getColumnCount(); j++) {
                    rows[i][j] = listProfesseur.getValueAt(i, j);
                }
            }
            tablemodel.setDataVector(rows,columns);
            tablemodel.fireTableDataChanged();
            table = new JTable(tablemodel);
            table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            frame.add(new JScrollPane(table));
            frame.setSize(900, 500);
            frame.show();
        }
        if(e.getSource()==retour){
            this.setVisible(false);
            Admin ad=new Admin();
        }
    }
}
