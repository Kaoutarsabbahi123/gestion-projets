package Presentation;

import Metier.Gestionnaires.Gestionnaire_projet;
import Metier.Projet;
import Presentation.tools.ShadowButton;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
public class Projet_admi  extends JFrame implements ActionListener {


    private JLabel Labelprojet;
    private JLabel LabelTitre;
    private JLabel LabelType;
    private JLabel LabelDure;
    private JLabel LabelDatedepart;
    private JLabel LabelNentp;
    private JLabel LabelNCNE;

    private JTextField Textprojet;
    private JTextField TextTitre;
    private JComboBox TextType;
    private JTextField TextDure;
    private JTextField TextDatedepart;
    private JTextField TextNentp;
    private JTextField TextNCNE;

    private ShadowButton Valider;
    private ShadowButton Supprimer;
    private ShadowButton modifier;
    private JButton retour;
    private ShadowButton Afficher;
    private Gestionnaire_projet proj = new Gestionnaire_projet();
    private String[] columns;
    private Object[][] rows;
    private ArrayList<Projet> list;
    private Modelpr listprojet;
    private DefaultTableModel tablemodel;
    private JTable table;

    private JFrame frame = new JFrame();
    Icon icon = new ImageIcon("C:\\back.png");
    Color c = new Color(0, 176, 255);
    ImageIcon icon2 = new ImageIcon(this.getClass().getResource("/education (3).png"));

    public void initialiser() {
        Labelprojet = new JLabel("N° Projet :");
        LabelTitre = new JLabel("Titre :");
        LabelType = new JLabel("Type :");
        LabelDure = new JLabel("Durée :");
        LabelDatedepart = new JLabel("Date de départ :");

        LabelNentp = new JLabel("N° Entreprise :");

        LabelNCNE = new JLabel("N° CNE :");

        Textprojet = new JTextField();

        TextTitre = new JTextField();

        String s[] = {"PFA", "PFE", "Doctorat"};
        TextType = new JComboBox(s);

        TextType.setBackground(Color.white);
        TextDure = new JTextField();

        TextDatedepart = new JTextField();

        TextNentp = new JTextField();

        TextNCNE = new JTextField();

        Valider = new ShadowButton("Valider", Color.decode("#1EEF28"), Color.decode("#01EEF28"));
        Supprimer = new ShadowButton("Supprimer",Color.decode("#FF0000"), Color.decode("#FF0000"));

        modifier = new ShadowButton("Modifier",c, c);

        Afficher = new ShadowButton("Afficher", c, c);

        retour = new JButton(icon);

        tablemodel = new DefaultTableModel();

    }

    public void dessiner() {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        Labelprojet.setBounds(200, 30, 70, 70);
        LabelTitre.setBounds(200, 60, 70, 70);
        LabelType.setBounds(200, 90, 70, 70);
        LabelDure.setBounds(200, 120, 70, 70);
        LabelDatedepart.setBounds(200, 150, 100, 70);
        LabelNentp.setBounds(200, 180, 100, 70);
        LabelNCNE.setBounds(200, 210, 70, 70);

        Textprojet.setBounds(300, 55, 200, 20);
        TextTitre.setBounds(300, 85, 200, 20);

        TextType.setBounds(300, 115, 200, 20);
        TextType.setBackground(Color.white);

        TextDure.setBounds(300, 145, 200, 20);

        TextDatedepart.setBounds(300, 175, 200, 20);

        TextNentp.setBounds(300, 205, 200, 20);

        TextNCNE.setBounds(300, 235, 200, 20);

        Valider.setBounds(110, 320, 100, 30);
        Valider.setBackground(Color.decode("#0CB414"));
        Supprimer.setBounds(240, 320, 100, 30);
        Supprimer.setBackground(Color.decode("#FF0000"));
        modifier.setBounds(370, 320, 100, 30);
        modifier.setBackground(c);
        Afficher.setBounds(500, 320, 100, 30);
        Afficher.setBackground(c);

        retour.setBounds(0, 2, 31, 32);
        retour.setOpaque(false);
        retour.setContentAreaFilled(false);
        retour.setBorderPainted(false);

        frame.setSize(900, 500);

        panel.add(Labelprojet);
        panel.add(Textprojet);
        panel.add(LabelTitre);
        panel.add(TextTitre);
        panel.add(LabelType);
        panel.add(TextType);
        panel.add(LabelDure);
        panel.add(TextDure);
        panel.add(LabelDatedepart);
        panel.add(TextDatedepart);
        panel.add(LabelNentp);
        panel.add(TextNentp);
        panel.add(LabelNCNE);
        panel.add(TextNCNE);

        panel.add(retour);
        panel.add(Valider);
        panel.add(Supprimer);

        panel.add(modifier);
        panel.add(Afficher);
        this.add(panel);
    }

