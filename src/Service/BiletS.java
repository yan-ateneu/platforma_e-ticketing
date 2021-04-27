package Service;

import Model.*;
import Repository.BiletR;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class BiletS {
    private BiletR biletRepository =new BiletR();

    public BiletS() {
    }

    public ArrayList<Bilet> getBilet() {
        return this.biletRepository.GetBilete();
    }

    public void adaugaBilet(Bilet x){
        this.biletRepository.AdaugaBilet(x);
    }

    public void stergeBilet(Bilet x){
        this.biletRepository.StergeBilet(x);
    }

    public Bilet detaliiDespreBiletCuIdul(int id_bilet) {
        return this.biletRepository.DetaliiDespreBiletulCuIdul(id_bilet);
    }
    public void UpdateBiletulCuIdul(int id_bilet, Bilet x){
        this.biletRepository.Update(id_bilet,x);

    }
    public void citesteBiletDinCSV(String path, String delimiter, AuditS auditS){
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
                int pret = Integer.parseInt(split[6]);
                int id_bilet = Integer.parseInt(split[7]);
                String nume = split[8];
                String prenume = split[9];
                int varsta = Integer.parseInt(split[10]);
                Persoana persoana=new Persoana(nume,prenume,varsta);


                Bilet b = new Bilet(data, locatie, tip_eveniment,pret,id_bilet,persoana);
                this.biletRepository.AdaugaBilet(b);
                auditS.Audit("citire", "bilet");
            }
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void scrieBiletInCSV(String path, String delimiter, AuditS auditS, Bilet bilet) throws Exception {

        StringBuilder sb = new StringBuilder();
        sb.append(bilet.getData().getZi()).append(delimiter)
                .append(bilet.getData().getLuna()).append(delimiter)
                .append(bilet.getData().getAn()).append(delimiter)
                .append(bilet.getLocatie().getTara()).append(delimiter)
                .append(bilet.getLocatie().getAdresa()).append(delimiter)
                .append(bilet.getTip_eveniment()).append(delimiter)
                .append(bilet.getPret()).append(delimiter)
                .append(bilet.getId_bilet()).append(delimiter)
                .append(bilet.getPersoana().getNume()).append(delimiter)
                .append(bilet.getPersoana().getPrenume()).append(delimiter)
                .append(bilet.getPersoana().getVarsta())
                .append("\n");

        // concateneaza la fisier, nu face overwrite
        BufferedWriter csvWriter = new BufferedWriter(new FileWriter(path, true));
        System.out.println("aa");
        System.out.println(sb.toString());
        csvWriter.append(sb.toString());
        csvWriter.flush();

        auditS.Audit("scriere", "bilet");
    }
    public void sorteazaCrescatorDupaPret(){
        this.biletRepository.Sort();
    }
}
