import java.io.File;
import java.util.Scanner;

public class Repertoire {

  public static File stringToXMFile() {

    return null;

  }

  public static void main(String[] args) {
    // get the path from the user
    // String path = "";
    // Scanner sc = new Scanner(System.in);
    // System.out.println("Entrez le chemin du répertoire :");
    // path = sc.nextLine();

    // create the file
    Builder xml = new Builder();

    String path = "C:/Users/HalimaG/Desktop/Java/Projet_PDC";
    xml.createXMLFile(path);
    // }
  }
}
