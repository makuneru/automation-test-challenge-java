package stepdefinitions;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.specification.RequestSpecification;
import pages.AccountsOverviewPage;
import pages.FindTransactionsPage;
import pages.LoginPage;
import pages.OpenNewAccountPage;
import pages.RegistrationPage;
import utils.CommonUtils;
import utils.ConfigReader;
import utils.FileNameConstants;

public class AutomationTestChallenge {
	WebDriver driver;

    private static final Random random = new Random();
	private OpenNewAccountPage openNewAccountPage;
	private FindTransactionsPage findTransactionsPage;
	private AccountsOverviewPage accountsOverviewPage;
    private LoginPage loginPage;
    private RegistrationPage registrationPage;
   	private CommonUtils commonUtils;
   	
    private Response response;
   	private RequestSpecification httpRequest;

    private String generatedFirstName;
    private String generatedLastName;
    private String generatedAddress;
    private String generatedCity;
    private String generatedState;
    private String generatedPhoneNumber;
    private String generatedZipCode;
    private String generatedSSN;
    private String generatedPassword;
    private String newAccountNumber;
    private String newAccountNumberViaAPI;
    private String accountType;
    private String customerId;
    
	@Given("User navigates to Open New Account Page")
	public void user_navigates_to_open_new_account_page() {
		driver = DriverFactory.getDriver();
		this.openNewAccountPage = new OpenNewAccountPage(driver);
		openNewAccountPage.clickLnkOpenNewAccount();

		this.findTransactionsPage = new FindTransactionsPage(driver);
	}

	@When("User selects {string} in type of account to open")
	public void user_selects_in_type_of_account_to_open(String accountType) {
		if ("SAVINGS".equalsIgnoreCase(accountType)) {
		    openNewAccountPage.selectOptionInAccountTypeDropdown("1");
		} else {
		    openNewAccountPage.selectOptionInAccountTypeDropdown("0");
		}
	}

	@When("User clicks on Open New Account button")
	public void user_clicks_on_open_new_account_button() {
		openNewAccountPage.clickOnOpenNewAccountButton();
	}

	@Then("User new savings account should get created successfully")
	public void user_new_savings_account_should_get_created_successfully() {
		// Assert the presence of the "Accounts Opened!" title
        boolean isTitlePresent =  openNewAccountPage.isAccountOpenedTitlePresent();
        Assert.assertTrue("Accounts Opened! title is not present after account creation.", isTitlePresent);
	}

	@Then("User clicks on the new account id link")
	public void user_clicks_on_the_new_account_id_link() {
		//store the new account id
		newAccountNumber = openNewAccountPage.getLnkNewAccountIdText();
		accountsOverviewPage = openNewAccountPage.clickOnNewAccountId();
	}

	@Then("User validates the new account details")
	public void user_validates_the_new_account_details() {
		assertEquals("Account numbers don't match!", accountsOverviewPage.getLblAccountNumberText(), newAccountNumber);
		assertEquals("Account Type don't match!", accountsOverviewPage.getLblAccountTypeText(), "SAVINGS");
		assertEquals("Account Balance don't match!", accountsOverviewPage.getLblAvailableBalanceText(), "$100.00");
		assertEquals("Account Available Balance don't match!", accountsOverviewPage.getLblAvailableBalanceText(), "$100.00");
	}

	@Given("User navigates to Find Transactions Page")
	public void user_navigates_to_find_transactions_page() {
	   findTransactionsPage.clickLnkFindTransactions();
	}

	@When("User selects the new account")
	public void user_selects_the_new_account() {
		findTransactionsPage.selectOptionInAccountDropdown(newAccountNumber);
	}

	@When("User enter the amount in Find By Amount Field")
	public void user_enter_the_amount_in_find_by_amount_field() {
		findTransactionsPage.enterTransactionAmount("100");
	}

	@When("User clicks on Find Transactions by {string} button")
	public void user_clicks_on_find_transactions_by_button(String searchType) {
		findTransactionsPage.clickFindTransactionsBySearchType(searchType);
	}

	@Then("User should see the transaction results.")
	public void user_should_see_the_transaction_results() {
		String expectedTransactionDescription = "Funds Transfer Received";
		String expectedTransactionAmount = "$100.00";
		assertEquals("Transaction Description don't match!", findTransactionsPage.getLblTransactionDescriptionText(), expectedTransactionDescription);
		assertEquals("Transaction Amount don't match!", findTransactionsPage.getLblTransactionAmountText(), expectedTransactionAmount);
	}
	
