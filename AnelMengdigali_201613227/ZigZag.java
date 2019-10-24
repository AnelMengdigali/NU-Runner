
public class ZigZag extends State {

    private int speed;
    private int duration;
    private Vector2D direction;
    public Vector2D normalizedV;
    
    public ZigZag( Vector2D direction, int duration, int speed ) {

        super( false, true );

        this.speed = speed;
        this.duration = duration;
        this.direction = direction;

    }
  
    @Override
    public void step( Entity entity ) {

        normalizedV = direction.normalize();

        entity.position.changePosition(normalizedV.scale(speed));

        if (entity.position.x <= 0 || entity.position.x >= entity.common.windowWidth) {

            direction.x = -direction.x;

        }
        if (entity.position.y <= 0 || entity.position.y >= entity.common.windowHeight) {

            direction.y = -direction.y;

        }

        if (--this.duration <= 0) {

            entity.state.isOver = true;

        }
           
    }

    @Override
    public final String toString() { return "Zigzag";  }
    
}
