import java.util.*;
import java.io.*;
import java.nio.file.*;


interface DocumentElement {
    public String render();
}

class TextElement implements DocumentElement{

    private String text;

    public TextElement(String text) {
        this.text = text;
    }

    @Override
    public String render() {
        return text;
    }
}

class NewLineText implements DocumentElement {
    
    @Override
    public String render() {
        return "\n";
    }
}

class ImageElement implements DocumentElement {

    private String path;

    public ImageElement(String path) {
        this.path = path;
    }

    @Override
    public String render() {
        return "[Image"+path+"]\n";
    }
}


//Document class -> Response for holding collection of DocumentElements
class Document {
    private List<DocumentElement> documentElements;
    
    public Document() {
        documentElements = new ArrayList<>();
    }

    public void addElement(DocumentElement documentElement) {
        this.documentElements.add(documentElement);
    }

    public String render() {

        String result="";

        for(DocumentElement docElem: documentElements) {
            result += docElem.render(); //Calling contractor render function and correspondingly it will call the diff type or render like image, text etc
        }
        return result;
    }
}

//Persistance
interface Persistance {
    void save(String data);
}

class SaveToFile implements Persistance{
    public void save(String data) {
        try {
            Files.write(Paths.get("document.txt"), data.getBytes());
            System.out.println("File saved successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class SaveToDB implements Persistance {
    public void save(String data) {
        try {
            System.out.println("Saving document in db");
        } catch(Exception e) {
            System.out.println("Got an error while saving document in DB. Please try later");
            System.out.println(e.getLocalizedMessage());
        }
    }
}


class DocumentEditor {
    private Document doc;
    private Persistance db;
    private String renderElement;

    public DocumentEditor(Document doc, Persistance db) {
        this.db = db;
        this.doc = doc;
        renderElement = "";
    }

    public void addText(String text) {
        doc.addElement(new TextElement(text));
    }

    public void addNewLine() {
        doc.addElement(new NewLineText());
    }

    public void addImages(String path) {
        doc.addElement(new ImageElement(path));
    }

    

    public String renderDoc() {
        if(renderElement.length() == 0) {
            renderElement = doc.render();
        }
        return renderElement;
    }

    public void save() {
        db.save(renderDoc());
    }

}

public class Client {
    public static void main(String[] args) {

        Document document = new Document();
        Persistance persistance = new SaveToFile();

        DocumentEditor editor = new DocumentEditor(document, persistance);
        editor.addText("Dear sir/ma'am,");
        editor.addNewLine();
        editor.addText("Thank you for choosing us.");
        editor.addNewLine();
        editor.addImages("Glad.jpg");
        editor.addText("Bye.");

        System.out.println(editor.renderDoc());
        editor.save();
    }
}
