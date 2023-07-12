package algorithm;
import component.utils.ArrayUtil;

public class SelectionSortAlgorithm<T extends Comparable<T> > extends SortingAlgorithm<T> {
	
	public SelectionSortAlgorithm(ArrayUtil<T> array) {
		super(array);
	}
	
	@Override
	public void sort() {
		int n=array.size();
		steps=0; //Initialize the steps count
		
		for(int i=0;i<n-1;i++) {
			int minIndex=1;
			for(int j=i+1;j<n;j++) {
				if(lessThan(array.get(j).getValue(),array.get(minIndex).getValue())) {
					minIndex=j;
				}
				steps++;
			}
			array.swap(i,minIndex);
			stepsList.add(array.clone());
		}
		timeComplexity=(long)n*n;
	}


}
