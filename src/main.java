import java.sql.*;
import java.util.Random;
import java.util.Scanner;


public class main {
    static Scanner lc = new Scanner(System.in);
    static Random rd = new Random();
    static int j=-1;
    public static void main(String[] args) {
        int resp1=0;
        int vida = 100;
        int pociones = 3;
        int defense = 0;
        int ataqueEnemigo=0;

        System.out.println("*****THE LEGEND OF ZELDA*****");
        System.out.println("Ingrese una tecla para continuar para iniciar el juego");
        String inicio = lc.next();
        System.out.println("\nLoading...\n\n\n\n\n");
        Cuartos[] cuarto= new Cuartos[41]; cuarto=inicializacionCuartos(cuarto);
        int[]c=new int[4];
        do {
            int aplicar = 1;
            j++;
            int[] x = new int[3];
            x = cuarto[j].getX();
            if (cuarto[j].getCantPuertas() < 4) {
                for (int i = 0; i < cuarto[j].getCantPuertas(); i++) {
                    if (x[i] == 1) {
                        c[0] = 1;
                    }
                    if (x[i] == 2) {
                        c[1] = 1;
                    }
                    if (x[i] == 3) {
                        c[2] = 1;
                    }
                    if (x[i] == 4) {
                        c[3] = 1;
                    }
                }
            } else {
                for (int i = 0; i < 4; i++) {
                    c[i] = 1;
                }
            }
            cuarto[j].impresion();
            int siguiente = 0;
            do {
                menu();
                boolean valorValido = true;
                Enemigos[] enemigos = new Enemigos[3];
                enemigos = cuarto[j].getEnemigos();
                do {
                    try {
                        resp1 = Integer.parseInt(lc.nextLine());
                        valorValido = true;
                    } catch (Exception ex) {
                        System.out.println("Introduzca un valor valido");
                        valorValido = false;
                    }
                } while (valorValido != true);
                switch (resp1) {
                    case 1:
                        cuarto[j].impresion();
                        break;
                    case 2:

                        if (cuarto[j].isPociones() == true) {
                            if (enemigos[0].getVida() == 0) {
                                pociones = pociones + 1;
                                if (pociones > 1) {
                                    System.out.println("Poción recogida, ahora tiene " + pociones + " pociones");
                                } else {
                                    System.out.println("Poción recogida, ahora tiene " + pociones + " poción");
                                }
                            } else {
                                System.out.println("Eliminar enemigo para recoger poción");

                            }
                        } else {
                            System.out.println("No pociones en la habitación");
                        }
                        break;
                    case 3:
                        if (cuarto[j].getCantEnemigos() == 0) {
                            if (c[0] == 1) {
                                siguiente = 1;
                            } else {
                                System.out.println("No hay puerta hacia el norte");
                            }
                        } else {
                            System.out.println("No deben haber enemigos para continuar");
                        }
                        break;
                    case 4:
                        if (cuarto[j].getCantEnemigos() == 0) {
                            if (c[1] == 1) {
                                siguiente = 1;
                            } else {
                                System.out.println("No hay puerta hacia el sur");
                            }
                        } else {
                            System.out.println("No deben haber enemigos para continuar");
                        }
                        break;
                    case 5:
                        if (cuarto[j].getCantEnemigos() == 0) {
                            if (c[2] == 1) {
                                siguiente = 1;
                            } else {
                                System.out.println("No hay puerta hacia el este");
                            }
                        } else {
                            System.out.println("No deben haber enemigos para continuar");
                        }
                        break;
                    case 6:
                        if (cuarto[j].getCantEnemigos() == 0) {
                            if (c[3] == 1) {
                                siguiente = 1;
                            } else {
                                System.out.println("No hay puerta hacia el oeste");
                            }
                        } else {
                            System.out.println("No deben haber enemigos para continuar");
                        }
                        break;
                    case 7:
                        if (cuarto[j].getCantEnemigos() != 0) {
                            {
                                int ataque = rd.nextInt(15) + 1;
                                if (enemigos[0].getVida() != 0) {
                                    if (ataque <= enemigos[0].getVida()) {
                                        enemigos[0].setVida(enemigos[0].getVida() - ataque);
                                    } else {
                                        enemigos[0].setVida(0);
                                    }
                                } else if (cuarto[j].getCantEnemigos() > 1) {
                                    if (enemigos[1].getVida() != 0) {
                                        if (ataque <= enemigos[1].getVida()) {
                                            enemigos[1].setVida(enemigos[1].getVida() - ataque);
                                        } else {
                                            enemigos[1].setVida(0);
                                        }
                                    }
                                }
                            }
                            System.out.println("Enemigo atacado");
                            System.out.print("Ahora " + enemigos[0].getName() + " tiene " + enemigos[0].getVida() + " de vida, ");
                            if (cuarto[j].getCantEnemigos() > 1) {
                                System.out.print("y " + enemigos[1].getName() + " tiene " + enemigos[1].getVida() + " de vida, ");
                            }
                            System.out.println("");
                            cuarto[j].setEnemigos(enemigos);
                            if (cuarto[j].getCantEnemigos() == 1) {
                                if (enemigos[0].getVida() == 0) {
                                    cuarto[j].setCantEnemigos(0);
                                }
                            }
                            if (cuarto[j].getCantEnemigos() == 2) {
                                if (enemigos[0].getVida() == 0 && enemigos[1].getVida() == 0) {
                                    cuarto[j].setCantEnemigos(0);
                                }
                            }


                        } else {
                            System.out.println("No hay enemigos al cual atacar");
                        }
                        if (cuarto[j].getCantEnemigos() > 0) {
                            if (enemigos[0].getVida() == 0) {
                                if (cuarto[j].getCantEnemigos() > 1 && enemigos[1].getVida() != 0) {
                                    System.out.println("Primer enemigo derrotado");
                                    if (enemigos[1].getVida() == 0) {
                                        System.out.println("Enemigos derrotados");
                                        cuarto[j].setCantEnemigos(0);
                                    }
                                }
                                if (cuarto[j].getCantEnemigos() < 1) {
                                    System.out.println("Enemigo derrotado");
                                    cuarto[j].setCantEnemigos(0);
                                }
                            }
                        }
                        break;
                    case 8:
                        defense = 1;
                        System.out.println("Defensa activa, se cubrira durante un turno");
                        break;
                    case 9:
                        if (vida >= 80) {
                            vida = 100;
                            pociones = pociones - 1;
                        } else {
                            vida = vida + 20;
                            pociones = pociones - 1;
                        }
                        System.out.println("Poción utilizada, su vida ahora es de: " + vida + " y la cantidad de pociones se redujo a: " + pociones);
                }
                if(resp1!=10){
                if (cuarto[j].getCantEnemigos() > 0) {
                    if (enemigos[0].getVida() > 0) {
                        if (defense == 0) {
                            ataqueEnemigo = rd.nextInt(10) + 1;
                            vida = vida - ataqueEnemigo;
                            if (vida<0){vida=0;}
                            System.out.println("Enemigo ha atacado, su vida ahora es: " + vida);
                        }
                    }
                    if (cuarto[j].getCantEnemigos() > 1) {
                        if (enemigos[1].getVida() > 0 && enemigos[0].getVida() == 0) {
                            ataqueEnemigo = rd.nextInt(10) + 1;
                            vida = vida - ataqueEnemigo;
                            if (vida<0){vida=0;}
                            System.out.println("Enemigo ha atacado, su vida ahora es: " + vida);
                        }
                    }
                    defense = 0;
                }
            }

            }while (siguiente !=1 && vida != 0 && resp1 !=10) ;

        }while (vida != 0 && resp1 != 10);

        }

