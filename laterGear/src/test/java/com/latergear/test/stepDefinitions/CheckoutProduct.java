package com.latergear.test.stepDefinitions;

import com.latergear.test.runner.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

public class CheckoutProduct {

   private  Hooks hook = null;

    public CheckoutProduct(Hooks hook) {
        this.hook = hook;
    }

    public CheckoutProduct(){}


    public Map<String,String> parseYanlToMap(String yamlFilePath){
        Map<String,String> yamlAsMap = new HashMap<>();
        Yaml yaml = new Yaml();
        try{
            yamlAsMap= yaml.load(new FileInputStream(yamlFilePath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return  yamlAsMap;
    }

    private final Map<String,String> locators = parseYanlToMap("src/test/java/com/latergear/test/resources/locators.yaml");

    @Given("Customer is on Later gear page")
    public void customer_is_on_later_gear_page() {

        hook.getDriver().get(locators.get("baseUrl"));
    }
    @When("customer selects the {string}")
    public void customer_selects_the(String product) {
          if(product.equalsIgnoreCase("Fifteen 52 Turbomac wheels"))
              hook.getDriver().findElement(By.cssSelector(locators.get("Fifteen52Turbomacwheels"))).click();
          else if(product.equalsIgnoreCase("Ladies Black and Green wet suit"))
              hook.getDriver().findElement(By.cssSelector(locators.get("LadiesBlackAndGreenWetSuitImg"))).click();
    }
    @When("adds to cart")
    public void adds_to_cart() {
        hook.getDriver().findElement(By.cssSelector(locators.get("AddToCartButton"))).click();

    }
    @When("clicks on checkout")
    public void clicks_on_checkout() {
        hook.getDriver().findElement(By.cssSelector(locators.get("checkoutButton"))).click();
    }
    @Then("customer should be on payments page")
    public void customer_should_be_on_payments_page() {
        Assert.assertTrue(hook.getDriver().getCurrentUrl().contains(locators.get("checkoutUrl")));
    }
    @Then("the product summary should be displayed on the side of screen")
    public void the_product_summary_should_be_displayed_on_the_side_of_screen() {

    }

}
