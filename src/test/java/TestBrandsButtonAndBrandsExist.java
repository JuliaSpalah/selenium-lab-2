import org.assertj.core.api.Assertions;
import org.example.MainPage;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class TestBrandsButtonAndBrandsExist extends BaseTest {
    @Test
    public void testOne() {
        MainPage mainPage = new MainPage();
        List<String> actualBrandsList = mainPage
                .clickBrandsLink()
                .getBrands();

        List<String> expectedBrandsList = Arrays.asList("Apple", "Canon", "Hewlett-Packard", "HTC", "Palm", "Sony");
        Assertions.assertThat(actualBrandsList)
                .as("error name")
                .containsExactlyElementsOf(expectedBrandsList);

    }


}
