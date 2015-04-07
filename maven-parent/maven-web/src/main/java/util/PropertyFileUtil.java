package util;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.DefaultPropertiesPersister;
import org.springframework.util.PropertiesPersister;

import com.alibaba.druid.util.StringUtils;

public class PropertyFileUtil {
	private static Logger logger = LoggerFactory.getLogger(PropertyFileUtil.class);
	private static Properties properties;
	private static ResourceLoader resourceLoader = new DefaultResourceLoader(); 
	private static PropertiesPersister propertyPersister = new DefaultPropertiesPersister();
	private static String DEFAULT_ENCODING = "UTF-8";
	
	public static void init(){
		String fileNames = "application-file.properties";
		innerInit(fileNames);
	}
	
	
	/**
	 * 初始化特定的属性文件
	 * @param profile
	 */
	public static void init(String profile){
		if(StringUtils.isEmpty(profile)){
			init();
		}else{
			innerInit(profile);
		}
	}
	/**
	 * 内部处理
	 * @param fileNames
	 */
	public static void innerInit(String fileNames){
		String[] profile = activePropertyFiles(fileNames);
		properties = loadProperties(profile);
		
		Set<String> set = properties.stringPropertyNames();
		for(String key : set){
			logger.debug("key {} value {}",key,properties.get(key));
		}
		
	}
	
	
	/**
	 * 获取读取的文件列表
	 * @param fileName
	 * @return
	 */
	public static String[] activePropertyFiles(String fileName){
		logger.debug("读取："+fileName);
		ClassLoader loader  = Thread.currentThread().getContextClassLoader();
		InputStream is = loader.getResourceAsStream(fileName);
		
		properties = new Properties();
		try {
			properties.load(is);
		} catch (IOException e) {
			logger.error("读取："+fileName+"异常");
			e.printStackTrace();
		}
		
		Set<Object> set = properties.keySet();
		
		List<Object> list = new ArrayList<Object>();
		String[] fileNames = new String[set.size()];
		list.addAll(set);
		
		for(int i =0;i<set.size();i++){
			fileNames[i] = properties.getProperty((String) list.get(i));
		}
		return fileNames;
	}
	
	/**
	 * 
	 * @param fileNames
	 * @return
	 */
	public static Properties loadProperties(String... fileNames){
		Properties property = new Properties();
		
		
		for(String location : fileNames){
			InputStream is = null;
			try {
				Resource resource = resourceLoader.getResource(location);
				is = resource.getInputStream();
				propertyPersister.load(property, new InputStreamReader(is,DEFAULT_ENCODING));
			} catch (IOException e) {
				logger.info("Could not find properties from location"+location+":"+e.getMessage());
			}finally{
				if(is != null){
					try {
						is.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
		
		return property;
	}
	
	/**
	 * 获取键值map
	 * @return
	 */
	public static Map<String,String> getKeyValue(){
		Set<String> set = properties.stringPropertyNames();
		Map<String,String> map  = new HashMap<String,String>();
		for(String key : set){
			map.put(key, properties.getProperty(key));
			
		}
		return map;
	}
}
