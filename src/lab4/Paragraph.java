package lab4;

import java.io.PrintStream;

public class Paragraph {
    private String content;

    public Paragraph setContent(String content) {
        this.content = content;
        return this;
    }

    public String getContent() {
        return this.content;
    }

    public void writeHTML(PrintStream out) {
        out.printf("<p>%s</p>\n", this.content);
    }
}
