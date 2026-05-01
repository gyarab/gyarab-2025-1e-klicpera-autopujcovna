import java.util.Scanner;

void main() {
    Scanner sc = new Scanner(System.in);

    Auto auto1 = new Auto(1,"Škoda", "Octavia 2 Combi", false, 2012, 550);
    Auto auto2 = new Auto(2,"Škoda", "Octavia 1 vRS", true, 2002, 1200);
    Auto auto3 = new Auto(3,"Škoda", "Octavia 3 Scout", true, 2016, 900);
    Auto auto4 = new Auto(4, "Subaru", "Impreza WRX STI", true, 1998, 1700);
    Auto auto5 = new Auto(5, "Mitsubishi", "Lancer Evo VI", true, 2001, 1700);
    Auto auto6 = new Auto(6, "Mazda", "Miata MX-5 NA", true, 1995, 1000);
    Auto auto7 = new Auto(7,"Renault", "Twingo", true, 1996, 400);
    Auto auto8 = new Auto(8, "Toyota", "GR86", true, 2024, 1100);
    Auto auto9 = new Auto(9, "BMW", "M3 E46 CSL", true, 2005, 2200);
    Auto auto10 = new Auto(10, "BMW", "M4 Competition G82", false, 2025, 2000);
    Auto auto11 = new Auto(11, "Honda", "CRV", false, 2016, 800);
    Auto auto12 = new Auto(12, "Toyota", "Land Cruiser", true, 2010, 800);
    Auto auto13 = new Auto(13, "Nissan", "GT-R R34", true, 2001, 2000);
    Auto auto14 = new Auto(14, "Datsun", "240z", true, 1973, 1500);
    Auto auto15 = new Auto(15, "Honda", "NSX", true, 1992, 3000);
    Auto auto16 = new Auto(16, "Volkswagen", "Golf Mk.IV", false, 2000, 500);

    Pujcovna pujcovna = new Pujcovna();

    pujcovna.addAuto(auto1);
    pujcovna.addAuto(auto2);
    pujcovna.addAuto(auto3);
    pujcovna.addAuto(auto4);
    pujcovna.addAuto(auto5);
    pujcovna.addAuto(auto6);
    pujcovna.addAuto(auto7);
    pujcovna.addAuto(auto8);
    pujcovna.addAuto(auto9);
    pujcovna.addAuto(auto10);
    pujcovna.addAuto(auto11);
    pujcovna.addAuto(auto12);
    pujcovna.addAuto(auto13);
    pujcovna.addAuto(auto14);
    pujcovna.addAuto(auto15);
    pujcovna.addAuto(auto16);


    Zakaznik zakaznik1 = new Zakaznik(1, "Lukáš", "Klicpera", 123456789);
//    Zakaznik zakaznik2 = new Zakaznik(2, "Keichi", "Tsuchiya", 222333444);
//    Zakaznik zakaznik3 = new Zakaznik(3, "Rowan", "Atkinson", 987654321);

    pujcovna.addZakaznik(zakaznik1);
//    pujcovna.addZakaznik(zakaznik2);
//    pujcovna.addZakaznik(zakaznik3);



    int vstupNum;

    System.out.println();
    System.out.println("Vítejte v autopůjčovně!");
    System.out.println();
    System.out.println("Pokud si půjčíte auto na více než 7 dní, tak Vám klesá denní cena o 10%!");
    System.out.println("Při půjčení třetího auta získáváte věrnostní slevu 15%!");
    System.out.println();

    //Menu
    do {
        System.out.println();
        System.out.println("Postupujte podle pokynů:");
        System.out.println();
        System.out.println("Pro výpis nabídky aut stiskněte 1+Enter");
        System.out.println("Pro vyhledávání auta stiskněte 2+Enter");
        System.out.println("Pro půjčení auta stiskněte 3+Enter");
        System.out.println("Pro vráceni auta stiskněte 4+Enter");
        System.out.println("Pro vyhledávání aut do určité ceny stiskněte 5+Enter");
        System.out.println("Pro statistiky půjčovny stiskněte 6+Enter");
        System.out.println("Pro ukončení programu stiskněte 0+Enter");
        System.out.println();
        System.out.println("Vaše volba:");
        System.out.println();
        vstupNum = sc.nextInt();

        if (vstupNum == 1) {
            pujcovna.serazeniCenaAVypis();
        }

        if (vstupNum == 2) {
            sc.nextLine();
            System.out.println("Zadejte model auta: ");
            String model = sc.nextLine();
            Auto[] nalezenaAuta =  pujcovna.findAuto(model);
            if (nalezenaAuta.length == 0) {
                System.out.println("Nebyly nalezené žádné shody.");
                break;
            }

            System.out.println("Nalezené shody: ");
            for (int i = 0; i < nalezenaAuta.length; i++) {
                System.out.println(nalezenaAuta[i]);
            }
        }

        if (vstupNum == 3) {
            System.out.println();
            System.out.println("Zadejte ID auta, které si chcete půjčit:");
            int ID = sc.nextInt();

            Auto[] getAutaMain = pujcovna.getAuta();

            Auto vybraneAuto = null;
            for (int i = 0; i < getAutaMain.length; i++) {
                if (getAutaMain[i].getId() == ID) {
                    vybraneAuto = getAutaMain[i];
                    break;
                }
            }

            if (vybraneAuto == null) {
                System.out.println("ID se neshoduje s žádným nalezeným autem.");
                System.out.println();
                continue;
            }

            System.out.println("Zadejte na kolik dní si chcete auto vypůjčit:");
            int dniPujcene = sc.nextInt();
            Zakaznik zakaznik = pujcovna.findZakId(1);

            Pujcka pujcka =  pujcovna.pujcitAuto(dniPujcene, vybraneAuto, zakaznik);


            System.out.println("Pujcka: " + pujcka);
            vybraneAuto.setTedPravePujcene(false);
        }

        if (vstupNum == 4) {
            System.out.println("Zadejte ID auta, které chcete vrátit:");
            int idAuta = sc.nextInt();

            System.out.println("Zadejte kolik dní jste skutečně auto měl:");
            int faktDniPujcene = sc.nextInt();

            pujcovna.vratitAuto(idAuta, faktDniPujcene);
        }



        if (vstupNum == 5) {
            System.out.println("Zadejte kolik nejvíce byste chtěli denně zaplatit za auto: ");
            int maxCena = sc.nextInt();
            System.out.println("Auta odpovídající Vaší zvolené maximální ceně: ");
            pujcovna.filtrCena(maxCena);

        }




        if (vstupNum == 6) {
            System.out.println("Momentálně je/jsou aktivní " + pujcovna.getPocetPujcek() + " půjček/ky.");
            System.out.println("Momentálně máme " + pujcovna.getPocetVolnychAut() + " volné/á/ých aut(o/a).");
            System.out.println("Celkový výdělek z momentálně probíhajících půjček bude " + pujcovna.celkVydelek() + " Kč.");
        }


    }
    while (vstupNum != 0);

}
