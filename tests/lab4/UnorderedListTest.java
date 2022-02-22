package lab4;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;

public class UnorderedListTest {
    @Test
    public void testUnorderedListItems() {
        ListItem item0 = new ListItem("item0");
        ListItem item2 = new ListItem("item2");

        UnorderedList list = new UnorderedList();
        list.addItem(item0);
        list.addItem("item1");
        list.addItem(item2);

        assertEquals(3, list.getListItems().size());
        assertTrue(list.getListItems().contains(item0));
        assertEquals("item1", list.getListItems().get(1).getContent());
        assertEquals(item2, list.getListItems().get(2));
    }

    @Test
    public void testUnorderedListHtmlResult() {
        UnorderedList list = new UnorderedList();
        list.addItem("item1");

        ByteArrayOutputStream os = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(os);
        list.writeHTML(ps);
        String result = os.toString(StandardCharsets.UTF_8);

        assertTrue(result.contains("<ul>"));
        assertTrue(result.contains("<li>item1</li>"));
        assertTrue(result.contains("</ul>"));
    }
}
