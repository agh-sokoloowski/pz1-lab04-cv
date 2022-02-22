package lab4;

import java.io.PrintStream;

public class ParagraphWithList extends Paragraph {
    private UnorderedList list = new UnorderedList();

    public ParagraphWithList setContent(String content) {
        super.setContent(content);
        return this;
    }

    public ParagraphWithList addListItem(String item) {
        this.list.addItem(item);
        return this;
    }

    public UnorderedList getList() {
        return this.list;
    }

    public void writeHTML(PrintStream out) {
        super.writeHTML(out);
        this.list.writeHTML(out);
    }
}
