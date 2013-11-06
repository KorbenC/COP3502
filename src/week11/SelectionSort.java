package week11;

public class SelectionSort extends AbstractSort{

	public SelectionSort(int[] list) {
		super("SelectionSort", list);
		// TODO Auto-generated constructor stub
	}
	
	private boolean minStart(int[] number, int startIndex){
		boolean minStart = true;
		for (int i = 0; i < number.length; i++){
			if(number[i+1] == startIndex){
				minStart = false;
			}
		}
		return minStart;
		
	}
	
	public void sort(){
		int[] selectionSort = new int[m_list.length];
		
		for(int i = 0; i < m_list.length; i++){
			int min = i;
			for(int j =i; j < m_list.length; j++){
				if(selectionSort[min] < selectionSort[j]){
					min = j;
				}
			}
			
			int temp = selectionSort[i];
			selectionSort[i] = selectionSort[min];
			selectionSort[min] = temp;
		}
		
	}

}
