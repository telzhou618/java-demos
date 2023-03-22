package com.example.spring.ioc.anno;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ApplicationContext {

    private Map<Class<?>, Object> beans = new ConcurrentHashMap<>();

    public ApplicationContext(String basePackage) {
        scanComponents(basePackage);
        injectDependencies();
    }

    public Object getBean(Class<?> clazz) {
        return beans.get(clazz);
    }

    private void scanComponents(String basePackage) {
        try {
            PackageScanner scanner = new PackageScanner(basePackage);
            List<Class<?>> classes = scanner.getClasses();
            for (Class<?> clazz : classes) {
                System.out.println(clazz.getName());
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to scan components in the package " + basePackage, e);
        }
    }

    private void injectDependencies() {
        // 遍历所有对象
        try {
            for (Object bean : beans.values()) {
                // 遍历对象所有的字段
                for (Field field : bean.getClass().getDeclaredFields()) {
                    // 如果字段使用了 @Autowired 注解，则进行依赖注入
                    if (field.isAnnotationPresent(Autowired.class)) {
                        Object dependency = beans.get(field.getType());
                        if (dependency == null) {
                            throw new RuntimeException("Failed to inject dependency for field " + field.getName() +
                                    " in the class " + bean.getClass().getName() + ", no bean of the type " + field.getType().getName() + " found");
                        }
                        field.setAccessible(true);
                        field.set(bean, dependency);
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("inject dependencies fail ", e);
        }

    }
}

