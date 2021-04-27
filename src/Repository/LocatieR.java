package Repository;
import Model.Locatie;
import java.util.ArrayList;

public class LocatieR {
    ArrayList<Locatie> Locatie= new ArrayList<Locatie>();

    public LocatieR() {

    }
    public void AdaugaLocatie(Locatie x){
        this.Locatie.add(x);
    }
    public void StergeLocatie(Locatie x){
        this.Locatie.remove(x);
    }
    public ArrayList<Locatie> getLocatie(){
        return Locatie;
    }
}