package Repository;

import Model.Data;
import Model.Eveniment;

import java.util.ArrayList;

public class EvenimentR {
    ArrayList<Eveniment> evenimente=new ArrayList<Eveniment>();

    public EvenimentR(){

    }

    public void AdaugaEveniment(Eveniment x){
        this.evenimente.add(x);
    }

    public void StergeEveniment(Eveniment x){
        this.evenimente.remove(x);
    }

    public ArrayList<Eveniment> GetEvenimente(){
        return evenimente;
    }

    public Eveniment DetaliiDespreEvenimentulDinData(Data data){
        int i=0;
        for (i=0;i<this.evenimente.size();i++)
            if(this.evenimente.get(i).getData()==data)
                return this.evenimente.get(i);

        return null;
    }
    public void Sort(){
        for (int i=0 ; i< this.evenimente.size() - 1;i++)
            for (int j=i+1 ; j<this.evenimente.size() ; j++)
            {
                if (this.evenimente.get(i).getTip_eveniment().compareTo(this.evenimente.get(j).getTip_eveniment())>0)
                {
                    Eveniment aux = new Eveniment();

                    aux.setTip_eveniment(this.evenimente.get(i).getTip_eveniment());
                    aux.setData(this.evenimente.get(i).getData());
                    aux.setLocatie(this.evenimente.get(i).getLocatie());

                    this.evenimente.get(i).setTip_eveniment(this.evenimente.get(j).getTip_eveniment());
                    this.evenimente.get(i).setData(this.evenimente.get(j).getData());
                    this.evenimente.get(i).setLocatie(this.evenimente.get(j).getLocatie());

                    this.evenimente.get(j).setTip_eveniment(aux.getTip_eveniment());
                    this.evenimente.get(j).setData(aux.getData());
                    this.evenimente.get(j).setLocatie(aux.getLocatie());
                    j--;
                }
            }
    }
}
