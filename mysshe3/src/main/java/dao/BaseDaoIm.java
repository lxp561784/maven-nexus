package dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;


@Repository("baseDaoIm")
public class BaseDaoIm<T> extends HibernateDaoSupport implements IBaseDao<T> {
	
	@Resource
	public void setMySessionFactory(SessionFactory sessionFactory){
		super.setSessionFactory(sessionFactory);
		
	}
	
	protected Class<T> persistentClass;
	

	public BaseDaoIm(){
		this.persistentClass=(Class<T>)getSuperClassGenricType(getClass(), 0);  
	}
	
	@Override
	public T get(Class<T> t,Integer id) {
		return this.getHibernateTemplate().get(t, id);
	} 
	
	public List<T> getAll(){
		return this.getHibernateTemplate().loadAll(persistentClass);
	}
	
	/** 
	     * 通过反射, 获得定义Class时声明的父类的泛型参数的类型. 如无法找到, 返回Object.class. 
	     *  
	    *@param clazz 
	     *            clazz The class to introspect 
	     * @param index 
	     *            the Index of the generic ddeclaration,start from 0. 
	     * @return the index generic declaration, or Object.class if cannot be 
	     *         determined 
	    */  
	    @SuppressWarnings("unchecked")  
	    public static Class<Object> getSuperClassGenricType(final Class clazz, final int index) {  
	          
	        //返回表示此 Class 所表示的实体（类、接口、基本类型或 void）的直接超类的 Type。  
	        Type genType = clazz.getGenericSuperclass();  
	  
	        if (!(genType instanceof ParameterizedType)) {  
	           return Object.class;  
	        }  
	        //返回表示此类型实际类型参数的 Type 对象的数组。  
	        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();  
	  
	        if (index >= params.length || index < 0) {  
	                    return Object.class;  
	        }  
	       if (!(params[index] instanceof Class)) {  
	             return Object.class;  
	        }  
	  
	        return (Class) params[index];  
	   } 


}
