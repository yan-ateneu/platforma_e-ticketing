package Service;

import Model.Data;
import Model.Eveniment;
import Model.Locatie;
import Model.Persoana;
import Repository.EvenimentR;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class EvenimentS {
    private EvenimentR evenimentRepository =new EvenimentR();



    public EvenimentS() {
    }

    public ArrayList<Eveniment> getEveniment() {
        return this.evenimentRepository.GetEvenimente();
    }

    public void adaugaEveniment(Eveniment x) {


        this.evenimentRepository.AdaugaEveniment(x);
    }

    public void stergeEveniment(Eveniment x) {

        this.evenimentRepository.StergeEveniment(x);
    }


    public Eveniment detaliiDespreEvenimentulDinData(Data data) {

        return this.evenimentRepository.DetaliiDespreEvenimentulDinData(data);
    }

    public void citesteEvenimentDinCSV(String path, String delimiter, AuditS auditS){
        try {
            Scanner scanner = new Scanner(new File(path));
            while(scanner.hasNext()){
                String line = scanner.next();

                String[] split = line.split(delimiter);
                int zi=Integer.parseInt(split[0]);
                int luna=Integer.parseInt(split[1]);
                int an=Integer.parseInt(split[2]);
                Data data = new Data(zi,luna,an);
                String tara = split[3] ;
                String oras = split[4];
                Locatie locatie = new Locatie(tara, oras);
                String tip_eveniment = split[5];
                

                Eveniment e = new Eveniment(data, locatie, tip_eveniment);
                this.evenimentRepository.AdaugaEveniment(e);
                auditS.Audit("citire", "eveniment");
            }
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void scrieEvenimentInCSV(String path, String delimiter, AuditS auditS, Eveniment eveniment) throws Exception {

        StringBuilder sb = new StringBuilder();
        sb.append(eveniment.getData().getZi()).append(delimiter)
                .append(eveniment.getData().getLuna()).append(delimiter)
                .append(eveniment.getData().getAn()).append(delimiter)
                .append(eveniment.getLocatie().getTara()).append(delimiter)
                .append(eveniment.getLocatie().getAdresa()).append(delimiter)
                .append(eveniment.getTip_eveniment())
                .append("\n");

        // concateneaza la fisier, nu face overwrite
        BufferedWriter csvWriter = new BufferedWriter(new FileWriter(path, true));
        csvWriter.append(sb.toString());
        csvWriter.flush();

        auditS.Audit("scriere", "eveniment");
    }
    
    public void SorteazaLexicograficDupaTipulEvenimentului(){
        this.evenimentRepository.Sort();
    }
}
