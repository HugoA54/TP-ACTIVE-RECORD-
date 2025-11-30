package activeRecord;
import java.sql.Connection;

public class PrincipaleJDBC {

    // IL FAUT PENSER A AJOUTER MYSQLCONNECTOR AU CLASSPATH

    public static void main(String[] args) {

        // variables de connection


        try {
            // chargement du driver jdbc
            Class.forName("com.mysql.cj.jdbc.Driver");

            // creation de la connection

            Connection connect = DBConnection.getInstance().getConnection();

            for(Personne pers : Personne.findAll()){
                System.out.println(pers.toString());
            }

            for(Personne pers : Personne.findByName("Scott")){
                System.out.println(pers.toString());
            }


            Personne personne = Personne.findById(1);
            System.out.println(personne.getNom() + " " + personne.getPrenom());




        } catch (ClassNotFoundException e) {
            System.out.println("*** ERREUR lors du chargement du driver ***");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("*** ERREUR inconnue... ***");
            e.printStackTrace();
        }
    }
}
