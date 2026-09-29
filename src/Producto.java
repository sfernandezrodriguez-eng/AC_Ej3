import java.beans.Transient;
import java.io.*;

public class Producto implements Serializable {
    String nome;
    int num1;
    double num2;

    public Producto(String nombre, int numero1, double numero2) {
        this.nome=nombre;
        this.num1=numero1;
        this.num2=numero2;
    }


    public void  escribirSerial() {
        try {
            FileOutputStream flujoArchivo = new FileOutputStream("serial");
            ObjectOutputStream flujoObjetos = new ObjectOutputStream(flujoArchivo);
            flujoObjetos.writeObject(this);
            System.out.println("Se ha hecho");

        }
        catch (IOException e){
            System.out.println("Sos bujarra "+ e.getMessage());

        }
    }

    public void leerSerial() {
        try (FileInputStream flujoArchivo = new FileInputStream("serial");
             ObjectInputStream flujoObjetos = new ObjectInputStream(flujoArchivo)) {

            Producto miProducto = (Producto) flujoObjetos.readObject();

            System.out.println("[LOG] Nome producto "+miProducto.nome);
            System.out.println("[LOG] Numero producto "+miProducto.num1);
            System.out.println("[LOG] Numero2 producto "+miProducto.num2);

            System.out.println("Se ha hecho correctamente");

        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("No se encontró la clase Producto: " + e.getMessage());
        }
    }
}



