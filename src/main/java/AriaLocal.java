import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.SelectOption;

import java.util.List;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

// co-pilot session id 5c2cd444-bbab-45d3-976a-2aba8e532cd0 28/05
// new session c8/06 1a0d3ead-3b07-4824-9c66-9b9f844e7eb0

/*
*Test plan*
1 load local html file
* 2. fill all elements - most important as per John brief.  use role/label prorities.  try and use all the items described in your training.*
if too difficult to amend rh html we can use demoform
3. check non interactive elemets display correctly - this is checkin the ui is working well.
 */

public class AriaLocal {

    public static void main(String[] args) {

      final String HTML_BASE = "//src//main//java//aria.html";
        String path = System.getProperty("user.dir");
        String url = "file://" + path + HTML_BASE;

        try {
            Playwright playwright = Playwright.create();
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            BrowserContext context = browser.newContext();

            Page page = context.newPage();
            page.navigate(url);

            // Inputs
            // Test data submitted for the tests (user input value)
            final String LASTNAME = "Hall";
            final String EMAIL_ADDRESS = "richard@ukorg.com";
            final String GENDER = "Male"; // deliberately using lower case to test the label matching
            final String MOBILENUMBER = "1234567890";
            final String DATEOFBIRTH = "1901-03-01";
            final String TESTINGSKILLS1 = "Java";
            final String TESTINGSKILLS2 = "JavaScript"; // deliberately using upper case to test the label matching
            final String TESTINGSKILLS3 = "Allure";
            final String TESTINGSKILLS4 = "Playwright";
            final String TESTINGSKILLS5 = "Test Planning"; // deliberate error
            List<String> TESTINGSKILLS = List.of(TESTINGSKILLS1, TESTINGSKILLS2, TESTINGSKILLS3, TESTINGSKILLS4, TESTINGSKILLS5);
            final String CV_FILE_INPUT = "src/main/resources/Test_Document.txt";
            final String WORKING_LOCATION_PREFERNCE1 = "Hyrbid Working";
            final String WORKING_LOCATION_PREFERNCE2 = "Fully Remote/Home Working";
            // didn't do list here to be different
            List<String> POSTALADDRESS = List.of(
                    "123 Example Street",
                    "Flat 4B",
                    "Leeds",
                    "LS1 1AA"
            );
            final String COUNTRY = "Northern Ireland";

            //  UI Labels (on page)
            final String FIRST_NAME_LABEL = "First Name";
            final String LAST_NAME_LABEL = "Last Name";
            final String EMAIL_ADDRESS_LABEL = "Email address";
            final String GENDER_LABEL = "Gender";
            final String GENDER_MALE_LABEL = "Male";
            final String GENDER_FEMALE_LABEL = "Female";
            final String GENDER_OTHER_LABEL  = "Other";
            final String GENDER_NOT_SAY_LABEL = "Prefer Not to Say";
            final String MOBILE_NUMBER_LABEL = "Mobile Number";
            final String DATE_OF_BIRTH_LABEL = "Date of birth";
            final String TESTING_SKILLS_LABEL = "Testing Skills";
            final String CV_UPLOAD_LABEL = "Please upload your CV";
            final String COUNTRY_LABEL = "Country Where you Live";
            // More to do - first focus is on interaction

            // Locators

            Locator lastName = page.getByRole(AriaRole.TEXTBOX,
                    new Page.GetByRoleOptions().setName(LAST_NAME_LABEL).setExact(true));
            lastName.fill(LASTNAME);

            Locator email = page.getByRole(AriaRole.TEXTBOX,
                    new Page.GetByRoleOptions().setName(EMAIL_ADDRESS_LABEL).setExact(true));
            email.fill(EMAIL_ADDRESS);

            Locator gender = page.getByRole(AriaRole.RADIO,
                    new Page.GetByRoleOptions().setName(GENDER).setExact(true));
            gender.check();

            Locator mobileNumber = page.getByRole(AriaRole.TEXTBOX,
                    new Page.GetByRoleOptions().setName(MOBILE_NUMBER_LABEL).setExact(true));
            mobileNumber.fill(MOBILENUMBER);

            Locator country = page.getByRole(AriaRole.COMBOBOX,
                    new Page.GetByRoleOptions().setName(COUNTRY_LABEL).setExact(true));
            country.selectOption(new SelectOption().setLabel(COUNTRY));

            Locator dateOfBirth = page.getByLabel(DATE_OF_BIRTH_LABEL,
                    new Page.GetByLabelOptions().setExact(true));
            dateOfBirth.fill(DATEOFBIRTH);

            Locator testingSkills = page.getByRole(AriaRole.COMBOBOX,
            new Page.GetByRoleOptions().setName(TESTING_SKILLS_LABEL).setExact(true));
            for (String skill : TESTINGSKILLS) {
                testingSkills.fill(skill);
            }

            Locator cvUpload = page.ge

            // Assertions
            //use get by role but use a textarea or 0-3 min test
            //assertThat(page.locator("#country"))
              //    .hasText(COUNTRY);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


//declare a disabled field and check its disabled
// run through the getbylabel, get by row - look at official playwrite documentation for java o
