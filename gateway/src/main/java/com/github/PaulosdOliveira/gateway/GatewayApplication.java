package com.github.PaulosdOliveira.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@EnableDiscoveryClient
@SpringBootApplication
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}


	@Bean
	public RouteLocator routeLocator(RouteLocatorBuilder builder){

		return builder.routes()
				.route(r -> r.path("/usuario/**").uri("lb://usuario"))
				.route(r -> r.path("/produto/**").uri("lb://usuario"))
				.route(r -> r.path(("/pedido/**")).uri("lb://usuario"))
				.build();
	}

}
