package com.example.InfraGateway.Config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class ApiGatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("bike_service", r -> r.path("/api/bikes/**")
                        .uri("lb://MicroServiceBike"))
                .route("station_service", r -> r.path("/api/stations/**")
                        .uri("lb://MicroServiceStation"))
                .route("notifications_service", r -> r.path("/api/notifications/**")
                        .uri("lb://MicroServiceNotifications"))
                .build();

    }
}
