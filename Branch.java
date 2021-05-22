
class Branch extends Company{
	String Branchname;
	int totalNumOfProducts;

	HybridList <OfficeChairs> officeChair;
	HybridList <OfficeDesks> officeDesk;
	HybridList <MeetingTables> meetingTable;
	HybridList <BookCases> bookcase;
	HybridList <OfficeCabinets> officeCabinet;
	
	int findBranch(Company com, String name) {
		int branchNum = -1;
		for(int i = 0; i < com.branch.size; i++) {
			if(name.equals(com.branch.get(i).Branchname)) {
				branchNum = i;
				break;
			}
		}
		return branchNum;
	}
}

