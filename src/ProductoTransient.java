import java.io.*;

public class ProductoTransient implements Serializable {
    private static final long serialVersionUID = 1L;

    String nome;
    transient int num1;
    double num2;

    public ProductoTransient(String nombre, int num1, double numero2) {
        this.nome = nombre;
        this.num1 = num1;
        this.num2 = numero2;
    }

    public void escribirSerial() {
        try (FileOutputStream flujoArchivo = new FileOutputStream("serial.dat");
             ObjectOutputStream flujoObjetos = new ObjectOutputStream(flujoArchivo)) {

            flujoObjetos.writeObject(this);
            System.out.println("Ha serializado correctamente.");

        } catch (IOException e) {
            System.err.println("Error al escribir el archivo: " + e.getMessage());
        }
    }

    public void leerSerial() {
        try (FileInputStream flujoArchivo = new FileInputStream("serial.dat");
             ObjectInputStream flujoObjetos = new ObjectInputStream(flujoArchivo)) {

            ProductoTransient miProducto = (ProductoTransient) flujoObjetos.readObject();

            System.out.println("[LOG] Nome producto: " + miProducto.nome);
            System.out.println("[LOG] Numero producto (transient): " + miProducto.num1); // Mostrará 0
            System.out.println("[LOG] Numero2 producto: " + miProducto.num2);

            System.out.println("Ha deserializado correctamente.");

        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("No se encontró la clase: " + e.getMessage());
        }
    }
}