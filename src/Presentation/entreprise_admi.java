package Presentation;

import Metier.Gestionnaires.Gestionnaire_Ent;
import Metier.entreprise;
import Presentation.Modelentrp;
import Presentation.tools.ShadowButton;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
    public class entreprise_admi  extends JFrame implements ActionListener {

        private JLabel Labelentrp;
        private JLabel Labelnumtele;
        private JLabel Labelemail;
        private JLabel Labeladrs;
        private JLabel Labelrespo;
        private JLabel Labelraison_s;


        private JTextField Textnumentrp;
        private JTextField TextTele;
        private JTextField TextEmail;
        private JTextField TextAdresse;
        private JTextField TextRespo;
        private JTextField TextRaison_s;


        private ShadowButton Valider;
        private ShadowButton Supprimer;
        private ShadowButton modifier;
        private JButton retour;
        private ShadowButton Afficher;

        private Gestionnaire_Ent gest_ent=new Gestionnaire_Ent();
        private String[] columns;
        private Object[][] rows;
        private ArrayList<entreprise> list;
        private Modelentrp listentrp;
        private DefaultTableModel tablemodel;
        private JTable table;
        ImageIcon icon2 = new ImageIcon(this.getClass().getResource("/education (3).png"));
        private JFrame frame=new JFrame() ;
        Icon icon= new ImageIcon("C:\\back.png");
        Color c=new Color(0, 176, 255);
        public void initialiser() {
            Labelentrp = new JLabel("N° Entreprise :");
            Labelrespo = new JLabel("Responsable :");
            Labelraison_s=new JLabel("Raison sociale :");
            Labeladrs= new JLabel("Adresse :");
            Labelnumtele= new JLabel("N° de telephone :");
            Labelemail= new JLabel("Email :");

            Textnumentrp = new JTextField();
            TextRespo = new JTextField();
            TextRaison_s=new JTextField();
            TextTele = new JTextField();
            TextEmail= new JTextField();
            TextAdresse = new JTextField();

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
            Labelentrp.setBounds(200,30,90,70);
            Labelrespo.setBounds(200,60,100,70);
            Labelraison_s.setBounds(200,90,100,70);
            Labeladrs.setBounds(200,120,70,70);
            Labelnumtele.setBounds(200,150,130,70);
            Labelemail.setBounds(200,180,70,70);

            Textnumentrp.setBounds(310,55,200,20);
            TextRespo.setBounds(310,85,200,20);
            TextRaison_s.setBounds(310,115,200,20);
            TextTele.setBounds(310,145,200,20);
            TextEmail.setBounds(310,175,200,20);
            TextAdresse.setBounds(310,205,200,20);

            Valider.setBounds(100,320,100,30);
            Valider.setBackground(Color.decode("#0CB414"));
            Supprimer.setBounds(230,320,100,30);
            Supprimer.setBackground(Color.decode("#FF0000"));
            modifier.setBounds(360,320,100,30);
            modifier.setBackground(c);
            Afficher.setBounds(490,320,100,30);
            Afficher.setBackground(c);

            retour.setBounds(0,2,31,31);
            retour.setOpaque(false);
            retour.setContentAreaFilled(false);
            retour.setBorderPainted(false);

            tablemodel = new DefaultTableModel();

            frame.setLayout(new BorderLayout());
            frame.setSize(900, 500);

            panel.add(Labelentrp);
            panel.add(Textnumentrp);
            panel.add(Labelrespo);
            panel.add(TextRespo);
            panel.add(Labelraison_s);
            panel.add(TextRaison_s);
            panel.add(Labeladrs);
            panel.add(TextAdresse);
            panel.add(Labelnumtele);
            panel.add(TextTele);
            panel.add(Labelemail);
            panel.add(TextEmail);

            panel.add(retour);
            panel.add(Valider);
            panel.add(Supprimer);

            panel.add(modifier);
            panel.add(Afficher);
            this.add(panel);
        }
        public entreprise_admi() {
            this.setTitle("Entreprise");
            this.initialiser();
            this.dessiner();
            this.setMinimumSize(new Dimension(700,490));
            setIconImage(icon2.getImage());
            Valider.addActionListener(this);
            Supprimer.addActionListener(this);
            modifier.addActionListener(this);
            Afficher.addActionListener(this);
            retour.addActionListener( this);
            this.setVisible(true);
        }
        private void clearFields(){
            TextAdresse.setText(null);
            TextEmail.setText(null);
            Textnumentrp.setText(null);
            TextRespo.setText(null);
            TextRaison_s.setText(null);
            TextTele.setText(null);
        }
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == Valider) {
                if (gest_ent.existe_ent(Integer.valueOf(Textnumentrp.getText()))== 0) {
                    entreprise etp = new entreprise(Integer.valueOf(Textnumentrp.getText()), TextTele.getText(), TextEmail.getText(),
                            TextAdresse.getText(), TextRespo.getText(), TextRaison_s.getText());
                    boolean test = gest_ent.ajout_entrp(etp);
                    if (test) {
                        clearFields();
                        JOptionPane.showMessageDialog(null, "Ajout avec succés");
                    } else {
                        JOptionPane.showMessageDialog(null, "échec", "Message d'erreur",
                                JOptionPane.ERROR_MESSAGE);
                    }

                }
                else {
                    JOptionPane.showMessageDialog(null, "Entreprise déjà existe", "Message d'erreur",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
            if (e.getSource() == Supprimer) {
                int  Id =Integer.valueOf(JOptionPane.showInputDialog("Donnez Numéro d'entreprise à supprimer "));
                boolean test =gest_ent.sup_entrp(Id);
                if (test) {
                    JOptionPane.showMessageDialog(null, "Supression avec succés");
                } else {
                    JOptionPane.showMessageDialog(null, "échec", "Message d'erreur",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
            if (e.getSource() == modifier) {
                if (gest_ent.existe_ent(Integer.valueOf(Textnumentrp.getText())) == 1) {
                    entreprise etp = new entreprise(Integer.valueOf(Textnumentrp.getText()), TextTele.getText(), TextEmail.getText(),
                            TextAdresse.getText(), TextRespo.getText(), TextRaison_s.getText());
                    boolean test = gest_ent.modif_entrp(etp);
                    if (test) {
                        clearFields();
                        JOptionPane.showMessageDialog(null, "Modifie avec succés");
                    } else {
                        JOptionPane.showMessageDialog(null, "échec", "Message d'erreur",
                                JOptionPane.ERROR_MESSAGE);
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "l'entreprise que vous pouvez modifier" +
                                    "déjà n'existe", "Message d'erreur",
                            JOptionPane.ERROR_MESSAGE);

                }
            }
            if (e.getSource() == Afficher) {
                list = gest_ent.getAllEnt();
                listentrp=new Modelentrp(list);
                String[] columns = new String[]{listentrp.getColumnName(0),
                        listentrp.getColumnName(1),
                        listentrp.getColumnName(2),listentrp.getColumnName(3),
                        listentrp.getColumnName(4),listentrp.getColumnName(5)
                };
                Object[][] rows = new Object[listentrp.getRowCount()]
                        [listentrp.getColumnCount()];
                for (int i = 0; i < listentrp.getRowCount(); i++) {
                    for (int j = 0; j < listentrp.getColumnCount(); j++) {
                        rows[i][j] = listentrp.getValueAt(i, j);
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


