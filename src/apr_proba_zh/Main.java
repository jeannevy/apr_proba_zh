package apr_proba_zh;

import java.util.Observable;
import java.util.Observer;

import apr_proba_zh.BasisStation.NameRadio;

public class Main {
	
	public static Matrix basises = new Matrix();
	
	public static void basisesSet(Cell one, Cell two, Cell three, Cell four) {
		Main.basises.cellList.add(one);
		Main.basises.cellList.add(two);
		Main.basises.cellList.add(three);
		Main.basises.cellList.add(four);
	}
	
	public static void main(String[] args) {
		Matrix matrix = new Matrix();
//		Matrix basises  = new Matrix();
		
		BasisStation b1 = new BasisStation(0.0, 0.0, "egyes");
		BasisStation b2 = new BasisStation(1.0, 6.0, "kettes");
		BasisStation b3 = new BasisStation(4.0, 4.0, "harmas");
		BasisStation b4 = new BasisStation(7.0, 1.0, "negyes");
		
//		basises.cellList.add(b1);
//		basises.cellList.add(b2);
//		basises.cellList.add(b3);
//		basises.cellList.add(b4);
		basisesSet(b1, b2, b3, b4);
		
//		Observer observer1 = new Observer() {
//			@Override
//			public void update(Observable o, Object arg) {
//				if (o instanceof BasisStation.NameRadio && arg instanceof String) {
//					NameRadio radio = (NameRadio)o;
//					BasisStation station = radio.owner;
//					String name = (String)arg;
//					System.out.println("Observer1 \n" + station.toString() + " sais: name changed to: " + name); 
//				}
//				
//			}
//		};
//		Observer observer2 = new Observer() {
//			@Override
//			public void update(Observable o, Object arg) {
//				if (o instanceof BasisStation.NameRadio && arg instanceof String) {
//					NameRadio radio = (NameRadio)o;
//					BasisStation station = radio.owner;
//					String name = (String)arg;
//					System.out.println("Observer2 \n" + station.toString() + " sais: name changed to: " + name); 
//				}
//				
//			}
//		};
//		b1.nameRadio.addObserver(observer1);
//		b1.nameRadio.addObserver(observer2);
//		b1.setName("cica");
//		
//		b1.nameRadio.deleteObserver(observer1);
//		b1.nameRadio.deleteObserver(observer2);
//		b1.setName("cica");
//		
		
		for (int i = 0; i<8; i++) {
			for (int j = 0; j<8; j++) {
				Cell actcell = new Cell((double) i, (double) j);
				String nearBasisName = basises.chooseSmallest(actcell);
				for (Cell bas: basises.cellList) {
					BasisStation basisst = (BasisStation) bas;
					if (basisst.name.equals(nearBasisName)) {
						actcell.basis = basisst;
						break;
					}
				}
				matrix.cellList.add(actcell);
				System.out.println(actcell.getRow() + ", " + actcell.getCol() + ", " + actcell.basis.name);
			}
		}
		
		int size = matrix.cellList.size();
		System.out.println(size);
		
		for (int i= 0; i<10; i++) {
			Mobil mobilx = new Mobil(0.0, 0.0, i);
			mobilx.basis = b1;
			b1.nameRadio.addObserver(mobilx);
			Thread threadx = new Thread(mobilx);
			threadx.start();	
		}

	}

}
