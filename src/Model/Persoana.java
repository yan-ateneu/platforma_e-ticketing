package Model;

public class Persoana {

    private String nume;
    private String prenume;
    private int varsta;

    public Persoana() {

    }

    public Persoana(String nume, String prenume, int varsta){
        this.prenume=prenume;
        this.nume=nume;
        this.varsta=varsta;
    }


    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getNume() {
        return nume;
    }

    public void setVarsta(int varsta) {
        this.varsta = varsta;
    }

    public int getVarsta() {
        return varsta;
    }

    @Override
    public String toString() {
        return "Persoana{" +
                "nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", varsta=" + varsta +
                '}';
    }
}

