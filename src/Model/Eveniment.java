package Model;

import Model.Data;

public class Eveniment {
    private Data data;
    private Locatie locatie;
    private String tip_eveniment;

    public Eveniment() {
    }

    public Eveniment(Data data, Locatie locatie, String tip_eveniment) {
        this.data=data;
        this.locatie = locatie;
        this.tip_eveniment=tip_eveniment;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public Locatie getLocatie() {
        return locatie;
    }

    public String getTip_eveniment() {
        return tip_eveniment;
    }

    public void setTip_eveniment(String tip_eveniment) {
        this.tip_eveniment = tip_eveniment;
    }

    public void setLocatie(Locatie locatie) {
        this.locatie = locatie;
    }

    @Override
    public String toString() {
        return "Eveniment{" +
                "data=" + data +
                ", locatie=" + locatie +
                ", tip_eveniment='" + tip_eveniment + '\'' +
                '}';
    }
}
