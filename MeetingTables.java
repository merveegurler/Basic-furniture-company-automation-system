
import java.util.Scanner;

class MeetingTables implements Sellings{
	int number;
	modelNames models[];
	String colors[];
	String ModelName[];
	int ModelNum;
	String ColorName[];
	int ColorNum;
	
	MeetingTables(){
		
	}
	
	MeetingTables(int branchNum, String[] ModelName, int ModelNum, String[] ColorName, int ColorNum, Company com){
		this.ColorNum = ColorNum;
		this.ModelNum = ModelNum;
		this.number = ModelNum;
		
		this.models = new modelNames[ModelNum];
		this.colors = new String[ColorNum];
		
		for(int i = 0; i < ModelNum; i++){
			this.models[i].modelName = ModelName[i];
		}
		for(int k = 0; k < ModelNum; k++) {
			for(int i = 0; i < ColorNum; i++){
				this.models[k].colorNames[i] = ColorName[i];
			}
		}
		com.branch.get(branchNum).meetingTable.add(this);
	}
	
	HybridList<MeetingTables> addProduct(int branchNum, int amount, int colorAmount[], String modelName[], String colorName[], Company com) {
		int j = 0;
		MeetingTables m = new MeetingTables();
		m.models = new modelNames[1];
		m.models[0] = new modelNames();
		
		while(amount > 0) {
			m.models[0].modelName = modelName[j];
			com.branch.get(branchNum).meetingTable.add(m);
			com.branch.get(branchNum).meetingTable.get(0).ModelNum++;
			j++;
			amount--;
		}
		return com.branch.get(branchNum).meetingTable;
	}
	
	HybridList<MeetingTables> removeProduct(int branchNum, String modelName, String colorName, Company com) {
		for(int i = 0; i < com.branch.get(branchNum).meetingTable.capacity + 1; i++) {
			for(int y = 0; y < com.branch.get(branchNum).meetingTable.furnitures.get(i).size; y++) {
				for(int t = 0; t < com.branch.get(branchNum).meetingTable.furnitures.get(i).get(y).models.length; t++) {
					if(modelName.equals(com.branch.get(branchNum).meetingTable.furnitures.get(i).get(y).models[t].modelName)) {
						com.branch.get(branchNum).meetingTable.furnitures.get(i).remove(y);
						com.branch.get(branchNum).meetingTable.furnitures.get(i).get(y).ModelNum--;
					}
				}
			}
		}
		return com.branch.get(branchNum).meetingTable;
	}
	
	public void checkProductSituation(Company com, int branchNum, int requested, int productNum) {
		int total = 0;
		for(int i = 0; i < com.branch.get(branchNum).meetingTable.capacity + 1; i++) {
			for(int j = 0; j < com.branch.get(branchNum).meetingTable.furnitures.get(i).size; j++) {
				total += com.branch.get(branchNum).meetingTable.furnitures.get(i).get(j).models.length;
			}
		}
		
		System.out.println("Number of meeting tables in the branch: " + total);
		for(int i = 0; i < com.branch.get(branchNum).meetingTable.capacity + 1; i++) {
			for(int y = 0; y < com.branch.get(branchNum).meetingTable.furnitures.get(i).size; y++) {
				for(int t = 0; t < com.branch.get(branchNum).meetingTable.furnitures.get(i).get(y).models.length; t++) {
					System.out.println("Names of the model of meeting tables in the branch: " + com.branch.get(branchNum).meetingTable.furnitures.get(i).get(y).models[t].modelName);
				}
				System.out.println("\n");
				if((com.branch.get(branchNum).meetingTable.furnitures.get(i).size) < 2 
						|| (com.branch.get(branchNum).meetingTable.furnitures.get(i).size) < requested) {
					com.branchEmployees.get(0).giveInfoToAdmin(branchNum, productNum, com);
				}
			}
		}
		
	}
	
	public int productNumberInStock(int branchNum, Company com) {
		
		int value = 0;
		for(int i = 0; i < com.branch.get(branchNum).meetingTable.capacity + 1; i++) {
			for(int y = 0; y < com.branch.get(branchNum).meetingTable.furnitures.get(i).size; y++) {
				value += com.branch.get(branchNum).meetingTable.furnitures.get(i).get(y).ModelNum;
			}
		}
		
		return value;
	}
	
	KWArrayList<Customers> searchProduct(int branchNum, String productName, int isRequested, String productColor, String modelName, int returnStatement, int customerNum, Wrapper w, Company com) {

		Scanner in = new Scanner(System.in);
		
		for(int k = 0; k < com.branch.get(branchNum).meetingTable.get(0).models.length; k++) {
			if(com.branch.get(branchNum).meetingTable.get(0).models[k].modelName.equals(modelName)) {
				if(w.value == 0)
					System.out.println("Product is available.");
				w.value = 1;
			if(isRequested == 1) {
				System.out.println("Name of the branch that product is available: " + com.branch.get(branchNum).Branchname);
				if(returnStatement == 1) {
					System.out.println("Do you want to buy?(y or n)");
					String response = in.next().toString();
					if(response == "y") {
						System.out.println("How much product do you want to buy)");
						String requestedAmount = in.next().toString();
						System.out.println("Please enter the adress: ");
						String adress = in.next().toString();
						com.customer.get(customerNum).adress = adress;
						System.out.println("Please enter the phone number: ");
						String phoneNum = in.next().toString();
						com.customer.get(customerNum).phoneNum = phoneNum;
						com.customer.get(customerNum).orders = com.branchEmployees.get(0).sellProduct(branchNum, com, requestedAmount, customerNum, productName, modelName, productColor);
						break;
					}else {
						break;
					}
				}
			}
			break;
			}
	}
		return com.customer;
	}
}
