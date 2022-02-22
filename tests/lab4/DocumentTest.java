package lab4;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;

public class DocumentTest {
    @Test
    public void testDocumentTitle() {
        Document document = new Document("Test document");
        assertEquals("Test document", document.getTitle());

        // Update title
        document.setTitle("Curriculum Vitae");
        assertEquals("Curriculum Vitae", document.getTitle());
    }

    @Test
    public void testDocumentPhoto() {
        Document document = new Document("Test document");
        document.setPhoto("test_url");

        assertEquals("test_url", document.getPhoto().getUrl());
    }

    @Test
    public void testDocumentSections() {
        Document document = new Document("Test document");
        Section section = new Section("section0");
        document.addSection(section)
                .addSection("section1");

        assertEquals(2, document.getSections().size());
        assertEquals(section, document.getSections().get(0));
        assertEquals("section1", document.getSections().get(1).getTitle());
    }

    @Test
    public void testDocumentHtmlResult() {
        Document document = new Document("test_doc")
                .setPhoto("test_url");
        document.addSection("section")
                .addParagraph("paragraph");

        ByteArrayOutputStream os = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(os);
        document.writeHTML(ps);
        String result = os.toString(StandardCharsets.UTF_8);

        assertTrue(result.contains("<title>test_doc</title>"));
        assertTrue(result.contains("<img src=\"test_url\""));
        assertTrue(result.contains("<h1>test_doc</h1>"));
        assertTrue(result.contains("<div>"));
        assertTrue(result.contains("<h2>section</h2>"));
        assertTrue(result.contains("<p>paragraph</p>"));
        assertTrue(result.contains("</div>"));
    }
}