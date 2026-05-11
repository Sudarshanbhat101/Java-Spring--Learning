/**
 * Enum with fields, constructor, and instance methods — each constant can carry state.
 */
enum HttpStatus {
    OK(200, "OK"),
    NOT_FOUND(404, "Not Found"),
    SERVER_ERROR(500, "Internal Server Error");

    private final int code;
    private final String phrase;

    HttpStatus(int code, String phrase) {
        this.code = code;
        this.phrase = phrase;
    }

    public int getCode() {
        return code;
    }

    public String getPhrase() {
        return phrase;
    }

    public String describe() {
        return code + " " + phrase;
    }
}

class EnumConstructorMethodDemo {

    public static void main(String[] args) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        System.out.println(status.describe());
        System.out.println("Code: " + status.getCode());
    }
}
