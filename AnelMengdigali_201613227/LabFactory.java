public class LabFactory extends AssessmentFactory {

    public LabFactory( Common common ) {
        super( common );
    }
    
    @Override
    public Assessment createAssessment( Vector2D position ) {

        return new Lab( "Lab", position, common.state, common, common.randomInt( 2, 4 ) );

    }

}
