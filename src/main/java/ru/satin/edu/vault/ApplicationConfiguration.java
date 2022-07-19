package ru.satin.edu.vault;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import ru.satin.edu.vault.model.ConcatenationProperties;

@Configuration
@EnableConfigurationProperties(value = {ConcatenationProperties.class})
public class ApplicationConfiguration {
}
