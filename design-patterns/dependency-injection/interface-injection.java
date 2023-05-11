// Interface representing a Printer
public interface Printer {
  void print(String document);
}

// Implementation of a LaserPrinter
public class LaserPrinter implements Printer {
  @Override
  public void print(String document) {
    System.out.println("Printing document using a laser printer: " + document);
  }
}

// Implementation of an InkjetPrinter
public class InkjetPrinter implements Printer {
  @Override
  public void print(String document) {
    System.out.println("Printing document using an inkjet printer: " + document);
  }
}

// Client class that depends on the Printer interface
public class Client {
  private Printer printer;

  public Client(Printer printer) {
    this.printer = printer;
  }

  public void printDocument(String document) {
    printer.print(document);
  }
}

// Main class to test the code
public class Main {
  public static void main(String[] args) {
    Printer laserPrinter = new LaserPrinter();
    Printer inkjetPrinter = new InkjetPrinter();

    Client client1 = new Client(laserPrinter);
    client1.printDocument("Document 1"); // Output: Printing document using a laser printer: Document 1

    Client client2 = new Client(inkjetPrinter);
    client2.printDocument("Document 2"); // Output: Printing document using an inkjet printer: Document 2
  }
}
