import java.awt.image.ImageObserver;
import java.awt.Image;
import java.awt.Graphics2D;
import javax.imageio.ImageIO;
import java.io.File;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class UniversityMap extends Entity {

    private BufferedImage image;
    
    public UniversityMap( String name, Vector2D position, State state, Common common, String filename ) {

        super( name, position, state, common );

        try {

            image = ImageIO.read( new File( filename ) );

        } catch ( IOException e ) {
        }

    }
    
    @Override
    public void draw( Graphics2D graphics2D ) {

        graphics2D.drawImage( image, 0, 0, common.windowWidth, common.windowHeight, null );

    }

}
