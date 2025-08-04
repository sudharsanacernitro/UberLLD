package repo;

import models.cab;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class cabRepo {
	
	HashMap<Integer,cab> cabDB;
	
	public cabRepo()
	{
		cabDB = new HashMap<>();
		
		cabDB.put(1 , new cab(1,"aaa","111",1,true));
		cabDB.put(2 , new cab(2,"bb","11",2,true));
		cabDB.put(3 , new cab(3,"ccc","22",0,true));
		cabDB.put(4 , new cab(4,"ddd","333",5,true));
		
	}
	
	public boolean isUser(String name , String password)
	{
		for(cab currCustomer : cabDB.values())
		{
			if(currCustomer.getName().equals(name) && currCustomer.getPassword().equals(password))
				return true;
		}
		
		return false;
	}
	
	public boolean updateLocation(int cabID , int currLocation)
	{
		if(cabID > cabDB.size()) return false;
		
		for(cab currCab : cabDB.values())
		{
			currCab.setAvailable(true);
		}
		
		cabDB.get(cabID).setCurrLocation(currLocation);
		cabDB.get(cabID).setAvailable(false);
		
		return true;
	}
	
	public List<cab> getListOfCabs()
	{
		List<cab> cabs = new ArrayList<>(cabDB.values());
		
		return cabs;
	}
	

}
