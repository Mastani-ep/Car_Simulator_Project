import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NowySamochodGUI extends JFrame{
    private JTextField NrRej;
    private JTextField Model;
    private JTextField Marka;
    private JTextField PredkoscMax;
    private JRadioButton SkrzBieg5;
    private JRadioButton SkrzBieg6;
    private JRadioButton SilBenzyna;
    private JRadioButton SilDiesel;
    private JButton DodajSam;
    private JButton Anuluj;
    private JLabel Nrrej;
    private JLabel model;
    private JLabel predkoscMax;
    private JLabel marka;
    private JLabel Skrzynia;
    private JLabel Silnik;
    private JPanel NowySamochod;
    ButtonGroup skrzynie = new ButtonGroup();
    ButtonGroup silniki = new ButtonGroup();
    public NowySamochodGUI(JComboBox wyborSam){
        setContentPane(NowySamochod);
        skrzynie.add(SkrzBieg5);
        skrzynie.add(SkrzBieg6);
        silniki.add(SilBenzyna);
        silniki.add(SilDiesel);

        DodajSam.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Pozycja pozycja = new Pozycja(0,0);
                double predkosc = 220;
                Sprzeglo sprzeglo = new Sprzeglo("Sprzeglo", 150, 300);

                Silnik silnikDiesel = new Silnik(8000, "Diesel", 5000, 550 );
                Silnik silnikBenzyna = new Silnik(7000, "Benzyna", 4500, 550 );
                //default silnik
                Silnik silnik = new Silnik(7500, "Benzyna - default", 4500, 550 );;

                SkrzyniaBiegow skrzynia5 = new SkrzyniaBiegow(sprzeglo, 5, 50, 600, "Manual-5");
                SkrzyniaBiegow skrzynia6 = new SkrzyniaBiegow(sprzeglo, 6, 70, 800, "Manual-6");
                //default skrzynia
                SkrzyniaBiegow skrzynia = new SkrzyniaBiegow(sprzeglo, 5, 50, 600, "Manual-5-default");
                int random =(int) (Math.random()*400 +1);
                String nrRej = NrRej.getText();
                String marka = Marka.getText();
                String model = Model.getText();

                if(nrRej.equals("")){
                    nrRej = "KR" + String.valueOf(random);
                }
                random =(int) (Math.random()*50 +1);
                if(model.equals("")) {
                    model = "AUTO " + random;
                }


                if(SilDiesel.isSelected()){
                    silnik = silnikDiesel;
                }else if(SilBenzyna.isSelected()){
                    silnik = silnikBenzyna;
                }

                if(SkrzBieg5.isSelected()){
                    skrzynia = skrzynia5;
                }else if(SkrzBieg6.isSelected()){
                    skrzynia = skrzynia6;
                }

                try{
                    predkosc = Double.parseDouble(PredkoscMax.getText());
                }catch(Exception e1){
                    System.out.println("Nie podałeś poprawnej wartości prędkości. Została zastapiona domyślną: 220.");
                }

                Samochod nowySamochod = new Samochod(nrRej, model, marka, predkosc, skrzynia, pozycja, silnik);

                wyborSam.addItem(nowySamochod);
                dispose();
            }
        });

        Anuluj.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
}
