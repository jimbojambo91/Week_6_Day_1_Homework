public class BusStop{
  private Person[] queue;

  public BusStop(){
    this.queue = new Person[10];
  }

  public void add(Person person){
    if(isQueueFull()){
      return;
    }
    int queueCount = queueCount();
    this.queue[queueCount] = person;
  }

  public boolean isQueueFull(){
    return queueCount() == queue.length;
  }

  public int queueCount(){
    int count = 0;
    for(Person person : this.queue){
      if(person != null){
        count++;
      }
    }
    return count;
  }

  public void arrival(Bus bus){
    for(int i = 0; i < queueCount(); i++){
      if(bus.isBusFull()){
        return;
      }
      bus.add(queue[i]);
      queue[i] = null;
    }
  }

}