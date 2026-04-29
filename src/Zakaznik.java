public class Zakaznik {
    private int id;
    private String jmeno;
    private String prijmeni;
    private int telCislo;
    private int pujckyCount;


    public Zakaznik(int id, String jmeno, String prijmeni, int telCislo) {
        this.id = id;
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.telCislo = telCislo;
    }


    public void zvyseniPoctuZakPujcek() {
        pujckyCount++;
    }


    public void setId(int id) {
        this.id = id;
    }

    public String getJmeno() {
        return jmeno;
    }

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    public String getPrijmeni() {
        return prijmeni;
    }

    public void setPrijmeni(String prijmeni) {
        this.prijmeni = prijmeni;
    }

    public int getTelCislo() {
        return telCislo;
    }

    public void setTelCislo(int telCislo) {
        this.telCislo = telCislo;
    }

    public int getId() {
        return id;
    }

    public int getPujckyCount() {
        return pujckyCount;
    }

    @Override
    public String toString() {
        return "Zákazník: " +
                " Id = " + id +
                ", jméno = " + jmeno +
                ", příjmení = " + prijmeni +
                ", telefonní číslo = " + telCislo;
    }
}