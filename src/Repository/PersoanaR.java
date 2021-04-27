package Repository;

import Model.Persoana;

import java.util.ArrayList;
public class PersoanaR {
    ArrayList<Persoana> Persoane = new ArrayList<Persoana>();


    public PersoanaR() {

    }

    public void AdaugaPersoane(Persoana x) {
        this.Persoane.add(x);
    }

    public void StergePersoane(Persoana x) {
        this.Persoane.remove(x);
    }

    public Persoana DetaliiDesprePersoanCuNumele(String Nume) {
        int i = 0;
        for (i = 0; i < this.Persoane.size(); i++)
            if (this.Persoane.get(i).getNume().equals(Nume))
                return this.Persoane.get(i);
        return null;
    }
    public void Update(String Nume, Persoana x){
        for (int i=0;i<this.Persoane.size();i++)
        {
            if(this.Persoane.get(i).getNume().equals(Nume)) {
                this.Persoane.get(i).setNume(x.getNume());
                this.Persoane.get(i).setPrenume(x.getPrenume());
                this.Persoane.get(i).setVarsta(x.getVarsta());

            }
        }
    }

    public ArrayList<Persoana> GetPersoane() {
        return Persoane;
    }

    public void Sort() {
        for (int i = 0; i < this.Persoane.size() - 1; i++)
            for (int j = i + 1; j < this.Persoane.size(); j++) {
                if (this.Persoane.get(i).getVarsta() < this.Persoane.get(j).getVarsta()) {
                    Persoana aux = new Persoana();

                    aux.setNume(this.Persoane.get(i).getNume());
                    aux.setVarsta(this.Persoane.get(i).getVarsta());
                    aux.setPrenume(this.Persoane.get(i).getPrenume());

                    this.Persoane.get(i).setNume(this.Persoane.get(j).getNume());
                    this.Persoane.get(i).setVarsta(this.Persoane.get(j).getVarsta());
                    this.Persoane.get(i).setPrenume(this.Persoane.get(j).getPrenume());

                    this.Persoane.get(j).setNume(aux.getNume());
                    this.Persoane.get(j).setVarsta(aux.getVarsta());
                    this.Persoane.get(j).setPrenume(aux.getPrenume());
                    j--;
                }
            }
    }
}
