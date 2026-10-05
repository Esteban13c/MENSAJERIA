public abstract class ENVIO {

    protected String Codigo;
    protected String Destino;
    protected double Peso;
    protected double Distancia;

    public ENVIO () {
    }

    public ENVIO (String codigo, String destino, double peso, double distancia) {
        Codigo = codigo;
        Destino = destino;
        Peso = peso;
        Distancia = Distancia;
    }

public abstract double Calcularcosto ();
    public abstract double TiempoEntrega ();

    public void MonstrarInformacion (){
        System.out.println("Codigo: "+Codigo);
        System.out.println("Destino: "+Destino);
        System.out.println("Peso: "+Peso);
        System.out.println("Distancia"+ Distancia);
        System.out.println(Calcularcosto());
        System.out.println(TiempoEntrega());

    }


}
