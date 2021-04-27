package Service;
import Model.Persoana;
import Repository.PersoanaR;

import java.io.*;
import java.sql.Timestamp;
import java.util.*;

public class PersoanaS {
    private PersoanaR persoanaRepository =new PersoanaR();

    public PersoanaS() {
    }

    public ArrayList<Persoana> getPersoana() {
        return this.persoanaRepository.GetPersoane();
    }

    public void adaugaPersoana(Persoana x){
        this.persoanaRepository.AdaugaPersoane(x);
    }

    public void stergePersoana(Persoana x){
        this.persoanaRepository.StergePersoane(x);
    }

    public Persoana detaliiDesprePersoanaCuNumele(String nume) {
        return this.persoanaRepository.DetaliiDesprePersoanCuNumele(nume);
    }
    public void updatePersoanaCuNumele(String nume, Persoana x){
        this.persoanaRepository.Update(nume,x);
    }

    public void citestePersoanaDinCSV(String path, String delimiter, AuditS auditS){
        try {
            Scanner scanner = new Scanner(new File(path));
            while(scanner.hasNext()){
                String line = scanner.next();

                String[] split = line.split(delimiter);
                String nume = split[0];
                String prenume = split[1];
                int varsta = Integer.parseInt(split[2]);

                Persoana p = new Persoana(nume, prenume, varsta);
                this.persoanaRepository.AdaugaPersoane(p);
                auditS.Audit("citire", "persoana");
            }
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void scriePersoanaInCSV(String path, String delimiter, AuditS auditS, Persoana persoana) throws Exception {

        StringBuilder sb = new StringBuilder();
        sb.append(persoana.getNume()).append(delimiter)
            .append(persoana.getPrenume()).append(delimiter)
            .append(persoana.getVarsta())
            .append("\n");

        // concateneaza la fisier, nu face overwrite
        BufferedWriter csvWriter = new BufferedWriter(new FileWriter(path, true));
        csvWriter.append(sb.toString());
        csvWriter.flush();

        auditS.Audit("scriere", "persoana");
    }


    public void sorteazaCrescatorDupaVarsta(){
        this.persoanaRepository.Sort();
    }
}
