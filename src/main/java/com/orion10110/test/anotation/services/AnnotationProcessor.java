package com.orion10110.test.anotation.services;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import com.orion10110.test.anotation.anotations.Init;
import com.orion10110.test.anotation.anotations.Service;

public class AnnotationProcessor {

	static Map<String, Object> servicesMap = new HashMap<String, Object>();

	public static void main(String[] args) {
		loadService("com.orion10110.test.anotation.services.LazyService");
		loadService("com.orion10110.test.anotation.services.SimpleService");
		loadService("java.lang.String");

	}

	static void loadService(String className) {
		try {
			Class<?> clazz = Class.forName(className);
			if (clazz.isAnnotationPresent(Service.class)) {
				Object serviceObj = clazz.newInstance();

				servicesMap.put(clazz.getAnnotation(Service.class).name(), serviceObj);
				Method[] methods = clazz.getMethods();
				for (Method method : methods) {
					if (method.isAnnotationPresent(Init.class)) {
						try {
							method.invoke(serviceObj);
						} catch (Exception e) {

						}
					}
				}
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	static void inspectService(Class<?> service) {
		if (service.isAnnotationPresent(Service.class)) {
			Service ann = service.getAnnotation(Service.class);
			Method[] methods = service.getMethods();
			for (Method method : methods) {
				if (method.isAnnotationPresent(Init.class)) {
					method.getAnnotation(Init.class);
					System.out.println("method " + method.getName() + "Содержит инит");
				} else {
					System.out.println("method " + method.getName() + " не инит");

				}
			}
			System.out.println(ann.name());

		}
	}
}
