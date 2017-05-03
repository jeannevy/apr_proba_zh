package apr_proba_zh;

import java.util.Observable;

public class BasisStation extends Cell {
	
	class NameRadio extends Observable {
		
		BasisStation owner;

		NameRadio(BasisStation owner) {
			this.owner = owner;
		}
		public BasisStation getOwner() {
			return this.owner;
		}
		
		void setChangedPublic() {
			super.setChanged();
		}
		
		public void notifyObservers(String name) {
			super.notifyObservers(name);
		}
	}
	
	NameRadio nameRadio = new NameRadio(this);
	String name;
	
	public String getName() {
		return name;
	}

	public void refresh(String name) {
		this.nameRadio.setChangedPublic();
		this.nameRadio.notifyObservers(name);
	}

	
	public BasisStation(double r, double c, String name) {
		super(r, c);
		this.name = name;
	}
	

	
		

}
