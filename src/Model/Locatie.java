package Model;

public class Locatie {
    private String tara;
    private String adresa;

    public Locatie() {

    }

    public Locatie(String tara,String adresa) {
        this.tara = tara;
        this.adresa=adresa;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getTara() {
        return tara;
    }

    public void setTara(String tara) {
        this.tara = tara;
    }
}