	@Given("User navigates to login page")
    public void user_navigates_to_login_page() {
        driver = DriverFactory.getDriver();
        loginPage = new LoginPage(driver);
    }

    @When("User enters valid username into {string} username field")
    public void User_enters_valid_username_into_username_field(String username) {
    	String usernameToEnter = (username != null && !username.isEmpty()) ? username : generatedFirstName;
        loginPage.enterUsername(usernameToEnter);
    }

    @And("User enters valid password into {string} password field")
    public void User_enters_valid_password_into_password_field(String password) {
    	String passwordToEnter = (password != null && !password.isEmpty()) ? password : generatedPassword;
        loginPage.enterPassword(passwordToEnter);
    }

    @And("User clicks on Login button")
    public void user_clicks_on_login_button() {
        accountsOverviewPage = loginPage.clickOnLoginButton();
    }

    @Then("User should get successfully logged in")
    public void user_should_get_successfully_logged_in() {
        // Assert the presence of the "Accounts Overview" title
        boolean isTitlePresent = accountsOverviewPage.isAccountsOverviewTitlePresent();
        Assert.assertTrue("Accounts Overview title is not present after login", isTitlePresent);
    }
    
	@Given("User navigates to Registration Page")
	public void user_navigates_to_registration_page() {
		driver = DriverFactory.getDriver();
		this.registrationPage = new RegistrationPage(driver);
		registrationPage.clickOnRegisterButton();
	}

	@When("User enters the details into Registration Page")
	public void user_enters_the_details_into_registration_page() {
		commonUtils = new CommonUtils();
        generatedFirstName = commonUtils.getRandomFirstName();
        registrationPage.enterFirstName(generatedFirstName);
   
        generatedLastName = commonUtils.getRandomLastName();
        registrationPage.enterLastName(generatedLastName);
  
        generatedAddress = commonUtils.getRandomAddress();
        registrationPage.enterAddress(generatedAddress);
        
        generatedCity = commonUtils.getRandomCity();
        registrationPage.enterCity(generatedCity);
   
        generatedState = commonUtils.getRandomState();
        registrationPage.enterState(generatedState);
  
        generatedZipCode = commonUtils.getRandomZipCode();
        registrationPage.enterZipCode(generatedZipCode);
        
        generatedPhoneNumber = commonUtils.getRandomPhoneNumber();
        registrationPage.enterPhoneNumber(generatedPhoneNumber);
        
        generatedSSN = commonUtils.getRandomSSN();
        registrationPage.enterSSN(generatedSSN);
        
        registrationPage.enterUserName(generatedFirstName);
        generatedPassword = generatedFirstName + random.nextInt(1000);
        registrationPage.enterPassword(generatedPassword);
        registrationPage.enterConfirmPassword(generatedPassword);
	}

	@When("User clicks on Register button")
	public void user_clicks_on_continue_button() {
		accountsOverviewPage = registrationPage.clickOnConfirmRegisterButton();
	}

	@Then("User account should get created successfully and logged in")
	public void user_account_should_get_created_successfully_and_logged_in() {
		// Assert the presence of the "Accounts Overview" title
        boolean isTitlePresent = accountsOverviewPage.isAccountsOverviewTitlePresent();
        Assert.assertTrue("Accounts Overview title is not present after login", isTitlePresent);
	}
	
    @Then("User click on logout button")
    public void user_click_on_logout_button() {
    	registrationPage.clickLnkLogout();
    }
    
    
    @Given("Rest service login endpoint {string}")
    public void rest_service_login_endpoint(String endpoint) {
    	String baseUrl = new ConfigReader().intializeProperties().getProperty("url");
    	httpRequest = RestAssured.given()
    			.contentType(ContentType.JSON)
    			.accept(ContentType.JSON)
    			.baseUri(baseUrl+endpoint+generatedFirstName + "/" + generatedPassword);
    }
    
    @Given("Rest service customer details endpoint {string}")
    public void rest_service_customer_details_endpoint(String endpoint) {
    	String baseUrl = new ConfigReader().intializeProperties().getProperty("url");
    	httpRequest = RestAssured.given()
    			.contentType(ContentType.JSON)
    			.accept(ContentType.JSON)
    			.baseUri(baseUrl+endpoint+response.then().extract().path("id"));
    }

    @Given("Rest service create account endpoint {string}")
    public void rest_service_create_account_endpoint(String endpoint) {
        String baseUrl = new ConfigReader().intializeProperties().getProperty("url");
        httpRequest = RestAssured.given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .baseUri(baseUrl + endpoint);
    }
    
