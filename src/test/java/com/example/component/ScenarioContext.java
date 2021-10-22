package com.example.component;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ScenarioContext {

    private Map<String, Object> data = new HashMap<>();

    public void saveData(String key, Object value) {
        this.data.put(key, value);
    }

    public Object getData(String key) {
        return this.data.get(key);
    }

    public void resetContext() {
        data.clear();
    }
}