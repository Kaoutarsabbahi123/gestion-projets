package Presentation.tools;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

public class ShadowButton extends JButton {
    private static final long serialVersionUID = 1L;
    private static final int BORDER_THICKNESS = 2;
    private  Color BORDER_COLOR ;
    private static final int SHADOW_THICKNESS = 5;
    private  Color SHADOW_COLOR ;

    public ShadowButton(String text ,Color BORDER_COLOR,Color SHADOW_COLOR) {
        super(text);
        this.SHADOW_COLOR= SHADOW_COLOR;
        this.BORDER_COLOR= BORDER_COLOR;
        setOpaque(false);
        setBorderPainted(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int width = getWidth();
        int height = getHeight();

        // Draw the border
        /*Border border = BorderFactory.createLineBorder(BORDER_COLOR, BORDER_THICKNESS);
        border.paintBorder(this, g2, 0, 0, width, height);*/

        // Draw the shadow
        g2.setColor(SHADOW_COLOR);
        g2.fillRoundRect(SHADOW_THICKNESS, SHADOW_THICKNESS, width - SHADOW_THICKNESS, height - SHADOW_THICKNESS, 10, 10);

        // Draw the text
        super.paintComponent(g2);
        g2.dispose();
    }

}