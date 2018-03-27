package dao;

import java.sql.*;

/**
 * Représente la base de données. Fournit une connexion à cette base (via
 * <code>getConnection()</code>.
 *
 * ATTENTION : ajouter dans cette classe tous les codes erreur prévus par les déclencheurs 
 * écrits par nous dans MySQL (après FOREIGN_KEY_NOT_FOUND).
 * @author plasse
 */
public class Database {

   /**
    * Code erreur MySQL quand le serveur est inaccessible
    */
   public static final int SERVER_OFF = 0;

   /**
    * Code erreur MySQL pour "duplicate entry" (doublons)
    */
   public static final int DOUBLON = 1062;

   /**
    * Code erreur MySQL pour "Cannot delete or update a parent row: a foreign
    * key constraint fails "
    */
   public static final int ROW_IS_REFERENCED = 1451;

   /**
    * Code erreur MySQL pour "Cannot add or update a child row: a foreign key
    * constraint fails"
    */
   public static final int FOREIGN_KEY_NOT_FOUND = 1452;
   

   
   /**
    * Pilote MySQL (bibliothèque contenant les implémentations de jdbc)
    */
   protected static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
   protected static final String DB_NAME = "agriotes2018";
   protected static final String USER = "agriotes2018user";
   protected static final String PASSWORD = "agriotes2018pwd";

   /**
    * Chaine de connexion (adresse TCP/IP de la base de données
    */
   protected static String URL = "jdbc:mysql://localhost/" + DB_NAME;
   // La chaine de connexion diffère d'un SGBD à l'autre.
   // Pour Oracle : "jdbc:oracle:oci8:@localhost:1521:XE/" + DB_NAME
   // Pour Derby (BD en mémoire en Java) : "jdbc:derby://localhost:1527/" + DB_NAME
   // Pour MySQL : "jdbc:mysql://localhost/" + DB_NAME;

   // Bloc d'initialisation pour les variables static, ne s'exécute qu'une fois
   static {
      try {
         Class.forName(DRIVER_NAME).newInstance();
         System.out.printf("*** Driver %s loaded.\n", DRIVER_NAME);
      } catch (ClassNotFoundException | InstantiationException | IllegalAccessException exc) {
         // Depuis java 1.7, on peut rassembler ainsi les exceptions
         exc.printStackTrace();
         throw new RuntimeException("Pilote pas chargé");
      }
   }

   public enum SortOrder {
      ASC, DESC;
   }

   /**
    * Fournit une connexion à la base de données. Ne fait pas appel à un pool de
    * connexion, même si cela est envisageable plus tard (ne changerait rien à
    * l'appel de la méthode)
    * <br><strong>Requiert</strong> que le pilote soir chargé
    *
    * @throws java.sql.SQLException
    */
   public static Connection getConnection() throws SQLException {
      return DriverManager.getConnection(URL, USER, PASSWORD);
   }

}
