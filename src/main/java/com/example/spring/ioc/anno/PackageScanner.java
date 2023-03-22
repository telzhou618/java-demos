package com.example.spring.ioc.anno;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class PackageScanner {
    private String basePackage;

    public PackageScanner(String basePackage) {
        this.basePackage = basePackage;
    }

    public List<Class<?>> getClasses() throws ClassNotFoundException {
        List<Class<?>> classes = new ArrayList<Class<?>>();
        String basePath = basePackage.replaceAll("\\.", "/");
        File dir = new File(basePath);
        if (!dir.exists() || !dir.isDirectory()) {
            return classes;
        }
        for (File file : dir.listFiles()) {
            if (file.isDirectory()) {
                String subPackage = basePackage + "." + file.getName();
                PackageScanner scanner = new PackageScanner(subPackage);
                classes.addAll(scanner.getClasses());
            } else if (file.getName().endsWith(".class")) {
                String pkg = "com.example.spring.ioc.anno";
                String className = pkg + "." + file.getName().substring(0, file.getName().length() - 6);
                Class<?> clazz = Class.forName(className);
                classes.add(clazz);
            }
        }
        return classes;
    }
}
