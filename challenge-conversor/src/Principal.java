import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        ConsultaMoneda consulta = new ConsultaMoneda();

        int opcion = 0;
        while (opcion!=7){
            System.out.println("**************************************\n");
            System.out.println("Sea bienvenido/a el conversor de monedas\n");
            System.out.println("1) Dolar =>> Peso argetino");
            System.out.println("2) Peso argentino =>> Dolar");
            System.out.println("3) Dolar =>> Real brasileño");
            System.out.println("4) Real brasileño =>> Dolar");
            System.out.println("5) Dolar =>> Peso colombiano");
            System.out.println("6) Peso colombiano =>> Dolar");
            System.out.println("7) Salir\n");
            System.out.println("Elija una opcion valida:\n");
            System.out.println("**************************************\n");
            opcion = lectura.nextInt();


            try {
                System.out.println("Ingrese un monto a convertir:");
                double monto = Double.parseDouble(String.valueOf(lectura.nextDouble()));
                switch (opcion){
                    case 1:
                        Moneda UsdAArs = consulta.buscaMoneda("USD","ARS", monto);
                        System.out.println("La converison de dolar a peso argentino es: "+UsdAArs);
                        break;
                    case 2:
                        Moneda ArsAUsda = consulta.buscaMoneda("ARS","USD", monto);
                        System.out.println("La conversión de peso argentino a dolar es: "+ArsAUsda);
                        break;
                    case 3:
                        Moneda UsdABrl = consulta.buscaMoneda("USD", "BRL",monto);
                        System.out.println("La conversión de dolar a real brasileño es: "+UsdABrl);
                        break;
                    case 4:
                        Moneda BrlAUsd = consulta.buscaMoneda("BRL", "USD",monto);
                        System.out.println("La conversión de real brasileño a dolar es: "+BrlAUsd);
                        break;
                    case 5:
                        Moneda UsdACop = consulta.buscaMoneda("USD", "COP",monto);
                        System.out.println("La conversión de dolar a peso colombiano es: "+UsdACop);
                        break;
                    case 6:
                        Moneda CopAUsd = consulta.buscaMoneda("COP", "USD",monto);
                        System.out.println("La conversión de peso colombiano a dolar  es: "+CopAUsd);
                        break;
                    case 7:
                        System.out.println("Salieno, gracias por usar el convertidor de monedas");

                    default:
                        System.out.println("Opción no valida");
                        break;
                }
            }catch (Exception e){
               System.out.println("Error, el programa se cierra");
               break;
            }
        }
    }
}
