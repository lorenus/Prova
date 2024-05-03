
import java.util.Comparator;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * COMPARADOR EN FUNCIO DELS KM RECORREGUTS (GASOLINA + A) 
 * @author DAW6K
 */
public class ComparadorCamions implements Comparator<CamioElectric>{

    @Override
    public int compare(CamioElectric o1, CamioElectric o2) {
        return (o1.getKmElectric()+o1.getGasolina())-;
        }
    }
    
}
