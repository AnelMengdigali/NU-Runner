import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.List;

public class Common {

    public int numStudents;
    public boolean graduationTime;
    public int windowWidth;
    public int windowHeight;

    public UniversityMap map;
    public List<Academician> academicians;
    public List<Speaker> speakers;
    public List<Student> students;
    public List<Assessment> assessments;
    public List<AssessmentFactory> factories;

    public boolean allGraduated;
    public Vector2D STELLA;
    public State state;
    public Random randomNumberGenerator;
    public String[] nameOfStudents;
    public Stationary stationary;

    public Common( int numStudents, int windowWidth, final int windowHeight ) {

        nameOfStudents = new String[]{ "Abay", "Abilda", "Abilkhaiyr", "Ablan", "Abylaikhan", "Adil", "Adilzhan", "Adlet", "Aidana", "Aidyn", "Aigerim", "Aisana", "Akhmed", "Akmyrza", "Alan", "Aldamzhar", "Alexandra", "Ali", "Alibek", "Alim", "Alisher", "Allan", "Altair", "Altynay", "Altynbek", "Amangeldy", "Amina", "Anel", "Angsar", "Anuar", "Ardan", "Arman", "Askhat", "Assanali", "Assem", "Ayazhan", "Azamat", "Azizkhan", "Bagdat", "Baglan", "Bakdaulet", "Bakdauren", "Bakyt", "Batyrbek", "Batyrkhan", "Bauyrzhan", "Beibarys", "Bekzat", "Bota", "Damir", "Dana", "Danel", "Daniyar", "Darina", "Dastan", "Daulet", "Dauren", "Dnislam", "Dulat", "Eldar", "Emir", "Galym", "Gulnaz", "Islam", "Kamila", "Kamilla", "Karim", "Kassym", "Khadisha", "Khafiz", "Kuanysh", "Kyran", "Madi", "Madiyar", "Magzhan", "Makhambet", "Mansur", "Margulan", "Maxim", "Medet", "Meirzhan", "Miras", "Mokhira", "Murat", "Nargiza", "Nartay", "Nuradil", "Nurbolat", "Nurdaulet", "Nurlan", "Nursultan", "Nurtileu", "Olzhas", "Rabbani", "Raiymbek", "Rakhat", "Ramazan", "Ramilya", "Rauan", "Rollan", "Rustem", "Sabyr", "Sagi", "Saidgaffor", "Saken", "Salavat", "Sandugash", "Sanzhar", "Shapagat", "Sherkhan", "Shynggys", "Shyngys", "Tatyana", "Temirlan", "Temirzhan", "Timur", "Togzhan", "Tomiris", "Turgankhan", "Vladislav", "Yeldos", "Yerkali", "Yerkhan", "Yermek", "Yernar", "Yerzhan", "Yussup", "Zarina", "Zhalgas", "Zhanarys", "Zhandos", "Zhangeldi", "Zhannur", "Zhansaya", "Zhassulan", "Zhibek", "Zhuldyz" };
        this.numStudents = numStudents;
        this.windowWidth = windowWidth;
        this.windowHeight = windowHeight;
        graduationTime = true;
        stationary = new Stationary(); 

        map = new UniversityMap( "NU", new Vector2D(0.0, 0.0), stationary, this, "NUMap-Faded.jpg" );
        academicians = new ArrayList<Academician>();
        speakers = new ArrayList<Speaker>();
        students = new ArrayList<Student>();
        assessments = new ArrayList<Assessment>();
        factories = new ArrayList<AssessmentFactory>();
        allGraduated = false;
        STELLA = new Vector2D( this.windowWidth * 564 / 800, this.windowHeight * 326 / 400 );
        state = new Stationary();
        randomNumberGenerator = new Random();

        factories.add( new LabFactory( this ) );
        factories.add( new QuizFactory( this ) );
        factories.add( new HomeworkFactory( this ) );


        Academician Katsu = new Academician( "Katsu", randomPosition(30), randomStateAcademician(), this, "ShigeoKatsu.gif" );
        Academician Tourassis = new Academician( "Tourassis", randomPosition(30), randomStateAcademician(), this, "VassiliosTourassis.gif" );
        Academician Nivelle = new Academician( "Nivelle", randomPosition(30), randomStateAcademician(), this, "HansDeNivelle.gif" );
        Academician Temizer = new Academician( "Temizer", randomPosition(30), randomStateAcademician(), this, "SelimTemizer.gif" );

        Speaker Tokayev = new Speaker( "Tokayev", STELLA.plus( new Vector2D( -100.0, 0.0 ) ), stationary, this, "KassymJomartTokayev.gif" );
        Speaker Nazarbayev = new Speaker( "Nazarbayev", STELLA.plus( new Vector2D( 100.0, 0.0 ) ), stationary, this, "NursultanNazarbayev.gif" );

        academicians.add( Katsu );
        academicians.add( Tourassis );
        academicians.add( Nivelle );
        academicians.add( Temizer );

        speakers.add( Tokayev );
        speakers.add( Nazarbayev );


        for( int i = 0; i < numStudents; ++i ){

            students.add( new Student( nameOfStudents[randomInt(0, nameOfStudents.length - 1)], randomPosition(30), randomStateStudent(), this ) );

        }

    }

