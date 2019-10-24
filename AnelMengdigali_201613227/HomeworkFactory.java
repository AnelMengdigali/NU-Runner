public class HomeworkFactory extends AssessmentFactory {

    public HomeworkFactory( Common common ) {
        super( common );
    }
    
    @Override
    public Assessment createAssessment( Vector2D position ) {

        return new Homework( "Homework", position, common.state, common, common.randomInt( 1, 3 ) );

    }

}
