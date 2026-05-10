package dataproviders;

import org.testng.annotations.DataProvider;

import Utils.ExcelUtil;

public class LoginDataProvider {

	@DataProvider(name = "loginData")
	public Object[][] loginData() {

        String filePath =
                System.getProperty("user.dir")
                + "/src/test/resources/testdata/LoginData.xlsx";

        return ExcelUtil.getTestData(
                filePath,
                "LoginData");
    }

}
