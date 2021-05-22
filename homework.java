
public class homework {
	public static void main(String[] args) {

		//Created an object for the furniture company
		Company company = new Company();
		
		
		// This is the name of the Company and the name of the administrator
		company.setCompany("Gurler Furniture", "merve");
		company.getCompany();
		
		company.initialAssignments(company);
		
		// Assign the number of branches of the company to 4
		// Which is given from pdf
		
		System.out.println("\nThese are the initial branches \n");
		
		for (int i = 0; i < company.branch.size; i++) {
			System.out.println("Branch Name " + (i + 1) + ": " + company.branch.get(i).Branchname);
		}
		
		System.out.println("\nAdministrator adds new branch \n");
		
		String a[] = {"Merve Gurler Furniture"};
		String b[] = {"Merve Gurler Furniture", company.branch.get(0).Branchname};
		
		Administrator administrator = new Administrator();
		administrator.name = "Merve";
		
		company.branch= company.administrators.get(0).addBranch(a, 1, company);
		
		
		for (int i = 0; i < company.branch.size; i++) {
			System.out.println("Branch Name " + (i + 1) + ": " + company.branch.get(i).Branchname);
		}
		
		System.out.println("\nAdministrator removes branches from branch list\n");
		
		company.branch = company.administrators.get(0).removeBranch(b, 2, company);
		
		for (int i = 0; i < company.branch.size; i++) {
			System.out.println("Branch Name " + (i + 1) + ": " + company.branch.get(i).Branchname);
		}
		
		System.out.println("\n");
		
		System.out.println("\nThese are the initial branch employees \n");
		
		for(int i = 0; i < company.branchEmployees.size; i++) {
			company.branchEmployees.get(i).getBranchEmployee();
		}
		System.out.println("\nAdministrator adds branch employees\n");
		
		company.administrators.get(0).addBranchEmployee("first", "employee", "first@employee.com", null, company);
		company.administrators.get(0).addBranchEmployee("merve", "gurler", "mgurler@gtu.edu.tr", null, company);
		
		for (int i = 0; i < company.branchEmployees.size; i++) {
			company.branchEmployees.get(i).getBranchEmployee();
		}
		
		System.out.println("\nAdministrator removes branch employees\n");
		
		company.administrators.get(0).removeBranchEmployees("merve", "gurler", "mgurler@gtu.edu.tr", null, company);
		
		for (int i = 0; i < company.branchEmployees.size; i++) {
			company.branchEmployees.get(i).getBranchEmployee();
		}
		
		System.out.println("\nAdministrator query the products in branch\n");
		
		System.out.println("There are " + company.administrators.get(0).query(1, 0, company) + " office chairs in " 
		+ company.branch.get(0).Branchname + " Branch " + "in different models and colors.");
		
		System.out.println("There are " + company.administrators.get(0).query(2, 0, company) + " office desks in " 
				+ company.branch.get(0).Branchname + " Branch " + "in different models and colors.");
		
		System.out.println("There are " + company.administrators.get(0).query(3, 1, company) + " office cabinets in " 
				+ company.branch.get(1).Branchname + " Branch " + "in different models and colors.");
		
		
		System.out.println("\nBranch Employee checks office chairs situation in first branch\n");
		
		//BRanch employee checks the office chairs situation in the first branch 
		company.branchEmployees.get(0).checkProductSituation(company, 0, 0, 1);
		
		System.out.println("\nBranch Employee checks product situation that is not a given product\n");
		company.branchEmployees.get(0).checkProductSituation(company, 0, 0, 6);
		
		System.out.println("\nBranch Employee checks bookcases situation in third branch\n");
		//BRanch employee checks the bookcases situation in the third branch 
		company.branchEmployees.get(0).checkProductSituation(company, 2, 0, 5);
		
		System.out.println("\nBranch Employee demonstrates the previous orders of a customer\n");
		company.branchEmployees.get(0).demonstratePreOrders(10000000, company);
		
		System.out.println("\nBranch Employee demonstrates the previous orders of a customer which is not subscribed\n");
		company.branchEmployees.get(0).demonstratePreOrders(10000001, company);
		
		System.out.println("\nBranch Employee adds new product to first branch\n");
		int array[] = new int[1];
		array[0] = 1;
		String c[] = new String[1];
		String d[] = new String[1];
		
		c[0] = "new";
		d[0] = "red";
		
		System.out.println("Before the addition there are " +company.administrators.get(0).query(5, 0, company) + " bookcases in " 
				+ company.branch.get(0).Branchname + " Branch " + "in different models and colors.");
		
		company.branch = company.branchEmployees.get(0).addProduct("Bookcases", 0, 1, array, c, d, company);
		
		System.out.println("After the addition there are " +company.administrators.get(0).query(5, 0, company) + " bookcases in " 
				+ company.branch.get(0).Branchname + " Branch " + "in different models and colors.");
		
		
		System.out.println("\nBranch Employee adds new product to third branch\n");
		
		c[0] = "etnic";
		d[0] = "purple";
		
		System.out.println("Before the addition there are " +company.administrators.get(0).query(4, 2, company) + " meeting tables in " 
				+ company.branch.get(2).Branchname + " Branch " + "in different models and colors.");
		
		company.branch = company.branchEmployees.get(0).addProduct("MeetingTables", 2, 1, array, c, d, company);
		
		System.out.println("After the addition there are " + company.administrators.get(0).query(4, 2, company) + " meeting tables in " 
				+ company.branch.get(2).Branchname + " Branch " + "in different models and colors.");
		
		
		
		System.out.println("\nBranch Employee removes one office cabinet from second branch\n");
		
		System.out.println("Before the deletion there are " + company.administrators.get(0).query(3, 2, company) + " office cabinets in " 
				+ company.branch.get(2).Branchname + " Branch " + "in different models and colors.");
		
		company.branch = company.branchEmployees.get(0).removeProduct("OfficeCabinets", 2, "stripped", "purple", company);
		
		System.out.println("After the deletion there are " + company.administrators.get(0).query(3, 2, company) + " office cabinets in " 
				+ company.branch.get(2).Branchname + " Branch " + "in different models and colors.");

		System.out.println("\nBranch Employee removes one office desk from second branch\n");
		
		System.out.println("Before the deletion there are " + company.administrators.get(0).query(2, 2, company) + " office cabinets in " 
				+ company.branch.get(2).Branchname + " Branch " + "in different models and colors.");
		
		company.branch = company.branchEmployees.get(0).removeProduct("OfficeDesks", 2, "stripped", "purple", company);
		
		System.out.println("After the deletion there are " + company.administrators.get(0).query(2, 2, company) + " office cabinets in " 
				+ company.branch.get(2).Branchname + " Branch " + "in different models and colors.");
		
		System.out.println("\nCustomer searchs a product named Office Cabinets its model is stripped and color is pink");
		company.customer.get(0).searchProduct("OfficeCabinets", 0, "pink", "stripped", 0, 0, company);
		
		System.out.println("\nCustomer searchs a product named Bookshelves(which is not a product name) its model is stripped and color is pink");
		company.customer.get(0).searchProduct("Bookshelves", 0, "pink", "stripped", 0, 0, company);
		
		System.out.println("\nCustomer searchs a product named Office Chairs its model is old and color is red");
		company.customer.get(0).searchProduct("OfficeChairs", 0, "blue", "stripped", 0, 0, company);
		
		System.out.println("\nCustomer learns the branch of a product named Meeting Tables its model is stripped and color is pink");
		company.customer.get(0).searchProduct("MeetingTables", 1, "pink", "stripped", 0, 0, company);
		
		System.out.println("\nCustomer learns the branch of a product named Office Tables (Which is not a product name) its model is stripped and color is pink");
		company.customer.get(0).searchProduct("OfficeTables", 1, "pink", "stripped", 0, 0, company);
		
		System.out.println("\nCustomer makes an online shop\n");
		company.customer.get(0).orders = company.branchEmployees.get(0).sellProduct(0, company, "1", 0, "OfficeChairs", "gray", "antique");
		
		System.out.println("\nCustomer checks previous orders\n");
		company.customer.get(0).checkPreviousOrders(company, 10000000);
		
		company.customer.add(1, company.customer.get(0));
		System.out.println("\nCustomer subscribes to system\n");
		company.customer = company.customer.get(1).setCustomer("deniz", "derya", "deryadeniz", "dfs", 1, 1, company);
		
		System.out.println("\nCustomer checks previous orders\n");
		company.customer.get(1).checkPreviousOrders(company, 10033550);
		
		System.out.println("\nCustomer checks previous orders\n");
		company.customer.get(0).checkPreviousOrders(company, 10000001);
		menu Menu = new menu();
		Menu.showMenu();
	}
}
