public class Auto {
    private int id;
    private String znacka;
    private String model;
    private boolean jeManual;
    private int rokVyroby;
    private int cenaZaDen;
    private boolean jeVolne;
    private boolean tedZrovnaPujcene;

    public Auto (int id, String znacka, String model, boolean jeManual, int rokVyroby, int cenaZaDen) {
        this.id = id;
        this.znacka = znacka;
        this.model = model;
        this.jeManual = jeManual;
        this.rokVyroby = rokVyroby;
        setCenaZaDen(cenaZaDen);
        this.jeVolne = true;
        this.tedZrovnaPujcene = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTedZrovnaPujcene(boolean tedZrovnaPujcene){
        this.tedZrovnaPujcene = tedZrovnaPujcene;
    }
    public String getZnacka() {
        return znacka;
    }

    public void setZnacka(String znacka) {
        this.znacka = znacka;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public boolean isJeManual() {
        return jeManual;
    }

    public void setJeManual(boolean jeManual) {
        this.jeManual = jeManual;
    }

    public int getRokVyroby() {
        return rokVyroby;
    }

    public void setRokVyroby(int rokVyroby) {
        this.rokVyroby = rokVyroby;
    }


    public boolean jeStarsiNez(int rok) {
        if (rokVyroby < rok) {
            return true;
        }
        return false;
    }


    public int getCenaZaDen() {
        return cenaZaDen;
    }

    public void setCenaZaDen(int cenaZaDen) {

        if (cenaZaDen <= 0) {
            throw new IllegalArgumentException("Cena nemůže být nižší nebo rovna 0");
        }

        this.cenaZaDen = cenaZaDen;
    }

    public boolean isJeVolne() {
        return jeVolne;
    }



    public void setJeVolne(boolean jeVolne) {
        this.jeVolne = jeVolne;
    }


    @Override
    public String toString() {


//        variable = (condition) ? expressionTrue :  expressionFalse;
        String typPrevodovky = jeManual ? ", převodovka: manuální" : ", převodovka: automatická";

        String isVolne;
        if (jeVolne) {
            isVolne = "auto je volné ";
        } else if (tedZrovnaPujcene) {
            isVolne = " auto jste si právě půjčil";
        } else {
            isVolne = " auto je bohužel momentálně půjčené ";
        }




        return
                "Id: " + id + ", " +
                znacka +
                " " +
                model +
                ", rok: " + rokVyroby +
                typPrevodovky +
                ", cena za den: " + cenaZaDen + " Kč, " +
                isVolne;
    }
}

