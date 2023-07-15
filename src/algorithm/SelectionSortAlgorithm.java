package algorithm;
import component.utils.ArrayUtil;
import component.utils.Element;

public class SelectionSortAlgorithm<T extends Comparable<T> > extends SortingAlgorithm<T> {
	
	public SelectionSortAlgorithm(ArrayUtil<T> array) {
		super(array);
	}
	
	@Override
	public void sort() {
		stepsList.add(array.clone());
		int n=array.size();
		
		for(int i=0;i<n-2;i++) {
			int minIndex= i;
			for(int j= i+1; j<n; j++) {
				if((lessThan(array.get(j).getValue(),array.get(minIndex).getValue()))){
					minIndex=j;
				}
				steps++;
			}
			Element<T> temp = array.get(i);
	        array.set(i, array.get(minIndex));
			stepsList.add(array.clone());
			
	        array.set(minIndex, temp);
			stepsList.add(array.clone());
		}
		timeComplexity=(long)n*n;
	}
}

