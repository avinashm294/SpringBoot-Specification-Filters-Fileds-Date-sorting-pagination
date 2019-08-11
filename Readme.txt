Filters Using Spring Data JPA Specifications

Features Added:
- Filter through fields.
- Filter through Dates.
- Sorting based on Any fields(ASC or DESC).
- Added the Pagination 
		- Number of  elements to be displayed.
		- which Page number to be displayed.



---------------------------------------Filter through fields--------------------------------------

1. Filter through single field 							  	  
http://localhost:9091/car-api/filter?cost=2000

2. Filter through Name using partial name 
http://localhost:9091/car-api/filter?name=ra
 				  
3. Filter through multiple fields with exact matching values  
http://localhost:9091/car-api/filter?name=rahul&cost=4000
http://localhost:9091/car-api/filter?name=rahul&model=alto

4. Filter through multiple field values	
http://localhost:9091/car-api/filter?name=rahul&model=alto
				  	  




	 
-----------------------------------------Filter through Dates----------------------------------------

1. Filter through the specific Date of Purchase field	 	
http://localhost:9091/car-api/search/purchaseDate?date=2012-02-11

2. Filter the specific Start and End date				 	-http://localhost:9091/car-api/search/startAndEndDates?startDate=2010-02-11&endDate=2010-03-11

3. Filter between given Start and End Date				 	
http://localhost:9091/car-api/search?purchaseStartDate=2010-02-13&purchaseEndDate=2010-02-15




--------------------------------------------Sorting and Pagination----------------------------------------

1. Added the Sorting based on any field through ASC or DESC.
http://localhost:9091/car-api/sortByField?fieldName=cost

2.
- Filter num of elements to be shown in the page.
- Filter to which page element to be displayed.
http://localhost:9091/car-api/sortByField?page=0&elementSize=10&fieldName=name


------------------------------------------------------------------------------------------------------------



Pending Task:

==> Filter through muliple values in a given field ----Working on
ex: In Flipkart site Filtering through multiple Brands like fastrack, titan.

SELECT * FROM car_data where model="Audi" or model="Alto";
(or)
SELECT * FROM car_data where model IN("Audi","Alto");

(field1 operation value1 and fiedl2 operation value2) or (field1 operation value2 and fiedl2 operation value4)


filter(String str1, String str2)
{
	
}



uploaded the code in GitHub: https://github.com/avinashm294/Filters-Using-Dates.git

http://localhost:9091/api/Car/search/purchaseDate?date=2010-02-21
http://localhost:9091/api/Car/search/startAndEndDates?startDate=2010-02-11&endDate=2010-03-11
http://localhost:9091/api/Car/search?purchaseDateStart=2010-02-13&purchaseDateEnd=2010-02-21


http://localhost:9091/api/Car/users?search=cost>2500


http://localhost:9091/car-api/advancedFilters

{  
   "pageLength":0,
   "sortField":9999,
   "sortOrder":"1",
   "ubFilter":{  
      "filterName":null,
      "filterObjectName":"",
      "ubFilterDetails":[  
         {  
            "filterField":"name",
            "filterValue":"Rahul",
            "filterOperator":"FILTER_OPERATOR_AND"
         }
		 
		 {  
            "filterField":"name",
            "filterValue":"Rahul",
            "filterOperator":"FILTER_OPERATOR_AND"
         }
      ]
   }
}


--------------------------------------------------------------------------------------------------------------
http://localhost:9091/car-api/filters?search=name:joe,name:ravi,name:rahul,name:smith
http://localhost:9091/car-api/filters?search=name:rahul,name:joe,name:ravi,cost:3000,cost:4000,age:30

http://localhost:9091/car-api/filters?search=cost:4000,name:rahul,cost:5000,name:smith,cost:2000,model:alto