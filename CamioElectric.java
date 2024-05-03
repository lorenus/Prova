
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author DAW6K
 */
public class CamioElectric {

    private int kmGasolina;
    private int kmElectric;
    private double gasolina;
    private int electricA;

    public CamioElectric() {
        this.kmGasolina = 0;
        this.kmElectric = 0;
        this.gasolina = 10; // Màxim 10 litres
        this.electricA = 6000; // Total de 6000 A
    }

    public int getKmGasolina() {
        return kmGasolina;
    }

    public int getKmElectric() {
        return kmElectric;
    }

    public double getGasolina() {
        return gasolina;
    }

    public int getElectricA() {
        return electricA;
    }

    
    public void avançar(int km) {

        if (kmGasolina > 10) {
            if (gasolina > 0) {
                electricA -= (km * 20);
                kmElectric = km;
            } else {
                electricA -= (km * 100);
                kmElectric = km;
            }

        } else {
            if (kmGasolina + km < 10) {
                gasolina -= ((kmGasolina % 5) + (km % 5));
                kmGasolina += km;

                } else {

                gasolina -= (((kmGasolina % 5) + ((10 - kmGasolina) % 5)));
                kmGasolina += (10 - kmGasolina);
                if (gasolina > 0) {
                    electricA -= ((km - (10 - kmGasolina)) * 20);
                    
                } else {
                    electricA -= ((km - (10 - kmGasolina)) * 100);
                   
                }
                kmElectric = (km - kmGasolina);
            }

        }

        if (electricA <= 0 && gasolina <= 0) {
            System.out.println("PUM! El camio ha explotat");
        } else {
            System.out.println("Avancem " + km + " km");
        }

    }

    public void repostarGasolina(double litres) {
        gasolina += litres;

        if (gasolina > 10) {
            System.out.println("PUM! El camio ha explotat");
        }
    }

    public void repostarElectric() {
        electricA = 6000;
    }

    public void status() {
        System.out.println("Km Gasolina: " + kmGasolina
                + "\nKM A: " + kmElectric
                + "\nCost A: " + (kmElectric * 0.2)
                + "\nCost gasolina: " + (kmGasolina * 1.2)
                + "\nQueden " + gasolina + " litres de gasolina"
                + "\nQueden " + electricA + " amperis");
    }

    // Altres mètodes privats per a gestió interna
    public static void main(String[] args) throws IOException {
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
        int res;
        CamioElectric camio= new CamioElectric();
        
        do {
            System.out.println("MENU D'INICI");
            System.out.println("1. Avançar");
            System.out.println("2. Repostar");
            System.out.println("3. Status");
            System.out.println("0. Eixir");
            System.out.println("Introdueix el número de l'opcio desitjada");

            res = Integer.parseInt(leer.readLine());

            switch (res) {
                case 1:
                    System.out.println("Introdueix els km que vols avançar");
                    int km= Integer.parseInt(leer.readLine());
                    camio.avançar(km);
                    break;
                    
                case 2:
                    System.out.println("Per a repostar gasolina pulsa 1, per a elèctric pulsa 2");
                    int r= Integer.parseInt(leer.readLine());
                    if(r==1){
                        System.out.println("Introdueix els litres que vols repostar");
                        double l=Double.parseDouble(leer.readLine());
                        camio.repostarGasolina(l);
                    }else{
                        camio.repostarElectric();
                    }
                    break;
                case 3: 
                    camio.status();
                    break;
            }
        } while (res != 0);
        while (res != 0);
    }
}
