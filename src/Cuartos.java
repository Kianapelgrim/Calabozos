public class Cuartos {
    private int cantPuertas;
    private int cantEnemigos;
    private String [] puertas= new String[3];
    private Enemigos [] enemigos = new Enemigos[cantEnemigos];
    private boolean pociones;
    private int[] x;

    public int[] getX() {
        return x;
    }

    public void setX(int[] x) {
        this.x = x;
    }

    public boolean isPociones() {
        return pociones;
    }

    public void setPociones(boolean pociones) {
        this.pociones = pociones;
    }

    public Enemigos[] getEnemigos() {
        return enemigos;
    }

    public void setEnemigos(Enemigos[] enemigos) {
        this.enemigos = enemigos;
    }


    public int getCantPuertas() {
        return cantPuertas;
    }

    public String[] getPuertas() {
        return puertas;
    }

    public void setPuertas(String[] puertas) {
        this.puertas = puertas;
    }

    public int getCantEnemigos() {
        return cantEnemigos;
    }

    public void setCantEnemigos(int cantEnemigos) {
        this.cantEnemigos = cantEnemigos;
    }

    public void setCantPuertas(int cantPuertas) {
        this.cantPuertas = cantPuertas;
    }
    public void impresion (){
        System.out.print("En el cuarto hay "+ cantPuertas+" puertas, ");
        for (int i = 0; i < cantPuertas; i++) {
            System.out.print(puertas[i]+", ");
        }
        System.out.print(" "+cantEnemigos+" enemigos, ");
        if(cantEnemigos>0){
        for (int i = 0; i < cantEnemigos; i++) {
            System.out.print("un "+enemigos[i].getName()+" con "+enemigos[i].getVida()+" de vida, ");
        }}
        System.out.print("y hay ");if(pociones==true) {System.out.println("1 poción en el cuarto");}else{
            System.out.println("0 pociones en el cuarto");
        }
    }

}
