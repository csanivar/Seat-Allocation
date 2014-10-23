import java.util.ArrayList;
import java.util.HashMap;

public class MeritList{
	HashMap<Integer,ArrayList<String>> merit_list;
	
	public MeritList(){
		this.merit_list = new HashMap<Integer,ArrayList<String>>();
	}
	
	void putCandidate(String ID,String rank){
		ArrayList<String> tempArrList;
		int tempRank = Integer.valueOf(rank);
		if(this.merit_list.containsKey(tempRank)){
			tempArrList = this.merit_list.get(rank);
			tempArrList.add(ID);
		}
		else{
			tempArrList = new ArrayList<String>();
			tempArrList.add(ID);
		}
		this.merit_list.put(tempRank, tempArrList);
	}
}