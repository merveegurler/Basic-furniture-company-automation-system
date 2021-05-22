
class Company{
	private String name;
	int BranchNumber, BranchEmpNum;
	
	KWLinkedList<Branch> branch;
	KWArrayList<Administrator> administrators;
	KWArrayList<BranchEmployees> branchEmployees;
	KWArrayList<Customers> customer;
	
	Company(){
		
	}
	
	Company(String name, String adminName){
		this.administrators = new KWArrayList<Administrator>();
		this.name = name;
		Administrator administrator = new Administrator();
		administrator.name = adminName;
		this.administrators.add(administrator);
	}
	
	void setCompany(String name, String adminName) {
		this.administrators = new KWArrayList<Administrator>();
		this.name = name;
		Administrator administrator = new Administrator();
		administrator.name = adminName;
		this.administrators.add(administrator);
	}
	
	void getCompany() {
		System.out.println("Company name: " + this.name + "Administrator Name: " + this.administrators.get(0).name);
	}
	
	Company initialAssignments(Company company) {
		
		company.administrators = new KWArrayList<Administrator>();
		Administrator admin = new Administrator("Merve");
		company.administrators.add(admin);
		company.customer = new KWArrayList();
		company.branch = new KWLinkedList();
		
		//Default branch objects
		//There must be 4 branches in the company
		Branch[] br = new Branch[4];
		br[0] = new Branch();
		br[0].Branchname = "Merve";
		company.branch.add(0,br[0]);
		
		br[1] = new Branch();
		br[1].Branchname = "Gurler";
		company.branch.add(1,br[1]);
		
		br[2] = new Branch();
		br[2].Branchname = "Gebze";
		company.branch.add(2,br[2]);
		
		br[3] = new Branch();
		br[3].Branchname = "Teknik";
		company.branch.add(3,br[3]);
		
		String models[] = {"stripped", "straigth", "colored", "etnic", "antique", "sport", "stylish", "new", "old", "vintage", "strange", "otantic"};
		String colors[] = {"pink", "black", "purple", "blue", "gray"};
		
		branch = new KWLinkedList<Branch>();
		
		for(int i = 0; i < 4; i++) {
			
			company.branch.add(br[i]);
			company.branch.get(i).officeChair = new HybridList();
			company.branch.get(i).officeDesk = new HybridList();
			company.branch.get(i).officeCabinet = new HybridList();
			company.branch.get(i).meetingTable = new HybridList();
			company.branch.get(i).bookcase = new HybridList();
			
			for(int j = 0; j < 7; j++) {
				OfficeChairs officeChairs = new OfficeChairs();
				officeChairs.models = new modelNames[1];
				officeChairs.models[0] = new modelNames();
				officeChairs.models[0].modelName = models[j];
				officeChairs.models[0].colorNames = new String[5];
				officeChairs.models[0].colorNum = 5;
				for(int k = 0; k < 5; k++) {
					officeChairs.models[0].colorNames[k] = new String();
					officeChairs.models[0].colorNames[k] = colors[k];
				}
				company.branch.get(i).officeChair.add(j, officeChairs);
			}
			
			for(int j = 0; j < 5; j++) {
				OfficeDesks officeDesks = new OfficeDesks();
				officeDesks.models = new modelNames[1];
				officeDesks.models[0] = new modelNames();
				officeDesks.models[0].modelName = models[j];
				officeDesks.models[0].colorNames = new String[5];
				officeDesks.models[0].colorNum = 4;
				for(int k = 0; k < 4; k++) {
					officeDesks.models[0].colorNames[k] = new String();
					officeDesks.models[0].colorNames[k] = colors[k];
				}
				company.branch.get(i).officeDesk.add(j, officeDesks);
			}
			
			for(int j = 0; j < 10; j++) {
				OfficeCabinets officeCabinets = new OfficeCabinets();
				officeCabinets.models = new modelNames[1];
				officeCabinets.models[0] = new modelNames();
				officeCabinets.models[0].modelName = models[j];
				officeCabinets.models[0].colorNames = new String[5];
				officeCabinets.models[0].colorNum = 4;
				for(int k = 0; k < 4; k++) {
					officeCabinets.models[0].colorNames[k] = new String();
					officeCabinets.models[0].colorNames[k] = colors[k];
				}
				company.branch.get(i).officeCabinet.add(j, officeCabinets);
			}
			
			for(int j = 0; j < 12; j++) {
				MeetingTables meetingTables = new MeetingTables();
				meetingTables.models = new modelNames[1];
				meetingTables.models[0] = new modelNames();
				meetingTables.ModelNum = 1;
				meetingTables.models[0].modelName = models[j];
				company.branch.get(i).meetingTable.add(j, meetingTables);
			}
			
			for(int j = 0; j < 12; j++) {
				BookCases bookcases = new BookCases();
				bookcases.models = new modelNames[1];
				bookcases.models[0] = new modelNames();
				bookcases.ModelNum = 1;
				bookcases.models[0].modelName = models[j];
				company.branch.get(i).bookcase.add(j, bookcases);
			}
		}
		
		BranchEmployees brE = new BranchEmployees();
		brE.name = "merve";
		brE.surname = "gurler";
		brE.email = "mgurler@gmail.com";
		
		company.branchEmployees = new KWArrayList<BranchEmployees>();
		company.branchEmployees.add(brE);
		
		company.customer = new KWArrayList<Customers>();
		Customers cus = new Customers();
		company.customer = cus.setCustomer("Merve", "Gurler", "mgurler@gtu.edu.tr", "mervegurler", 1, 0, company);
		
		cus.orders = new String[5];
		cus.orders[0] = "Office Chairs";
		cus.orders[1] = "Duz";
		cus.orders[2] = "Mor";
		cus.orders[3] = "merve";
		cus.orders[4] = "1";
		
		company.customer.get(0).orders = new String[5];
		company.customer.get(0).orders = cus.orders;
		System.out.println(company.customer.get(0).id);
		return company;
	}
}
