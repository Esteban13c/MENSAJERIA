public class EnvioAereo extends ENVIO {

    public EnvioAereo() {
    }

    public EnvioAereo(String codigo, String destino, double peso, double distancia) {
        super(codigo, destino, peso, distancia);
    }

    @Override
    public double Calcularcosto() {
        double costo;
        costo= 8000 + (Peso*4000)+(Distancia*600);

        if (Peso>10){
            return costo=costo +(costo * 0.2);
        }
        if (Distancia>1000){
            return costo=costo +(costo * 0.05);
        }
        return costo;
    }

    @Override
    public double TiempoEntrega() {
        if (Distancia<=500){
            System.out.println(" 1 dia");
        } else if (Distancia>501 && Distancia <=1500) {
            System.out.println("2 dias");
        } else if (Distancia >1500) {
            System.out.println("3 dias");
        }
        return TiempoEntrega();
    }
}
