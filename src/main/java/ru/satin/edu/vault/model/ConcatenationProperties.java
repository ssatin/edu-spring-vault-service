package ru.satin.edu.vault.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "application.concat")
public class ConcatenationProperties {

  private String prefix;
  private String suffix;
}
