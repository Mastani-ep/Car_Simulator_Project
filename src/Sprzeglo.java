public class Sprzeglo extends Komponent{
    private boolean stanSprzegla;

    public Sprzeglo(String nazwa, double waga, double cena){
        super(nazwa, waga, cena);
        this.stanSprzegla = false;
    }

    public boolean isStanSprzegla() {
        return stanSprzegla;
    }

    public void wcisnij(){
        if(!this.stanSprzegla) {
            this.stanSprzegla = true;
        }else{
            System.out.println("Sprzęgło jest już wciśnięte.");
        }
    }

    public void zwolnij(){
        if(this.stanSprzegla) {
            this.stanSprzegla = false;
        }else{
            System.out.println("Sprzęgło jest już zwolnione.");
        }

    }
}
