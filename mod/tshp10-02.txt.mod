set DEPOTS :=D1 D2 D3 ;
set PLATFORMS :=PF1 PF2 PF3 ;
set CLIENTS :=C1 C2 C3 C4 ;
param T := 87.43159752080899;
# demand for nodes
param b := 
  D1  -18
  D2  -16
  D3  -15
  C1  13
  C2  12
  C3  16
  C4  7
;
# Arcs parameters : u=capacity; c=fixed cost; h=unit cost; t=time
param : A : u c h t :=
D1  PF1  7 45.6914984058231 10.895121338607979 69.54395219323021
D1  PF2  7 66.73204603715179 13.516102146630551 96.57267956777552
D1  PF3  4 57.588639422202874 14.44628122902324 76.44268302570354
D2  PF1  5 58.50319608064827 7.069307212595361 92.07425594971124
D2  PF2  5 33.55016762877255 8.83383123080602 26.131330224911746
D2  PF3  4 99.37589129120306 7.369296767067577 53.152785715953954
D3  PF1  4 25.680090777746955 10.639982235365922 27.733287929264048
D3  PF2  6 21.027481757008985 3.092101804988703 68.73321950862274
D3  PF3  4 16.376226005079516 10.622787822268512 36.57736791499453
PF1  C1  3 86.57139258937951 2.2925575744353637 11.844531826612869
PF1  C2  4 56.97532912173517 1.014387411021201 28.555371295967817
PF1  C3  3 88.39322292944483 11.982788862284925 44.83333769808504
PF1  C4  4 98.50091832514538 18.355315413590084 96.94365794906567
PF2  C1  4 12.093454512466936 1.666682541259257 10.107867943149603
PF2  C2  3 95.64653216498347 11.642229685275623 90.94650990950132
PF2  C3  4 23.919508450445278 14.48270495819583 81.9201691761644
PF2  C4  4 87.62731079527505 15.31639707064232 57.719110796669675
PF3  C1  4 81.5700179749936 5.357394068213712 37.194329318220596
PF3  C2  3 72.0326517463699 9.370282688761858 72.12796232531332
PF3  C3  4 30.754084634906715 16.32187950623171 15.908520337935265
PF3  C4  4 50.31277895737091 12.599586558467086 41.006525764447744
;
# platforms cost parameters
param g := 
  PF1  79.12121933750703
  PF2  40.264625774286216
  PF3  33.610670004855876
;
# platforms time parameters
param s := 
  PF1  72.98949149522711
  PF2  40.87324443627604
  PF3  73.86575111047719
;