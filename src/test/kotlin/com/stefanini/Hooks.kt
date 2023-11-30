package com.stefanini

import com.stefanini.core.DriverService
import com.stefanini.core.PropertyManager
import io.cucumber.core.api.Scenario
import io.cucumber.java.After
import io.cucumber.java.Before
import org.apache.log4j.Logger

class Hooks {

    @Before
    fun beforeScenario(scenario: Scenario) {
        Logger.getLogger(javaClass).info(">>>Running scenario: ${scenario.name}")
        DriverService.getInstance().get(PropertyManager.getProperty("base.url"))
    }

    @After
    fun afterScenario(scenario: Scenario) {
        Logger.getLogger(javaClass).info(">>>Ending scenario: ${scenario.name}")
        DriverService.dismissDriver()
    }
}