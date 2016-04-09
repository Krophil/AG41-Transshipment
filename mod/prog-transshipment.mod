/**
 * Program of transport : minimize the traveling costs of the products
 * from the depots to the clients
 *
 * Author : Olivier Grunder
 */
 
set DEPOTS ; 
set PLATFORMS ;
set CLIENTS ;

set V := DEPOTS union PLATFORMS union CLIENTS ; # set of nodes

set A, within V cross V ; # arcs 

# demands for each node : b_i 
param b { i in DEPOTS union CLIENTS} ; 

# edge capacity
param u { (i,j) in A } ; 

# edge fixed cost
param c { (i,j) in A } ; 

# edge unit cost
param h { (i,j)  in A} ;

# edge transport time
param t { (i,j)  in A} ;

# platform cost
param g {i in PLATFORMS} ;

# platform setup time
param s {i in PLATFORMS} ;

# max time
param T ;

# variables 
var x { (i,j) in A }, integer, >= 0 ; # quantity transported with edge e
var ye { (i,j) in A }, binary ; # edge e is used

/* Objective function */ 
minimize z: sum{(i,j) in A} (c[i,j]*ye[i,j] + h[i,j]*x[i,j]) + sum{i in DEPOTS, j in PLATFORMS} (g[j]*x[i,j]) ;

/* Constraints */ 
s.t. R_Stock{ i in DEPOTS } : sum{ j in PLATFORMS:(i,j) in A } x[i,j] = -b[i] ; 
s.t. R_Demande{ j in CLIENTS } : sum{ i in PLATFORMS:(i,j) in A } x[i,j] = b[j] ; 
s.t. R_flow{ i in PLATFORMS } : sum{ j in DEPOTS:(j,i) in A } x[j,i] = sum{ k in CLIENTS:(i,k) in A } x[i,k]  ; 
s.t. R_capa{ (i,j) in A } : x[i,j] <= u[i,j] * ye[i,j] ;
s.t. R_time{ (i,j) in A, (j,k) in A:t[i,j]+s[j]+t[j,k]>T } : x[i,j]+x[j,k] <= 1 ;


solve ; 


printf {i in DEPOTS, j in PLATFORMS : x[i,j]>0}: "depot %s -> platform %s = %f\n",i,j,x[i,j];
printf {i in PLATFORMS, j in CLIENTS : x[i,j]>0}: "platform %s -> client %s = %f\n",i,j,x[i,j];
printf "total cost z=%f\n",z;


/***********************************************************/ 

data; 

set DEPOTS := D1 D2 ; 
set PLATFORMS := PF1  ; 
set CLIENTS := C1 C2 ;

param T := 100 ;

# demand for nodes
param b :=  
	D1  -3
	D2  -5
	C1   4
	C2   4 ;

# Arcs parameters : u=capacity; c=fixed cost; h=unit cost; t=time
param : A : u c h t :=
		D1  PF1 5 3 2 4
		D2  PF1 5 3 2 4
		PF1 C1  5 3 2 4
		PF1 C2  5 3 2 4 ;
		
# platforms cost parameters
param g := 
	PF1 3 ;
		
# platforms time parameters
param s := 
	PF1 5 ;
		
end ; 
