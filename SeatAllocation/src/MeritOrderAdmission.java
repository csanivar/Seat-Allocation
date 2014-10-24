import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

public class MeritOrderAdmission{
	static String program_tokens[] = {"GE","OBC","SC","ST","GE-PD","OBC-PD","SC-PD","ST-PD"};
	static HashMap<String,VirtualProgramme> allVirtualPrograms= new HashMap<String,VirtualProgramme>();
	static HashMap<String,Candidate> allCandidates = new HashMap<String,Candidate>();
	static HashMap<String,MeritList> allRankLists  = new HashMap<String,MeritList>();
	public static void main(String args[]) throws FileNotFoundException{
		for(int i=0;i<8;i++){
			MeritList tempMeritList = new MeritList();
			allRankLists.put(program_tokens[i],tempMeritList);
		}
		readPrograms();
		readChoices();
		readRankList();
		firstIteration();             // Iterate through all the rank lists and allot seats accordingly
	}
	
	private static void readPrograms() throws FileNotFoundException{
        BufferedReader fileReader = null;
        try
        {
            String line = "";
            fileReader = new BufferedReader(new FileReader("programs.csv"));
            line = fileReader.readLine();
            while ((line = fileReader.readLine()) != null)
            {
                String[] tokens = line.split(",");
                for(int i=0;i<program_tokens.length;i++)
                {
                	VirtualProgramme tempVPL = new VirtualProgramme();
                	tempVPL.setQuota(Integer.valueOf(tokens[i+3]));
                	tempVPL.setCategory(program_tokens[i]);
                	allVirtualPrograms.put(tokens[1]+"-"+program_tokens[i],tempVPL);
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        } 
	}
	private static void readChoices(){
		BufferedReader fileReader = null;
		try{
			String line ="";
			fileReader = new BufferedReader(new FileReader("choices.csv"));
            line = fileReader.readLine();
			while((line = fileReader.readLine()) != null){
				String[] tokens = line.split(",");
				Candidate tempCandidate = new Candidate();
				tempCandidate.setID(tokens[0]);
				tempCandidate.setCategory(tokens[1]);
				tempCandidate.setPDStatus(tokens[2]);
				tempCandidate.setPL(tokens[3]);
				tempCandidate.makeVPL();
			/*	for(int i=0;i<tempCandidate.virtual_pl.size();i++){
					System.out.print(tempCandidate.virtual_pl.get(i));
					System.out.print(" ");
				}
				System.out.println(); */
				allCandidates.put(tokens[0],tempCandidate);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	private static void readRankList(){
		BufferedReader fileReader = null;
		try{
			String line ="";
			fileReader = new BufferedReader(new FileReader("ranklist.csv"));
            line = fileReader.readLine();
			while((line = fileReader.readLine()) != null){
				String[] tokens = line.split(",");
				for(int i=0;i<4;i++){
					MeritList tempMeritList = allRankLists.get(program_tokens[i]);
					if(!tokens[i+3].equals("0")){
						tempMeritList.putCandidate(tokens[0], tokens[i+3]);
						allRankLists.put(program_tokens[i], tempMeritList);
					}
				}
				for(int i=4;i<8;i++){
					MeritList tempMeritList = allRankLists.get(program_tokens[i]);
					if(!tokens[i+4].equals("0")){
						tempMeritList.putCandidate(tokens[0], tokens[i+4]);
						allRankLists.put(program_tokens[i], tempMeritList);
					}
				}
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private static void firstIteration(){
		for(int i=0;i<program_tokens.length;i++){
			MeritList merit_list = allRankLists.get(program_tokens[i]);
			int highest_rank = merit_list.getHighestRank();
			for(int j=0;j<=highest_rank;j++){
				if(merit_list.rank_list.containsKey(j)){
					ArrayList<String> candidate_ids = merit_list.rank_list.get(j);
					for(int k=0;k<candidate_ids.size();k++){
						String candidate_id = candidate_ids.get(i);
						Candidate candidate = allCandidates.get(candidate_id);
						ArrayList<String> preferences = candidate.virtual_pl;
						for(int n=0;n<preferences.size();n++){
							VirtualProgramme virtual_programme = allVirtualPrograms.get(preferences.get(n));
							/*System.out.println(virtual_programme.wait_list.size());
							System.out.println(virtual_programme.quota);
							System.out.println(virtual_programme.highest_rank); */
							if(virtual_programme.wait_list.size()==virtual_programme.quota && virtual_programme.highest_rank==j){
								virtual_programme.quota++;
								virtual_programme.addCadidateToWaitList(candidate);
								candidate.setAllotedVP(n);
								virtual_programme.highest_rank = j;
								break;
							}
							else if(virtual_programme.wait_list.size()<virtual_programme.quota){
								virtual_programme.addCadidateToWaitList(candidate);
								virtual_programme.highest_rank = j;
								candidate.setAllotedVP(n);
								System.out.println(candidate.id+" "+candidate.virtual_pl.get(candidate.alloted_vp));
								break;
							}
						}
					}
				}
			}
		}
	}
}