import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import javax.swing.SwingUtilities;
import java.awt.Component;
import javax.swing.JFrame;

public class NURunner extends JFrame {

    public Display display;
    public Common common;

    public NURunner( String str, int windowWidth, int windowHeight, int numStudents ) {

        common = new Common(numStudents, windowWidth, windowHeight);
        display = new Display(common);

        setTitle(str + " by Anel Mengdigali ");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(display);
        pack();

    }

    public static void main( String[] args ) {

        final String name = "NU Graduation";
        int numStudents = 10;
        int windowWidth = 1200;
        int windowHeight = 600;

        NURunner nuRunner = new NURunner(name, windowWidth, windowHeight, numStudents);

        SwingUtilities.invokeLater(new Runnable()
                                                 {
                                                    public void run()
                {
                    nuRunner.setVisible(true);
                }
                                                }
                                    );
        try {

            while ( true ) {

                nuRunner.common.stepAllEntities();
                nuRunner.display.repaint();

                Thread.sleep(50L);

                }

            } catch ( InterruptedException e ) {
            }

        }
        
    }

