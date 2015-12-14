package model;

import java.sql.ResultSet;
import java.util.ArrayList;

import dao.DAO;
import dao.DAOAttribute;
import dao.DAOBusinessRule;
import dao.DAOValue;

public class BusinessRule {
	private String name;
	private String ruleType;
	private String operator;
	private ArrayList<Value> values = new ArrayList<Value>();
	private ArrayList<Attribute> attributes = new ArrayList<Attribute>();
	private DAO dao = null;
	
	
	/**
	 * setter for String name
	 * @param name
	 */
	public void setName(String name){
		this.name = name;
	}
	/**
	 * getter for name
	 * @return a String
	 */
	public String getName(){
		return name;
	}
	
	public void setRuleType(String ruleType){
		this.ruleType = ruleType;
	}
	
	public String getRuleType(){
		return ruleType;
	}
	
	public void setOperator(String operator){
		this.operator = operator;
	}
	public String getOperator(){
		return operator;
	}
	public void setAllValues(ArrayList<Value> values){
		this.values = values;
	}
	
	public Value getValueOrder(String orderNr){
		int number = Integer.parseInt(orderNr);
		Value value = null;
		for(Value v : values){
			if(v.getOrder() == number){
				value = v;
				break;
			}
		}
		return value;
	}
	
	public ArrayList<Value> getAllValues(){
		return values;
	}
	
	public void setAllAttibutes(ArrayList <Attribute> attributes){
		this.attributes = attributes;
	}
	
	public Attribute getAttributeOrder(String orderNr){
		int number = Integer.parseInt(orderNr);
		Attribute attribute = null;
		for(Attribute a : attributes){
			if(a.getOrder() == number){
				attribute = a;
				break;
			}
		}
		return attribute;
	}
	
	/**
	 * getContent gives a resultSet that contains the content of the given type
	 * @param type specifies what you need to fetch from the database
	 * @return a resultSet with content of the given type
	 */
	public ResultSet getContent(String type) {
		switch (type){
			case "businessrule": 
				dao = new DAOBusinessRule(); 
				break;
			case "attribute": 
				dao = new DAOAttribute();
				break;
			case "value": 
				dao = new DAOValue();
				break;
		}
		return dao.fetch(this.name);
	}
	
}
