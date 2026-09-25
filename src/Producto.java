import java.io.*;

public class Producto implements Serializable {
    String nome;
    int num1;
    double num2;

    public Producto(String nombre, int numero1, int numero2) {
        String nome=nombre;
        int num1=numero1;
        double num2=numero2;
    }


    public void  escribirSerial() {
        try {
            FileOutputStream flujoArchivo = new FileOutputStream("serial");
            ObjectOutputStream flujoObjetos = new ObjectOutputStream(flujoArchivo);
            Producto miProducto = new Producto("Cositas",12,12);
            flujoObjetos.writeObject(miProducto);
            System.out.println("Se ha hecho");


            flujoObjetos.close();
            flujoArchivo.close();

        }
        catch (IOException e){
            System.out.println("Sos bujarra");

        }
    }
}
