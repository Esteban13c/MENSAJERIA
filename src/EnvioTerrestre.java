public class EnvioTerrestre extends ENVIO{

    public EnvioTerrestre() {
    }

    public EnvioTerrestre(String codigo, String destino, double peso, double distancia) {
        super(codigo, destino, peso, distancia);
    }

    @Override
    public double Calcularcosto() {
        double costo;
        costo= 8000 + (Peso*1500)+(Distancia*400);

        if (Peso>20){
            return costo=costo +(costo * 0.2);
        }
        if (Distancia>500){
            return costo=costo +(costo * 0.15);
        }
        return costo;
    }

    @Override
    public double TiempoEntrega() {
        if (Distancia<=200){
            System.out.println(" 1 dia");
        } else if (Distancia>201 && Distancia <=500) {
            System.out.println("2 dias");
        } else if (Distancia>501 && Distancia<=1000) {
            System.out.println("3 dias");
        } else if (Distancia >1000) {
            System.out.println("5 dias");
        }

        return TiempoEntrega();
    }


}



