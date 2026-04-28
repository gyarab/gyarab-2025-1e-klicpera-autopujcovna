import java.util.Scanner;

void main() {
    Scanner sc = new Scanner(System.in);

    Auto auto1 = new Auto(1,"Škoda", "Octavia 1", true, 2000, 550);
    Auto auto2 = new Auto(2,"Škoda", "Octavia 1", true, 2000, 600);
    Auto auto3 = new Auto(3,"Škoda", "Octavia 2", false, 2008, 700);
    Auto auto4 = new Auto(4, "Subaru", "Impreza WRX STI 22B", true, 1998, 1800);
    Auto auto5 = new Auto(5, "Mitsubishi", "Lancer Evo 6.5 TME", true, 2001, 2500);
    Auto auto6 = new Auto(6, "Mazda", "Miata MX-5 NA", true, 1995, 1000);




    Zakaznik zakaznik1 = new Zakaznik(1,"Martin", "Novák",123456789);
//    Zakaznik zakaznik2 = new Zakaznik(2, "Bunta", "Fujiwara", 222333444);
//    Zakaznik zakaznik3 = new Zakaznik(2, "Tommi", "Mäkinen", 987654321);



    Pujcka pujcka1 = new Pujcka(7, auto1, zakaznik1);
//    Pujcka pujcka2 = new Pujcka(5, auto2, zakaznik2);
//    Pujcka pujcka3 = new Pujcka(3, auto2, zakaznik3);


    Pujcovna pujcovna = new Pujcovna();
    pujcovna.addZakaznik(zakaznik1);
//    pujcovna.addZakaznik(zakaznik2);
//    pujcovna.addZakaznik(zakaznik3);
    pujcovna.addAuto(auto1);
    pujcovna.addAuto(auto2);

    pujcovna.addAuto(auto4);
    pujcovna.addAuto(auto5);
    pujcovna.addAuto(auto6);
    pujcovna.addAuto(auto3);


    int vstupNum;

    System.out.println();
    System.out.println("Vítejte v autopůjčovně!");
    System.out.println();
    System.out.println("Pokud si půjčíte auto na více než 7 dní, tak Vám klesá denní cena o 10% !!! ");
    System.out.println("Při půjčení třetího auta získáváte věrnostní slevu 15% !!!");
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
            }

            System.out.println("Zadejte na kolik dní si chcete auto vypůjčit:");
            int dniPujcene = sc.nextInt();
            Zakaznik zakaznik = pujcovna.findZakId(1);

            Pujcka pujcka =  pujcovna.pujcitAuto(dniPujcene, vybraneAuto, zakaznik);


            System.out.println("Pujcka: " + pujcka);
            vybraneAuto.setTedZrovnaPujcene(false);
        }

        if (vstupNum == 4) {
            System.out.println("Zadejte ID auta, které chcete vrátit:");
            int idAuta = sc.nextInt();

            System.out.println("Zadejte jak dlouho jste skutečně auto měl:");
            int faktDniPujcene = sc.nextInt();

            pujcovna.vratitAuto(idAuta, faktDniPujcene);
        }



        if (vstupNum == 5) {
            System.out.println("Zadejte kolik nejvíce byste chtěli zaplatit za auto na den: ");
            int maxCena = sc.nextInt();
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
