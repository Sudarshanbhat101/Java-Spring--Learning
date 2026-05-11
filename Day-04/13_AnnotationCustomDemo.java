import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

/**
 * Custom annotation: metadata you define; often read by frameworks or reflection.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Task {
    String id();

    int priority() default 1;
}

class WorkItem {

    @Task(id = "AUTH-1", priority = 2)
    void runAuthCheck() {
        System.out.println("Running auth check (annotated task)");
    }
}

class AnnotationCustomDemo {

    public static void main(String[] args) throws Exception {
        WorkItem item = new WorkItem();
        Method method = WorkItem.class.getMethod("runAuthCheck");
        Task task = method.getAnnotation(Task.class);
        if (task != null) {
            System.out.println("Annotation id=" + task.id() + ", priority=" + task.priority());
        }
        item.runAuthCheck();
    }
}
