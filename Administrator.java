
class Administrator extends Company{
	String name;
	
	Administrator(){
		
	}
	
	Administrator(String name){
		this.name = name;
	}
	
	KWLinkedList<Branch> addBranch(String[] Branchname, int numOfNewBranches, Company com) {
		int j = 0;
		while(numOfNewBranches > 0) {
				Branch br = new Branch();
				br.Branchname = Branchname[j];
				
				OfficeChairs oCh = new OfficeChairs();
				OfficeDesks oD = new OfficeDesks();
				OfficeCabinets oCa = new OfficeCabinets();
				MeetingTables mT = new MeetingTables();
				BookCases bC = new BookCases();
				
				br.officeChair = new HybridList();
				br.officeChair.add(oCh);
				
				br.officeDesk = new HybridList();
				br.officeDesk.add(oD);
				
				br.officeCabinet = new HybridList();
				br.officeCabinet.add(oCa);
				
				br.meetingTable = new HybridList();
				br.meetingTable.add(mT);
				
				br.bookcase = new HybridList();
				br.bookcase.add(bC);
				
				com.branch.add(br);
				numOfNewBranches--;
				j++;
		}
		return com.branch;
	}
	
	KWLinkedList<Branch> removeBranch(String[] BranchName, int numOfUnnecessaryBranch, Company com) {
		int i = 0;
		while(i< numOfUnnecessaryBranch) {
			for(int j = 0; j < com.branch.size; j++) {
				if(BranchName[i].equals(com.branch.get(j).Branchname)) {
					com.branch.remove(j);
				}
					
			}
			i++;
		}
		return com.branch;
	}
	
	KWArrayList<BranchEmployees> addBranchEmployee(String name, String surname, String email, BranchEmployees emp, Company com) {
		BranchEmployees brE = new BranchEmployees();
		brE.name = name;
		brE.surname = surname;
		brE.email = email;
		com.branchEmployees.add(brE);
		return com.branchEmployees;
	}
	
	KWArrayList<BranchEmployees> removeBranchEmployees(String name, String surname, String email, BranchEmployees emp, Company com) {
		for(int i = 0; i < com.branchEmployees.size; i++) {
			if(name.equals(com.branchEmployees.get(i).name) && surname.equals(com.branchEmployees.get(i).surname) && email.equals(com.branchEmployees.get(i).email)) {
				com.branchEmployees.remove(i);
			}
		}
		return com.branchEmployees;
	}
	
	int query(int choose, int branchNum, Company com) {
		int value = 0;
		switch(choose) {
			case 1: 
				value = com.branch.get(branchNum).officeChair.get(0).productNumberInStock(branchNum, com);
				break;
			case 2:
				value = com.branch.get(branchNum).officeDesk.get(0).productNumberInStock(branchNum, com);
				break;
			case 3:
				value = com.branch.get(branchNum).officeCabinet.get(0).productNumberInStock(branchNum, com);
				break;
			case 4:
				value = com.branch.get(branchNum).meetingTable.get(0).productNumberInStock(branchNum, com);
				break;
			case 5:
				value = com.branch.get(branchNum).bookcase.get(0).productNumberInStock(branchNum, com);
				break;
			default :
	            System.out.println("Invalid choose.");
		}
		return value;
	}
}
