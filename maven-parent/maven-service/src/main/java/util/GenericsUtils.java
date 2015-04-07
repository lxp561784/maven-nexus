package util;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class GenericsUtils {

	/**
	 * 通过反射获得定义Class时声明的父类的泛型参数的类型
	 */
	@SuppressWarnings("unchecked")
	public static Class getSupperClassGenericType(Class clazz){
		return GenericsUtils.getSupperClassGenericType(clazz,0);
	}
	
	/**
	 * 通过反射过得定义Class时声明的父类的泛型参数的类型
	 */
	@SuppressWarnings("unchecked")
	public static Class getSupperClassGenericType(Class clazz,int index){
		Type genType = clazz.getGenericSuperclass();
		if(!(genType instanceof ParameterizedType)){
			return Object.class;
		}
		Type[] params = ((ParameterizedType)genType).getActualTypeArguments();
		if(index >= params.length || index < 0){
			return Object.class;
		}
		if(!(params[index] instanceof Class) ){
			return Object.class;
		}
		return (Class)params[index];
	}
}