    public int randomInt ( int min, int max ){
        return randomNumberGenerator.nextInt(max - min + 1) + min;
    }


    public State randomStateAcademician () {

        switch ( randomInt( 1, 3 ) ) {

            case 1: {
                return new Rest( ( int )randomDuration( 30, 50 ) );
            }
            case 2: {
                return new ZigZag( randomVector( 1200, 600 ), ( int )randomDuration( 30, 50 ), ( int )randomSpeed( 2,5 ) );
            }
            case 3: {
                return new GotoXY( randomVector( 1200, 600 ), ( int )randomSpeed( 2,5 ) );
            }
            default: {
                System.err.println( "ERROR" );
                return null;
            }

        }

    }

    public State randomStateStudent () {

        switch ( randomInt( 1, 4 ) ) {

            case 1: {
                return new Rest( ( int )randomDuration( 30, 50 ) );
            }
            case 2: {
                return new ZigZag( randomVector( 1200, 600 ), ( int )randomDuration( 30, 50 ), ( int )randomSpeed( 2, 5 ) );
            }
            case 3: {
                return new GotoXY( randomVector( 1200, 600 ), ( int )randomSpeed( 2,5 ) );
            }
            case 4: {
                return new Closest( ( int )randomDuration( 30, 50 ), ( int )randomSpeed( 2, 5 ) );
            }
            default: {
                System.err.println( "ERROR" );
                return null;
            }

        }

    }

    public Vector2D randomPosition ( int i ){

        return new Vector2D( randomInt( i, windowWidth - i ), randomInt( i, windowHeight - i ) );

    }

    public void stepAllEntities () {

        int checker = 0;

        for ( Student student : students ) {
            student.step();

            if ( student.grade < 100 ) {

                synchronized ( assessments ) {
                    for ( int i = assessments.size() - 1; i >= 0; i-- ) {

                        Assessment assess = ( Assessment ) assessments.get(i);

                        if ( student.position.distanceTo( assess.position ) <= 10 ) {

                            student.grade += assess.points;
                            assessments.remove(i);

                        }

                    }

                }

            }

            if (student.state.isOver) {

                if (student.grade < 100) {

                    student.state = randomStateStudent();

                } 
                
                else {

                    if(student.position.distanceTo( STELLA) <= 25 ){

                         student.state = stationary;
                    }
                    else {

                        student.state = new GotoXY(STELLA.plus( new Vector2D( randomInt( -10, 10 ), randomInt( -10, 10 ) ) ), ( int )randomSpeed( 2, 5 ) );

                    }

                }

             }

            if ( student.grade >= 100 ) {

                    ++ checker;

            }

        }

        if( checker == numStudents ){

            allGraduated = true;

        }

        if ( allGraduated ) {

            assessments.clear();

            int i = 0;

            for(Academician academ: academicians) {

                academ.state.isVisible = true;

                academ.position = STELLA.plus( new Vector2D( -150 + i * 100, -120.0 ) );
                academ.state = stationary;

                i++;

            }

        }

        for ( Academician academ: academicians ) {

            academ.step();

            if ( !( ( academ.state.toString() ).equals("Rest") ) && !( ( academ.state.toString() ).equals( "Stationary") ) && randomInt( 1, 8 ) == 1 ) {

                Common common2 = academ.common;

                Vector2D vector2 = academ.position;

                int x = ( int )vector2.x + ( ( common2.randomInt( 0, 1 ) == 0 ) ? -1 : 1 ) * common2.randomInt( 10, 20 );
                int y = ( int )vector2.y + ( ( common2.randomInt( 0, 1 ) == 0 ) ? -1 : 1 ) * common2.randomInt( 10, 20 );

                if ( x <= 0 ) {

                    x = 10;

                } else if ( x >= common2.windowWidth ) {

                    x = common2.windowWidth - 10;

                }

                if ( y <= 0 ) {

                    y = 10;

                } else if (y >= common2.windowHeight) {

                    y = common2.windowHeight - 10;
                }

                AssessmentFactory factory = common2.factories.get(common2.randomInt(0, common2.factories.size() - 1));
               
                Assessment newAssessment = factory.createAssessment( new Vector2D( x, y ) );

                assessments.add( newAssessment );

            }
            if( academ.state.isOver ){

                academ.state = randomStateAcademician();

            }

        }

    }

    public void drawAllEntities ( Graphics2D g2D ){
       
        map.draw( g2D );

        synchronized ( assessments ) {

            for ( Assessment assess : assessments ) {
               
                assess.draw( g2D );
                
            }

            for ( Academician academic : academicians ) {

                academic.draw( g2D );

            }

            for ( Student student : students ) {

                student.draw( g2D );

            }
        
            if( allGraduated ){

                for ( Speaker speaker : speakers ) {

                    speaker.draw( g2D );

                }

            }

        }

    }

    public int randomSpeed( int i1, int i2 ) {

        return randomInt( i1, i2 );

    }

    public Vector2D randomVector( int i1, int i2 ){

        return new Vector2D( randomNumberGenerator.nextInt(i1), randomNumberGenerator.nextInt(i2) );

    }

    public int randomDuration( int i1, int i2 ){

        return randomInt( i1, i2 );

    }

}
