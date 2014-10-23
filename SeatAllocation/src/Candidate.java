import java.io.*;
import java.util.*;

public class Candidate{
	String id;
	String category;
	Boolean pd_status;
	String ds_eligibility;
	String nationality;
	String pl;
	ArrayList<String> virtual_pl;
	int current_vp;
	int next_vp;
	int alloted_vp;

	public Candidate(){
		this.pl="";
		this.pd_status = false;
		this.virtual_pl = new ArrayList<String>();
		this.current_vp = 0;
		this.next_vp = 0;
		this.alloted_vp = -1;
	}

	void setID(String id){
		this.id = id;
	}

	void setCategory(String category){
		this.category = category;
	}

	void setPDStatus(String pd_status){
		if(pd_status=="Y") this.pd_status = true;
		else if(pd_status=="N") this.pd_status = false;
	}

	void setDSStatus(String ds_eligibility){
		this.ds_eligibility = ds_eligibility;
	}

	void setNationality(String nationality){
		this.nationality = nationality;
	}

	void setPL(String pl){
		this.pl = pl;
	}

	void setCurrentVP(int current_vp){
		this.current_vp = current_vp;
	}

	void setNextVP(int next_vp){
		this.next_vp = next_vp;
	}

	void setAllotedVP(int alloted_vp){
		this.alloted_vp = alloted_vp;
	}

	void makeVPL(){
		String[] all_pls = pl.split("_");
		if(pd_status.equals("NO")){
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
				case "ST": for(int i=0;i<all_pls.length;i++){
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
		else if(pd_status.equals("YES")){
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
				case "ST": for(int i=0;i<all_pls.length;i++){
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

	String getID(){
		return this.id;
	}
	String getCategory(){
		return this.category;
	}
	String getNationality(){
		return this.nationality;
	}
	Boolean getPDStatus(){
		return this.pd_status;
	}
	String getDSStatus(){
		return this.ds_eligibility;
	}
	ArrayList<String> getVPL(){
		return this.virtual_pl;
	}
	Integer getCurrentVP(){
		return current_vp;
	}
	Integer getNextVP(){
		return next_vp;
	}
	Integer getAllotedVP(){
		return alloted_vp;
	}
	
}