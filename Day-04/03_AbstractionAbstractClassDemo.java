/**
 * Abstraction via abstract class: cannot instantiate; subclasses provide bodies.
 */
abstract class Document {
    protected String title;

    Document(String title) {
        this.title = title;
    }

    abstract void render(); // no body — concrete subclasses must implement

    void printTitle() {
        System.out.println("Title: " + title);
    }
}

class PdfDocument extends Document {
    PdfDocument(String title) {
        super(title);
    }

    @Override
    void render() {
        System.out.println("Rendering PDF: " + title);
    }
}

class AbstractionAbstractClassDemo {

    public static void main(String[] args) {
        Document doc = new PdfDocument("Report");
        doc.printTitle();
        doc.render();
    }
}
