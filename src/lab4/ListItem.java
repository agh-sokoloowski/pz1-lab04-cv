package lab4;

import java.io.PrintStream;

public class ListItem {
    private String content;

    public ListItem(String content) {
        this.content = content;
    }

    public String getContent() {
        return this.content;
    }

    public void writeHTML (PrintStream out) {
        out.printf("<li>%s</li>\n", this.content);
    }
}
