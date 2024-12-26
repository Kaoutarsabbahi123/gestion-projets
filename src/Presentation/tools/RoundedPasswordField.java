package Presentation.tools;

    import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JPasswordField;

    public class RoundedPasswordField extends JPasswordField {
        private Color borderColor = Color.GRAY;
        private int cornerRadius = 15;

        public RoundedPasswordField() {
            super();
            setOpaque(false);
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            Shape border = new RoundRectangle2D.Double(0, 0, getWidth()-1, getHeight()-1, cornerRadius, cornerRadius);
            g2.setColor(getBackground());
            g2.fill(border);
            g2.setColor(Color.white);
            g2.draw(border);
            super.paintComponent(g);
            g2.dispose();
        }

        @Override
        public void setBorder(javax.swing.border.Border border) {
            // No-op
        }

        public void setBorderColor(Color borderColor) {
            this.borderColor = borderColor;
            repaint();
        }

        public void setCornerRadius(int cornerRadius) {
            this.cornerRadius = cornerRadius;
            repaint();
        }

    }
