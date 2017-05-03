package apr_proba_zh;

import java.util.Random;

public class Mobil extends Cell implements Runnable {
	int id;
	
	public Mobil(double r, double c, int id) {
		super(r, c);
		this.id = id;
	}
	
	public String toString() {
		String result = "id: " + this.id + ", " + this.getRow() + ", " + this.getCol() + ", " + "basis name: " + this.basis.name;
		return result;
	}
	
	public void run() {
		while (true) {
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
					break;
				}
			}
			System.out.println(this);
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
}
