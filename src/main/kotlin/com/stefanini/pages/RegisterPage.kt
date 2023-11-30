package com.stefanini.pages

import com.stefanini.pages.common.BasePage
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

class RegisterPage : BasePage() {

    @FindBy(id = "name")
    val nameInput: WebElement? = null

    @FindBy(css = "#name+p")
    val nameErrorLabel: WebElement? = null

    @FindBy(id = "email")
    val emailInput: WebElement? = null

    @FindBy(css = "#email+p")
    val emailErrorLabel: WebElement? = null

    @FindBy(id = "password")
    val passwordInput: WebElement? = null

    @FindBy(css = "#password+p")
    val passwordErrorLabel: WebElement? = null

    @FindBy(id = "register")
    val registerButton: WebElement? = null

    @FindBy(id = "removeUser1")
    val firstRemoveButton: WebElement? = null

    @FindBy(id = "tdUserId1")
    val firstIdLabel: WebElement? = null

    @FindBy(id = "tdUserName1")
    val firstNameLabel: WebElement? = null

    @FindBy(id = "tdUserEmail1")
    val firstEmailLabel: WebElement? = null

    fun isDisplayed(): Boolean {
        return isVisible(passwordInput)
    }
}