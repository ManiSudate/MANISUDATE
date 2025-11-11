import static java.lang.Math.pow;


public class Cerchio {
    float raggio;

    public void setRaggio(float raggio) {
        this.raggio = raggio;
    }

    public float getRaggio(){
        return this.raggio;
    }

    public float calcArea(){
        return (float) (Math.PI*pow(raggio, 2));
    }
    public float calcCirconferenza(){
        return (float) (2*Math.PI*raggio);
    }
}
