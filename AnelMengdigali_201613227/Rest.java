public class Rest extends State {

    public int duration;
    
    public Rest( int duration ) {

        super( false, true );
        this.duration = duration;

    }
    
    @Override
    public void step( Entity entity ) {

        if (--duration <= 0) {

            entity.state.isOver = true;
        }        

    }
    
    @Override
    public final String toString() {
        return "Rest";
    }

}
