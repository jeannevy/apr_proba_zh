package apr_proba_zh;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class Matrix {
	ArrayList<Cell> cellList;
	
	public Matrix() {
		this.cellList = new ArrayList<Cell>();
	}
	
	public String chooseSmallest(Cell param) {
		HashMap<String, Double> resultmap = new HashMap<String, Double>();
		
		for (Cell c : this.cellList) {
			double result = param.calculateDistance(c);
			BasisStation b = (BasisStation)c;
			String name = b.name;
			resultmap.put(name, result);
		}
		Set<Entry<String, Double>> resultSet = resultmap.entrySet();
		ArrayList<Entry<String, Double>> resultList = new ArrayList<Entry<String, Double>>(resultSet);
		resultList.sort(new Comparator<Entry<String, Double>>() {
	        @Override
	        public int compare(Entry<String, Double> entry1, Entry<String, Double> entry2) {
	        	double distance1 = entry1.getValue();
	        	double distance2 = entry2.getValue();
	            return (int) (distance2 - distance1);
	        }
	    });
		
		
	}
}
