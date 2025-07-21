package com.urbanLadder.reRun;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class RetryListener implements IAnnotationTransformer {
	@Override
	public void transform(ITestAnnotation annotation, @SuppressWarnings("rawtypes") Class testClass,
			@SuppressWarnings("rawtypes") Constructor constructor, Method method) {
		annotation.setRetryAnalyzer(RetryAnalyzer.class);
	}
}
