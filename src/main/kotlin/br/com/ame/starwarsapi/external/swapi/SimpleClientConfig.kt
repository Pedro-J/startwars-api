package br.com.ame.starwarsapi.external.swapi

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.client.ClientHttpRequestFactory
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory
import org.springframework.web.client.RestTemplate




@Configuration
class SimpleClientConfig {

    @Bean
    fun getClientHttpRequestFactory(): ClientHttpRequestFactory {
        val timeout = 5000
        val clientHttpRequestFactory = HttpComponentsClientHttpRequestFactory()
        clientHttpRequestFactory.setConnectTimeout(timeout)
        clientHttpRequestFactory.setConnectionRequestTimeout(timeout)
        clientHttpRequestFactory.setReadTimeout(timeout)
        return clientHttpRequestFactory
    }

    @Bean
    fun restTemplate(clientHttpRequestFactory: ClientHttpRequestFactory): RestTemplate {
        return RestTemplate(clientHttpRequestFactory)
    }
}