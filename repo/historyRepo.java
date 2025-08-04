package repo;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

import models.historyModel;

public class historyRepo {
	
	HashMap<Integer , historyModel> historyDB;
	
	public historyRepo()
	{
		historyDB = new HashMap<>();
		
	}
	
	public boolean addRecord(historyModel history)
	{
		int id = historyDB.size() + 1;
		
		historyDB.put(id, history);
		
		return true;
	}
	
	public List<historyModel> getRecords()
	{
		List<historyModel> records = new ArrayList<>(historyDB.values());
		
		return records;
	}
	
	public historyModel getRecordById(int id)
	{
		if( id > historyDB.size()) return null;
		
		return historyDB.get(id);
	}

}
