set DEPOTS :=D1 D2 D3 ;
set PLATFORMS :=PF1 ;
set CLIENTS :=C1 C2 C3 C4 C5 C6 ;
param T := 78.14352324857317;
# demand for nodes
param b := 
  D1  -16
  D2  -18
  D3  -15
  C1  6
  C2  9
  C3  6
  C4  6
  C5  9
  C6  11
;
# Arcs parameters : u=capacity; c=fixed cost; h=unit cost; t=time
param : A : u c h t :=
D1  PF1  20 67.8958066633453 11.732210723463302 53.32701947329098
D2  PF1  21 17.378954153276744 11.606813428798029 22.19587237801607
D3  PF1  14 12.766898905067787 7.337378664354965 12.463992534591094
PF1  C1  10 79.16716106865945 18.463988782631183 56.97712162884017
PF1  C2  7 11.429823352101007 14.190498387845327 31.793713078470716
PF1  C3  9 36.95098360756076 4.283118624656977 75.57174138856215
PF1  C4  8 92.84934201063317 16.90189775314829 95.57183790590862
PF1  C5  8 62.38562720075826 5.106769457449532 53.92086877860321
PF1  C6  10 87.18398757047031 11.396052549427631 24.000753832218468
;
# platforms cost parameters
param g := 
  PF1  55.672268676158176
;
# platforms time parameters
param s := 
  PF1  19.340462526066034
;