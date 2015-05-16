import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {

 @Inject
 private ModuleService moduleService;

 private Testee testee;
 
 @BeforeClass
 public void before(){
  testee = Testee.getInstance();
 }
 
 @Test
 public void test() {
  IMockMe mockMeMock = createMock();
  testee.setDependeny(mockMeMock);

  moduleService.setModule(IMockMe.class, mockMeMock);

  Date result = testee.doSomething();
  // assertThat(result ist so oder so);
 }

 private IMockMe createMock() {
  IMockMe mock = mockito.makeMock(IMockMe.class);
  mockito.mockMethod{{
   mock.getDate();
   returns(new Date(o));
  }};
  return mock;
 }

 private class Testee {
  
  private Testee instance;
  
  static Testee getInstance(){
   if (instance == null){
    instance = new Testee();
   }
   return instance;
  }

  private IMockMe dependeny;

  public Date public void setDependeny(IMockMe dependeny) {
   this.dependeny = dependeny;
  }


  static doSomething() {
   return dependeny.getDate();
  }
 }

 private interface IMockMe {
  Date getDate();
 }

 private class MockMeProductive implements IMockMe {
  public Date getDate() {
   return new Date();
  }
 }

 private class ModuleService {
  public <T> T getModule(Class<T> clazz) {
  }
  public <T> void setModule(Class<T> clazz, T service) {
  }
 }
}
