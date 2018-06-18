package com.pengjinfei.common.job.console;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created on 6/18/18
 *
 * @author jinfei
 */
@ComponentScan("com.pengjinfei.common.job")
@EnableWebMvc
@Configuration
public class ConsoleMvcConfiguration extends WebMvcConfigurerAdapter {


}
