package Presentation;

import Metier.Gestionnaires.Gestionnaire_projet;
import Metier.Projet;
import Presentation.tools.ShadowButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class respo_labo extends JFrame implements ActionListener {
        private JLabel Labelprojet;
        private JLabel LabelTitre;
        private JLabel LabelType;
        private JLabel LabelDure;
        private JLabel LabelDatedepart;
        private JLabel LabelNentp;
        private JLabel LabelNCNE;
        private Gestionnaire_projet proj=new Gestionnaire_projet();
        private JTextField Textprojet;
        private JTextField TextTitre;
        private JComboBox TextType;
        private JTextField TextDure;
        private JTextField TextDatedepart;
        private JTextField TextNentp;
        private JTextField TextNCNE;
        private JButton logout;
        private ShadowButton Valider;
        Icon icon= new ImageIcon("C:\\m.png");
        public void initialiser() {
            Labelprojet = new JLabel("N° Projet :");
            LabelTitre = new JLabel("Titre :");
            LabelType = new JLabel("Type :");
            LabelDure = new JLabel("Durée :");
            LabelDatedepart = new JLabel("Date de départ :");
            LabelNentp = new JLabel("N° Entreprise :");
            LabelNCNE = new JLabel("N° CNE :");

            Textprojet = new JTextField(20);
            TextTitre = new JTextField(20);
            String s[] = {"Doctorat"};
            TextType = new JComboBox(s);
            TextType.setBackground(Color.white);
            TextDure = new JTextField(20);
            TextDatedepart = new JTextField(20);
            TextNentp = new JTextField(20);
            TextNCNE = new JTextField(20);
            Valider= new ShadowButton("Valider", Color.decode("#1EEF28"), Color.decode("#01EEF28"));
            logout=new JButton(icon);
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
            Valider.setBounds(330,290,100,30);
            Valider.setBackground(Color.decode("#1EEF28"));
            logout.setBounds(650,350,36,36);
            logout.setOpaque(false);
            logout.setContentAreaFilled(false);
            logout.setBorderPainted(false);
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
            panel.add(Valider);
            panel.add(logout);
            this.add(panel);
        }

        public respo_labo() {
            this.setTitle("Affecter projet");
            this.initialiser();
            this.dessiner();
            this.setMinimumSize(new Dimension(750, 450));
            Valider.addActionListener(this);
            logout.addActionListener(this);
            this.setVisible(true);
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==Valider){
                Projet p=new Projet(Integer.valueOf(Textprojet.getText()), TextDure.getText(), TextDatedepart.getText(),
                        TextTitre.getText(),String.valueOf(TextType.getSelectedItem()),Integer.valueOf(TextNentp.getText()), TextNCNE.getText());
                boolean test = proj.ajout_proj(p);
                if (test) {
                    JOptionPane.showMessageDialog(null, "Ajout avec succés");
                } else {
                    JOptionPane.showMessageDialog(null, "échec", "Message d'erreur",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
            if(e.getSource()==logout){
                System.exit(0);
            }

        }
    }

