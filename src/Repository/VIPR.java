package Repository;
import Model.Client;
import Model.VIP;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class VIPR {
    //ArrayList<VIP> Vipuri= new ArrayList<VIP>();
    private VIP[] Vipuri = new VIP[100];
    private int index;

    public VIPR(){
        index = 0;
    }
    public void AdaugaVIP(VIP x){
        Vipuri[index] = x;
        index++;
    }
    public void StergeVIP(VIP x)
    {
        int k = 0;
        for(VIP vip : Vipuri){
            if(vip == x){
                break;
            }
            k++;
        }
        if(k < index){
            for(int i = k; i < index; i++){
                Vipuri[i] = Vipuri[i + 1];
            }
        }
        index--;
    }

    public Client DetaliiDespreVipulCuNumele(String Nume){
        int i=0;
        for (i=0;i<index;i++)
            if(this.Vipuri[i].getNume().equals(Nume))
                return this.Vipuri[i];
        return null;
    }
    public VIP[] GetVipuri() {
        return Vipuri;
    }
    public void Update(String Nume, VIP x){
        for (int i=0;i<index;i++)
        {
            if(this.Vipuri[i].getNume().equals(Nume)) {
                this.Vipuri[i].setNume(x.getNume());
                this.Vipuri[i].setPrenume(x.getPrenume());
                this.Vipuri[i].setVarsta(x.getVarsta());
                this.Vipuri[i].setId_client(x.getId_client());
                this.Vipuri[i].setDiscount(x.getDiscount());
                this.Vipuri[i].setBani_consumatie(x.getBani_consumatie());
            }
        }
    }

    public void sort(){
        Arrays.sort(this.Vipuri, 0, index, new SortByConsumatie());
    }

    /*
    public void Sort(){
        for (int i=0 ; i< this.Vipuri.size() - 1;i++)
            for (int j=i+1 ; j<this.Vipuri.size() ; j++)
            {
                if (this.Vipuri.get(i).getBani_consumatie()< this.Vipuri.get(j).getBani_consumatie())
                {
                    VIP aux = new VIP();

                    aux.setBani_consumatie(this.Vipuri.get(i).getBani_consumatie());
                    aux.setNume(this.Vipuri.get(i).getNume());
                    aux.setVarsta(this.Vipuri.get(i).getVarsta());
                    aux.setPrenume(this.Vipuri.get(i).getPrenume());
                    aux.setId_client(this.Vipuri.get(i).getId_client());
                    aux.setDiscount(this.Vipuri.get(i).getDiscount());

                    this.Vipuri.get(i).setBani_consumatie(this.Vipuri.get(j).getBani_consumatie());
                    this.Vipuri.get(i).setNume(this.Vipuri.get(j).getNume());
                    this.Vipuri.get(i).setVarsta(this.Vipuri.get(j).getVarsta());
                    this.Vipuri.get(i).setPrenume(this.Vipuri.get(j).getPrenume());
                    this.Vipuri.get(i).setId_client(this.Vipuri.get(j).getId_client());
                    this.Vipuri.get(i).setDiscount(this.Vipuri.get(j).getDiscount());

                    this.Vipuri.get(j).setBani_consumatie(aux.getBani_consumatie());
                    this.Vipuri.get(j).setNume(aux.getNume());
                    this.Vipuri.get(j).setVarsta(aux.getVarsta());
                    this.Vipuri.get(j).setPrenume(aux.getPrenume());
                    this.Vipuri.get(j).setId_client(this.Vipuri.get(j).getId_client());
                    this.Vipuri.get(j).setDiscount(this.Vipuri.get(j).getDiscount());
                    j--;
                }
            }
    } */
}

class SortByConsumatie implements Comparator<VIP>{

    @Override
    public int compare(VIP vip1, VIP vip2) {
        return vip1.getBani_consumatie() - vip2.getBani_consumatie();
    }
}
