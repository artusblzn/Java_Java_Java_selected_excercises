/**
 * EXERCISE 11.25 Challenge: Write a program in Java named Copy to copy one file into another. The
 * program should prompt the user for two file names, filename1 and filename2. Both filename1 and
 * filename2 must exist or the program should throw a FileNotFoundException. Although filename1 must
 * be the name of a file (not a directory), filename2 may be either a file or a directory. If
 * filename2 is a file, then the program should copy filename1 to filename2. If filename2 is a
 * directory, then the program should simply copy filename1 into filename2. That is, it should
 * create a new file with the name filename1 inside the filename2 directory, copy the old file to
 * the new file, and then delete the old file.
 */

package chapter11;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Copy {

    public static void makeCopy(String filename1, String filename2)
            throws FileNotFoundException, IOException {
        File file1 = new File(filename1);
        if (!file1.isFile()) {
            throw (new FileNotFoundException("No such a file:" + filename1));
        }
        if (!file1.canRead()) {
            throw (new IOException("Can't read file:" + filename1));
        }
        File file2 = new File(filename2);
        if (!file2.exists()) {
            throw (new FileNotFoundException("No such a file or directory:" + filename2));
        }
        if (file2.isDirectory()) {
            file2 = new File(filename2 + "/" + filename1);
            file2.createNewFile();
        }
        InputStream in = new BufferedInputStream(new FileInputStream(file1));
        OutputStream out = new BufferedOutputStream(new FileOutputStream(filename2, true));
        try {
            byte[] buffer = new byte[1024];
            int lengthRead;
            while ((lengthRead = in.read(buffer)) > 0) {
                out.write(buffer, 0, lengthRead);
                out.flush();
            }
        } catch (IOException e) {
            throw new IOException("Error while copying " + filename1 + " to " + filename2);
        } finally {
            in.close();
            out.close();
        }
    }

}
