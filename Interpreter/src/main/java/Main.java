import java.util.*;
import java.io.*;
import java.util.regex.Pattern;

public class Main {

  char nextChar (Scanner in) {
    return in.next().charAt(0);
  }

  boolean nextCharIs(Scanner in, char c) {
    return in.hasNext(Pattern.quote(c+""));
  }


  public void assignment() {

  }


////////////////////////////////////////////////////////////////////////////////

    private void start() {
        // Create a scanner on System.in
        Scanner in = new Scanner(System.in);
        // in.useDelimiter("");
        System.out.println("Starting program");

        // While there is input, read line and parse it.
        while (in.hasNext()) {
          in.next();
        }
    }

    public static void main(String[] argv) {
        new Main().start();
    }
}
