import java.util.Random;
import java.math.BigInteger;
public class Individuo {
    private String hexa;
    private String bin;
    //Constructor
    public Individuo(Integer tamañoIndividuo){
        this.setHexa(this.getRandomHexString(tamañoIndividuo));
        this.setBin(this.toBin(this.getHexa()));
    }
    
    //G&S
    public String getBin() {
        return this.bin;
    }
    
    public void setBin(String bin) {
        this.bin = bin;
    }
    
    public String getHexa() {
        return this.hexa;
    }
    
    public void setHexa(String hexa) {
        this.hexa = hexa;
    }
    
    //Metodos
    private String getRandomHexString(Integer tamañoIndividuo){
        Random r = new Random();
        Integer num;
        StringBuffer sb = new StringBuffer();
        while(sb.length() < tamañoIndividuo){
            num=r.nextInt(16)+1;
            sb.append(Integer.toHexString(num));
        }
        return sb.toString().substring(0, tamañoIndividuo);
    }
    public String alterarNumBin(int position, String str){
        char[] charArray = str.toCharArray();
        //System.out.println(charArray[position]);
        charArray[position] = (char) (str.charAt(position) ^ 1);
        //System.out.println(charArray[position]);
        return new String(charArray);
    }
    
    private String toBin(String hexString) {
        String bin = new BigInteger("1" + hexString, 16).toString(2).substring(1);
        return bin;
    }
    
    private Integer countH(Individuo solucion){
        Integer h=0;
        for(int i=0;i<this.getHexa().length();i++){
            if( this.getHexa().charAt(i) == solucion.getHexa().charAt(i) ){
                h++;
            }
        }
        return h;
    }
    
    private Integer countB(Individuo solucion){
        Integer b=0;
        for(int i=0;i<this.getBin().length();i++){
            if( this.getBin().charAt(i) == solucion.getBin().charAt(i) ){
                b++;
            }
        }
        return b;
    }
    
    public Integer getFitness(Individuo solucion) {
        return (this.countH(solucion)+1)*this.countB(solucion)*this.countB(solucion);
    }
    
    public void mutar(Integer maximoAMutar) {
        Random rand = new Random();
        int cant = rand.nextInt(maximoAMutar);
        for(int i=1; i < cant; i++){
            Random aux = new Random();
            this.setBin(this.alterarNumBin(aux.nextInt(this.getBin().length()), this.getBin()));
        }
        this.setHexa(this.toHexa(this.getBin()));
    }
    
    public String toHexa(String binString) {
        BigInteger b = new BigInteger(binString, 2);
        return b.toString(16);
    }
}