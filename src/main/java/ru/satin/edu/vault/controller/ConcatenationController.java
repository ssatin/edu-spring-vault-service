package ru.satin.edu.vault.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.satin.edu.vault.model.ConcatenationProperties;

@RestController
@RequiredArgsConstructor
public class ConcatenationController {

  private final ConcatenationProperties properties;

  @GetMapping("concat")
  public String concat(@RequestParam String first, @RequestParam String second) {
    return "prefix: " + properties.getPrefix()
        + ", first: " + first
        + ", second: " + second
        + ", suffix: " + properties.getSuffix();
  }
}
