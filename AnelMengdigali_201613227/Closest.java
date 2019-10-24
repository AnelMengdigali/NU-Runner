import java.nio.file.attribute.AclEntryType;
import java.util.Iterator;
import java.util.List;

public class Closest extends State {

    private int duration;
    private int speed;
    
    public Closest( int duration, int speed ) {

        super( false, true );
        this.duration = duration;
        this.speed = speed;

    }
    
    @Override
    public void step( Entity entity ) {
       
        double minDistance = Double.MAX_VALUE;
        Assessment closest = null;

        for (Assessment assess : entity.common.assessments) {

            double distance = assess.position.distanceTo(entity.position);

            if ( distance < minDistance ) {

                minDistance = distance;
                closest = assess;

            }

        }

        if ( closest != null ) {
            
                Vector2D normalizedV = closest.position.minus(entity.position).normalize();
                entity.position.changePosition(normalizedV.scale(speed));

        }

        -- duration;
        if (duration <= 0) {

            entity.state.isOver = true;
            
        }

    }
    
    @Override
    public final String toString() {
        return "Closest";
    }

}
