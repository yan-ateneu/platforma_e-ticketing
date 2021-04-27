package Repository;
import Model.Data;
import java.util.ArrayList;

public class DataR {
    ArrayList<Data> data= new ArrayList<Data>();

    public DataR() {

    }
    public void AdaugaData(Data x){
        this.data.add(x);
    }
    public void StergeData(Data x){
        this.data.remove(x);
    }
    public ArrayList<Data> getData(){
        return data;
    }
}
