package Repository;

import Model.Bilet;
import Model.Eveniment;

import java.util.ArrayList;

public class BiletR {
    ArrayList<Bilet> Bilete=new ArrayList<Bilet>();
    public BiletR(){

    }

    public void AdaugaBilet(Bilet x){
        this.Bilete.add(x);
    }

    public void StergeBilet(Bilet x){
        this.Bilete.remove(x);
    }

    public ArrayList<Bilet> GetBilete(){
        return Bilete;
    }
    public Bilet DetaliiDespreBiletulCuIdul(int id_bilet){
        int i=0;
        for (i=0;i<this.Bilete.size();i++)
            if(this.Bilete.get(i).getId_bilet()==id_bilet)
                return this.Bilete.get(i);
        return null;
    }
    public void Update(int id_bilet, Bilet x){
        for (int i=0;i<this.Bilete.size();i++)
        {
            if(this.Bilete.get(i).getId_bilet()==id_bilet) {
                this.Bilete.get(i).setPersoana(x.getPersoana());
                this.Bilete.get(i).setPret(x.getPret());
                this.Bilete.get(i).setId_bilet(x.getId_bilet());
            }
        }
    }
    public void Sort(){
        for (int i=0 ; i< this.Bilete.size() - 1;i++)
            for (int j=i+1 ; j<this.Bilete.size() ; j++)
            {
                if (this.Bilete.get(i).getPret()< this.Bilete.get(j).getPret())
                {
                    Bilet aux = new Bilet();

                    aux.setPersoana(this.Bilete.get(i).getPersoana());
                    aux.setPret(this.Bilete.get(i).getPret());
                    aux.setId_bilet(this.Bilete.get(i).getId_bilet());

                    this.Bilete.get(i).setPersoana(this.Bilete.get(j).getPersoana());
                    this.Bilete.get(i).setPret(this.Bilete.get(j).getPret());
                    this.Bilete.get(i).setId_bilet(this.Bilete.get(j).getId_bilet());

                    this.Bilete.get(j).setPersoana(aux.getPersoana());
                    this.Bilete.get(j).setPret(aux.getPret());
                    this.Bilete.get(j).setId_bilet(aux.getId_bilet());
                    j--;
                }
            }
    }
}
