package task1;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class RandomGenerator implements RandomGen {

    public void generateUniqueStrings(int x, String path) throws IOException {
        byte[] bytes = new byte[100];
        Arrays.fill(bytes, (byte) 'a');

        byte[] arr = new byte[] {'\r', '\n'};

        FileOutputStream fileOutputStream = new FileOutputStream(path);

        for (int i = 0; i < x; i++) {
            fileOutputStream.write(bytes);
            fileOutputStream.write(arr);
            fileOutputStream.flush();

            for (int j = 0; j < 100; j++) {
                bytes[j]++;
                if (bytes[j] <= 'z') {
                    break;
                } else {
                    bytes[j] = 'a';
                }
            }
        }

        fileOutputStream.close();
    }
}
