import java.awt.geom.AffineTransform;
import java.awt.FontMetrics;
import java.util.Iterator;
import java.awt.Paint;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JPanel;

public class Display extends JPanel {

    private Common common;
    
    public Display( Common common ) {

        this.common = common;

        setBackground(Color.WHITE);

    }

    @Override
    public Dimension getPreferredSize() {

        return new Dimension(common.windowWidth, common.windowHeight);

    }
    
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        
        final Graphics2D g2D = ( Graphics2D ) g;

        synchronized (common) {

            common.drawAllEntities(g2D);

        }

    }

}
