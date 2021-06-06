import classes.TaxeSalaire;
import classes.TaxeSalaireException;
import org.junit.Assert;
import org.junit.Test;
import static org.assertj.core.api.Assertions.*;
import static classes.TaxeSalaireException.SALAIRE_NEGATIF;

public class TaxeSalaireTest {

    @Test //(timeout = 1000, expected = TaxeSalaireException.class)
    public void calculerImpositionRevenuNegatif() {
       // TaxeSalaire tSalaire = new TaxeSalaire();

        //double resultat = tSalaire.calculerImposition(-20000.0);

        //System.out.println("La valeur de l'impot sur le revenu est : "+ resultat);

        //Assert.assertEquals(2000.0,resultat,0.000001);
        assertThatThrownBy(()-> new TaxeSalaire().calculerImposition(-20000.0)).isInstanceOf(TaxeSalaireException.class)
                .hasMessage(SALAIRE_NEGATIF);
    }

    @Test
    public void calculerImposition20000() throws TaxeSalaireException {
        TaxeSalaire tSalaire = new TaxeSalaire();

        double resultat = tSalaire.calculerImposition(20000.0);

        System.out.println("La valeur de l'impot sur le revenu est : "+ resultat);

        Assert.assertEquals(2000.0,resultat,0.000001);
    }

    @Test
    public void calculerImposition20001() throws TaxeSalaireException {
        TaxeSalaire tSalaire = new TaxeSalaire();

        double resultat = tSalaire.calculerImposition(20001.0);

        System.out.println("La valeur de l'impot sur le revenu est : "+ resultat);
        Assert.assertEquals(2000.20,resultat,0.000001);
    }

    @Test
    public void calculerImposition19999() throws TaxeSalaireException {
        TaxeSalaire tSalaire = new TaxeSalaire();

        double resultat = tSalaire.calculerImposition(19999.0);

        System.out.println("La valeur de l'impot sur le revenu est : "+ resultat);
        Assert.assertEquals(1999.9,resultat,0.000001);
    }

    @Test
    public void calculerImposition200000() throws TaxeSalaireException {
        TaxeSalaire tSalaire = new TaxeSalaire();

        double resultat = tSalaire.calculerImposition(200000.0);

        System.out.println("La valeur de l'impot sur le revenu est : "+ resultat);
        Assert.assertEquals(48000.0,resultat,0.000001);
    }

}