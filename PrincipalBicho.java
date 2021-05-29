import java.util.*;
public class PrincipalBicho{

    public static void main(String[]args){
        Scanner lea = new Scanner(System.in);
        Random azar= new Random(); 
        Bicho bichos[][] = new Bicho [2][2];
        for (int x=0; x < 2; x++) {

            for (int y=0; y < 2; y++) {
                bichos[x][y]= new Bicho(0,"");

            }

        }
        int indice=0;
        while(indice<1){
            System.out.println("Bienvenido a guerra de bichos selecciona una opcion:   ");
            System.out.println("Presione 0 para salir del juego");
            System.out.println("Presione 1 para crear los bichos");
            System.out.println("Presione 2 para ver el campo de batalla");
            System.out.println("Presione 3 para disparar una bala");
            System.out.println("Presione 4 para activar la bomba atomica");
            System.out.println("Presione 5 para activar a el bicho mutante");
            int caso = lea.nextInt();
            switch(caso){
                case 0:
                indice=1;
                System.out.println("Gracias por jugar Guerra de Bichos");
                break;

                case 1:
                int cantidadBichos= azar.nextInt(5);
                for (int i = 0; i<2; i++) {
                    for (int j = 0; j<2; j++) {
                        int SelecciondeBicho= azar.nextInt(3);
                        Bicho b1= new Bicho();
                        if(SelecciondeBicho==1){
                            System.out.println("Se creo BichoNormal");
                            b1.setNombre("BN");
                            b1.setSalud(10);
                            bichos[i][j]=b1;
                        }else if (SelecciondeBicho==2){
                            System.out.println("Se creo BichoAlien");
                            b1.setNombre("BA");
                            b1.setSalud(20);
                            bichos[i][j]=b1;
                        }
                    }
                }
                continue;

                case 2:
                System.out.println("CAMPO DE BATALLA");
                for (int x=0; x < 2; x++) {
                    System.out.print("------" + " ------" + "\n");
                    for (int y=0; y < 2; y++) {
                        System.out.print ("|"+bichos[x][y]+"| " );

                    }
                    System.out.println("\n" +"------" + " ------"  );
                }
                continue;

                case 3:
                System.out.println("Ingrese el numero de la fila");
                int fila= lea.nextInt();

                System.out.println("Ingrese el numero de la columna");
                int columna= lea.nextInt();

                if(fila <= 1 && columna <= 1){
                    System.out.print("Disparo efectuado");
                    bichos[fila][columna].AtaqueBala();
                }else{
                    System.out.println("Parametros no admitidos");
                }
                indice=Bicho.FinJuego(bichos); 
                continue;

                case 4:
                System.out.println("Escogiendo Fila...");
                int fila2= azar.nextInt(2);

                System.out.println("Escogiendo Columna...");
                int columna2= azar.nextInt(2);

                if(fila2 <= 1 && columna2 <= 1){
                    System.out.print("Bomba desplegada");
                    bichos[fila2][columna2].AtaqueBomba();
                }
                indice=Bicho.FinJuego(bichos); 
                continue;

                case 5:
                int f=bichos[0][0].getSalud();
                for (int i = 0; i<2; i++) {
                    for (int j = 0; j<2; j++) {

                        if(bichos[i][j].getSalud() < f  ){
                            if(bichos[i][j].getSalud() != 0){
                                f= bichos[i][j].getSalud();
                            }
                        }
                    }
                }
                if(f == bichos[0][0].getSalud()  ){
                    bichos[0][0].BichoMutante();
                }else if(f == bichos[0][1].getSalud()){
                    bichos[0][1].BichoMutante();
                }else if(f == bichos[1][0].getSalud() ){
                    bichos[1][0].BichoMutante();
                }else if( f == bichos[1][1].getSalud() ){
                    bichos[1][1].BichoMutante();
                }

                continue;
            }
        }
    }
}