package BruteForce;

import java.lang.Math;
import java.util.Arrays;

public class BFDecrypt {

    //combinazioni massime calcolate dal numero di digit della combinazione della cassaforte
    private int maxCombination;

    //combinazioni attuali analizzate
    private int nCombination;

    //combinazione memorizzata della cassaforte
    private String combination;

    //n° di digit della cassaforte
    private int A, B, C, D;

    //stato di blocco della cassaforte
    private boolean lock;

    //stringa che costruisce la combinazione da analizzare
    private String[] resolver;

    /**
     * Costruttore che inizializza o parametri della csassaforte
     *
     * @param digit
     *          numero che rappresenta una parte della combinazione
     * @param comb
     *          valore che prende in input il valore della combinazione da scoprire
     */
    public BFDecrypt(int digit, String comb){
        this.maxCombination = (int) Math.pow(10, digit);
        this.resolver = new String[digit];
        Arrays.fill(this.resolver, "0");
        this.nCombination = 0;
        this.combination = comb;
        this.lock = true;
        this.A = 0;
        this.B = 0;
        this.C = 0;
        this.D = 0;
    }

    public void checkCombination(){
        while (this.lock){
            this.nCombination++;
            this.resolveCombination();
        }
    }
    public void resolveCombination(){
        if (this.combination.equals(fill(this.nCombination)))
            this.lock = false;
        System.out.println("La combinazione è " + resolver + ", trovata dopo n " + this.nCombination + " tentativi. Stato della cassaforte: " + this.lock);
    }

    private String[] fill(int n){
        String convertCombination = String.valueOf(n);
        for (int i = this.resolver.length; i < 0 ; i--) {
            this.resolver[i] = convertCombination;
        }
        return resolver;
    }
}
