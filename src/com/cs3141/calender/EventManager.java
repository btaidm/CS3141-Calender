
Public Class EventManager
{

	private HashMap<Integer, Event> events;
	
	public EventManager(){
	
	}

	public void addEvent(Event event){
		events.addObject(event.getHash, event);
	}
	
	public Event removeEventWithKey(Integer key){

	}
	
	public Void removeEvent(Event event){

	}

	public Event getEvent(Integer key){

	}

	

	

}
