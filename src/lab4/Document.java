package lab4;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Document {
    private String title;
    private Photo photo;
    private List<Section> sections = new ArrayList<>();

    public Document(String title) {
        this.title = title;
    }

    public Document setTitle(String title){
        this.title = title;
        return this;
    }

    public String getTitle() {
        return this.title;
    }

    public Document setPhoto(String photoUrl){
        this.photo = new Photo(photoUrl);
        return this;
    }

    public Photo getPhoto() {
        return this.photo;
    }

    public Section addSection(String sectionTitle){
        // utwórz sekcję o danym tytule i dodaj do sections
        Section section = new Section(sectionTitle);
        this.sections.add(section);
        return section;
    }

    public Document addSection(Section s){
        this.sections.add(s);
        return this;
    }

    public List<Section> getSections() {
        return this.sections;
    }

    public void writeHTML(PrintStream out){
        /*
         * That's all that browser needs to generate webpage.
         * Rest of elements is added by browser itself.
         */
        out.printf("<title>%s</title>\n", this.title);
        this.photo.writeHTML(out);
        out.printf("<h1>%s</h1>\n", this.title);
        for (Section s : this.sections) {
            s.writeHTML(out);
        }
    }
}
