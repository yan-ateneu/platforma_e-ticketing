package Service;

import Model.Client;
import Model.Persoana;
import Repository.ClientR;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ClientS {
    private ClientR clientRepository =new ClientR();

    public ClientS() {
    }

    public ArrayList<Client> getClient() {
        return this.clientRepository.GetClienti();
    }

    public void adaugaClient(Client x){
        this.clientRepository.AdaugaClient(x);
    }

    public void stergeClient(Client x){
        this.clientRepository.StergeClient(x);
    }

    public Client detaliiDespreClientCuNumele(String nume) {
        return this.clientRepository.DetaliiDespreClientulCuNumele(nume);
    }
    public void UpdateClientulCuNumele(String nume, Client x){
        this.clientRepository.Update(nume,x);

    }
    public void citesteClientDinCSV(String path, String delimiter, AuditS auditS){
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

                Client c = new Client(nume, prenume, varsta, id_client, discount);
                this.clientRepository.AdaugaClient(c);
                auditS.Audit("citire", "persoana");
            }
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void scrieClientInCSV(String path, String delimiter, AuditS auditS, Client client) throws Exception {

        StringBuilder sb = new StringBuilder();
        sb.append(client.getNume()).append(delimiter)
                .append(client.getPrenume()).append(delimiter)
                .append(client.getVarsta()).append(delimiter)
                .append(client.getId_client()).append(delimiter)
                .append(client.getDiscount())
                .append("\n");

        // concateneaza la fisier, nu face overwrite
        BufferedWriter csvWriter = new BufferedWriter(new FileWriter(path, true));
        csvWriter.append(sb.toString());
        csvWriter.flush();

        auditS.Audit("scriere", "client");
    }
    public void sorteazaCrescatorDupaDiscaunt(){
        this.clientRepository.Sort();
    }
}
