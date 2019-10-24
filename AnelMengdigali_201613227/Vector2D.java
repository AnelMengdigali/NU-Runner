public class Vector2D {

    public double x;
    public double y;
    
    public Vector2D( double x, double y ) {

        this.x = x;
        this.y = y;

    }
    
    public void set( Vector2D position ) {

        this.x = position.x;
        this.y = position.y;

    } 

    public void changePosition( Vector2D position ) {

        this.x += position.x;
        this.y += position.y;

    }

    public double distanceTo( Vector2D position ) {

        return Math.sqrt(Math.pow(position.x - x, 2.0) + Math.pow(position.y - y, 2.0));

    }

    public Vector2D normalize() {

        Vector2D zeroV= new Vector2D(0,0);
        double length = distanceTo(zeroV);

        Vector2D position;

        if( length == 0 ) {

            position = new Vector2D( 0.01, 0.01 );

        } else {

            position = new Vector2D( x / length, y / length );

        }

        return position;

    }
    
    public Vector2D plus( Vector2D position ) {
        return new Vector2D( this.x + position.x, this.y + position.y );
    }
    
    public Vector2D minus( Vector2D position ) {
        return new Vector2D( this.x - position.x, this.y - position.y );
    }
    
    public Vector2D scale( double factor ) {
        return new Vector2D(this.x * factor, this.y * factor );
    }

}
