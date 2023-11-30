package com.stefanini.steps

import com.stefanini.pages.RegisterPage
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import org.testng.Assert

class RegisterSteps {

    private val registerPage: RegisterPage by lazy { RegisterPage() }

    @Given("me encuentro ubicado en el formulario de registro")
    fun isRegisterPageDisplayed() {
        Assert.assertTrue(registerPage.isDisplayed(), PAGE_NOT_DISPLAYED)
    }

    @When("completo el campo Nombre con {string}")
    fun setNameInput(name: String) {
        registerPage.apply {
            setInput(nameInput, name)
        }
    }

    @When("completo el campo Contraseña con {string}")
    fun setPasswordInput(password: String) {
        registerPage.apply {
            setInput(passwordInput, password)
        }
    }

    @When("completo el campo E-mail con {string}")
    fun setEmailInput(email: String) {
        registerPage.apply {
            setInput(emailInput, email)
        }
    }

    @When("clickeo el boton de Registrar")
    fun clickRegisterButton() {
        registerPage.apply {
            click(registerButton)
        }
    }

    @When("clickeo el boton de Eliminar en el primer usuario")
    fun clickFirstDeleteButton() {
        registerPage.apply {
            click(firstRemoveButton)
        }
    }

    @Then("veo el error {string} en el campo Nombre")
    fun verifyNameErrorLabel(expectedError: String) {
        registerPage.apply {
            Assert.assertEquals(getText(nameErrorLabel), expectedError)
        }
    }

    @Then("veo el error {string} en el campo E-mail")
    fun verifyEmailErrorLabel(expectedError: String) {
        registerPage.apply {
            Assert.assertEquals(getText(emailErrorLabel), expectedError)
        }
    }

    @Then("veo el error {string} en el campo Contraseña")
    fun verifyPasswordErrorLabel(expectedError: String) {
        registerPage.apply {
            Assert.assertEquals(getText(passwordErrorLabel), expectedError)
        }
    }

    @Then("veo el Id {string}, Nombre {string} y E-mail {string} en Usuarios registrados")
    fun verifyUserRegistration(expectedId: String, expectedName: String, expectedEmail: String) {
        registerPage.apply {
            Assert.assertEquals(getText(firstIdLabel), expectedId)
            Assert.assertEquals(getText(firstNameLabel), expectedName)
            Assert.assertEquals(getText(firstEmailLabel), expectedEmail)
        }
    }

    @Then("la tabla de usuarios registrados esta vacia")
    fun isUsersTableEmpty() {
        registerPage.apply {
            Assert.assertFalse(
                isVisible(firstIdLabel),
                "La tabla de usuarios registrados no esta vacia. Se encontro el Id}"
            )
            Assert.assertFalse(
                isVisible(firstNameLabel),
                "La tabla de usuarios registrados no esta vacia. Se encontro el Nombre"
            )
            Assert.assertFalse(
                isVisible(firstEmailLabel),
                "La tabla de usuarios registrados no esta vacia. Se encontro el E-mail")
        }
    }

    companion object {
        private const val PAGE_NOT_DISPLAYED = "El formulario de registro no se encuentra visible."
    }
}