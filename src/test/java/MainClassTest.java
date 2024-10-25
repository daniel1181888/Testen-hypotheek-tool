import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;
import static org.example.Main.*;

public class MainClassTest {

    @Test
    public void testMainMethod() {
        String maandInkomenInput = "3000\n";
        String rentevasteInput = "5\n";
        String partnerInput = "ja\n";        //test input gesimuleerd die de gebruiker zelf zou invoeren
        String studieschuldInput = "500\n";
        String postcodeInput = "1234\n";

        String simulatedInput = maandInkomenInput +
                rentevasteInput +
                partnerInput +              //Deze regel voegt alle invoer samen tot één enkele String genaamd simulatedInput
                studieschuldInput +
                postcodeInput;

        ByteArrayInputStream in = new ByteArrayInputStream(simulatedInput.getBytes()); //Dit stukje code maakt een nieuwe stroom (ByteArrayInputStream) aan met de tekst die we in simulatedInput
        System.setIn(in);

        ByteArrayOutputStream out = new ByteArrayOutputStream(); //Deze regels omleiden de standaard uitvoer (System.out) naar een ByteArrayOutputStream, out
        System.setOut(new PrintStream(out));

        main(new String[]{});

        String consoleOutput = out.toString(); //Hier wordt de main-methode van het Main-programma uitgevoerd

        assertTrue(consoleOutput.contains("U heeft een geldig maandinkomen ingevoerd: 3000"));
        assertTrue(consoleOutput.contains("U heeft een geldig studie inkomen ingevoerd: 500"));
        assertTrue(consoleOutput.contains("Maximaal lenen"));                                     // Elke assertTrue-regel controlleert of de consoleOutput de goeie tekst bevat
        assertTrue(consoleOutput.contains("Maandelijkse intrest"));
        assertTrue(consoleOutput.contains("maandelijkse betaling"));
    }
}