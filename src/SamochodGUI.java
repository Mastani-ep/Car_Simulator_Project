import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SamochodGUI extends Thread{
    private JPanel Sprzęgło;
    private JPanel Silnik;
    private JPanel Skrzynia;
    private JPanel Samochód;
    private JPanel Mapa;
    private JPanel Panel;
    private JPanel Samochod;
    private JTextField samModel;
    private JTextField samNrrej;
    private JTextField samWaga;
    private JTextField samPred;
    private JTextField skrzNazwa;
    private JTextField skrzCena;
    private JTextField skrzWaga;
    private JTextField skrzBieg;
    private JTextField silNazwa;
    private JTextField silCena;
    private JTextField silWaga;
    private JTextField silObroty;
    private JTextField sprzNazwa;
    private JTextField sprzWaga;
    private JTextField sprzStan;
    private JTextField sprzCena;
    private JButton silnikWylacz;
    private JButton silnikWlacz;
    private JButton Zwbieg;
    private JButton Zmbieg;
    private JButton dodgaz;
    private JButton zmgaz;
    private JButton Sprznac;
    private JButton Sprzzw;
    private JButton Usunsam;
    private JButton Dodsam;
    private JComboBox wybierzSamochod;
    private JLabel samIcon;


    private Samochod sam;


    public SamochodGUI(Samochod s){
        sam = s;
        refresh();
        silnikWlacz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(sam!=null){
                    sam.wlacz();
                }else{
                    System.out.println("Najpierw musisz stworzyć samochód.");
                }
                refresh();
            }
        });

        silnikWylacz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(sam!=null){
                    sam.wylacz();
                }else{
                    System.out.println("Najpierw musisz stworzyć samochód.");
                }
                refresh();
            }
        });

        Zwbieg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(sam!=null){
                    sam.zwiekszBieg();
                }else{
                    System.out.println("Najpierw musisz stworzyć samochód.");
                }
                refresh();
            }
        });
        Zmbieg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(sam!=null){
                    sam.zmniejszBieg();
                }else{
                    System.out.println("Najpierw musisz stworzyć samochód.");
                }
                refresh();
            }
        });
        dodgaz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(sam!=null){
                    sam.silnik.zwiekszObroty(300);
                }else{
                    System.out.println("Najpierw musisz stworzyć samochód.");
                }
                refresh();
            }
        });
        zmgaz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(sam!=null){
                    sam.silnik.zmniejszObroty(300);
                }else{
                    System.out.println("Najpierw musisz stworzyć samochód.");
                }
                refresh();
            }
        });
        Sprznac.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(sam!=null){
                    sam.skrzynia.sprzeglo.wcisnij();
                }else{
                    System.out.println("Najpierw musisz stworzyć samochód.");
                }
                refresh();
            }
        });
        Sprzzw.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(sam!=null){
                    sam.skrzynia.sprzeglo.zwolnij();
                }else{
                    System.out.println("Najpierw musisz stworzyć samochód.");
                }
                refresh();
            }
        });
        Mapa.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                if(sam!=null){
                    sam.jedzDo(new Pozycja(e.getX(), e.getY()));
                    //System.out.println(e.getX() + "," + e.getY());
                    //.out.println(sam.getAktPozycja().getX() + "," + sam.getAktPozycja().getY());
                }else{
                    System.out.println("Najpierw musisz stworzyć samochód, żeby pojechać gdziekolwiek.");
                }
                refresh();
            }
        });
        this.start();

        wybierzSamochod.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sam = (Samochod) wybierzSamochod.getSelectedItem();
                samIcon.isVisible();
                refresh();
            }
        });

        Dodsam.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame f = new NowySamochodGUI(wybierzSamochod);
                f.pack();
                f.setVisible(true);
                refresh();
            }
        });

        Usunsam.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               wybierzSamochod.removeItem(wybierzSamochod.getSelectedItem());
               try {
                   sam.interrupt();
               }catch(NullPointerException n){
                   return;
                }
               refresh();
            }
        });
    }
    public void refresh(){
        if(this.sam!=null) {
            samModel.setText(sam.getModel());
            samNrrej.setText(sam.getNrRejestr());
            samWaga.setText(String.valueOf(sam.getWaga()));
            samPred.setText(String.valueOf(sam.getAktPredkosc()));

            silNazwa.setText(sam.silnik.getNazwa());
            silCena.setText(String.valueOf(sam.silnik.getCena()));
            silWaga.setText(String.valueOf(sam.silnik.getWaga()));
            silObroty.setText(String.valueOf(sam.silnik.getObroty()));

            skrzNazwa.setText(sam.skrzynia.getNazwa());
            skrzCena.setText(String.valueOf(sam.skrzynia.getCena()));
            skrzWaga.setText(String.valueOf(sam.skrzynia.getWaga()));
            skrzBieg.setText(String.valueOf(sam.skrzynia.getAktualnyBieg()));

            sprzNazwa.setText(sam.skrzynia.sprzeglo.getNazwa());
            sprzStan.setText(String.valueOf(sam.skrzynia.sprzeglo.isStanSprzegla()));
            sprzCena.setText(String.valueOf(sam.skrzynia.sprzeglo.getCena()));
            sprzWaga.setText(String.valueOf(sam.skrzynia.sprzeglo.getWaga()));

            samIcon.setLocation((int) sam.getAktPozycja().getX(), (int) sam.getAktPozycja().getY());
            samIcon.setVisible(true);
            //System.out.println(samIcon.getX()+","+ samIcon.getY());
        }else{
            samModel.setText("");
            samNrrej.setText("");
            samWaga.setText("");
            samPred.setText("");

            silNazwa.setText("");
            silCena.setText("");
            silWaga.setText("");
            silObroty.setText("");

            skrzNazwa.setText("");
            skrzCena.setText("");
            skrzWaga.setText("");
            skrzBieg.setText("");

            sprzNazwa.setText("");
            sprzStan.setText("");
            sprzCena.setText("");
            sprzWaga.setText("");

            //samIcon.setLocation(0, 0);
            samIcon.setVisible(false);
        }

    }
    public void run(){
        while(true){
            refresh();
            try {
                sleep(100);
            }catch(InterruptedException e){
                System.out.println("got interrupted!");
            }
        }
    }
    public static void main(String[] args) {
        //Silnik
        Silnik Benzyna = new Silnik(8000, "Benzyna", 5000, 150);
        //Sprzeglo
        Sprzeglo sprzeglo = new Sprzeglo("Sprzeglo", 130, 500);
        //Skrzynia biegów
        SkrzyniaBiegow manual6 = new SkrzyniaBiegow(sprzeglo,6, 50, 600, "Manual-6");
        //Pozycja
        Pozycja pozycja = new Pozycja(0,0);

        Samochod sam = null;
        // Samochod sam = new Samochod("KR12345", "grbus","Volvo" ,220, manual6, pozycja, Benzyna);
        JFrame frame = new JFrame("SamochodGUI");
        frame.setContentPane(new SamochodGUI(sam).Samochod);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
}

