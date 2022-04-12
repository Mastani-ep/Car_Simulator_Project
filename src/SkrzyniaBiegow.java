public class SkrzyniaBiegow extends Komponent{
    private int aktualnyBieg;
    private int iloscBiegow;
    private double aktualnePrzelozenie;
    Sprzeglo sprzeglo;

    public SkrzyniaBiegow(Sprzeglo sprzeglo, int iloscBiegow, double waga, double cena, String nazwa){
        super(nazwa,waga,cena);
        this.sprzeglo = sprzeglo;
        this.aktualnePrzelozenie = 0;
        this.iloscBiegow = iloscBiegow;
        this.aktualnyBieg = 0;
    }

    public int getAktualnyBieg() {
        return aktualnyBieg;
    }

    public double getAktualnePrzelozenie() {
        return aktualnePrzelozenie;
    }

    public void zwiekszBieg(){
        if(this.sprzeglo.isStanSprzegla()) {
            if(this.aktualnyBieg<this.iloscBiegow){
                this.aktualnyBieg += 1;
                switch(this.aktualnyBieg) {
                    case 1:
                        this.aktualnePrzelozenie = 0.3;
                        break;
                    case 2:
                        this.aktualnePrzelozenie = 0.5;
                        break;
                    case 3:
                        this.aktualnePrzelozenie = 0.7;
                        break;
                    case 4:
                        this.aktualnePrzelozenie = 1.0;
                        break;
                    case 5:
                        this.aktualnePrzelozenie = 1.3;
                        break;
                    case 6:
                        this.aktualnePrzelozenie = 1.6;
                        break;
                }
            }else{
                System.out.println("Aktualny bieg jest maksymalny.");
            }
        }else{
            System.out.println("Wciśnij sprzęgło.");
        }
    }
    public void zmniejszBieg(){
        if(this.sprzeglo.isStanSprzegla()) {
            if(this.aktualnyBieg > 0){
                this.aktualnyBieg -= 1;
                switch(this.aktualnyBieg) {
                    case 0:
                        this.aktualnePrzelozenie = 0.0;
                        break;
                    case 1:
                        this.aktualnePrzelozenie = 0.3;
                        break;
                    case 2:
                        this.aktualnePrzelozenie = 0.5;
                        break;
                    case 3:
                        this.aktualnePrzelozenie = 0.7;
                        break;
                    case 4:
                        this.aktualnePrzelozenie = 1.0;
                        break;
                    case 5:
                        this.aktualnePrzelozenie = 1.3;
                        break;
                }
            }else{
                System.out.println("Aktualny bieg jest minimalny.");
            }
        }else{
            System.out.println("Wciśnij sprzęgło.");
        }
    }
}
