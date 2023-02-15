package tw.com.imsoft.conf;

import org.sitemesh.builder.SiteMeshFilterBuilder;
import org.sitemesh.config.ConfigurableSiteMeshFilter;
import org.springframework.stereotype.Component;

@Component
public class WebSiteMeshFilter extends ConfigurableSiteMeshFilter {
	
	@Override
	protected void applyCustomConfiguration(SiteMeshFilterBuilder builder) {

		builder.addDecoratorPath("/*", "/WEB-INF/jsp/layout/mainLayout.jsp");
		//builder.addExcludedPath("/login");

	}

}