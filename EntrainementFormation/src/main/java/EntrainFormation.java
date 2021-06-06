import bdd.DbEleve;
import bdd.DbPersonne;
import classes.*;
import enums.Sexe;
import interfaces.EleveDao;
import interfaces.PersonneDao;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

public class EntrainFormation {

    public static void main (String[] args) throws SQLException, TaxeSalaireException {
       // int tab[] = { 1 , 5 , 4 , 2 , 3 } ;
      //  for ( int i : tab) System.out.println ( i ) ;

        PersonneDao daodbPersonne = new DbPersonne();

        List<Personne> personnes = daodbPersonne.findPersonnes();

        EleveDao daodbEleve = new DbEleve();

        List<Eleve> eleves = daodbEleve.findEleves();


        System.out.println("---------------------------------------");


        personnes.stream()
                .filter(p -> p.getNom().contains("che"))
                .forEach(p -> System.out.println(p.getNom() +" - "+ p.getPrenom() +" - "+ p.getAdresse() ));

//result.forEach(p -> p.getNom());
        System.out.println("---------------------------------------");

        List<String> mesClients = personnes.stream()
                .map( p -> p.getNom() +" - "+ p.getPrenom())
                .distinct()
                .filter(p-> p.contains("J"))
                .collect( Collectors.toList() );
        mesClients.forEach(System.out::println);


        System.out.println("---------------------------------------");

       // System.out.println("Liste des personnes");
        System.out.println("Liste des eleves");

        for (Personne personne : personnes) {
         //   System.out.println(personne.getNom() +" - "+ personne.getPrenom() +" - "+ personne.getAdresse());

            for (Eleve eleve : eleves) {

                if(personne.getId().equals(eleve.getId())){
                    System.out.println("---------------------------------------");
                    System.out.println("IMPOT --> " + personne.tSalaire.calculerImposition(personne.getSalaire()));

                    if(personne.getSexe().equals(Sexe.FEMME)) {
                        System.out.println(personne.getNom() + " - " + personne.getPrenom() + " à obtenue la note de  " +
                                eleve.getNote() + " en " + eleve.getClasse() + " et a un salaire de : ["+ personne.getSalaire() +"] avec un impot de : ["+ personne.getImpot() +"].");
                    }
                    else
                    {
                        System.out.println(personne.getNom() + " - " + personne.getPrenom() + " à obtenu la note de  " +
                                eleve.getNote() + " en " + eleve.getClasse()+ " et a un salaire de : ["+ personne.getSalaire() +"] avec un impot de : ["+ personne.getImpot() +"].");
                    }
                }

            }
        }
        System.out.println("---------------------------------------");

    }
}

