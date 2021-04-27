package Service;

import Model.Minor;
import Model.Persoana;
import Model.VIP;
import Repository.VIPR;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class VIPS {
    private VIPR VIPRepository =new VIPR();

    public VIPS() {
    }
    public VIP[] getVipur() {
        return this.VIPRepository.GetVipuri();
    }
    public void adaugaVIP(VIP x) {
        this.VIPRepository.AdaugaVIP(x);
    }

    public void stergeVIP(VIP x) {

        this.VIPRepository.StergeVIP(x);
    }


    public Persoana detaliiDespreVipulCuNumele(String nume) {
        
        return this.VIPRepository.DetaliiDespreVipulCuNumele(nume);
    }
    public void updateVipulCuNumele(String nume, VIP x){
        this.VIPRepository.Update(nume,x);
    }

    public void citesteVIPDinCSV(String path, String delimiter, AuditS auditS){
        try {
            Scanner scanner = new Scanner(new File(path));
            while(scanner.hasNext()){
                String line = scanner.next();

                String[] split = line.split(delimiter);
                String nume = split[0];
                String prenume = split[1];
                int varsta = Integer.parseInt(split[2]);
                int id_client = Integer.parseInt(split[3]);
                int discount = Integer.parseInt(split[4]);
                int bani_consumatie=Integer.parseInt(split[5]);

                VIP vip = new VIP(nume, prenume, varsta, id_client, discount, bani_consumatie);
                this.VIPRepository.AdaugaVIP(vip);
                auditS.Audit("citire", "VIP");
            }
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void scrieVIPInCSV(String path, String delimiter, AuditS auditS, VIP vip) throws Exception {

        StringBuilder sb = new StringBuilder();
        sb.append(vip.getNume()).append(delimiter)
                .append(vip.getPrenume()).append(delimiter)
                .append(vip.getVarsta()).append(delimiter)
                .append(vip.getId_client()).append(delimiter)
                .append(vip.getDiscount()).append(delimiter)
                .append(vip.getBani_consumatie())
                .append("\n");

        // concateneaza la fisier, nu face overwrite
        BufferedWriter csvWriter = new BufferedWriter(new FileWriter(path, true));
        csvWriter.append(sb.toString());
        csvWriter.flush();

        auditS.Audit("scriere", "VIP");
    }

    public void sorteazaCrescatorDupaBugetulConsumabil(){
        this.VIPRepository.sort();

}
}
