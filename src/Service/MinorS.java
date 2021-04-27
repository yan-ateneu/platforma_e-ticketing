package Service;

import Model.Client;
import Model.Persoana;
import Model.Minor;
import Repository.MinorR;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class MinorS {
    private MinorR minorRepository =new MinorR();
    public MinorS() {
    }
    public ArrayList<Minor> getMinor() {
        return this.minorRepository.GetMinori();
    }
    public void adaugaMino(Minor x) {
        this.minorRepository.AdaugaMinor(x);
    }

    public void stergeMino(Minor x) {

        this.minorRepository.StergeMinor(x);
    }


    public Persoana detaliiDespreMinorulCuNumele(String nume) {

        return this.minorRepository.DetaliiDespreMinorulCuNumele(nume);
    }
    public void citesteMinorDinCSV(String path, String delimiter, AuditS auditS){
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
                String telefon_parinte=split[5];

                Minor m = new Minor(nume, prenume, varsta, id_client, discount, telefon_parinte);
                this.minorRepository.AdaugaMinor(m);
                auditS.Audit("citire", "persoana");
            }
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void scrieMinorInCSV(String path, String delimiter, AuditS auditS, Minor minor) throws Exception {

        StringBuilder sb = new StringBuilder();
        sb.append(minor.getNume()).append(delimiter)
                .append(minor.getPrenume()).append(delimiter)
                .append(minor.getVarsta()).append(delimiter)
                .append(minor.getId_client()).append(delimiter)
                .append(minor.getDiscount()).append(delimiter)
                .append(minor.getTelefon_parinte())
                .append("\n");

        // concateneaza la fisier, nu face overwrite
        BufferedWriter csvWriter = new BufferedWriter(new FileWriter(path, true));
        csvWriter.append(sb.toString());
        csvWriter.flush();

        auditS.Audit("scriere", "minor");
    }
}
