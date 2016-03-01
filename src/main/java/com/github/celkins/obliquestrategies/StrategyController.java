package com.github.celkins.obliquestrategies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
public class StrategyController {

    private final StrategyRepository repository;

    @Autowired
    public StrategyController(StrategyRepository repository) {
        this.repository = Objects.requireNonNull(repository, "repository cannot be null");
    }

    @RequestMapping("/")
    public String randomStrategy() {
        List<String> randomStrategies = this.repository.randomStrategies();
        assert !randomStrategies.isEmpty();
        return randomStrategies.get(0);
    }
}
