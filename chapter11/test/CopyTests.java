package chapter11.test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import org.junit.jupiter.api.Test;
import chapter11.Copy;

public class CopyTests {

    private Path workingDir = Path.of("", "test/resources");

    @Test
    public void testMakeCopyNoFilename1() {
        assertThrows(FileNotFoundException.class, () -> Copy.makeCopy("error.txt", "whatever.txt"));
    }

    @Test
    public void testMakeCopyFilenameIsDirectory() {
        assertThrows(FileNotFoundException.class,
                () -> Copy.makeCopy(this.workingDir.toString(), "whatever.txt"));
    }

    @Test
    public void testMakeCopyNoFilename2() {
        Path filename1 = this.workingDir.resolve("greptests.txt");
        assertThrows(FileNotFoundException.class,
                () -> Copy.makeCopy(filename1.toString(), "whatever.txt"));
    }

    @Test
    public void testMakeCopyWithTwoExistingFiles() {
        try {
            Path filename1 = this.workingDir.resolve("greptests.txt");
            Path filename2 = this.workingDir.resolve("copy.txt");
            File file2 = new File(filename2.toString());
            file2.createNewFile();
            Copy.makeCopy(filename1.toString(), filename2.toString());
            assertEquals(Files.readAllLines(filename1), Files.readAllLines(filename2));
        } catch (Exception e) {
        }
    }

    @Test
    public void testMakeCopyWithTwoOneFileAndOneDirectory() {
        try {
            Path filename1 = this.workingDir.resolve("greptests.txt");
            Path filename2 = this.workingDir;
            Copy.makeCopy(filename1.toString(), filename2.toString());
            assertEquals(Files.readAllLines(filename1),
                    Files.readAllLines(this.workingDir.resolve("greptests.txt")));
        } catch (Exception e) {
        }
    }

}
