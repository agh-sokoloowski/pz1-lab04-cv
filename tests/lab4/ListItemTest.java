package lab4;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;

public class ListItemTest {
    @Test
    public void testListItemContent() {
        ListItem listItem = new ListItem("Test content");
        assertEquals("Test content", listItem.getContent());
    }

    @Test
    public void testListItemHtmlResult() {
        ListItem listItem = new ListItem("Test content");

        ByteArrayOutputStream os = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(os);
        listItem.writeHTML(ps);
        String result = os.toString(StandardCharsets.UTF_8);

        assertTrue(result.contains("<li>Test content</li>"));
    }
}
