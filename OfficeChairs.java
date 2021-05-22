
import java.util.Scanner;

class OfficeChairs implements Sellings{
	 int number;
	 modelNames models[];
	 String colors[];
	 String ModelName[];
	 int ModelNum;
	 String ColorName[];
	 int ColorNum;
	 
	OfficeChairs(){
		
	}
	
	OfficeChairs(int branchNum, String[] ModelName, int ModelNum, String[] ColorName, int ColorNum, Company com){
		this.ColorNum = ColorNum;
		this.ModelNum = ModelNum;
		this.number = ModelNum;
		
		this.models = new modelNames[ModelNum];
		this.colors = new String[ColorNum];
		this.models = new modelNames[ModelNum];
		
		for(int i = 0; i < ModelNum; i++){
			this.models[i] = new modelNames();
			this.models[i].modelName = ModelName[i];
		}
		
		
		for(int k = 0; k < ModelNum; k++) {
			this.models[k].colorNames = new String[ColorNum];
			for(int i = 0; i < ColorNum; i++){
				this.models[k].colorNames[i] = new String();
				this.models[k].colorNames[i] = ColorName[i];
			}
		}
		com.branch.get(branchNum).officeChair.add(this);
	}
	
	HybridList<OfficeChairs> addProduct(int branchNum, int amount, int colorAmount[], String modelName[], String colorName[], Company com) {
		int j = 0, k = 0;
		OfficeChairs o = new OfficeChairs();
		int size = com.branch.get(branchNum).officeChair.get(0).models.length;
		while(amount > 0) {
			for(int t = 0; t < colorAmount[j]; t++) {
				o.models[size].colorNames[t] = new String();
				o.models[size].colorNames[t] = colorName[k];
				k++;
				size++;
			}
			com.branch.get(branchNum).officeChair.add(o);
			com.branch.get(branchNum).officeChair.get(com.branch.get(branchNum).officeChair.capacity).ModelNum++;
			amount--;
			j++;
		}
		
		return com.branch.get(branchNum).officeChair;
	}
	
	HybridList<OfficeChairs> removeProduct(int branchNum, String modelName, String colorName, Company com) {
		for(int i = 0; i < com.branch.get(branchNum).officeChair.capacity; i++) {
			for(int y = 0; y < com.branch.get(branchNum).officeChair.furnitures.get(i).size; y++) {
				for(int t = 0; t < com.branch.get(branchNum).officeChair.furnitures.get(i).get(y).models.length; t++) {
					if(modelName.equals( com.branch.get(branchNum).officeChair.furnitures.get(i).get(y).models[t].modelName) 
							&& colorName.equals( com.branch.get(branchNum).officeChair.furnitures.get(i).get(y).models[t].colorNames[y])) {
						com.branch.get(branchNum).officeChair.furnitures.get(i).remove(i);
						com.branch.get(branchNum).officeChair.furnitures.get(i).get(y).ModelNum--;
						com.branch.get(branchNum).officeChair.furnitures.get(i).get(y).ColorNum--;
					}
				}
			}
		}
		return com.branch.get(branchNum).officeChair;
	}
	
	public void checkProductSituation(Company com, int branchNum, int requested, int productNum) {
		int total = 0;
		for(int i = 0; i < com.branch.get(branchNum).officeChair.capacity + 1; i++) {
			for(int y = 0; y < com.branch.get(branchNum).officeChair.furnitures.get(i).size; y++) {
				for(int t = 0; t < com.branch.get(branchNum).officeChair.furnitures.get(i).get(y).models.length; t++) {
					total += com.branch.get(branchNum).officeChair.furnitures.get(i).get(y).models[t].colorNum;
				}
			}
		}
		System.out.println("Number of office chairs in the branch: " + total);
		for(int i = 0; i < com.branch.get(branchNum).officeChair.capacity + 1; i++) {
			for(int y = 0; y < com.branch.get(branchNum).officeChair.furnitures.get(i).size; y++) {
				for(int t = 0; t < com.branch.get(branchNum).officeChair.furnitures.get(i).get(y).models.length; t++) {
					System.out.println("Model name of the office chair in the branch: " + com.branch.get(branchNum).officeChair.furnitures.get(i).get(y).models[t].modelName);
					for(int j = 0; j < com.branch.get(branchNum).officeChair.furnitures.get(i).get(y).models[t].colorNames.length; j++) {
						System.out.println("Names of the color of office chairs in the branch: " + com.branch.get(branchNum).officeChair.furnitures.get(i).get(y).models[t].colorNames[j]);
					}
				}
				System.out.println("\n");
				if((com.branch.get(branchNum).officeChair.furnitures.get(i).size) < 2 
						|| (com.branch.get(branchNum).officeChair.furnitures.get(i).size) < requested) {
					com.branchEmployees.get(0).giveInfoToAdmin(branchNum, productNum, com);
				}
			}
		}
		
	}
	
	public int productNumberInStock(int branchNum, Company com) {
		int value = 0;
		
		for(int i = 0; i < com.branch.get(branchNum).officeChair.capacity + 1; i++) {
			for(int y = 0; y < com.branch.get(branchNum).officeChair.furnitures.get(i).size; y++) {
				for(int t = 0; t < com.branch.get(branchNum).officeChair.furnitures.get(i).get(y).models.length; t++) {
					value += com.branch.get(branchNum).officeChair.furnitures.get(i).get(y).models[t].colorNum;
				}
			}
		}
		
		return value;
	}
	
	KWArrayList<Customers> searchProduct(int branchNum, String productName, int isRequested, String productColor, String modelName, int returnStatement, int customerNum, Wrapper w,Company com) {

		Scanner in = new Scanner(System.in);
		
		for(int i = 0; i < com.branch.get(branchNum).officeChair.capacity + 1; i++) {
			for(int y = 0; y < com.branch.get(branchNum).officeChair.furnitures.get(i).size; y++) {
				for(int t = 0; t < com.branch.get(branchNum).officeChair.furnitures.get(i).get(y).models.length; t++) {
					for(int k = 0; k < com.branch.get(branchNum).officeChair.furnitures.get(i).get(y).models[t].colorNames.length; k++) {
						if(com.branch.get(branchNum).officeChair.furnitures.get(i).get(y).models[t].modelName.equals(modelName) 
								&& com.branch.get(branchNum).officeChair.furnitures.get(i).get(y).models[t].colorNames[k].equals(productColor)) {
							if(w.value == 0)
								System.out.println("Product is available.");
							w.value = 1;
							if(isRequested == 1) {
								System.out.println("Name of the branch that product is available: " + com.branch.get(branchNum).Branchname);
								if(returnStatement == 1) {
									System.out.println("Do you want to buy?(y or n)");
									String response = in.next().toString();
									if(response.equals("y")) {
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
				}
			}
		}
		return com.customer;
	}
}
