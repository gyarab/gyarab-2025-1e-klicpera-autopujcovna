public class Pujcka {
    private int pocetDni;
    private Auto auto;
    private Zakaznik zakaznik;

    public Pujcka(int pocetDni, Auto auto, Zakaznik zakaznik) {
        this.pocetDni = pocetDni;
        this.auto = auto;
        this.zakaznik = zakaznik;
    }


    public double totalCena() {
        double celkCena = auto.getCenaZaDen() * pocetDni;
        if (pocetDni > 7) {
            celkCena *= 0.9;
        }

        if (zakaznik.getPujckyCount() >= 3) {
            celkCena *= 0.85;
        }

        return celkCena;
    }


    public int pokuta(int faktDniPujcene) {
        if (faktDniPujcene > pocetDni) {
            int pokuta = (faktDniPujcene - pocetDni) * 500 + ((faktDniPujcene - pocetDni) * auto.getCenaZaDen());
            return pokuta;
        }
        return 0;
    }


    public Auto getAuto() {
        return auto;
    }

    public void setAuto(Auto auto) {
        this.auto = auto;
    }



    @Override
    public String toString() {

        double zakladCeny = pocetDni * auto.getCenaZaDen();

        StringBuilder slevaInfo = new StringBuilder();



        if (pocetDni > 7){
            slevaInfo.append(" --> Aplikovaná sleva 10% --> ");
        }

        if (zakaznik.getPujckyCount() >= 3){
            slevaInfo.append(" --> Aplikovaná věrnostní sleva 15% --> ");
        }

        return " Počet dní: " + pocetDni + ", "
                 + auto +
                "\nZákladní cena: " + zakladCeny + " Kč " +
                slevaInfo.toString() +
                " Konečná cena: "  + totalCena() + " Kc ";
    }
}
