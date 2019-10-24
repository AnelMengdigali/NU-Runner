import java.awt.geom.AffineTransform;
import java.awt.FontMetrics;
import java.awt.Paint;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class Lab extends Assessment {

    public Lab( String name, Vector2D position, State state, Common common, int points ) {

        super( name, position, state, common, points );

    }
    
    @Override
    public void draw( Graphics2D graphics2D ) {

        Font font = graphics2D.getFont();
        graphics2D.setFont( new Font( "Sans Serif", 1, 14 ) );
        FontMetrics fontMetrics = graphics2D.getFontMetrics();
        AffineTransform transform = graphics2D.getTransform();
        graphics2D.translate( ( int )position.x, ( int )position.y );
        graphics2D.setPaint(Color.RED);
        graphics2D.fillOval(-9, -9, 18, 18);

        String str = new StringBuilder().append( points ).toString();
        graphics2D.setPaint( Color.BLACK );
        graphics2D.drawString( str, ( int )(-fontMetrics.stringWidth( str ) / 2.0 ) + 1, 6 );
        graphics2D.setTransform( transform );
        graphics2D.setFont( font );

    }

}
