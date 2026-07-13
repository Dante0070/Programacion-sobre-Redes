import java.io.*;

public class Main {

    static BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {

        int opcion;

        do {

            System.out.println("\n==============================");
            System.out.println("1 - Guardar ultimo dato");
            System.out.println("2 - Guardar numeros");
            System.out.println("3 - Crear numeros.txt");
            System.out.println("4 - Mostrar numeros.txt");
            System.out.println("5 - Eliminar multiplos de 3");
            System.out.println("6 - Crear primos.dat");
            System.out.println("7 - Caracteres");
            System.out.println("9 - Clima");
            System.out.println("0 - Salir");

            System.out.print("Opción: ");

            opcion = Integer.parseInt(teclado.readLine());

            switch(opcion){

                case 1:
                    ejercicio1();
                    break;

                case 2:
                    ejercicio2();
                    break;

                case 3:
                    ejercicio3();
                    break;

                case 4:
                    ejercicio4();
                    break;

                case 5:
                    ejercicio5();
                    break;

                case 6:
                    ejercicio6();
                    break;

                case 7:
                    ejercicio7();
                    break;


                case 9:
                    clima();
                    break;

            }

        }while(opcion!=0);

    }
    

    //================ EJERCICIO 1 =================
    

    static void ejercicio1() throws Exception{

        String dato="";
        String ultimo="";

        System.out.println("Ingrese datos (FIN para terminar)");

        do{

            dato=teclado.readLine();

            if(!dato.equalsIgnoreCase("FIN")){

                ultimo=dato;

            }

        }while(!dato.equalsIgnoreCase("FIN"));

        PrintWriter pw=new PrintWriter("ultimoDato.txt");

        pw.println(ultimo);

        pw.close();

        System.out.println("Último dato guardado.");

    }
    

    //================ EJERCICIO 2 =================
    

    static void ejercicio2() throws Exception{

        PrintWriter pw=new PrintWriter("numerosIngresados.txt");

        String dato;

        System.out.println("Ingrese datos (FIN para terminar)");

        do{

            dato=teclado.readLine();

            if(!dato.equalsIgnoreCase("FIN")){

                try{

                    int numero=Integer.parseInt(dato);

                    pw.println(numero);

                }catch(Exception e){

                }

            }

        }while(!dato.equalsIgnoreCase("FIN"));

        pw.close();

        System.out.println("Archivo creado.");

    }
    

    //================ EJERCICIO 3 =================
    

    static void ejercicio3() throws Exception{

        // CAMBIAR ESTA RUTA
        PrintWriter pw=new PrintWriter("C:\\TP\\numeros.txt");

        for(int i=0;i<=1000;i+=2){

            pw.println(i);

        }

        pw.close();

        System.out.println("Archivo numeros.txt creado.");
        
    }

    
//================ EJERCICIO 4 =================
    

        static void ejercicio4() throws Exception{

            BufferedReader br=new BufferedReader(
                    new FileReader("C:\\TP\\numeros.txt"));

            String linea;

            while((linea=br.readLine())!=null){

                System.out.println(linea);

            }

            br.close();

        }
        

        //================ EJERCICIO 5 =================
        

        static void ejercicio5() throws Exception{

            BufferedReader br=new BufferedReader(
                    new FileReader("C:\\TP\\numeros.txt"));

            PrintWriter pw=new PrintWriter("C:\\TP\\aux.txt");

            String linea;

            while((linea=br.readLine())!=null){

                int numero=Integer.parseInt(linea);

                if(numero%3!=0){

                    pw.println(numero);

                }

            }

            br.close();
            pw.close();

            File viejo=new File("C:\\TP\\numeros.txt");
            viejo.delete();

            File nuevo=new File("C:\\TP\\aux.txt");
            nuevo.renameTo(viejo);

            System.out.println("Se eliminaron los múltiplos de 3.");

        }

        
        //================ FUNCIÓN PRIMO =================
        

