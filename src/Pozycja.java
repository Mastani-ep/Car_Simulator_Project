import static java.lang.Math.sqrt;

public class Pozycja {
    private double x;
    private double y;

    Pozycja(double x, double y){
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void przeniesc(double v,double dt, Pozycja pozycja){
        double odl = ((this.x - pozycja.getX())*(this.x - pozycja.getX()) + (this.y - pozycja.getY())*(this.y - pozycja.getY()));
        double dx = v*dt*(pozycja.getX()-this.x)/sqrt(odl);
        double dy = v*dt*(pozycja.getY()-this.y)/sqrt(odl);
        if(dx < 0) {
            if (this.getX() > pozycja.getX()) {
                this.setX(this.x + dx);
                if (this.getX() < pozycja.getX()) {
                    this.setX(pozycja.getX());
                }}
        }else {
                if (this.getX() < pozycja.getX()) {
                    this.setX(this.x + dx);
                    if (this.getX() > pozycja.getX()) {
                        this.setX(pozycja.getX());
                    }
                }
            }
        if(dy < 0) {
            if (this.getY() > pozycja.getY()) {
                this.setY(this.y + dy);
                if (this.getY() < pozycja.getY()) {
                    this.setY(pozycja.getY());
                }}
        }else {
            if (this.getY() < pozycja.getY()) {
                this.setY(this.y + dy);
                if (this.getY() > pozycja.getY()) {
                    this.setY(pozycja.getY());
                }
            }
        }

    }
   //public static void main(String[] args){
    //    Pozycja obj= new Pozycja(0,0);
    //    obj.przeniesc(120,1, new Pozycja(5,6));
    //System.out.println(obj.getX() +","+obj.getY());
    //}
}
