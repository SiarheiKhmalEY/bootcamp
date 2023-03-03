import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.*;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        List<MyInterface> myObjectsToScan = new ArrayList<>();
        myObjectsToScan.add(new FirstClassImpl());
        myObjectsToScan.add(new SecondClassImpl());
        myObjectsToScan.add(new ThirdClassImpl());
        myObjectsToScan.add(new FourthClassImpl());

        List<Class<? extends Annotation>> customAnnotationList = new ArrayList<>();
        customAnnotationList.add(Private.class);
        customAnnotationList.add(Public.class);

//        Task iii.1
//        getAllClassesWithAnnotation(ScanMe.class, myObjectsToScan);

//        Task iii.2
//        getAllMethodsWithPrivateAnnotationInClassWithAnnotationScanMe(ScanMe.class, Private.class,
//                myObjectsToScan);

//        Task iii.3
//        getAllMethodsWithoutCustomAnnotationInClassWithoutAnnotation(customAnnotationList, myObjectsToScan);

//        Task iii.4
//        getAllScannedClasses(myObjectsToScan);

    }

    public static void getAllClassesWithAnnotation(Class<? extends Annotation> classAnnotation, List<MyInterface> elementList) {
        for (MyInterface element : elementList
        ) {
            if (checkClassAnnotation(classAnnotation, element)) {
                System.out.println("Class " + element.getClass().getName() + " has annotation " + classAnnotation.getName());
            }
        }
    }

    public static void getAllScannedClasses(List<MyInterface> myObjectsToScan) {
        myObjectsToScan.stream().forEach(x -> {
            System.out.print("Class: " + Arrays.toString(x.getClass().getDeclaredAnnotations()) + " " +
                    x.getClass().getName() + "{ \n");
            for (Method method : x.getClass().getDeclaredMethods()
            ) {
                System.out.print(Arrays.toString(method.getDeclaredAnnotations()) + " " + method.getName() + "\n");
            }
            System.out.print("}\n\n");
        });

    }

    public static void getAllMethodsWithPrivateAnnotationInClassWithAnnotationScanMe(Class<? extends Annotation> classAnnotation,
                                                                                     Class<? extends Annotation> methodAnnotation,
                                                                                     List<MyInterface> elementList) {
        for (MyInterface element : elementList) {
            if (checkClassAnnotation(classAnnotation, element)) {
                Method[] methods = element.getClass().getDeclaredMethods();
                for (var method : methods
                ) {
                    if (method.isAnnotationPresent(methodAnnotation)) {
                        System.out.println("Class " + element.getClass().getName() + " has method " + method.getName()
                                + " with annotation " + methodAnnotation.getName());
                    }
                }
            }
        }
    }

    public static void getAllMethodsWithoutCustomAnnotationInClassWithoutAnnotation(
            List<Class<? extends Annotation>> methodAnnotations, List<MyInterface> myObjectsToScan) {
        Class<? extends Annotation> scanMeAnnotation = ScanMe.class;

        for (var objectToScan : myObjectsToScan
        ) {
            if (!checkClassAnnotation(scanMeAnnotation, objectToScan)) {
                Arrays.stream(objectToScan.getClass().getDeclaredMethods())
                        .filter(x -> Arrays.stream(x.getDeclaredAnnotations())
                                .noneMatch(method -> methodAnnotations.contains(method.annotationType())))
                        .forEach(y -> System.out.println(y.getName()));
            }
        }
    }

    public static boolean checkClassAnnotation(Class<? extends Annotation> annotation, MyInterface element) {
        return element.getClass().isAnnotationPresent(annotation);
    }
}