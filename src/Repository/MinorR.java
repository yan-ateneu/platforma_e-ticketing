package Repository;
import Model.Client;
import Model.Minor;
import java.util.ArrayList;
public class MinorR {
    ArrayList<Minor> Minori= new ArrayList<Minor>();
    public MinorR(){

    }
    public void AdaugaMinor(Minor x){
        this.Minori.add(x);
    }
    public void StergeMinor(Minor x){
        this.Minori.remove(x);
    }

    public Client DetaliiDespreMinorulCuNumele(String Nume){
        int i=0;
        for (i=0;i<this.Minori.size();i++)
            if(this.Minori.get(i).getNume().equals(Nume))
                return this.Minori.get(i);
        return null;
    }
    public ArrayList<Minor> GetMinori() {
        return Minori;
    }
}