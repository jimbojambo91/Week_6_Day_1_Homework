public class Bus{
  private Person[] passengers;

  public Bus(){
    this.passengers = new Person[10];
  }

  public void add(Person person){
    if(isBusFull()){
      return;
    }
    int passengerCount = passengerCount();
    this.passengers[passengerCount] = person;
  }

  public boolean isBusFull(){
    return passengerCount() == passengers.length;
  }

  public int passengerCount(){
    int count = 0;
    for(Person person : this.passengers){
      if(person != null){
        count++;
      }
    }
    return count;
  }

  public void stop(){
    for(int i = 0; i < passengers.length; i++){
      this.passengers[i] = null;
    }
  }
}