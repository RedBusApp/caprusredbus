package com.caprusit.redbus.web.config;

import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

import com.caprusit.redbus.data.utility.CurdOperationUtility;

@Configuration
//@ComponentScan(basePackages={"com.caprusit.redbus.data","com.caprusit.redbus.service"})
public class ParentConfigurationBean {
	
	@Value("${driver_class}")
	private String driverClassName;
	
	@Value("${url}")
	private String url;
	
	@Value("${username}")
	private String username;
	
	@Value("${password}")
	private String password;
	
	private static Logger logger=Logger.getLogger(ParentConfigurationBean.class);
	

	@Bean
	public static PropertyPlaceholderConfigurer getPropertyPlaceholderConfigurer() {
		
		logger.info(" getPropertyPlaceholderConfigurer()");

		PropertyPlaceholderConfigurer configurer = new PropertyPlaceholderConfigurer();

		configurer.setLocation(new ClassPathResource(
				"com/caprusit/redbus/web/properties/database.properties"));

		return configurer;
	}

	@Bean
	public DataSource getDataSource() {

		DriverManagerDataSource ds = new DriverManagerDataSource();

		ds.setDriverClassName(driverClassName);
		ds.setUrl(url);
		ds.setUsername(username);
		ds.setPassword(password);		
		
		return ds;

	}

	@Bean
	@Autowired
	public LocalSessionFactoryBean getLocalSessionFactoruy(DataSource ds) throws IOException {

		LocalSessionFactoryBean factory = new LocalSessionFactoryBean();
		factory.setPackagesToScan("com.caprusit.redbus.domain");

		
		ClassPathResource hibernatePropertiesResource = new ClassPathResource("com/caprusit/redbus/web/properties/hibernate.properties");
		Properties hibernateProperties = new Properties();
		hibernateProperties.load(hibernatePropertiesResource.getInputStream());
      
		factory.setHibernateProperties(hibernateProperties);

		factory.setDataSource(ds);
		
		return factory;
	}
	
	@Bean
	@Autowired
	public HibernateTransactionManager getHibernateTransactionManager(SessionFactory factory){
		
		HibernateTransactionManager hibernateTxManager=new HibernateTransactionManager();
		
		hibernateTxManager.setSessionFactory(factory);
		
		return hibernateTxManager;
				
	}
	
	@Bean
	@Autowired
	public CurdOperationUtility getCurdOperationUtility(SessionFactory factory){
		
		CurdOperationUtility ut=new CurdOperationUtility();
		ut.setSessionFactory(factory);
		
		return ut;
	}

}
