set DEPOTS :=D1 D2 D3 ;
set PLATFORMS :=PF1 ;
set CLIENTS :=C1 C2 C3 C4 C5 C6 ;
param T := 55.05537255663408;
# demand for nodes
param b := 
  D1  -19
  D2  -13
  D3  -15
  C1  9
  C2  8
  C3  7
  C4  4
  C5  9
  C6  4
;
# Arcs parameters : u=capacity; c=fixed cost; h=unit cost; t=time
param : A : u c h t :=
D1  PF1  18 81.16085301980208 18.803491811409497 67.34936828036456
D2  PF1  10 82.44627909699638 17.05501107115824 17.099831528231967
D3  PF1  13 58.98183774506825 10.533787217295645 27.971901904067824
PF1  C1  10 30.05396708743391 18.71537533224499 69.71970328728453
PF1  C2  7 29.80953008675311 18.33190990901103 16.348616400792128
PF1  C3  7 71.36664343656813 14.04087303098724 20.77201518900496
PF1  C4  10 75.9605751592754 7.433845089503026 65.38396586000283
PF1  C5  7 96.22291907035589 15.69231908919174 21.57675762456514
PF1  C6  6 97.19420479670949 14.157648321448654 65.26531157961904
;
# platforms cost parameters
param g := 
  PF1  60.14685303563575
;
# platforms time parameters
param s := 
  PF1  74.18412200086891
;
