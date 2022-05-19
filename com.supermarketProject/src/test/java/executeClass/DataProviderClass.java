package executeClass;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class DataProviderClass {
 
  @DataProvider(name="data-provider")
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { "admin", "admin12" },
      new Object[] { "admin1", "admin" },
      new Object[] { "admin1", "admin1" }
    };
  }
}
