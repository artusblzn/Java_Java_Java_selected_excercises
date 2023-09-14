package chapter11.test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import org.junit.jupiter.api.Test;


import chapter11.Grep;

public class GrepTests {

    private Path workingDir = Path.of("", "test/resources");

    @Test
    public void testListLines() {
        String[] lines = {"This should be an exmple", "But it's not a valid one.",
                "on the other hand, this is a valid example.", "And we have enough of examples."};
        String[] ret =
                {"on the other hand, this is a valid example.", "And we have enough of examples."};

        assertArrayEquals(Grep.listLines("example", lines), ret);
    }

    @Test
    public void testListLinesWithAnEmptyArray() {
        String[] lines = {};
        String[] ret = {};

        assertArrayEquals(Grep.listLines("example", lines), ret);
    }

    @Test
    public void testGetFileLines() {
        try {
            Path file = this.workingDir.resolve("greptests.txt");
            String[] lines = {"This should be an exmple", "But it's not a valid one.",
                    "on the other hand, this is a valid example.",
                    "And we have enough of examples."};
            assertArrayEquals(Grep.getFileLines(file.toString()), lines);
        } catch (IOException e) {
            // do nothing
        }
    }

    @Test
    public void testGetFileLinesFileNotFound() {
        Path file = this.workingDir.resolve("error.txt");
        assertThrows(FileNotFoundException.class, () -> Grep.getFileLines(file.toString()));
    }

}


