package org.saumil.services;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.persist.PersistFilter;
import com.google.inject.persist.jpa.JpaPersistModule;
import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;
import org.saumil.infrastructure.DatabaseConfiguration;
import org.saumil.infrastructure.MessageConfiguration;
import org.saumil.infrastructure.WelcomeConfiguration;
import org.saumil.repository.IPostDao;
import org.saumil.repository.PostDao;
import org.saumil.resources.PostResource;
import org.saumil.resources.WelcomeResource;

import java.util.Properties;

/**
 * Created by saumil on 2014/04/25.
 */
public class WelcomeService extends Service<WelcomeConfiguration> {

    public static void main(String[] args) throws Exception{
        new WelcomeService().run(args);
    }

    @Override
    public void initialize(final Bootstrap<WelcomeConfiguration> bootstrap) {
        bootstrap.setName("blogservice");
    }

    private Injector createInjector(final WelcomeConfiguration config){
        return Guice.createInjector(new AbstractModule() {
            @Override
            protected void configure() {
                bind(WelcomeConfiguration.class).toInstance(config);
                bind(MessageConfiguration.class).toInstance(config.getMessage());
                bind(IPostDao.class).to(PostDao.class);
            }
        }, crateJpaPersistenceModule(config.getDatabase()));
    }

    private Module crateJpaPersistenceModule(DatabaseConfiguration config) {
        Properties props = new Properties();
        props.put("javax.persistence.jdbc.url", config.getUrl());
        props.put("javax.persistence.jdbc.user", config.getUser());
        props.put("javax.persistence.jdbc.password", config.getPassword());
        props.put("javax.persistence.jdbc.driver", config.getDriverClass());
        JpaPersistModule jpaModule = new JpaPersistModule("Default");
        jpaModule.properties(props);
        return jpaModule;
    }

    @Override
    public void run(WelcomeConfiguration welcomServiceConfig, Environment environment) throws Exception {
        Injector injector = createInjector(welcomServiceConfig);
        environment.addFilter(injector.getInstance(PersistFilter.class), "/*");

        environment.addResource(injector.getInstance(WelcomeResource.class));
        environment.addResource(injector.getInstance(PostResource.class));
    }
}
