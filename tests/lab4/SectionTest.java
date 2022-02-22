package lab4;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;

public class SectionTest {
    @Test
    public void testSectionTitle() {
        Section section = new Section("Test section");
        assertEquals("Test section", section.getTitle());

        // Update title
        section.setTitle("Another test section");
        assertEquals("Another test section", section.getTitle());
    }

    @Test
    public void testSectionParagraphs() {
        Section section = new Section("Test section");
        Paragraph paragraph0 = new Paragraph();
        paragraph0.setContent("paragraph0");

        section.addParagraph(paragraph0)
                .addParagraph("paragraph1");

        assertTrue(section.getParagraphs().contains(paragraph0));
        assertEquals(paragraph0, section.getParagraphs().get(0));
        assertEquals("paragraph1", section.getParagraphs().get(1).getContent());
    }

    @Test
    public void testSectionHtmlResult() {
        Section section = new Section("Test section");
        section.addParagraph("paragraph");

        ByteArrayOutputStream os = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(os);
        section.writeHTML(ps);
        String result = os.toString(StandardCharsets.UTF_8);

        assertTrue(result.contains("<div>"));
        assertTrue(result.contains("<h2>Test section</h2>"));
        assertTrue(result.contains("<p>paragraph</p>"));
        assertTrue(result.contains("</div>"));
    }
}
