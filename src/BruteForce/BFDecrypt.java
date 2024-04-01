package BruteForce;

import java.lang.Math;
public class BFDecrypt {

    private int maxCombination;

    private int nCombination;

    private int combination;

    private int A, B, C, D;

    private boolean lock;

    private String s, resolver;

    public BFDecrypt(int digit, int comb){
        this.maxCombination = (int) Math.pow(10, digit);
        this.resolver = "";
        this.nCombination = 0;
        this.combination = comb;
        this.lock = true;
        this.A = 0;
        this.B = 0;
        this.C = 0;
        this.D = 0;
        this.s = String.valueOf(this.combination);
    }

    public int checkCombination(){

        for (int i = 0; i <= maxCombination; i++) {
            this.D = i;
            if (!lock || (this.nCombination == maxCombination)) {
                break;
            }
            else this.nCombination++;
            resolveCombination();
            if (this.D == 9){
                this.C++;
            }
            if (this.C == 9){
                this.B++;
            }
            if (this.B == 9){
                this.A++;
            }

        }
        return 0;
    }
    public void resolveCombination(){
        this.resolver = String.valueOf((A) + (B) + (C) + (D));
        if (s.equals(resolver))
            this.lock = false;
        System.out.println("La combinazione è " + resolver + ", trovata dopo n " + this.nCombination + " tentativi. Stato della cassaforte: " + this.lock);

    }
}
