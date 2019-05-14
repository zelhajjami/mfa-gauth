package org.apereo.cas.config.support.authentication;

import lombok.extern.slf4j.Slf4j;
import org.apereo.cas.adaptors.gauth.rest.GoogleAuthenticatorRestHttpRequestCredentialFactory;
import org.apereo.cas.configuration.CasConfigurationProperties;
import org.apereo.cas.rest.factory.ChainingRestHttpRequestCredentialFactory;
import org.apereo.cas.rest.plan.RestHttpRequestCredentialFactoryConfigurer;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * This is {@link GoogleAuthenticatorRestConfiguration}.
 *
 * @author Misagh Moayyed
 * @since 5.3.0
 */
@Configuration("googleAuthenticatorRestConfiguration")
@EnableConfigurationProperties(CasConfigurationProperties.class)
@ConditionalOnClass(value = RestHttpRequestCredentialFactoryConfigurer.class)
@Slf4j
public class GoogleAuthenticatorRestConfiguration {

    @Bean
    public RestHttpRequestCredentialFactoryConfigurer googleAuthenticatorRestHttpRequestCredentialFactoryConfigurer() {
        return new RestHttpRequestCredentialFactoryConfigurer() {
            @Override
            public void configureCredentialFactory(final ChainingRestHttpRequestCredentialFactory factory) {
                factory.registerCredentialFactory(new GoogleAuthenticatorRestHttpRequestCredentialFactory());
            }
        };
    }
}
