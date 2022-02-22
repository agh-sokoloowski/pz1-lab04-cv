package lab4;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Section {
    private String title;
    private List<Paragraph> paragraphs = new ArrayList<>();

    public Section(String title) {
        this.title = title;
    }

    public Section setTitle(String title) {
        this.title = title;
        return this;
    }

    public Section addParagraph(String paragraphText) {
        Paragraph p = new Paragraph();
        this.paragraphs.add(p);
        p.setContent(paragraphText);
        return this;
    }

    public Section addParagraph(Paragraph p) {
        this.paragraphs.add(p);
        return this;
    }

    public String getTitle() {
        return this.title;
    }

    public List<Paragraph> getParagraphs() {
        return this.paragraphs;
    }

    public void writeHTML(PrintStream out) {
        out.println("<div>");
        out.printf("\t<h2>%s</h2>\n", this.title);
        for (Paragraph p : this.paragraphs) {
            out.print("\t");
            p.writeHTML(out);
        }
        out.println("</div>");
    }
}
