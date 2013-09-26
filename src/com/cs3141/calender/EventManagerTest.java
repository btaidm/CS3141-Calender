
public class EventManagerTest
{

	public static void main(String args[]){
		EventManager manager = new EventManager();
		Event e = new Event();
		manager.addEvent(e);
		if(!manager.getEvent(e.getHashCode).equals(e)){
			System.out.println("ERROR");
		}
		if(!manager.removeEvent(e).equals(e){
			System.out.println("ERROR");
		}
		manager.addEvent(e);
		if(!manager.removeEventWithKey(e.getHashCode()).equals(e)){
			System.out.println("ERROR")
		}
	}

}
