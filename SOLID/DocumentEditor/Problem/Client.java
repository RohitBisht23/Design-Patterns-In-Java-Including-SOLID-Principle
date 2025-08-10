import java.util.*;
import java.io.*;
import java.nio.file.*;

class DocumentEditor {
    private List<String> documentElements;
    private String renderElement;

    public DocumentEditor() {
        documentElements = new ArrayList<>();
        renderElement = "";
    }

    public void addImages(String path) {
        documentElements.add(path);
    }

    public void addText(String text) {
        documentElements.add(text);
    }

    public String renderDocument() {
        if (renderElement.length() == 0) {
            StringBuilder result = new StringBuilder();
            for (String elem : documentElements) {
                if (elem.length() > 4 && (elem.endsWith(".jpg") || elem.endsWith(".png"))) {
                    result.append("[Image ").append(elem).append("]\n");
                } else {
                    result.append(elem).append("\n");
                }
            }
            renderElement = result.toString();
        }
        return renderElement;
    }

    public void saveToFile() {
        try {
            Files.write(Paths.get("document.txt"), renderElement.getBytes());
            System.out.println("File saved successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Client {
    public static void main(String[] args) {
        DocumentEditor documentEditor = new DocumentEditor();
        documentEditor.addImages("yourRohitLogo.png");
        documentEditor.addText("Hello Rohit,");
        documentEditor.addText("How are you?");
        documentEditor.addImages("Thank_you.jpg");

        System.out.println(documentEditor.renderDocument());

        documentEditor.saveToFile();
    }
}
