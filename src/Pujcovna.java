public class Pujcovna {
    private Auto[] auta = new Auto[20];
    private Zakaznik[] zakaznici = new Zakaznik[20];
    private Pujcka[] pujcky = new Pujcka[20];
    private int pocetAut = 0;
    private int pocetZakazniku = 0;
    private int pocetPujcek = 0;

    public void addAuto(Auto auto) {
        auta[pocetAut++] = auto;

    }

    public void addZakaznik(Zakaznik zakaznik) {
        zakaznici[pocetZakazniku++] = zakaznik;
    }


    public void vypisAut() {
        for (int i = 0; i < pocetAut; i++) {
            System.out.println(auta[i]);
        }
    }

    public Auto[] getAuta() {
        return auta;
    }

    public void serazeniCenaAVypis() {
        for (int i = 0; i < pocetAut - 1; i++) {
            for (int j = 0; j < pocetAut - i - 1; j++) {
                if (auta[j].getCenaZaDen() > auta[j+1].getCenaZaDen()) {
                    Auto temp = auta[j];
                    auta[j] = auta[j+1];
                    auta[j+1] = temp;
                }
            }
        }
        vypisAut();
    }




    public void vypisZakazniku() {
        for (int i = 0; i < pocetZakazniku; i++) {
            System.out.println(zakaznici[i]);
        }
    }

    public void vypisPujcek() {
        for (int i = 0; i < pocetPujcek; i++) {
            System.out.println(pujcky[i]);
        }
    }

    public Auto[] findAuto(String hledejModelAuta) {
        int pocetShod = 0;
        for (int i = 0; i < pocetAut; i++) {
            if (auta[i].getModel().toLowerCase().contains(hledejModelAuta.toLowerCase())){
                pocetShod++;
            }
        }

        Auto[] autaShody = new Auto[pocetShod];
        int index = 0;
        for (int i = 0; i < pocetAut; i++) {
            if (auta[i].getModel().toLowerCase().contains(hledejModelAuta.toLowerCase())) {
                autaShody[index++] = auta[i];
            }
        }
        return autaShody;
    }




    public Zakaznik[] findZakazniky(String hledejZakPrijmeni) {

        int pocetShod = 0;
        for (int i = 0; i < pocetZakazniku; i++) {
            if (zakaznici[i].getPrijmeni().toLowerCase().contains(hledejZakPrijmeni.toLowerCase())) {
                pocetShod++;
            }
        }

      Zakaznik[] nalezeneShody = new Zakaznik[pocetShod];
      int index = 0;
        for (int i = 0; i < pocetZakazniku; i++) {
            if (zakaznici[i].getPrijmeni().toLowerCase().contains(hledejZakPrijmeni.toLowerCase())) {
               nalezeneShody[index++] = zakaznici[i];
            }
        }
        return nalezeneShody;
  }





// nechat vysvetlit chatem gpt DU
  public Zakaznik findZakId(int hledejZakId) {
        for (int i = 0; i < pocetZakazniku; i++) {
            if (zakaznici[i].getId() == hledejZakId) {
              return zakaznici[i];
          }
        }
        return null;
    }





    public void filtrCena(int maxCena) {
        boolean nalezeno = false;

        for (int i = 0; i < pocetAut; i++) {
            if (auta[i].getCenaZaDen() <= maxCena) {
                nalezeno = true;
                System.out.println("Auta odpovídající Vaší zvolené maximální ceně: " + auta[i]);
            }
        }

        if (!nalezeno) {
            System.out.println("Nebyla nalezena žádná auta do požadované ceny za den.");
        }
    }




    public Pujcka pujcitAuto(int pocetDni, Auto auto, Zakaznik zakaznik) {

        if (!auto.isJeVolne()) {
            throw new IllegalStateException("Bohužel, auto už je vypůjčené");
        }

            auto.setJeVolne(false);
            auto.setTedZrovnaPujcene(true);

            Pujcka pujckaX = new Pujcka(pocetDni, auto, zakaznik);

            pujcky[pocetPujcek++] = pujckaX;

            zakaznik.zvyseniPoctuZakPujcek();

            return pujckaX;
    }



    public void vratitAuto(int idAuta, int faktDniPujcene) {
        for (int i = 0; i < pocetPujcek; i++) {
            if (pujcky[i].getAuto().getId() == idAuta) {
                int pokuta = pujcky[i].pokuta(faktDniPujcene);
                if (pokuta > 0) {
                    System.out.println("Byla Vám přidělena pokuta " + pokuta + " Kč za pozdní vrácení půjčenného auta.");
                }
                pujcky[i].getAuto().setJeVolne(true);
                vypisPujcek();

                pujcky[i] = pujcky[pocetPujcek--];
                pujcky[pocetPujcek--] = null;
                pocetPujcek --;
                vypisPujcek();
            }

        }
    }




    public int getPocetPujcek() {
        return pocetPujcek;
    }



    public int getPocetVolnychAut() {
        int volnaAuta = 0;

        for (int i = 0; i < pocetAut; i++) {
            if (auta[i].isJeVolne()) {
                volnaAuta++;
            }
        }
        return volnaAuta;
    }


    public double celkVydelek() {
        double suma = 0;
        for (int i = 0; i < pocetPujcek; i++) {
            suma += pujcky[i].totalCena();
        }
        return suma;
    }


}