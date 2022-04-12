public class Samochod extends Thread{
    private boolean stanWlaczenia;
    private String nrRejestr;
    private String model;
    private String marka;
    private double predkoscMax;
    private Pozycja pozycja;
    private Pozycja cel = new Pozycja(0,0);
    private double predkosc = 0; //do zmiany biegow
    private int bieg = 0;// do zmiany biegow
    SkrzyniaBiegow skrzynia;
    Silnik silnik;


    public Samochod(String nrRejestr, String model, String marka ,double predkoscMax, SkrzyniaBiegow skrzynia, Pozycja pozycja,Silnik silnik){
        this.nrRejestr = nrRejestr;
        this.model = model;
        this.marka = marka;
        this.predkoscMax = predkoscMax;
        this.skrzynia = skrzynia;
        this.pozycja = pozycja;
        this.silnik = silnik;
        start();
    }

    public void wlacz(){
        if(!isStanWlaczenia()) {
            if(this.skrzynia.sprzeglo.isStanSprzegla() && this.skrzynia.getAktualnyBieg() == 0) {
                this.stanWlaczenia = true;
                this.silnik.uruchom();
            }else{
                System.out.println("Proszę wcisnąć sprzęgło lub zmniejszyć bieg.");
            }
        }else{
            System.out.println("Samochod jest już włączony.");
        }
    }

    public void wylacz(){
        if(isStanWlaczenia()) {
            if( this.silnik.getObroty() == 0) {
                this.stanWlaczenia = false;
                this.silnik.zatrzymaj();
            }else{
                System.out.println("Bezpieczniej jest zmniejszyć obroty przed wyłączeniem auta.");
            }
        }else{
            System.out.println("Samochod jest już wyłączony.");
        }
    }

    public void jedzDo(Pozycja cel){
        this.cel = cel;
    }

    public void zwiekszBieg(){
        this.bieg = this.skrzynia.getAktualnyBieg();
        this.predkosc = this.getAktPredkosc();
        this.skrzynia.zwiekszBieg();
        if(this.skrzynia.getAktualnyBieg()!=bieg) {
            double zmianaObr = this.silnik.getObroty()- predkosc/(this.skrzynia.getAktualnePrzelozenie()*0.02);
            this.silnik.zmniejszObroty(zmianaObr);
        }
    }

    public void zmniejszBieg(){
        this.bieg = this.skrzynia.getAktualnyBieg();
        this.predkosc = this.getAktPredkosc();
        this.skrzynia.zmniejszBieg();
        if(this.skrzynia.getAktualnyBieg()!=bieg) {
            double zmianaObr = predkosc/(this.skrzynia.getAktualnePrzelozenie()*0.02)-this.silnik.getObroty();
            this.silnik.zwiekszObroty(zmianaObr);
        }
    }
    public double getWaga(){
        return this.silnik.getWaga() + this.skrzynia.getWaga() +this.skrzynia.sprzeglo.getWaga()+1000;
    }

    public double getAktPredkosc(){
        if(this.silnik.getObroty()*this.skrzynia.getAktualnePrzelozenie()*0.02 <= this.predkoscMax){
            return this.silnik.getObroty()*this.skrzynia.getAktualnePrzelozenie()*0.02;
        }else {
            return this.predkoscMax;
        }
    }

    public Pozycja getAktPozycja(){
        return this.pozycja;
    }
    public String getModel() {
        return model;
    }

    public String getMarka() {
        return marka;
    }

    public String getNrRejestr() {
        return nrRejestr;
    }

    public boolean isStanWlaczenia() {
        return stanWlaczenia;
    }

    public String toString(){
        if(getMarka().equals("")) {
            return getNrRejestr() + "," + getModel();
        }else {
            return getNrRejestr() + "," + getMarka() + "," + getModel();
        }
    }

    public void run(){
        while(true){
            this.pozycja.przeniesc(this.getAktPredkosc(), 0.1, this.cel);
            try {
                sleep(100);
            }catch(InterruptedException e){
                e.printStackTrace();
                return;
            }

        }
    }


    public static void main(String[] args){
        // A = new Samochod("KR12345","grbus",220,new SkrzyniaBiegow(new Sprzeglo(),0,6),new Pozycja(0,0), new Silnik(4500));
        //A.jedzDo(new Pozycja(20,20));
    }

}

