
package Vista;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class RoundedPanel extends JPanel {

    private int radius;

    public RoundedPanel(int radius) {
        super();
        this.radius = radius;
        setOpaque(false); // Para que el fondo sea transparente
        setBorder(new EmptyBorder(10, 10, 10, 10)); // Margen interno opcional
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        // Configurar color del borde y fondo
        g2d.setColor(getBackground());
        g2d.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, radius, radius);
        
        // Borde opcional
        g2d.setColor(Color.GRAY);
        g2d.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, radius, radius);
    }
}

