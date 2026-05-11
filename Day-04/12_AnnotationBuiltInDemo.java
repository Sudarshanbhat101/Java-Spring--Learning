/**
 * Built-in annotations: @Override, @Deprecated, @SuppressWarnings (compile-time hints).
 */
class LegacyApi {
    @Deprecated
    void oldMethod() {
        System.out.println("Deprecated: use newMethod instead");
    }

    void newMethod() {
        System.out.println("Preferred API");
    }
}

class AnnotationBuiltInDemo extends LegacyApi {

    @Override
    void newMethod() {
        System.out.println("Overridden newMethod in demo");
    }

    @SuppressWarnings("deprecation")
    public static void main(String[] args) {
        AnnotationBuiltInDemo demo = new AnnotationBuiltInDemo();
        demo.oldMethod();
        demo.newMethod();
    }
}
