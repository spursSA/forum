package classes;

public class Eleve {

    private Integer eleve_id;
    private String classe;
    private Integer note;

    public Eleve(String classe, Integer note) {
        this.classe = classe;
        this.note = note;
    }

    public Eleve(Integer eleve_id, String classe, Integer note) {
        this(classe,note);
        this.eleve_id = eleve_id;
    }



    public Integer getId() {
        return eleve_id;
    }

    public void setId(Integer id) {
        this.eleve_id = eleve_id;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public Integer getNote() {
        return note;
    }

    public void setNote(Integer note) {
        this.note = note;
    }
}
