package lab4;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class UnorderedList {
    private List<ListItem> listItems = new ArrayList<>();

    public UnorderedList addItem(String content) {
        ListItem item = new ListItem(content);
        this.listItems.add(item);
        return this;
    }

    public UnorderedList addItem(ListItem item) {
        this.listItems.add(item);
        return this;
    }

    public List<ListItem> getListItems() {
        return listItems;
    }
    
    public void writeHTML(PrintStream out) {
        out.println("\t<ul>");
        for (ListItem item : this.listItems) {
            out.print("\t\t");
            item.writeHTML(out);
        }
        out.println("\t</ul>");
    }
}