        static boolean esPrimo(int numero){

            if(numero<2){
                return false;
            }

            for(int i=2;i<numero;i++){

                if(numero%i==0){
                    return false;
                }

            }

            return true;

        }
        

        //================ EJERCICIO 6 =================
        

        static void ejercicio6() throws Exception{

            BufferedReader br=new BufferedReader(
                    new FileReader("C:\\TP\\numeros.txt"));

            // CAMBIAR ESTA RUTA
            PrintWriter pw=new PrintWriter("D:\\primos.dat");

            String linea;

            while((linea=br.readLine())!=null){

                int numero=Integer.parseInt(linea);

                if(esPrimo(numero)){

                    pw.println(numero);

                }

            }

            br.close();
            pw.close();

            System.out.println("Archivo primos.dat creado.");

        }
        
        
        //================ EJERCICIO 7 =================
        

        static void ejercicio7() throws Exception{

            PrintWriter pw = new PrintWriter("D:\\caracteres.dat");

            System.out.println("Ingrese 10 palabras que contengan la letra ñ:");

            for(int i=1;i<=10;i++){

                System.out.print("Palabra "+i+": ");
                pw.println(teclado.readLine());

            }

            pw.close();

            BufferedReader br = new BufferedReader(
                    new FileReader("D:\\caracteres.dat"));

            String linea;

            System.out.println("\nFichero original:");

            while((linea=br.readLine())!=null){

                System.out.println(linea);

            }

            br.close();

            br = new BufferedReader(new FileReader("D:\\caracteres.dat"));
            pw = new PrintWriter("D:\\aux.dat");

            while((linea=br.readLine())!=null){

                linea = linea.replace("ñ","nie-nio");
                pw.println(linea);

            }

            br.close();
            pw.close();

            File viejo = new File("D:\\caracteres.dat");
            viejo.delete();

            File nuevo = new File("D:\\aux.dat");
            nuevo.renameTo(viejo);

            br = new BufferedReader(new FileReader("D:\\caracteres.dat"));

            System.out.println("\nFichero arreglado:");

            while((linea=br.readLine())!=null){

                System.out.println(linea);

            }

            br.close();

        }
        

        //================ EJERCICIO 9 =================
        

        static void clima() throws Exception{

            int op;

            do{

                System.out.println("\n----- CLIMA -----");
                System.out.println("1- Agregar");
                System.out.println("2- Mostrar");
                System.out.println("3- Eliminar");
                System.out.println("0- Volver");

                op = Integer.parseInt(teclado.readLine());

                switch(op){

                    case 1:

                        PrintWriter pw = new PrintWriter(new FileWriter("clima.txt",true));

                        System.out.print("Fecha: ");
                        String fecha = teclado.readLine();

                        System.out.print("Temperatura: ");
                        String temp = teclado.readLine();

                        System.out.print("Estado: ");
                        String estado = teclado.readLine();

                        pw.println(fecha+";"+temp+";"+estado);

                        pw.close();

                        break;

                    case 2:

                        BufferedReader br = new BufferedReader(new FileReader("clima.txt"));

                        String linea;

                        while((linea=br.readLine())!=null){

                            System.out.println(linea);

                        }

                        br.close();

                        break;

                    case 3:

                        System.out.print("Fecha a borrar: ");

                        String borrar = teclado.readLine();

                        br = new BufferedReader(new FileReader("clima.txt"));
                        pw = new PrintWriter("aux.txt");

                        while((linea=br.readLine())!=null){

                            if(!linea.startsWith(borrar+";")){

                                pw.println(linea);

                            }

                        }

                        br.close();
                        pw.close();

                        File viejo = new File("clima.txt");
                        viejo.delete();

                        File nuevo = new File("aux.txt");
                        nuevo.renameTo(viejo);

                        System.out.println("Registro eliminado.");

                        break;

                }

            }while(op!=0);

        }

    }