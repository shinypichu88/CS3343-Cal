package cal;

import java.util.Scanner;

/**
 * The Class Calculator.
 */
public class Calculator {

    private Parser parser;
    private static Scanner scannerIn;

    public static void main(String[] args) {

        Calculator cal = new Calculator();

        String input = "";
        boolean isTryAgain = true;
        
        do {

            System.out.print("Enter (Type \"quit\" to stop): ");
            input = scanInput();

            isTryAgain = !input.toLowerCase().equals("quit");
            
            if(isTryAgain) {
                cal.setInputExpression(input);
                System.out.println("Result:\n" + cal.execute() + "\n");
            }

        } while (isTryAgain);

        System.out.println("Bye!");
        
        scannerIn.close();
    }

    public static String scanInput() {
    	scannerIn = new Scanner(System.in);
        String input = scannerIn.nextLine();
        return input;
    }

    public void setInputExpression(final String input) {
        ParserFactory factory = new ParserFactory();
        factory = new ParserFactory();
        parser = factory.createParser(input);
        parser.read(input);
    }

    public String execute() {
        return parser.execute();
    }

}
