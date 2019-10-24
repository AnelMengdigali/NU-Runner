public class Stationary extends State {

    public Stationary() {

        super( false, true );

    }
    
    @Override
    public void step( Entity entity ) { }
    
    @Override
    public final String toString() { return "Stationary"; }

}
