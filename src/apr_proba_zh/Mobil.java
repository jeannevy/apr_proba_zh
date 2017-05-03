package apr_proba_zh;

import java.util.Observable;
import java.util.Observer;
import java.util.Random;

public class Mobil extends Cell implements Runnable, Observer {
	int id;
	
	public Mobil(double r, double c, int id) {
		super(r, c);
		this.id = id;
	}
	
	public String toString() {
		String result = "id: " + this.id + ", " + this.getRow() + ", " + this.getCol() + ", " + "basis name: " + this.basis.name;
		return result;
	}
	
	public void update(Observable o, Object message) {
		if (o instanceof BasisStation.NameRadio && message instanceof String) {
			BasisStation.NameRadio radio = (BasisStation.NameRadio)o;
			BasisStation station = radio.owner;
			String nameMessage = (String)message;
			System.out.println("mobil id: " + this.id + " new basisstation name: " + nameMessage + " (is got from, basis position): " + station.getRow() + ", " + station.getCol()); 
		}
		}
	
	public void run() {
		
		while (true) {
			this.basis.nameRadio.deleteObserver(this);
			Random randrow = new Random();
			int randrowint = randrow.nextInt(8);
			double randrowDouble = (double)randrowint;
			
			Random randcol = new Random();
			int randcolint = randcol.nextInt(8);
			double randcolDouble = (double)randcolint;
			
			this.setCell(randrowDouble, randcolDouble);
			String nearBasisName = Main.basises.chooseSmallest(this);
			for (Cell bas: Main.basises.cellList) {
				BasisStation basisst = (BasisStation) bas;
				if (basisst.name.equals(nearBasisName)) {
					this.basis = basisst;
					this.basis.nameRadio.addObserver(this);
//					this.basis.refresh(this.basis.name);
					break;
				}
			}
			System.out.println(this);

			Random daterand = new Random();
			int dateRandInt = daterand.nextInt(5);
			if (dateRandInt == 2) {
				System.out.println("this mobil wants to know the time: " + this.id);
				this.basis.getDate();
			}
			
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
}
