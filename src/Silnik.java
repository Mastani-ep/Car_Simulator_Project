public class Silnik extends Komponent{
    private double maxObroty;
    private double obroty;
    private boolean stan;

    public Silnik(double max_obroty, String nazwa, double cena, double waga){
        super(nazwa, waga, cena);
        this.maxObroty = max_obroty;
        this.obroty = 0;
    }


    public double getObroty(){
        return obroty;
    }

    public double getMaxObroty() {
        return maxObroty;
    }

    public void zwiekszObroty(double zmiana){
        if(this.stan) {
            if(this.obroty < this.maxObroty) {
                if(this.obroty + zmiana < this.maxObroty){
                    this.obroty+=zmiana;
                }else{
                    this.obroty=this.maxObroty;
                }
            }else{
                System.out.println("Osiągnąłeś maksymalne obroty.");
            }
        }else{
            System.out.println("Silnik nie jest włączony");
        }
    }

    public void zmniejszObroty(double zmiana){
        if(this.stan) {
            if(this.obroty > 0) {
                if(this.obroty - zmiana > 0) {
                    this.obroty -= zmiana;
                }else{
                    this.obroty = 0;
                }
            }else{
                System.out.println("Aktualne obroty wynoszą 0.");
            }
        }else{
            System.out.println("Silnik nie jest włączony");
        }
    }

    public void uruchom(){
        this.stan = true;
    }

    public void zatrzymaj(){
        this.stan = false;
    }
}
