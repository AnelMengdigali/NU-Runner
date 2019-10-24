public abstract class State {
 
    public boolean isOver;
    public boolean isVisible;
    
    public abstract void step( Entity entity );
    
    public State( boolean isOver, final boolean isVisible ) {

        this.isOver = false;
        this.isVisible = true;

    }

}
