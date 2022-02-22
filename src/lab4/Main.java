package lab4;

public class Main {
    public static void main(String[] args) {
        System.out.println("Piszemy CV...");
        Document cv = new Document("Jana Kowalski - CV");
        cv.setPhoto("https://sokoloowski.pl/avatar.png")
            .addSection("Wykształcenie")
                .addParagraph("2000-2005 Przedszkole im. Królewny Snieżki w ...")
                .addParagraph("2006-2012 SP7 im Ronalda Regana w ...")
                .addParagraph("...");
        cv.addSection("Umiejętności")
                .addParagraph(
                        new ParagraphWithList().setContent("Umiejętności")
                                .addListItem("C")
                                .addListItem("C++")
                                .addListItem("Java")
                );

        cv.writeHTML(System.out);
    }
}
