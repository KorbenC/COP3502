package week11;

public class BubbleSort extends AbstractSort{
	
	
	
	public BubbleSort(int[] list) {
		super("BubbleSort", list);
		// TODO Auto-generated constructor stub
	}

	
	private boolean isSorted(int[] number){
		
		boolean sorted = true;
		for(int i = 1; i < number.length; i++){
			if(number[i-1] > number[i]){
				sorted = false;
				break;
			}	
		}
		return sorted;
	}
	
	private boolean maxBottom(int[] number, int lastIndex){
		boolean isMaxBot = false;
		for (int i = 0; i < number.length;){
			if(number[i] == lastIndex)
				isMaxBot = true;
			else
				isMaxBot = false;
		}
		return isMaxBot;
		
	}
	@Override
	public void sort() {
		// TODO Auto-generated method stub
		
		int[] bubbleSort = new int[m_list.length];
		
		int temp = 0;
		
		for(int i = 0; i < m_list.length; i++){
			for(int j = 1; j < (m_list.length - i); j++ ){
				if(bubbleSort[j-1] > bubbleSort[j]){
					temp = bubbleSort[j-1];
					bubbleSort[j-1] = bubbleSort[j];
					bubbleSort[j] = temp;
				}
			}
		}
		
		
		
	}

}
