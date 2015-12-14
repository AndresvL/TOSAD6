package model;

public class Attribute {
	public int order;
	public String scheme;
	public String table;
	public String column;

	/**
	 * setter for attribute order
	 * @param order integer that will be assigned to order attribute
	 */
	public void setOrder(int order){
		this.order = order;
	}
	/**
	 * getter for attribute order
	 * @return an interger
	 */
	public int getOrder(){
		return order;
	}
	/**
	 * setter for the scheme of the database
	 * @param scheme
	 */
	public void setScheme(String scheme){
		this.scheme = scheme;
	}
	/**
	 * getter for the scheme of the database
	 * @return a String
	 */
	public String getScheme(){
		return scheme;
	}
	/**
	 * setter for a database table
	 * @param table
	 */
	public void setTable(String table){
		this.table = table;
	}
	/**
	 * getter for a table
	 * @return a String
	 */
	public String getTable(){
		return table;
	}
	public void setColumn(String column){
		this.column = column;
	}
	public String getColumn(){
		return column;
	}
	
}
