package Model;

public class Bilet extends Eveniment{
    private int pret;
    private int id_bilet;
    private Persoana persoana;

    public Bilet() {

    }
    public Bilet(Data data, Locatie locatie, String tip_eveniment, int pret, int id_bilet, Persoana persoana) {
        super(data, locatie, tip_eveniment);
        this.pret = pret;
        this.id_bilet=id_bilet;
        this.persoana=persoana;
    }

    public int getPret() {
        return pret;
    }

    public void setPret(int pret) {
        this.pret = pret;
    }

    public int getId_bilet() {
        return id_bilet;
    }

    public void setId_bilet(int id_bilet) {
        this.id_bilet = id_bilet;
    }

    public Persoana getPersoana() {
        return persoana;
    }

    public void setPersoana(Persoana persoana) {
        this.persoana = persoana;
    }

    @Override
    public String toString() {
        return "Bilet{" +
                "pret=" + pret +
                ", id_bilet=" + id_bilet +
                ", persoana=" + persoana +
                "} " + super.toString();
    }
}
