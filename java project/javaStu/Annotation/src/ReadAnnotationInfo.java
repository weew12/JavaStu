/**
 * @Classname ReadAnnotationInfo
 * @Description
 *              获取注解信息
 * @Date 2019-09-28
 * @Created by 枫weew12
 */

public class ReadAnnotationInfo {

    public static void main(String[] args) {

        try {
            Class<?> clz = Class.forName("com.a51work6.Person");
            // 读取类注解
            if (clz.isAnnotationPresent(MyAnnotation.class)) {
                MyAnnotation ann = (MyAnnotation) clz.getAnnotation(MyAnnotation.class);
                System.out.printf("类%s， 读取注解描述： %s \n",
                        clz.getName(), ann.description());
            }

            // 读取成员方法的注解信息
            Method[] methods = clz.getDeclaredMethods();
            for (Method method : methods) {
                if (method.isAnnotationPresent(MemberAnnotation.class)) {
                    MemberAnnotation ann = method.getAnnotation(MemberAnnotation.class);
                    System.out.printf("方法%s， 读取注解描述： %s \n",
                            method.getName(), ann.description());
                }
            }

            // 读取成员变量的注解信
            Field[] fields = clz.getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(MemberAnnotation.class)) {
                    MemberAnnotation ann = field.getAnnotation(MemberAnnotation.class);
                    System.out.printf("成员变量%s， 读取注解描述： %s \n",
                            field.getName(), ann.description());}
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}