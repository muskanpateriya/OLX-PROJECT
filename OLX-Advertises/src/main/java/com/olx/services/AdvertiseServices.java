package com.olx.services;

import java.time.LocalDate;
import java.util.List;

import com.olx.dto.Advertises;

public interface AdvertiseServices {
	public Advertises postNewadvertise(Advertises advertises,String authToken);//8
	
	public  Advertises UpdatesExistingAdvertise(Advertises advertises,int advertiseId,String authTolen);//9
	
	public List<Advertises> readsAllAdvertisements(String authToken);//10
	
	public Advertises getAdvertisementById(int advertiseId,String authToken);//11
	
	public boolean deleteSpecificAdvertisement (int advertiseId,String authToken);//12
	
	public List<Advertises> getAdvertisesBySearchFilterCriteria(String searchText, int categoryId, String postedBy,
			String dateCondition, LocalDate onDate, LocalDate fromDate, LocalDate toDate, String sortedBy,
			int startIndex, int records);//13
	
	public List<Advertises>getAllAdvertisementsBySearch (String Advertises); //14
	
	public Advertises getAdvertisesById(int advertiseId,String authToken);//15
	
	
	
}
