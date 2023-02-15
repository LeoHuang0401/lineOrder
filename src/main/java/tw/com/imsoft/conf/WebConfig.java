package tw.com.imsoft.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
	
	@Autowired
	WebSiteMeshFilter webSiteMeshFilter;
	
	@Bean
	public FilterRegistrationBean<WebSiteMeshFilter> siteMeshFilter() {
		FilterRegistrationBean<WebSiteMeshFilter> fitler = new FilterRegistrationBean<>();
		fitler.setFilter(webSiteMeshFilter);
		return fitler;
	}

}