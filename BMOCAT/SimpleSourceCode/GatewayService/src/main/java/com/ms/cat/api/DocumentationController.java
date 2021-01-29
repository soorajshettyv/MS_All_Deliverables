package com.ms.cat.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

@Component
@Primary
@Configuration
@EnableSwagger2WebMvc
@Import({ SpringDataRestConfiguration.class, BeanValidatorPluginsConfiguration.class })
public class DocumentationController implements SwaggerResourcesProvider {

	@Bean
	public Docket api() {

		List<Parameter> parameters = new ArrayList<>();
		parameters.add(new ParameterBuilder().name("Authorization").modelRef(new ModelRef("string"))
				.parameterType("header").build());

		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("com.ms.bootcamp.controller"))
				.paths(PathSelectors.any()).build().globalOperationParameters(parameters);
	}
	
	@Override
	public List<SwaggerResource> get() {
		List<SwaggerResource> resources = new ArrayList<>();
		resources.add(swaggerResource("orderms", "/v2/api-docs", "2.0"));
		resources.add(swaggerResource("cartms", "/v2/api-docs", "2.0"));
		resources.add(swaggerResource("productcataloguems", "/v2/api-docs", "2.0"));
		resources.add(swaggerResource("accountloginms", "/v2/api-docs", "2.0"));
		return resources;
	}

	private SwaggerResource swaggerResource(String name, String location, String version) {
		SwaggerResource swaggerResource = new SwaggerResource();
		swaggerResource.setName(name);
		swaggerResource.setLocation(location);
		swaggerResource.setSwaggerVersion(version);
		return swaggerResource;
	}

}
