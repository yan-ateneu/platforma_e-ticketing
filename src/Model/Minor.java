package Model;

public class Minor extends Client{
    private String telefon_parinte;

    public Minor() {

    }

    public Minor(String nume, String prenume, int varsta, int id_client, int discount, String telefon_parinte) {
        super(nume, prenume, varsta, id_client, discount);
        this.telefon_parinte = telefon_parinte;
    }

    public String getTelefon_parinte() {
        return telefon_parinte;
    }

    public void setTelefon_parinte(String telefon_parinte) {
        this.telefon_parinte = telefon_parinte;
    }

    @Override
    public String toString() {
        return "Minor{" +
                "telefon_parinte='" + telefon_parinte + '\'' +
                "} " + super.toString();
    }
}