    public static Cuartos[] inicializacionCuartos(Cuartos[] cuarto) {
        for (int i = 0; i < 40; i++) {
            cuarto[i] = new Cuartos();
            cuarto[i].setPociones(false);
            int resp = rd.nextInt(4)+1;
            cuarto[i].setCantPuertas(resp);
            int [] x = new int[3];
            x[0] = rd.nextInt(4)+1;
            do{x[1] = rd.nextInt(4)+1;}while (x[1]==x[0]); do {x[2] = rd.nextInt(4)+1; }while (x[2]==x[0]||x[2]==x[1]);
            cuarto[i].setX(x);
            cuarto[i].setPuertas(puertas(resp,x));
            int cantenemigos = rd.nextInt(3) ;
            cuarto[i].setCantEnemigos(cantenemigos);
            Enemigos[] enemigos = new Enemigos[cantenemigos];
            int pociones;
            if (cantenemigos>0){
                pociones= rd.nextInt(2);
            for (int j = 0; j < cantenemigos; j++) {
                enemigos[j] = new Enemigos();
                enemigos[j].setName(nombreEnemigo());
                enemigos[j].setVida(rd.nextInt(20)+1);
               }
            if (pociones==1){cuarto[i].setPociones(true);}
            cuarto[i].setEnemigos(enemigos);
            }
            }
     return cuarto;
}


    public static String nombreEnemigo() {
        int x = rd.nextInt(5)+1;
        String name = "";
        switch (x){
            case 1: name = "Dragon";break;
            case 2: name = "Esqueleto";break;
            case 3: name = "Guerrero";break;
            case 4: name = "Asesino";break;
            case 5: name = "Zombie";break;
        }
        return name;
    }

    public static void menu() {
        System.out.println("1.-Mirar\n2.-Recoger \n3.-Norte\n4.-Sur\n5.-Este\n6.-Oeste\n7.-Ataque\n8.-Defender\n9.-Usar poción\n10.-Salir");
    }
    public static String[] puertas(int resp, int[] x) {
        String[] puerta = new String[4];
        switch (x[0]) {
            case 1:
                puerta[0] = "Hay una puerta al norte";
                break;
            case 2:
                puerta[0] = "Hay una puerta al sur";
                break;
            case 3:
                puerta[0] = "Hay una puerta al este";
                break;
            case 4:
                puerta[0] = "Hay una puerta al oeste";
                break;
        }
        if (resp > 1) {
            switch (x[1]) {
                case 1:
                    puerta[1] = "Hay una puerta al norte";
                    break;
                case 2:
                    puerta[1] = "Hay una puerta al sur";
                    break;
                case 3:
                    puerta[1] = "Hay una puerta al este";
                    break;
                case 4:
                    puerta[1] = "Hay una puerta al oeste";
                    break;
            }}
            if (resp > 2) {
                switch (x[2]) {
                    case 1:
                        puerta[2] = "Hay una puerta al norte";
                        break;
                    case 2:
                        puerta[2] = "Hay una puerta al sur";
                        break;
                    case 3:
                        puerta[2] = "Hay una puerta al este";
                        break;
                    case 4:
                        puerta[2] = "Hay una puerta al oeste";
                        break;
                }
            }
                if (resp == 4) {
                    puerta[0] = "Hay una puerta al norte";
                    puerta[1] = "Hay una puerta al sur";
                    puerta[2] = "Hay una puerta al este";
                    puerta[3] = "Hay una puerta al oeste";
                }

                return puerta;

            }

        }
