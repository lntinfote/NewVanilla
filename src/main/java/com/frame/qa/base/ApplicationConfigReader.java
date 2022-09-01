package com.frame.qa.base;


import ru.qatools.properties.Property;
import ru.qatools.properties.PropertyLoader;
import ru.qatools.properties.Resource;

@Resource.Classpath("ApplicationConfig.properties")
public class ApplicationConfigReader {

	public ApplicationConfigReader() {
		PropertyLoader.newInstance().populate(this);
	}

	@Property(value = "Browser")
	private String Browser;

	@Property(value = "Url")
	private String WebsiteUrl;
	
	@Property(value = "UrlUI")
	private String WebsiteUrlUI;

	@Property(value = "MaxPageLoadTime")
	private int MaxPageLoadTime;

	@Property(value = "ImplicitlyWaitTime")
	private int implicitWaitTime;

	@Property(value = "ExplicitWaitTime")
	private int explicitWaitTime;
	
	@Property(value = "UserName")
	private String UserName;
	
	@Property(value = "Password")
	private String Password;
	
	@Property(value = "product")
	private String Product;

	public String getBrowser() {
		return Browser;
	}

	public String getProduct() {
		return Product;
	}

	public String getWebsiteUrl() {
		return WebsiteUrl;
	}
	
	public String getWebsiteUrlUI() {
		return WebsiteUrlUI;
	}

	public int getMaxPageLoadTime() {
		return MaxPageLoadTime;
	}

	public int getImplicitlyWait() {
		return implicitWaitTime;
	}

	public int getExplicitWait() {
		return explicitWaitTime;
	}
	
	public String getUserName() {
		return UserName;
	}
	
	public String getPassword() {
		return Password;
	}

}
