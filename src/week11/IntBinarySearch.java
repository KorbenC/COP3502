package week11;

public class IntBinarySearch extends AbstractSearch {

	private int m_foundItemIndex;
	
	
	public RESULT search(int[] list, int searchItem) {
		// TODO Auto-generated method stub
		return binarySearch(list, searchItem);
	}

	
	private RESULT binarySearch(int[] number, int searchValue)
	{
		RESULT result = RESULT.FOUND;
		int lo = 0;
		int hi = number.length - 1;
		
		while(lo <= hi){
			int mid = lo + (hi - lo) / 2;
			if(searchValue == number[mid])
				break;
			else if (searchValue < number[mid])
				hi = mid - 1;
			else if (searchValue > number[mid])
				lo = mid + 1;
		}
		
		if(lo > hi){
			result = RESULT.NOT_FOUND;
		}
		
		return result;
	}
}
