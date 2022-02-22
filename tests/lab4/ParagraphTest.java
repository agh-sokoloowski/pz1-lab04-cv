package lab4;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;

public class ParagraphTest {
    @Test
    public void testParagraphContent() {
        Paragraph paragraph = new Paragraph();
        paragraph.setContent("Test content");
        assertEquals("Test content", paragraph.getContent());
    }

    @Test
    public void testParagraphHtmlResult() {
        Paragraph paragraph = new Paragraph();
        paragraph.setContent("Test content");

        ByteArrayOutputStream os = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(os);
        paragraph.writeHTML(ps);
        String result = os.toString(StandardCharsets.UTF_8);

        assertTrue(result.contains("<p>Test content</p>"));
    }
}
