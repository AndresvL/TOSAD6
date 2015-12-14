package model;

public class Value {
	private int order;
	private String value;
	public String dataType;
	
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
	 * setter for the attribute value
	 * @param value
	 */
	public void setValue(String value){
		this.value = value;		
	}
	/**
	 * getter for the attribute value
	 * @return a String
	 */
	public String getValue(){
		return value;
	}
	/**
	 * setter for the datatype of a value
	 * @param dataType
	 */
	public void setDataType(String dataType){
		this.dataType = dataType;
	}
	/**
	 * getter for the dataype of a value
	 * @return a String
	 */
	public String getDatatype(){
		return dataType;
	}
}