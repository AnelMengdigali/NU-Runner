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

//Speaker or academician
public class Speaker extends Entity {

    private int width;
    private int height;
    private BufferedImage image;
    
    public Speaker( String name, Vector2D position, State state, Common common, String pathname ) {

        super( name, position, state, common );

        try {
            image = ImageIO.read( new File( pathname ) );

        } catch (IOException e) {
        }

        this.width = image.getWidth() / 4;
        this.height = image.getHeight() / 4;

    }
    
    @Override
    public void draw( Graphics2D graphics2D ) {

        Font font = graphics2D.getFont();
        graphics2D.setFont( new Font( "Sans Serif", 1, 14 ) );

        FontMetrics fontMetrics = graphics2D.getFontMetrics();
        AffineTransform transform = graphics2D.getTransform();

        graphics2D.translate( ( int )position.x, ( int )position.y );
        graphics2D.drawImage( image, ( int )-width / 2, ( int )-height / 2, width, height, null );
        
        String nameOfSpeaker = name;
        graphics2D.setPaint( Color.BLACK );
        graphics2D.drawString( nameOfSpeaker, ( int )( - fontMetrics.stringWidth( nameOfSpeaker ) / 2.0 ) + 1, ( int ) ( -width / 2 - 5 ) );
        
        String str = state.toString();
        graphics2D.setPaint( Color.BLACK );
        graphics2D.drawString( str, ( int )( - fontMetrics.stringWidth( str ) / 2.0 ) + 1, ( int )width / 2 + 12 );
        graphics2D.setTransform( transform );
        graphics2D.setFont( font );

    }

}
