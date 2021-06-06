package classes;

import static classes.TaxeSalaireException.SALAIRE_NEGATIF;

/**
 * taxe sur les salaires des personnes se trouvant dans la table Personne
 * 10% --> jusqu'à 20000
 * 20% --> jusqu'à 100000
 * 30% --> jusqu'à 200000
 *
 * 19999 : 10% = 1999,9
 * 20000 : 10% = 2000
 * 20001 : 20% = 2000,20
 *      20000 : 10% --> 2000
 *      1     : 20% --> 0,20
 * 100000 : 20 % = 18000
 *      20000 : 10% --> 2000
 *      80000 : 20% --> 16000
 * 200000 : 30 % = 48000
 *      20000 : 10% --> 2000
 *      80000 : 20% --> 16000
 *      100000 : 30% --> 30000
 */

public class TaxeSalaire {

    /**
     * Cette méthode calcul l'impot sur le revenu
     * @param revenu
     * @return
     * @throws TaxeSalaireException --> si le montant est négatif
     */

    public double calculerImposition(double revenu) throws TaxeSalaireException {
        if (revenu < 0){
            System.out.println("Erreur ");

            throw new TaxeSalaireException(SALAIRE_NEGATIF);
        }

        double impot = 0.0;

        if (revenu <= 20000) {
            impot = revenu * 0.10;
        } else if (revenu <= 100000) {
            impot = 20000 * 0.10;
            impot += ((revenu - 20000) * 0.20);
        } else if (revenu > 100000) {
            impot = 20000 * 0.10;
            impot += (80000 * 0.20);
            impot +=  ((revenu - 100000) * 0.30);
        }
        return impot;
    }

}
