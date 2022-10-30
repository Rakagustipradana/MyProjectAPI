import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class APITest {

    @Test(dataProvider="page")
    public void GetDataDetails(int x) {
        RestAssured.baseURI = "https://api.punkapi.com/v2";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET, "/beers?page=2&per_page="+ x);

        System.out.println("Status received => " + response.getStatusLine());
        System.out.println("Response=>" + response.prettyPrint());
    }

    @DataProvider(name="page")
    public Object[][] getData()
    {
        //multi-dimension element collection with two data sets
        return new Object[][]
                {{20},{1},{5}};
    }
}
