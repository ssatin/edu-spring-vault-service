package ru.satin.edu.vault;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.util.PropertyUtils;

import java.util.Locale;

@SpringBootApplication
public class Application {

  public static void main(String... args) {
    Locale.setDefault(new Locale("RU"));
    System.setProperty(PropertyUtils.BOOTSTRAP_ENABLED_PROPERTY, Boolean.toString(true));
    SpringApplication.run(Application.class);
  }
}
