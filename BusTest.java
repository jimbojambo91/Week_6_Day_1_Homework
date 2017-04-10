import static org.junit.Assert.assertEquals;
import org.junit.*;

public class BusTest{
  Bus bus;
  Person person;
  BusStop busStop;

  @Before
  public void before() {
    this.bus = new Bus();
    this.person = new Person();
  }

  @Test
  public void busStartsEmpty(){
    assertEquals(0, this.bus.passengerCount());
  }

  @Test
  public void canAddPerson(){
    this.bus.add(this.person);
    assertEquals(1, this.bus.passengerCount());
  }

  @Test
  public void cannotAddPersonWhenBusFull(){
    for(int i = 0; i < 12; i++){
      this.bus.add(person);
    }
    assertEquals(10, this.bus.passengerCount());
  }

  @Test
  public void busIsFull(){
    for (int i = 0 ; i < 10; i++){
      this.bus.add(this.person);
    }
    assertEquals(true, this.bus.isBusFull());
  }

  @Test
  public void shouldEmptyBusAfterStop(){
    this.bus.add(this.person);
    this.bus.stop();
    assertEquals(0, this.bus.passengerCount());
  }

  

  


}

