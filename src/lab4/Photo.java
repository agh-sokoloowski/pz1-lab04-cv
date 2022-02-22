package lab4;

import java.io.PrintStream;

public class Photo {
    private String url;

    public Photo(String url) {
        this.url = url;
    }

    public String getUrl() {
        return this.url;
    }

    public void writeHTML(PrintStream out){
        out.printf("<img src=\"%s\" alt=\"Zdjęcie\" style=\"float:right;width:42px;height:42px;\">\n", url);
    }
}
