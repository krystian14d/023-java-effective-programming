package preferTryOverTryFinally;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

class TryOverTryFinally {

    private final static int BUFFER_SIZE = 8;

    static String firstLineOfFile(String path) throws IOException {

        try (BufferedReader br = new BufferedReader(new FileReader(path));) {
            return br.readLine();
        }
    }

    static void copy(String src, String dst) throws IOException {
        try (FileInputStream in = new FileInputStream(src); FileOutputStream out = new FileOutputStream(dst)) {

            byte[] buf = new byte[BUFFER_SIZE];
            int n;
            while ((n = in.read(buf)) >= 0) {
                out.write(buf, 0, n);
            }
        }
    }
}
