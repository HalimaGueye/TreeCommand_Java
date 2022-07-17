import org.w3c.dom.Attr;
import org.w3c.dom.Element;

public class Dossier extends Doc {

  private String name;

  public Dossier(String nomDossier) {
    this.name = nomDossier;
  }

  public String getNom() {
    return this.name;
  }

  public void afficher() {
    System.out.printf(" ├───  %s\n", this.name);
  }

public static Element createElement(String string) {
    return null;
}


public static Attr createAttribute(String string) {
    return null;
}

}
