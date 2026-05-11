/**
 * Abstraction + template method: abstract steps, shared algorithm in base class.
 */
abstract class DataExporter {
    final void export() { // template method
        openConnection();
        writeRows();
        closeConnection();
    }

    abstract void openConnection();

    abstract void writeRows();

    void closeConnection() {
        System.out.println("Connection closed.");
    }
}

class CsvExporter extends DataExporter {
    @Override
    void openConnection() {
        System.out.println("CSV stream opened.");
    }

    @Override
    void writeRows() {
        System.out.println("Writing CSV rows...");
    }
}

class AbstractionTemplateMethodDemo {

    public static void main(String[] args) {
        DataExporter exporter = new CsvExporter();
        exporter.export();
    }
}
