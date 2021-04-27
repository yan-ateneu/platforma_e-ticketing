package Model;

public class VIP extends Client{
    private int bani_consumatie;//persoanele care dispun de un bilet VIP pot sa-si puna la inceputul evenimentului o anumita suma de bani pe un cont pentru a nu plati fiecare lucru consumat in parte

    public VIP() {

    }

    public VIP(String nume, String prenume, int varsta, int id_client, int discount, int bani_consumatie) {
        super(nume, prenume, varsta, id_client, discount);
        this.bani_consumatie = bani_consumatie;
    }

    public int getBani_consumatie() {
        return bani_consumatie;
    }

    public void setBani_consumatie(int bani_consumatie) {
        this.bani_consumatie = bani_consumatie;
    }

    @Override
    public String toString() {
        return "VIP{" +
                "bani_consumatie=" + bani_consumatie +
                "} " + super.toString();
    }
}
