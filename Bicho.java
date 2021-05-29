public class Bicho{
    private int Salud;
    private String Nombre;

    public Bicho(){

    }

    public Bicho(int s, String n){
        this.Salud=s;
        this.Nombre=n;
    }

    public int getSalud(){
        return this.Salud;
    }

    public String getNombre(){
        return this.Nombre;
    }

    public void setSalud(int s){
        this.Salud = s;
    }

    public void setNombre(String n){
        this.Nombre = n;
    }

    public void AtaqueBala(){
        this.setSalud(this.getSalud()-5);   
    }

    public void AtaqueBomba(){
        this.setSalud(this.getSalud()-this.getSalud()); 
    }

    public void BichoMutante(){
        this.setSalud(this.getSalud()*2); 

    }
    public static int FinJuego(Bicho[][]bichos){
        int contador=0;
        int cambioIndice=0;
        for (int x=0; x < 2; x++) {
            for (int y=0; y < 2; y++) {
                if(bichos[x][y].getSalud()<1){
                    contador++;
                    if(contador>=4)  
                        cambioIndice=1;
                }
            }
        }
        return cambioIndice;
    }

    public  String toString(){
        String text1=this.Nombre;
        String text2=       String.valueOf(this.Salud);
        String text3= text1 + text2;

        return text3;
    }

}

