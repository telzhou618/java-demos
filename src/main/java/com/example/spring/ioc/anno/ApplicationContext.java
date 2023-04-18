package com.example.spring.ioc.anno;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ApplicationContext {

    private Map<Class<?>, Object> beans = new ConcurrentHashMap<>();

    public ApplicationContext(String basePackage) {
        scanComponents(basePackage);
    }

    public Object getBean(Class<?> clazz) {
        return beans.get(clazz);
    }

    private void scanComponents(String basePackage) {
        try {
            PackageScanner scanner = new PackageScanner(basePackage);
            List<Class<?>> classes = scanner.getClasses();
            for (Class<?> clazz : classes) {
                Object o = clazz.newInstance();
                beans.put(clazz, o);
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to scan components in the package " + basePackage, e);
        }
    }
}

