package Presentation;
import Metier.Etudiant;
import Metier.Gestionnaires.Gestionnaire_Etudiant;
import Presentation.tools.ShadowButton;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Etudiant_admi  extends JFrame implements ActionListener {
    private JLabel CNE;
    private JLabel nom;
    private JLabel prenom;
    private JLabel niveau;
    private JLabel filiere;
    private JLabel email;
    private JLabel labo;
    private JTextField Textcne;
    private JTextField Textnom;
    private JTextField Textpre;
    private JTextField Textfil;
    private JTextField Texteml;
    private JTextField Textlab;
    private JButton Valider;
    private JButton Supprimer;
    private JButton modifier;
    private JButton retour;
    private JButton Afficher;
    private Gestionnaire_Etudiant et=new Gestionnaire_Etudiant();
    private String[] columns;
    private Object[][] rows;
    private ArrayList<Etudiant> list;
    private ModelEtd listetuidiant;
    private DefaultTableModel tablemodel;
    private JTable table;
    private JComboBox niv;
    private JFrame frame=new JFrame();
    Icon icon= new ImageIcon("C:\\back.png");
    ImageIcon icon2 = new ImageIcon(this.getClass().getResource("/education (3).png"));
    Color c=new Color(0, 176, 255);
    public Etudiant_admi(){
        this.setTitle("Etudiant");
        this.initialiser();
        this.dessiner();
        this.setMinimumSize(new Dimension(750,550));
        setIconImage(icon2.getImage());
        Valider.addActionListener(this);
        Supprimer.addActionListener(this);
        modifier.addActionListener(this);
        Afficher.addActionListener(this);
        retour.addActionListener( this);
        this.setVisible(true);
    }
    public void initialiser() {
        CNE = new JLabel("CNE :");
        nom = new JLabel("Nom :");
        prenom = new JLabel("Prenom :");
        niveau = new JLabel("Niveau :");
        filiere = new JLabel("Filiere :");
        email = new JLabel("Email :");
        labo = new JLabel("Labo :");
        Textcne = new JTextField();
        Textnom = new JTextField();
        Textpre = new JTextField();
        String s4[]={"Doctorant","5éme","4éme"};
        niv=new JComboBox(s4);

        Textfil = new JTextField();
        Texteml = new JTextField();
        Textlab = new JTextField();
        Valider= new ShadowButton("Valider",Color.decode("#0CB414"),Color.decode("#0CB414"));
        Supprimer = new ShadowButton("Supprimer",Color.decode("#FF0000"),Color.decode("#FF0000"));
        modifier = new ShadowButton("Modifier",c,c);
        Afficher=new ShadowButton("Afficher",c,c);
        retour = new JButton(icon);

        tablemodel = new DefaultTableModel();
    }
        public void dessiner() {
            JPanel panel=new JPanel();
            panel.setLayout(null);

            CNE.setBounds(200, 30, 70, 70);
            nom.setBounds(200, 60, 70, 70);
            prenom.setBounds(200, 90, 70, 70);
            niveau.setBounds(200, 120, 70, 70);
            filiere.setBounds(200, 150, 70, 70);
            email.setBounds(200, 180, 70, 70);
            labo.setBounds(200, 210, 70, 70);

            Textcne.setBounds(300, 55, 200, 20);
            Textnom.setBounds(300, 85, 200, 20);
            Textpre.setBounds(300, 115, 200, 20);
            niv.setBounds(300, 145, 200, 20);
            niv.setBackground(Color.white);

            Textfil.setBounds(300, 175, 200, 20);
            Texteml.setBounds(300, 205, 200, 20);
            Textlab.setBounds(300, 235, 200, 20);

            Valider.setBounds(110, 300, 100, 30);
            Valider.setBackground(Color.decode("#0CB414"));
            Supprimer.setBounds(240, 300, 100, 30);
            Supprimer.setBackground(Color.decode("#FF0000"));
            modifier.setBounds(370, 300, 100, 30);
            modifier.setBackground(c);
            Afficher.setBounds(500, 300, 100, 30);
            Afficher.setBackground(c);

            retour.setBounds(0, 2, 31, 31);
            retour.setOpaque(false);
            retour.setContentAreaFilled(false);
            retour.setBorderPainted(false);
            panel.add(CNE);
            panel.add(nom);
            panel.add(prenom);
            panel.add(niveau);
            panel.add(filiere);
            panel.add(email);
            panel.add(labo);
            panel.add(Textcne);
            panel.add(Texteml);
            panel.add(Textlab);
            panel.add(niv);
            panel.add(Textfil);
            panel.add(Textpre);
            panel.add(Textnom);
            panel.add(retour);
            panel.add(Valider);
            panel.add(Supprimer);
            panel.add(modifier);
            panel.add(Afficher);
            this.add(panel);
        }
        private void clearFields(){
              Textlab.setText(null);
              Textnom.setText(null);
              Textpre.setText(null);
              Textfil.setText(null);
              Texteml.setText(null);
              Textcne.setText(null);
        }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Valider) {
            if(et.existe_etd(Textcne.getText())==0){
           Etudiant etd=new Etudiant(Textcne.getText(),Textnom.getText(),Textpre.getText(),String.valueOf(niv.getSelectedItem()),
                  Integer.valueOf(Textfil.getText()) ,Texteml.getText(),Integer.valueOf(Textlab.getText()));
            boolean test = et.ajouterEtudiant(etd);
            if (test) {
                clearFields();
                JOptionPane.showMessageDialog(null, "Ajout avec succés");
            } else {
                JOptionPane.showMessageDialog(null, "échec", "Message d'erreur",
                        JOptionPane.ERROR_MESSAGE);
            }

        }else{
                JOptionPane.showMessageDialog(null, "Etudiant déjà existe", "Message d'erreur",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
        if (e.getSource() == Supprimer) {
            String Id = JOptionPane.showInputDialog("Donnez CNE de l'etudiant à supprimer ");
            boolean test = et.supprimerEtudiant(Id);
            if (test) {
                JOptionPane.showMessageDialog(null, "Supression avec succés");
            } else {
                JOptionPane.showMessageDialog(null, "échec", "Message d'erreur",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
        if (e.getSource() == modifier) {
            if (et.existe_etd(Textcne.getText()) == 0) {
                Etudiant etd = new Etudiant(Textcne.getText(), Textnom.getText(), Textpre.getText(), String.valueOf(niv.getSelectedItem()),
                        Integer.valueOf(Textfil.getText()), Texteml.getText(), Integer.valueOf(Textlab.getText()));
                boolean test = et.modifier(etd);
                if (test) {
                    clearFields();
                    JOptionPane.showMessageDialog(null, "Modifie avec succés");
                } else {
                    JOptionPane.showMessageDialog(null, "échec", "Message d'erreur",
                            JOptionPane.ERROR_MESSAGE);
                }

            }
            else{
                JOptionPane.showMessageDialog(null, "l'étudiant que vous pouvez modifier " +
                                "n'existe pas", "Message d'erreur", JOptionPane.ERROR_MESSAGE);
            }
        }
        if (e.getSource() == Afficher) {
            list = et.getAll();
           listetuidiant= new ModelEtd(list);
            String[] columns = new String[]{listetuidiant.getColumnName(0),
                    listetuidiant.getColumnName(1),
                    listetuidiant.getColumnName(2),
                    listetuidiant.getColumnName(3),
                    listetuidiant.getColumnName(4),
                    listetuidiant.getColumnName(5),
                    listetuidiant.getColumnName(6)};
            Object[][] rows = new Object[listetuidiant.getRowCount()]
                    [listetuidiant.getColumnCount()];
            for (int i = 0; i < listetuidiant.getRowCount(); i++) {
                for (int j = 0; j < listetuidiant.getColumnCount(); j++) {
                    rows[i][j] = listetuidiant.getValueAt(i, j);
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
