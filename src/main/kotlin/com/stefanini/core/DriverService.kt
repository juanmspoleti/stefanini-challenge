package com.stefanini.core

import io.github.bonigarcia.wdm.WebDriverManager
import com.stefanini.core.browser.Browser
import com.stefanini.core.browser.BrowserType
import org.openqa.selenium.WebDriver
import org.openqa.selenium.remote.RemoteWebDriver
import java.net.URL


class DriverService {
    companion object {
        private val driver = ThreadLocal<WebDriver>()

        private fun createDriver(): WebDriver {
            val browser = BrowserType.getBrowser(PropertyManager.getProperty("browser"))
            WebDriverManager.getInstance(browser.getDriverClass()).setup()
            val driver = initDriver(browser)

            driver.manage().window().maximize()
            return driver
        }

        private fun initDriver(browser: Browser): WebDriver {
            return browser.initDriver()
        }

        fun dismissDriver() {
            driver.get().quit()
            driver.remove()
        }

        fun getInstance(): WebDriver {
            if (driver.get() == null) {
                driver.set(createDriver())
            }
            return driver.get()
        }
    }
}