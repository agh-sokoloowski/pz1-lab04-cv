package lab4;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;

public class ParagraphWithListTest {
    @Test
    public void testParagraphWithListContent() {
        ParagraphWithList paragraph = new ParagraphWithList();
        paragraph.setContent("Test content");
        assertEquals("Test content", paragraph.getContent());
    }

    @Test
    public void testParagraphWithListList() {
        ParagraphWithList paragraph = new ParagraphWithList();
        paragraph.addListItem("item0")
                .addListItem("item1")
                .addListItem("item2");
        assertEquals(3, paragraph.getList().getListItems().size());
        assertEquals("item0", paragraph.getList().getListItems().get(0).getContent());
    }

    @Test
    public void testParagraphWithListHtmlResult() {
        /*
         * Test only if list appends after paragraph. The rest is
         * tested in ParagraphTest and UnorderedListTest
         */
        ParagraphWithList paragraph = new ParagraphWithList();

        ByteArrayOutputStream os = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(os);
        paragraph.writeHTML(ps);
        String result = os.toString(StandardCharsets.UTF_8);

        assertTrue(result.contains("</p>\n\t<ul>"));
    }
}
