package by.pvt.home;


import org.mockito.Mock;
import static org.mockito.Mockito.*;
import static org.testng.Assert.assertEquals;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.*;


public class DataServiceTest {

    private DataService service;

    @Mock
    private DataClazz dataClazz;

    @BeforeClass
    public void initOne() {
        service = new DataService();

        MockitoAnnotations.openMocks(this);

        when(dataClazz.getValue()).thenReturn("value");
    }

    @Test(groups = "one", threadPoolSize = 4, invocationCount = 10, timeOut = 10000)
    public void prefixAdditionShouldPositive() throws InterruptedException {
        String valueWithPrefix = service.addValue(dataClazz);
        Thread.sleep(3000);
        assertEquals(valueWithPrefix, "Value is value");
    }

    @Test(groups = "one", threadPoolSize = 4, invocationCount = 10, timeOut = 1000, expectedExceptions = InterruptedException.class)
    public void prefixAdditionShouldNegative() throws InterruptedException {
        String valueWithPrefix = service.addValue(dataClazz);
        Thread.sleep(3000);
        assertEquals(valueWithPrefix, "Value is value");

    }

    @Test(groups = "one", expectedExceptions = IllegalArgumentException.class)
    public void getIdShouldNegative() {
        service.getId(133);

    }

    @Test(groups = "one", expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = "error")
    public void getIdMessageShouldNegative() {
        service.getId(133);
    }

}