import org.w3c.dom.Attr;

public class Fichier extends Doc {

  private String name;

  public Fichier(String nomFichier) {
    this.name = nomFichier;
  }

  public String getNom() {
    return this.name;
  }

  public void afficher() {
    System.out.printf("\t└─── %s\n", this.name);
  }

  public void lireXml(String fichier) {
    
  }

public static Attr createAttribute(String string) {
    return null;
}

}
