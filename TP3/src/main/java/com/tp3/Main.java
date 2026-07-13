package com.tp3;
import java.io.*;

public class Main {

    static BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

    // ...

    static final String ARCHIVO = "Inventario.dat";

    // Colores
    static final String RESET = "\u001B[0m";
    static final String VERDE = "\u001B[32m";
    static final String ROJO = "\u001B[31m";
    static final String AZUL = "\u001B[34m";
    static final String AMARILLO = "\u001B[33m";

    public static void main(String[] args) throws Exception {

        crearArchivo();

        int opcion;

        do {

            System.out.println(AZUL + "\n======================================");
            System.out.println("      SISTEMA DE INVENTARIO");
            System.out.println("======================================" + RESET);

            System.out.println("1 - Agregar producto");
            System.out.println("2 - Mostrar productos");
            System.out.println("3 - Editar producto");
            System.out.println("4 - Eliminar producto");
            System.out.println("0 - Salir");

            System.out.print("\nOpción: ");

            opcion = convertirEntero(leerTexto());

            switch(opcion){

                case 1:
                    agregarProducto();
                    break;

                case 2:
                    mostrarProductos();
                    break;

                case 3:
                    editarProducto();
                    break;

                case 4:
                    eliminarProducto();
                    break;

                case 0:
                    System.out.println(VERDE + "\nHasta luego." + RESET);
                    break;

                default:
                    System.out.println(ROJO + "Opción incorrecta." + RESET);

            }

        }while(opcion!=0);

    }

    //===========================

    static void crearArchivo() throws Exception{

        File f = new File(ARCHIVO);

        if(!f.exists()){

            PrintWriter pw = new PrintWriter(f);
            pw.close();

        }

    }

    //===========================

    static String leerTexto() throws Exception{

        return teclado.readLine();

    }

    //===========================

    static boolean esEntero(String texto){

        try{

            Integer.parseInt(texto);
            return true;

        }catch(Exception e){

            return false;

        }

    }

    //===========================

    static boolean esDecimal(String texto){

        try{

            Float.parseFloat(texto);
            return true;

        }catch(Exception e){

            return false;

        }

    }

    //===========================

    static int convertirEntero(String texto){

        while(!esEntero(texto)){

            try{

                System.out.print("Ingrese un número entero: ");
                texto = leerTexto();

            }catch(Exception e){}

        }

        return Integer.parseInt(texto);

    }

    //===========================

    static float convertirFloat(String texto){

        while(!esDecimal(texto)){

            try{

                System.out.print("Ingrese un número decimal: ");
                texto = leerTexto();

            }catch(Exception e){}

        }

        return Float.parseFloat(texto);

    }

    //===========================

    static void agregarProducto() throws Exception{

        PrintWriter pw = new PrintWriter(new FileWriter(ARCHIVO,true));

        System.out.print("\nNombre: ");
        String nombre = leerTexto();

        System.out.print("Precio compra: ");
        float compra = convertirFloat(leerTexto());

        System.out.print("Precio venta: ");
        float venta = convertirFloat(leerTexto());

        System.out.print("Stock: ");
        int stock = convertirEntero(leerTexto());

        pw.println(nombre+";"+compra+";"+venta+";"+stock);

        pw.close();

        System.out.println(VERDE + "\nProducto agregado correctamente." + RESET);
        
    }

        
        //========================================

        static void mostrarProductos() throws Exception {

            BufferedReader br = new BufferedReader(new FileReader(ARCHIVO));

            String linea;

            System.out.println(AMARILLO);
            System.out.printf("%-20s %-15s %-15s %-10s\n",
                    "NOMBRE", "COMPRA", "VENTA", "STOCK");
            System.out.println("--------------------------------------------------------------");
            System.out.print(RESET);

            while((linea = br.readLine()) != null){

                String datos[] = linea.split(";");

                System.out.printf("%-20s %-15s %-15s %-10s\n",
                        datos[0],
                        datos[1],
                        datos[2],
                        datos[3]);

            }

            br.close();

        }

        //========================================

        static void editarProducto() throws Exception{

            BufferedReader br = new BufferedReader(new FileReader(ARCHIVO));

            PrintWriter pw = new PrintWriter("aux.dat");

            System.out.print("Nombre del producto a editar: ");
            String buscar = leerTexto();

            String linea;
            boolean encontrado = false;

            while((linea = br.readLine()) != null){

                String datos[] = linea.split(";");

                if(datos[0].equalsIgnoreCase(buscar)){

                    encontrado = true;

                    System.out.println("\nIngrese los nuevos datos");

                    System.out.print("Nombre: ");
                    String nombre = leerTexto();

                    System.out.print("Precio compra: ");
                    float compra = convertirFloat(leerTexto());

                    System.out.print("Precio venta: ");
                    float venta = convertirFloat(leerTexto());

                    System.out.print("Stock: ");
                    int stock = convertirEntero(leerTexto());

                    pw.println(nombre + ";" + compra + ";" + venta + ";" + stock);

                }else{

                    pw.println(linea);

                }

            }

            br.close();
            pw.close();

            File viejo = new File(ARCHIVO);
            viejo.delete();

            File nuevo = new File("aux.dat");
            nuevo.renameTo(viejo);

            if(encontrado){

                System.out.println(VERDE + "\nProducto editado correctamente." + RESET);

            }else{

                System.out.println(ROJO + "\nProducto no encontrado." + RESET);

            }

        }
        
        //========================================

        static void eliminarProducto() throws Exception{

            BufferedReader br = new BufferedReader(new FileReader(ARCHIVO));

            PrintWriter pw = new PrintWriter("aux.dat");

            System.out.print("Nombre del producto a eliminar: ");
            String buscar = leerTexto();

            String linea;
            boolean encontrado = false;

            while((linea = br.readLine()) != null){

                String datos[] = linea.split(";");

                if(datos[0].equalsIgnoreCase(buscar)){

                    encontrado = true;

                }else{

                    pw.println(linea);

                }

            }

            br.close();
            pw.close();

            File viejo = new File(ARCHIVO);
            viejo.delete();

            File nuevo = new File("aux.dat");
            nuevo.renameTo(viejo);

            if(encontrado){

                System.out.println(VERDE + "\nProducto eliminado correctamente." + RESET);

            }else{

                System.out.println(ROJO + "\nProducto no encontrado." + RESET);

            }

        }

    }