package Model;

import Model.Persoana;

public class Client extends Persoana {
    private int id_client;
    private int discount;

    public Client() {

    }

    public Client(String nume, String prenume, int varsta, int id_client, int discount) {
        super(nume, prenume, varsta);
        this.id_client=id_client;
        this.discount = discount;
    }

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id_client=" + id_client +
                ", discount=" + discount +
                "} " + super.toString();
    }
}
