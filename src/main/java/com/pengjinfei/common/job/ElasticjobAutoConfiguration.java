package com.pengjinfei.common.job;

import com.pengjinfei.common.job.console.ConsoleMvcConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * Created on 6/18/18
 *
 * @author jinfei
 */
@Configuration
@EnableConfigurationProperties(ElasticjobProperties.class)
@ConditionalOnProperty(prefix = "elasticjob",name = "enabled",havingValue = "true")
public class ElasticjobAutoConfiguration {

    public ElasticjobAutoConfiguration(ElasticjobProperties properties) {
        this.properties = properties;
    }

    private final ElasticjobProperties properties;

    @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(ConsoleMvcConfiguration.class);
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new DispatcherServlet(context));
        registrationBean.addUrlMappings("/elasticjob/*");
        registrationBean.setLoadOnStartup(1);
        registrationBean.setName("elasticjob");
        return registrationBean;
    }
}
