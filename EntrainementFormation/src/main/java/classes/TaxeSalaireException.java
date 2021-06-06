package classes;

public class TaxeSalaireException extends RuntimeException {

    public static final String SALAIRE_NEGATIF = "Le montant est négatif";

    public TaxeSalaireException(final String message) {
        super(message);
    }
}
