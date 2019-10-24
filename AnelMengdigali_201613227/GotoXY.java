public class GotoXY extends State {

    private int speed;
    private Vector2D target;
    
    public GotoXY( Vector2D target, int speed ) {

        super( false, true );
        this.speed = speed;
        this.target = target;

    }

    @Override
    public void step( Entity entity ) {

        if (entity.position.distanceTo(target) < speed) {

            entity.position.set(target);

        } else {

            Vector2D normalizedV = target.minus(entity.position).normalize();
            entity.position.changePosition(normalizedV.scale((double)speed));

        }

        if (entity.position.distanceTo(target) < 1.5) {

            entity.state.isOver = true;

        }

    }
    
    @Override
    public final String toString() {
        return "GotoXY";
    }

}
