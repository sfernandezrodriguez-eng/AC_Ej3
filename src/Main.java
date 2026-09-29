void main() {

    Producto programa = new Producto("cositas",1,12);
    programa.escribirSerial();
    programa.leerSerial();

    ProductoTransient programa2 = new ProductoTransient("cositas",1,12);
    programa2.escribirSerial();
    programa2.leerSerial();
}
