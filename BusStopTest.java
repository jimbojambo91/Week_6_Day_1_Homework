import static org.junit.Assert.assertEquals;
import org.junit.*;

public class BusStopTest{
  Bus bus;
  Person person;
  BusStop busStop;

  @Before
  public void before() {
    this.bus = new Bus();
    this.person = new Person();
    this.busStop = new BusStop();
  }

  @Test
  public void busStopStartsEmpty(){
    assertEquals(0, this.busStop.queueCount());
  }

  @Test
  public void canAddPerson(){
    this.busStop.add(this.person);
    assertEquals(1, this.busStop.queueCount());
  }

  @Test
  public void cannotAddPersonWhenQueueFull(){
    for(int i = 0; i < 20; i++){
      this.busStop.add(person);
    }
    assertEquals(15, this.busStop.queueCount());
  }

  @Test
  public void QueueIsFull(){
    for (int i = 0 ; i < 20; i++){
      this.busStop.add(this.person);
    }
    assertEquals(true, this.busStop.isQueueFull());
  }

  @Test
  public void shouldEmptyQueueAfterBusArrival(){
    this.busStop.add(this.person);
    this.busStop.arrival(this.bus);
    assertEquals(1, this.bus.passengerCount());
    assertEquals(0, this.busStop.queueCount());
  }

  @Test
  public void shouldBePeopleLeftInQueueIfBusFull(){
    for (int i = 0 ; i < 15; i++){
      this.busStop.add(this.person);
    }
    this.busStop.arrival(this.bus);
    assertEquals(10, this.bus.passengerCount());
    assertEquals(5, this.busStop.queueCount());
  }



  }