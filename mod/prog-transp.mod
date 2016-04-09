/**
 * Program of transport : minimize the traveling costs of the products
 * from the depots to the clients
 *
 * Author : Olivier Grunder
 */
 
set DEPOT ; 
set CLIENT ;

param cost { i in DEPOT, j in CLIENT} ; 
param stock { i in DEPOT } ; 
param demande {j in CLIENT} ;

var x { i in DEPOT, j in CLIENT}, >= 0 ;

/* Objective function */ 
minimize z: sum{i in DEPOT, j in CLIENT} cost[i,j]*x[i,j] ;

/* Constraints */ 
s.t. R_Stock{ i in DEPOT } : sum{j in CLIENT} x[i,j] = stock[i] ; 
s.t. R_Demande{ j in CLIENT } : sum{i in DEPOT} x[i,j] = demande[j] ;

solve ; 

printf {i in DEPOT, j in CLIENT : x[i,j]>0}: "x[%s,%s]=%f\n",i,j,x[i,j];
printf "total cost z=%f\n",z;


/***********************************************************/ 

data; 

set DEPOT := I II III IV ; 
set CLIENT := 1 2 3 4 5 6 ;

param cost :    1 2 3 4 5 6 :=    
	I    12  27  61  49  83  35
	II   23  39  78  28  65  42
	III  67  56  92  24  53  54
	IV   71  43  91  67  40  49 ;

param stock :=  
	I   18
	II  32
	III 14
	IV   9 ;
	
param demande :=
	1    9 
	2   11
	3   28
	4    6
	5   14
	6    5 ;

end ; 