    public Projet_admi() {
        this.setTitle("Projet");
        this.initialiser();
        this.dessiner();
        this.setMinimumSize(new Dimension(750, 550));
        setIconImage(icon2.getImage());
        Valider.addActionListener(this);
        Supprimer.addActionListener(this);
        modifier.addActionListener(this);
        Afficher.addActionListener(this);
        retour.addActionListener(this);
        this.setVisible(true);
    }
    private void clearFields(){
        TextNCNE.setText(null);
        TextNentp.setText(null);
        TextTitre.setText(null);
        TextDatedepart.setText(null);
        Textprojet.setText(null);
        TextDure.setText(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Valider) {
            if (proj.existe_projet(Integer.valueOf(Textprojet.getText())) == 0) {
                Projet p = new Projet(Integer.valueOf(Textprojet.getText()), TextDure.getText(), TextDatedepart.getText(),
                        TextTitre.getText(), String.valueOf(TextType.getSelectedItem()), Integer.valueOf(TextNentp.getText()), TextNCNE.getText());
                boolean test = proj.ajout_proj(p);
                if (test) {
                    clearFields();
                    JOptionPane.showMessageDialog(null, "Ajout avec succés");
                } else {
                    JOptionPane.showMessageDialog(null, "échec", "Message d'erreur",
                            JOptionPane.ERROR_MESSAGE);
                }

            }
            else{
                JOptionPane.showMessageDialog(null, "Projet déjà existe", "Message d'erreur",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
        if (e.getSource() == Supprimer) {
            int Id = Integer.valueOf(JOptionPane.showInputDialog("Donnez Numéro du projet à supprimer "));
            boolean test = proj.sup_proj(Id);
            if (test) {
                JOptionPane.showMessageDialog(null, "Supression avec succés");
            } else {
                JOptionPane.showMessageDialog(null, "échec", "Message d'erreur",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
        if (e.getSource() == modifier) {
            if (proj.existe_projet(Integer.valueOf(Textprojet.getText())) == 1) {
                Projet p = new Projet(Integer.valueOf(Textprojet.getText()), TextDure.getText(), TextDatedepart.getText(),
                        TextTitre.getText(), String.valueOf(TextType.getSelectedItem()), Integer.valueOf(TextNentp.getText()), TextNCNE.getText());
                boolean test = proj.modif_proj(p);
                if (test) {
                    clearFields();
                    JOptionPane.showMessageDialog(null, "Modifie avec succés");
                } else {
                    JOptionPane.showMessageDialog(null, "échec", "Message d'erreur",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
            else {
                JOptionPane.showMessageDialog(null, "le Projet que vous pouvez modifier " +
                                "n'existe pas", "Message d'erreur", JOptionPane.ERROR_MESSAGE);
            }
        }
        if (e.getSource() == Afficher) {
            list = proj.getAllProj();
            listprojet = new Modelpr(list);
            String[] columns = new String[]{listprojet.getColumnName(0),
                    listprojet.getColumnName(1),
                    listprojet.getColumnName(2),
                    listprojet.getColumnName(3),
                    listprojet.getColumnName(4),
                    listprojet.getColumnName(5),
                    listprojet.getColumnName(6),
            };
            Object[][] rows = new Object[listprojet.getRowCount()]
                    [listprojet.getColumnCount()];
            for (int i = 0; i < listprojet.getRowCount(); i++) {
                for (int j = 0; j < listprojet.getColumnCount(); j++) {
                    rows[i][j] = listprojet.getValueAt(i, j);
                }
            }
            tablemodel.setDataVector(rows, columns);
            tablemodel.fireTableDataChanged();
            table = new JTable(tablemodel);
            table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            frame.add(new JScrollPane(table));
            frame.show();
        }
        if (e.getSource() == retour) {
            this.setVisible(false);
            Admin ad = new Admin();
        }

    }

}




