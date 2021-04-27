package Repository;

import Model.Client;
import Model.Persoana;

import java.util.ArrayList;

public class ClientR {
    ArrayList<Client> Clienti = new ArrayList<Client>();


    public ClientR(){

    }

    public void AdaugaClient(Client x){
        this.Clienti.add(x);
    }
    public void StergeClient(Client x){
        this.Clienti.remove(x);
    }


    public Client DetaliiDespreClientulCuNumele(String Nume){
        int i=0;
        for (i=0;i<this.Clienti.size();i++)
            if(this.Clienti.get(i).getNume().equals(Nume))
                return this.Clienti.get(i);

        return null;
    }

    public ArrayList<Client> GetClienti() {
        return Clienti;
    }
    
    public void Update(String Nume, Client x){
        for (int i=0;i<this.Clienti.size();i++)
        {
            if(this.Clienti.get(i).getNume().equals(Nume)) {
                this.Clienti.get(i).setNume(x.getNume());
                this.Clienti.get(i).setPrenume(x.getPrenume());
                this.Clienti.get(i).setVarsta(x.getVarsta());
                this.Clienti.get(i).setId_client(x.getId_client());
                this.Clienti.get(i).setDiscount(x.getDiscount());
            }
        }
    }
    public void Sort(){
        for (int i=0 ; i< this.Clienti.size() - 1;i++)
            for (int j=i+1 ; j<this.Clienti.size() ; j++)
            {
                if (this.Clienti.get(i).getDiscount()< this.Clienti.get(j).getDiscount())
                {
                    Client aux = new Client();

                    aux.setDiscount(this.Clienti.get(i).getDiscount());
                    aux.setId_client(this.Clienti.get(i).getId_client());
                    aux.setNume(this.Clienti.get(i).getNume());
                    aux.setVarsta(this.Clienti.get(i).getVarsta());
                    aux.setPrenume(this.Clienti.get(i).getPrenume());

                    this.Clienti.get(i).setDiscount(this.Clienti.get(j).getDiscount());
                    this.Clienti.get(i).setId_client(this.Clienti.get(j).getId_client());
                    this.Clienti.get(i).setNume(this.Clienti.get(j).getNume());
                    this.Clienti.get(i).setVarsta(this.Clienti.get(j).getVarsta());
                    this.Clienti.get(i).setPrenume(this.Clienti.get(j).getPrenume());

                    this.Clienti.get(j).setDiscount(aux.getDiscount());
                    this.Clienti.get(j).setId_client(aux.getId_client());
                    this.Clienti.get(j).setNume(aux.getNume());
                    this.Clienti.get(j).setVarsta(aux.getVarsta());
                    this.Clienti.get(j).setPrenume(aux.getPrenume());
                    j--;
                }
            }
    }
}
