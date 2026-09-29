import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CreacionAutoresXML {

    public static void main(String[] args) {
        XMLOutputFactory factory = XMLOutputFactory.newInstance();

        try (FileWriter fileWriter = new FileWriter("autores.xml")) {
            XMLStreamWriter writer = factory.createXMLStreamWriter(fileWriter);

            writer.writeStartDocument("1.0");

            writer.writeStartElement("autores");

            writer.writeStartElement("autor");
            writer.writeAttribute("codigo", "a1");

            writer.writeStartElement("nome");
            writer.writeCharacters("Alexandre Dumas");
            writer.writeEndElement(); // </nome>

            writer.writeStartElement("titulo");
            writer.writeCharacters("El conde de montecristo");
            writer.writeEndElement(); // </titulo>

            writer.writeStartElement("titulo");
            writer.writeCharacters("Los miserables");
            writer.writeEndElement(); // </titulo>

            writer.writeEndElement(); // </autor>

            // Segundo autor (a2)
            writer.writeStartElement("autor");
            writer.writeAttribute("codigo", "a2");

            writer.writeStartElement("nome");
            writer.writeCharacters("Fiodor Dostoyevski");
            writer.writeEndElement(); // </nome>

            writer.writeStartElement("titulo");
            writer.writeCharacters("El idiota");
            writer.writeEndElement(); // </titulo>

            writer.writeStartElement("titulo");
            writer.writeCharacters("Noches blancas");
            writer.writeEndElement();
            writer.writeEndElement();
            writer.writeEndElement();
            writer.writeEndDocument();

            writer.flush();
            writer.close();

            System.out.println("Se genero correctamente.");

        } catch (IOException | XMLStreamException e) {
            System.err.println("Erro ao xerar o ficheiro XML: " + e.getMessage());
        }
    }
}