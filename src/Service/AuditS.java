package Service;

import Model.Persoana;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

public class AuditS {

    private BufferedWriter csvWriter;
    private String delimiter;
    public AuditS(String path, String delimiter) throws IOException {
        csvWriter = new BufferedWriter(new FileWriter(path, true));
        this.delimiter = delimiter;
    }

    public void Audit(String actiune, String model) throws Exception {
        if(!(actiune.equals("citire") || actiune.equals("scriere"))){
            throw new Exception("Actiune invalida pentru audit");
        }
        StringBuilder sb = new StringBuilder(actiune);

        if(model.equals("persoana")) {
            sb.append("_persoana");
        }
        else if(model.equals("client")){
            sb.append("_client");
        }
        else if(model.equals("minor")){
            sb.append("_minor");
        }
        else if(model.equals("VIP")){
            sb.append("_VIP");
        }
        else if(model.equals("eveniment")){
            sb.append("_eveniment");
        }
        else if(model.equals("bilet")) {
            sb.append("_bilet");
        }
        else{
            throw new Exception("Model invalid pentru audit.");
        }
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());

        sb.append(delimiter).append(timestamp.toString()).append("\n");
        csvWriter.append(sb.toString());
        csvWriter.flush();
    }

}
