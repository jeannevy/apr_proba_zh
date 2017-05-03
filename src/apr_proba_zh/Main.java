package apr_proba_zh;

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
		
		Cell b1 = new BasisStation(0.0, 0.0, "egyes");
		Cell b2 = new BasisStation(1.0, 6.0, "kettes");
		Cell b3 = new BasisStation(4.0, 4.0, "harmas");
		Cell b4 = new BasisStation(7.0, 1.0, "negyes");
		
//		basises.cellList.add(b1);
//		basises.cellList.add(b2);
//		basises.cellList.add(b3);
//		basises.cellList.add(b4);
		basisesSet(b1, b2, b3, b4);
		
		
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
			Thread threadx = new Thread(mobilx);
			threadx.start();	
		}
		


		

	}

}
