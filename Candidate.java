import java.io.*;
import java.util.*;

public class Candidate{
	String id;
	String category;
	String pd_status;
	String ds_eligibility;
	String nationality;
	String pl;
	ArrayList<String> virtual_pl;
	int current_vp;
	int next_vp;
	int alloted_vp;

	public void Candidate(){
		this.pl="";
		this.virtual_pl = new ArrayList<String>();
		this.current_vp = 0;
		this.next_vp = 0;
		this.alloted_vp = -1;
	}

	private void setID(String id){
		this.id = id;
	}

	private void setCategory(String category){
		this.category = category;
	}

	private void setPDStatus(String pd_status){
		this.pd_status = pd_status;
	}

	private void setDSStatus(String ds_eligibility){
		this.ds_eligibility = ds_eligibility;
	}

	private void setNationality(String nationality){
		this.nationality = nationality;
	}

	private void setPL(String pl){
		this.pl = pl;
	}

	private void setCurrentVP(int current_vp){
		this.current_vp = current_vp;
	}

	private void setNextVP(int next_vp){
		this.next_vp = next_vp;
	}

	private void setAllotedVP(int alloted_vp){
		this.alloted_vp = alloted_vp;
	}

	private void makeVPL(){
		String[] all_pls = pl.split("_");
		if(pd_status.equlas("NO")){
			switch(category){
				case "GE": for(int i=0;i<all_pls.length;i++){
							virtual_pl.add(all_pls[i]);
							virtual_pl.add(all_pls[i]+"-OBC");
							virtual_pl.add(all_pls[i]+"-PD");
							virtual_pl.add(all_pls[i]+"-OBC-PD");
						 }
						 break;
				case "OBC": for(int i=0;i<all_pls.length;i++){
							virtual_pl.add(all_pls[i]);
							virtual_pl.add(all_pls[i]+"-OBC");
							virtual_pl.add(all_pls[i]+"-PD");
							virtual_pl.add(all_pls[i]+"-OBC-PD");
						  }
						  break;
				case "SC": for(int i=0;i<all_pls.length;i++){
							virtual_pl.add(all_pls[i]);
							virtual_pl.add(all_pls[i]+"-SC");
							virtual_pl.add(all_pls[i]+"-OBC");
							virtual_pl.add(all_pls[i]+"-PD");
							virtual_pl.add(all_pls[i]+"-OBC-PD");
							virtual_pl.add(all_pls[i]+"-SC-PD");
						 }
						 break;
				case "ST": for(int i=0;i<all_pls.length();i++){
							virtual_pl.add(all_pls[i]);
							virtual_pl.add(all_pls[i]+"-ST");
							virtual_pl.add(all_pls[i]+"-OBC");
							virtual_pl.add(all_pls[i]+"-PD");
							virtual_pl.add(all_pls[i]+"-OBC-PD");
							virtual_pl.add(all_pls[i]+"-ST-PD");
						 }
						 break;
			}
		}
		else if(pd_status.equlas("YES")){
			switch(category){
				case "GE": for(int i=0;i<all_pls.length;i++){
							virtual_pl.add(all_pls[i]);
							virtual_pl.add(all_pls[i]+"-PD");	
						 }
						 break;
				case "OBC": for(int i=0;i<all_pls.length;i++){
							virtual_pl.add(all_pls[i]);
							virtual_pl.add(all_pls[i]+"-PD");
							virtual_pl.add(all_pls[i]+"-OBC");
							virtual_pl.add(all_pls[i]+"-OBC-PD");
						  }
						  break;
				case "SC": for(int i=0;i<all_pls.length;i++){
							virtual_pl.add(all_pls[i]);
							virtual_pl.add(all_pls[i]+"-SC");
							virtual_pl.add(all_pls[i]+"-PD");
							virtual_pl.add(all_pls[i]+"-SC-PD");
							virtual_pl.add(all_pls[i]+"-OBC");
							virtual_pl.add(all_pls[i]+"-OBC-PD");
						 }
						 break;
				case "ST": for(int i=0;i<all_pls.length();i++){
							virtual_pl.add(all_pls[i]);
							virtual_pl.add(all_pls[i]+"-ST");
							virtual_pl.add(all_pls[i]+"-PD");
							virtual_pl.add(all_pls[i]+"-ST-PD");
							virtual_pl.add(all_pls[i]+"-OBC");
							virtual_pl.add(all_pls[i]+"-OBC-PD");
						 }
						 break;
			}
		}
	}

	private String getID(){
		return this.id;
	}
	private String getCategory(){
		return this.category;
	}
	private String getNationality(){
		return this.nationality;
	}
	private String getPDStatus(){
		return this.pd_status;
	}
	private String getDSStatus(){
		return this.ds_eligibility;
	}
	private ArrayList<String> getVPL(){
		return this.virtual_pl;
	}
	private Integer getCurrentVP(){
		return current_vp;
	}
	private Integer getNextVP(){
		return next_vp;
	}
	private Integer getAllotedVP(){
		return alloted_vp;
	}
	
}