package com.shabushabu.javashop.products;

import com.google.inject.Guice;
import com.google.inject.Injector;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import com.shabushabu.javashop.products.healthchecks.BasicHealthCheck;
import com.shabushabu.javashop.products.configuration.ProductServiceConfiguration;
import com.shabushabu.javashop.products.resources.ProductResource;


public class ProductServiceApplication extends Application<ProductServiceConfiguration> {
    public static void main(String[] args) throws Exception {
        new ProductServiceApplication().run(args);
    }

    @Override
    public String getName() {
        return "product-list-service";
    }

    @Override
    public void initialize(Bootstrap<ProductServiceConfiguration> bootstrap) {
        // nothing to do yet
    }

    @Override
    public void run(ProductServiceConfiguration config,
                    Environment environment) {
        final BasicHealthCheck healthCheck = new BasicHealthCheck(config.getVersion());
        environment.healthChecks().register("template", healthCheck);

        Injector injector = Guice.createInjector();
        environment.jersey().register(injector.getInstance(ProductResource.class));
    }
}
