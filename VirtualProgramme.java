import java.io.*
import candidate

public class VirtualProgramme{
	int quota;
	String category;
	String pd_status;
	ArrayList<Candidate> wait_list;
	ArrayList<Candidate> applied_list;
	ArrayList<Candidate> foreign_wait_list;
	ArrayList<Candidate> foreign_applied_list;
	ArrayList<Candidate> ds_wait_list;
	ArrayList<Candidate> ds_applied_list;

	public void VirtualProgramme(){
		this.quota = 0;
		this.category = "";
		this.pd_status = "";
		this.wait_list = new ArrayList<Candidate>();
		this.applied_list = new ArrayList<Candidate>();
		this.foreign_wait_list = new ArrayList<Candidate>();
		this.foreign_applied_list = new ArrayList<Candidate>();
		this.ds_wait_list = new ArrayList<Candidate>();
		this.ds_applied_list = new ArrayList<Candidate>();
	}
	private void setQuota(int quota){
		this.quota = quota;
	}
	private void setCategory(String category){
		this.category = category;
	}
	private void setPDStatus(String pd_status){
		this.pd_status = pd_status;
	}
	private void addCadidateToWaitList(Candidate candidate){
		this.wait_list.add(candidate);
	}
	private void addCandidateToAppliedList(Candidate candidate){
		this.applied_list.add(candidate);
	}
}