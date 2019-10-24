import java.awt.geom.AffineTransform;
import java.awt.FontMetrics;
import java.awt.Paint;
import java.awt.Color;
import java.awt.image.ImageObserver;
import java.awt.Image;
import java.awt.Font;
import java.awt.Graphics2D;
import javax.imageio.ImageIO;
import java.io.File;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Academician extends Entity {

    private int width;
    private int height;
    private BufferedImage image;
    
    public Academician( String name, Vector2D position, State state, Common common, String filename) {

        super( name, position, state, common );

        try {
            this.image = ImageIO.read( new File( filename ) );
        } catch (IOException e) {
        }

        this.width = image.getWidth() / 4;
        this.height = image.getHeight() / 4;

    }

    @Override
    public void draw( Graphics2D graphics2D ) {

        Font font = graphics2D.getFont();
        graphics2D.setFont(new Font("Sans Serif", Font.BOLD, 14));

        FontMetrics fontMetrics = graphics2D.getFontMetrics();
        AffineTransform transform = graphics2D.getTransform();

        graphics2D.translate( (int )position.x, ( int )position.y );
        graphics2D.drawImage( image, ( int )-width / 2, ( int )-height / 2, width, height, null );
        
        String nameOfAcadem = name;
        graphics2D.setPaint( Color.BLACK );
        graphics2D.drawString( nameOfAcadem, ( int )( - fontMetrics.stringWidth( nameOfAcadem ) / 2.0 ) + 1, ( int ) ( -width / 2 - 5 ) );
        
        String str = state.toString();
        graphics2D.setPaint( Color.BLACK );
        graphics2D.drawString( str, ( int )( - fontMetrics.stringWidth( str ) / 2.0 ) + 1, ( int )width / 2 + 15 );
        graphics2D.setTransform( transform );
        graphics2D.setFont( font );

    }

}
