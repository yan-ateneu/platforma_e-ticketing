package Main;

import Model.*;
import Model.Persoana;
import Service.*;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws Exception {
        String csvDelimiter = ",";

        AuditS auditS = new AuditS("res/audit.csv", csvDelimiter);

        Bilet bilet = new Bilet();
        Persoana persoana=new Client();
        persoana.setNume("Vasu");
        persoana.setPrenume("Ionut");
        persoana.setVarsta(22);

        bilet.setPret(50);
        bilet.setId_bilet(1);
        bilet.setPersoana(persoana);

        BiletS actiune=new BiletS();
        actiune.adaugaBilet(bilet);
        System.out.println(actiune.detaliiDespreBiletCuIdul(1).toString());
        System.out.println("merge");

        PersoanaS persoanaS = new PersoanaS();
        persoanaS.citestePersoanaDinCSV("res/persoane.csv", csvDelimiter, auditS);

        Persoana pers = new Persoana();
        pers.setNume("Tapirdea");
        pers.setPrenume("Alexandru");
        pers.setVarsta(24);
        persoanaS.scriePersoanaInCSV("res/persoane.csv", csvDelimiter, auditS, pers);

        BiletS biletS=new BiletS();

        Bilet bil=new Bilet();
        int zi=30;
        int luna=12;
        int an=2020;
        Data data=new Data(zi,luna,an);
        bil.setData(data);
        bil.setLocatie(new Locatie("Romania","Stirbei_Voda_nr2"));
        bil.setTip_eveniment("petrecere");
        bil.setPret(100);
        bil.setId_bilet(2);
        bil.setPersoana(pers);
        biletS.scrieBiletInCSV("res/bilete.csv",csvDelimiter,auditS,bil);

        biletS.citesteBiletDinCSV("res/bilete.csv",csvDelimiter,auditS);

        EvenimentS evenimentS=new EvenimentS();

        Eveniment even=new Eveniment();
        even.setData(new Data(28,4,2021));
        even.setLocatie(new Locatie("Romania","FMI"));
        even.setTip_eveniment("Banchet");
        evenimentS.scrieEvenimentInCSV("res/evenimente.csv",csvDelimiter,auditS,even);

        evenimentS.citesteEvenimentDinCSV("res/evenimente.csv",csvDelimiter,auditS);

        ClientS clientS=new ClientS();

        Client cli= new Client();
        cli.setNume("Zidaru");
        cli.setPrenume("Catalin-Costin");
        cli.setVarsta(52);
        cli.setId_client(22);
        cli.setDiscount(100);

        clientS.scrieClientInCSV("res/clienti.csv",csvDelimiter,auditS,cli);

        clientS.citesteClientDinCSV("res/clienti.csv",csvDelimiter,auditS);

        MinorS minorS=new MinorS();

        Minor min=new Minor();
        min.setNume("Marinas");
        min.setPrenume("Vlad");
        min.setVarsta(16);
        min.setDiscount(23);
        min.setId_client(232);
        min.setTelefon_parinte("0758836404");

        minorS.scrieMinorInCSV("res/minori.csv",csvDelimiter,auditS,min);

        minorS.citesteMinorDinCSV("res/minori.csv",csvDelimiter,auditS);



        VIPS vips=new VIPS();

        VIP vip=new VIP();
        vip.setNume("Yang");
        vip.setPrenume("pisica");
        vip.setVarsta(3);
        vip.setId_client(33);
        vip.setDiscount(1000);
        vip.setBani_consumatie(99999999);

        VIP vip2=new VIP();
        vip.setNume("Cristi");
        vip.setPrenume("Pantilie");
        vip.setVarsta(3);
        vip.setId_client(38);
        vip.setDiscount(21);
        vip.setBani_consumatie(1);

        vips.scrieVIPInCSV("res/vipuri.csv",csvDelimiter,auditS,vip);

        vips.citesteVIPDinCSV("res/vipuri.csv",csvDelimiter,auditS);

        vips.scrieVIPInCSV("res/vipuri.csv",csvDelimiter,auditS,vip2);

        vips.sorteazaCrescatorDupaBugetulConsumabil();
}
}
