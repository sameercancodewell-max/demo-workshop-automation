package com.automation.util;

import java.io.InputStream;
import java.util.Map;

import org.yaml.snakeyaml.Yaml;

public class YamlConfigReader {
    private Map<String, Object> config;

    public YamlConfigReader(String fileName) {
        Yaml yaml = new Yaml();
        try (InputStream in = getClass().getClassLoader().getResourceAsStream(fileName)) {
            config = yaml.load(in);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load YAML config", e);
        }
    }

    public Map<String, Object> getEnvConfig(String env) {
        return (Map<String, Object>) config.get(env);
    }
}
