package Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Data {

    private int an;
    private int luna;
    private int zi;

    public Data() {
    }

    public Data(int zi, int luna, int an) {
        this.zi = zi;
        this.luna=luna;
        this.an= an;
    }

    public int getAn() {
        return an;
    }

    public void setAn(int an) {
        this.an = an;
    }

    public int getZi() {
        return zi;
    }

    public void setZi(int zi) {
        this.zi = zi;
    }

    public int getLuna() {
        return luna;
    }

    public static Data stringToData(String dataString) throws ParseException {
        Data data = new Data();

        Date date1 = new SimpleDateFormat("dd.mm.yyyy").parse(dataString);

        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date1);
        data.zi = calendar.get((Calendar.DAY_OF_MONTH));
        data.luna = calendar.get((Calendar.MONTH));
        data.an = calendar.get((Calendar.YEAR));

        return data;
    }

    public void setLuna(int luna) {
        this.luna = luna;
    }

    @Override
    public String toString() {
        return "Model.Data{" +
                "an=" + an +
                ", luna=" + luna +
                ", zi=" + zi +
                '}';
    }
}
