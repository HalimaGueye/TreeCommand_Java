public class Factory {

  public static Doc fabrique(Boolean verdic, String elementNom) {
    Doc instance;
    if (verdic) {
      instance = new Dossier(elementNom);
    } else instance = new Fichier(elementNom);
    return instance;
  }
}