    @When("User Call {string} method.")
    public void user_call_request_method(String method) {
    	switch (method.toUpperCase()) {
        case "GET":
            response = httpRequest.get();
            break;
        case "POST":
            response = httpRequest.post();
            break;
        case "PUT":
            response = httpRequest.put();
            break;
        case "PATCH":
            response = httpRequest.patch();
            break;
        case "DELETE":
            response = httpRequest.delete();
            break;
        default:
            throw new IllegalArgumentException("Invalid HTTP method: " + method);
    	}
    	
    	System.out.println("Response Status Code: " + response.getStatusCode());
        System.out.println("Response Body: " + response.getBody().asString());
    }

    @When("User Call POST method with account {string} parameters.")
    public void user_call_method_with_parameters(String account) {    	
        accountType = account.equalsIgnoreCase("SAVINGS") ? "1" : "0";
	    response = httpRequest
	            .queryParam("customerId", response.then().extract().path("id").toString())
	            .queryParam("fromAccountId", newAccountNumber)
	            .queryParam("newAccountType", Integer.parseInt(accountType))
	            .post();
        
	    System.out.println("Response Status Code: " + response.getStatusCode());
        System.out.println("Response Body: " + response.getBody().asString());
        
        newAccountNumberViaAPI = response.then().extract().path("id").toString();
        customerId = response.then().extract().path("customerId").toString();
        accountType = response.then().extract().path("type");
    }
    
    @Then("User validates response is successful with code {string}")
    public void user_verify_response_is_successful_with_code(String  statusCode) {
    	int expectedStatusCode = Integer.parseInt(statusCode);
    	response.then().assertThat().statusCode(expectedStatusCode);
    }
    
    @Then("User validates the user details response schema")
    public void user_validates_the_user_details__response_schema() throws IOException  {
    	String userDetailsSchema = FileUtils.readFileToString(new File(FileNameConstants.USER_DETAILS_SCHEMA), "UTF-8");
    	response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(userDetailsSchema));
    }
    
    @Then("User validates the create account response schema")
    public void user_validates_the_create_account_response_schema() throws IOException  {
    	String createAccountSchema = FileUtils.readFileToString(new File(FileNameConstants.CREATE_ACCOUNT_SCHEMA), "UTF-8");
    	response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(createAccountSchema));
    }
    
    @Then("User validates transaction results with details")
    public void user_validates_transactions_results_with_details(List<Map<String, String>> dataTable) throws IOException  {
    	// Validate the API response body with the expected details in the 'dataTable'
        for (Map<String, String> row : dataTable) {
            String expectedAccountId = newAccountNumberViaAPI;
            String expectedType = row.get("type");
            String expectedDescription = row.get("description");
            
            String expectedAmount = row.get("amount").toString();
            String actualAmount = response.then().extract().path("[0].amount").toString().split("\\.")[0]; ;
            Assert.assertEquals(actualAmount, expectedAmount);
            
	        String actualAccountId = response.then().extract().path("[0].accountId").toString();
	    	Assert.assertEquals(actualAccountId, expectedAccountId);
	    	
	        String actualType = response.then().extract().path("[0].type").toString();
	    	Assert.assertEquals(actualType, expectedType);    
	    	
	        String actualDescription = response.then().extract().path("[0].description").toString();
	    	Assert.assertEquals(actualDescription, expectedDescription);
        }
    }

    
    @Then("User validates the find transactions response schema")
    public void user_validates_the_find_transactions_response_schema() throws IOException  {
    	String findTransactionsSchema = FileUtils.readFileToString(new File(FileNameConstants.FIND_TRANSACTIONS_SCHEMA), "UTF-8");
    	response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(findTransactionsSchema));
    }

    @Then("User validates the response body")
    public void user_validates_the_response_body() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    
    @Given("Rest service find transactions endpoint {string} by amount {string}")
    public void rest_service_find_transactions_endpoint_by_amount(String endpoint, String amount) {
        String baseUrl = new ConfigReader().intializeProperties().getProperty("url");
        String endpointWithAccountId = endpoint.replace("//", "/" + newAccountNumberViaAPI + "/");
        httpRequest = RestAssured.given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .baseUri(baseUrl+ endpointWithAccountId + amount);
    }
    
    @Then("User validates {string} account created.")
    public void user_validates_account_created(String accountType) {
    	String actualAccountType = response.then().extract().path("type").toString();
    	Assert.assertEquals(actualAccountType, accountType);
    	
    	String actualCustomerId = response.then().extract().path("customerId").toString();
    	Assert.assertEquals(actualCustomerId, customerId.trim());
    }
}
