package renfe.com.pdf.datamanager;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import renfe.com.util.BundleCts;


public class BundleMgr {
	
	private static BundleMgr instance = null;
	
	private BundleMgr(){
		super();
	}
	
	public static BundleMgr getInstance(){
		
		if(instance == null){
			instance = new BundleMgr();
		}
		return instance;
	}
	
	public String resolve(String key){
		
		return resolve(key, BundleCts.BUNDLE_NAME_ASG_MESSAGE);
	}
	
	public List resolve(List keyList){
		
		return resolve(keyList, BundleCts.BUNDLE_NAME_ASG_MESSAGE);
	}
	
	public String resolve(String key, String bundleName) {
		
		return resolve(key, bundleName, null);
	}
	
	public String resolve(String key, String bundleName, Locale locale) {
				
		ResourceBundle bundle = null;
		if(locale == null) bundle = ResourceBundle.getBundle(bundleName);
		else bundle = ResourceBundle.getBundle(bundleName, locale);
		
		return bundle.getString(key);
	}
	
	public List resolve(List keyList, String bundleName){
		
		return 	resolve(keyList, bundleName, null);
	}
	
	public List resolve(List keyList, String bundleName, Locale locale) {
			
		List messages = new ArrayList();
		
		ResourceBundle bundle = null;
		if(locale == null) bundle = ResourceBundle.getBundle(bundleName);
		else bundle = ResourceBundle.getBundle(bundleName, locale);
				
		Iterator it = keyList.iterator();
		while(it.hasNext()){
			
			String key = (String) it.next();
			String msg = bundle.getString(key);
			messages.add(msg);
		}
		return messages;
	}
}
