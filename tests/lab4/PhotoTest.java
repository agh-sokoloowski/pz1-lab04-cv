package lab4;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;

public class PhotoTest {
    @Test
    public void testPhotoUrl() {
        Photo photo = new Photo("test_url");
        assertEquals("test_url", photo.getUrl());
    }

    @Test
    public void testPhotoHtmlResult() {
        Photo photo = new Photo("test_url");

        ByteArrayOutputStream os = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(os);
        photo.writeHTML(ps);
        String result = os.toString(StandardCharsets.UTF_8);

        assertTrue(result.contains("<img"));
        assertTrue(result.contains("src="));
        assertTrue(result.contains("test_url"));
        assertTrue(result.contains("alt"));
        assertTrue(result.contains("Zdjęcie"));
        assertTrue(result.contains("style="));
        assertTrue(result.contains("float:right;width:42px;height:42px;"));
        assertTrue(result.contains(">"));
    }
}
