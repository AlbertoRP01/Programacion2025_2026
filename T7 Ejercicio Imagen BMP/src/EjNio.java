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
        try (FileChannel canal = FileChannel.open(p, StandardOpenOption.READ);
             FileChannel canal2 = FileChannel.open(p2, StandardOpenOption.WRITE, StandardOpenOption.CREATE)) {



            ByteBuffer buffer = ByteBuffer.allocate(54);
            canal.read(buffer);
            buffer.flip();
            canal2.write(buffer);

            ByteBuffer bufferPixel = ByteBuffer.allocate(3);
            int canalLeido;
            while ((canalLeido = canal.read(bufferPixel)) > 0) {
                bufferPixel.flip();
                byte azul = bufferPixel.get(0);
                byte verde = bufferPixel.get(1);
                byte rojo = bufferPixel.get(2);
                int mezclado = ((azul + verde + rojo) / 3);
                byte inverso1 = (byte) mezclado;
                byte inverso2 = (byte) mezclado;
                byte inverso3 = (byte) mezclado;

                bufferPixel.put(0, inverso1);
                bufferPixel.put(1, inverso2);
                bufferPixel.put(2, inverso3);

                canal2.write(bufferPixel);
                bufferPixel.clear();
            }
            System.out.println("Imagen invertida correctamente");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
