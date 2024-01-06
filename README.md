# Automation Test Challenge

This repository contains UI and API Test Automation scripts for [Parabank Application](https://parabank.parasoft.com). Parabank is a realistic online banking application that facilitates fund transaction management.

**Note:** If the [Parabank Application](https://parabank.parasoft.com) is not up and running, deploy the pre built parabank app [(github repo for reference)](https://github.com/parasoft/parabank) `parabank-3.0.0-SNAPSHOT.war` located in the root directory using an [Apache Tomcat](https://tomcat.apache.org/download-90.cgi) container.

## Prerequisites

To run this automation framework locally, ensure you have the following installed:

- JDK 11 or higher
- Maven
- [ChromeDriver](https://sites.google.com/a/chromium.org/chromedriver/) (for executing Selenium tests)

## UI Test

### Account Creation

- Registering a new user account and logged in
- Logging out after successful login

### New Account Opening and Transaction Search

- Logging in with valid credentials
- Creating a new savings account
- Verifying the details of the newly created account
- Searching for transactions related to the new account

## API Endpoint Tests

### Validating REST service endpoints

- **GET /services/bank/login/${username}/${password}**
- **GET /services/bank/customers/${customerId}**
- **POST /services/bank/createAccount with 3 parameters { customerId: int, newAccountType: int, fromAccountId: int }**
- **GET /services/bank/accounts/${accountid}/transactions/amount/${amount} **
  - Checking response codes and schema validations for the endpoints
  - Validating specific transaction details from an API response

## Setup and Running the Test

1. **Clone the Project Repository:**

   ```bash
   git clone https://github.com/makuneru/automation-test-challenge-java.git
   ```

   Clone the project repository to your local machine.

2. **Navigate to Project Directory:**
   ```bash
   cd automation-test-challenge-java
   ```
   Move into the root directory of the cloned project.

### Building and Running Tests

3. **Install Dependencies:**

   ```bash
   mvn clean install
   ```

   This command installs all required dependencies and prepares the project for execution.

4. **Run Tests:**

   ```bash
   mvn test
   ```

5. **Run Cucumber Tests with Tags:**
   ```bash
   mvn test -Dcucumber.filter.tags="@test-challenge"
   ```
   Run Cucumber-based tests with specific tags by replacing `@test-challenge` with your desired tag.

### Viewing Test Reports

6. **Access Test Reports:**
   - Once tests have run, find the reports in the `target` folder.
   - Cucumber test reports are typically available at `target/cucumber-reports/index.html`.

# UI Web Elements Naming Convention

Use the following prefixes when naming UI Web Elements in your application page objects:
| Category | UI Control Type | Prefix | Example |
|----------|----------------------------|--------|------------------|
| Basic | Button | btn | btnExit |
| Basic | Check box | chk | chkReadOnly |
| Basic | Combo box | cbo | cboEnglish |
| Basic | Common dialog | dlg | dlgFileOpen |
| Basic | Date picker | dtp | dtpPublished |
| Basic | Dropdown List / Select tag | ddl | ddlCountry |
| Basic | Form | frm | frmEntry |
| Basic | Frame | fra | fraLanguage |
| Basic | Image | img | imgIcon |
| Basic | Label | lbl | lblHelpMessage |
| Basic | Links/Anchor Tags | lnk | lnkForgotPwd |
| Basic | List box | lst | lstPolicyCodes |
| Basic | Menu | mnu | mnuFileOpen |
| Basic | Radio button / group | rdo | rdoGender |
| Basic | RichTextBox | rtf | rtfReport |
| Basic | Table | tbl | tblCustomer |
| Basic | TabStrip | tab | tabOptions |
| Basic | Text Area | txa | txaDescription |
| Basic | Text box | txt | txtLastName |
| Basic | Header | hdr | hdrCustomerLogin |
| Complex | Chevron | chv | chvProtocol |
| Complex | Data grid | dgd | dgdTitles |
| Complex | Data list | dbl | dblPublisher |
| Complex | Directory list box | dir | dirSource |
| Complex | Drive list box | drv | drvTarget |
| Complex | File list box | fil | filSource |
| Complex | Panel/Fieldset | pnl | pnlGroup |
| Complex | ProgressBar | prg | prgLoadFile |
| Complex | Slider | sld | sldScale |
| Complex | Spinner | spn | spnPages |
| Complex | StatusBar | sta | staDateTime |
| Complex | Timer | tmr | tmrAlarm |
| Complex | Toolbar | tlb | tlbActions |
| Complex | TreeView | tre | treOrganization |
