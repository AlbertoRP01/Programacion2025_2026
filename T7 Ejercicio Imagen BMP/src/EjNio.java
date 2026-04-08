import java.io.BufferedReader;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;

public class EjNio {
    static void main(String[] args) {
        Path p = Path.of("src/imagen/pradera.bmp");
        Path p2 = Path.of("src/imagen/pradera2.bmp");
        try (FileChannel canal = FileChannel.open(p, StandardOpenOption.READ)) {

            FileChannel canal2 = FileChannel.open(p2, StandardOpenOption.WRITE, StandardOpenOption.CREATE_NEW);

            ByteBuffer buffer = ByteBuffer.allocate(54);
            canal.read(buffer);
            buffer.flip();
            canal2.write(buffer);
            ByteBuffer bufferPixel = ByteBuffer.allocate(4096);
            int canalLeido;
            while ((canalLeido = canal.read(bufferPixel)) != 1) {
                bufferPixel.flip();
                for (int i = 0; i < bufferPixel.limit(); i++) {
                    Byte b = bufferPixel.get(i);
                    int valor = b & 0xFF;
                    int invertido = 255 - valor;
                    bufferPixel.put(i, (byte) invertido);

                }
                canal2.write(bufferPixel);
                bufferPixel.clear();
            }
            System.out.println("Imagen invertida correctamente");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
