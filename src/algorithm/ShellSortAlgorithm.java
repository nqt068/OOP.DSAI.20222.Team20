package algorithm;

import component.utils.ArrayUtil;
import component.utils.Element;

public class ShellSortAlgorithm<T extends Comparable<T>> extends SortingAlgorithm<T> {
	private int n;
	private int[] gaps;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ShellSortAlgorithm(int[] gaps, ArrayUtil<T> array) {
		super(array);
		
		ArrayUtil<T> arrayUtilGaps = new ArrayUtil(new Element[gaps.length]);
		for (int i = 0; i < gaps.length; i ++) {
			arrayUtilGaps.set(i, new Element(gaps[i]));
		}
				
		InsertionSortAlgorithm gapsIns = new InsertionSortAlgorithm(arrayUtilGaps);
		gapsIns.sort();
		arrayUtilGaps = gapsIns.array;
		
		for (int i = 0; i < gaps.length; i ++) {
			gaps[i] = (int) arrayUtilGaps.get(i).getValue();
		}
		
		this.gaps = gaps;
		this.array = array;
		this.n = array.size();
	}
		
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void sort() {
		for (int gap: gaps) {
			if (gap >= n) {
				continue;
			}
			else {
				for (int j = 0; j < gap; j++) {
					int count = 0;
					for (int i = j; i < n; i+= gap) {
						count += 1;
					}
					if (count > 1) {
						
						ArrayUtil<T> subArray = new ArrayUtil(new Element[count]);
						
						count = 0;
						for (int i = j; i < n; i+= gap) {
							subArray.set(count, array.get(i));
							count += 1;
						}
						
						InsertionSortAlgorithm ins = new InsertionSortAlgorithm(subArray);
						ins.sort();
						
						count = 0;
						for (int i = j; i < n; i+= gap) {
							array.set(i, ins.array.get(count));
							count += 1;
						}
					}
				}
			}
		}
	}
}

class InsertionSortAlgorithm<T extends Comparable<T>> extends SortingAlgorithm<T>{
	
	public InsertionSortAlgorithm(ArrayUtil<T> array) {
		super(array);
	}
	
	@SuppressWarnings("unchecked")
	public ArrayUtil<T> partlySort(int n, ArrayUtil<T> arr) {
		if (n == 1) {
			return arr;
		}
		else if (n == arr.size()) {
			ArrayUtil<T> tmp = new ArrayUtil<T>(new Element[arr.size() + 1]);
			for (int i = 0; i < arr.size(); i ++) {
				tmp.set(i, arr.get(i));
			}
			tmp = partlySort(n, tmp);
			for (int i = 0; i < arr.size(); i ++) {
				arr.set(i, tmp.get(i));
			}
			return arr;
 		}
		else {
			arr = partlySort(n-1, arr);
			
			ArrayUtil<T> tmp;
			tmp = new ArrayUtil<T>(new Element[arr.size()]);

			int location = -1;
			
			for (int i = 0; i < n; i++) {
				if (lessThanOrEqual(arr.get(n-1).getValue(), arr.get(i).getValue())) {
					location = i;
					break;
				}
			}
			
			if (location == n-1) {
				return arr;
			}
			
			else {
				for (int i = 0; i < n; i++) {
					if (i < location) {
						tmp.set(i, arr.get(i));;
					}
					else if (i >= location) {
						tmp.set(i+1, arr.get(i));
					}
					if (i == location) {
						tmp.set(location, arr.get(n-1));
					}
				}
				for (int i = 0; i < n; i ++) {
					arr.set(i, tmp.get(i));
				}

				return arr;
			}
		}
	}
	
	@Override
	public void sort() {
		this.array = partlySort(array.size(), array);
	}
}