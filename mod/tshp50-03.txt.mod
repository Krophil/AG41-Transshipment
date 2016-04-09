set DEPOTS :=D1 D2 D3 D4 D5 D6 D7 D8 D9 D10 D11 D12 D13 D14 D15 D16 ;
set PLATFORMS :=PF1 ;
set CLIENTS :=C1 C2 C3 C4 C5 C6 C7 C8 C9 C10 C11 C12 C13 C14 C15 C16 C17 C18 C19 C20 C21 C22 C23 C24 C25 C26 C27 C28 C29 C30 C31 C32 C33 ;
param T := 60.397682316525476;
# demand for nodes
param b := 
  D1  -9
  D2  -12
  D3  -10
  D4  -9
  D5  -20
  D6  -19
  D7  -21
  D8  -21
  D9  -13
  D10  -21
  D11  -19
  D12  -11
  D13  -19
  D14  -12
  D15  -21
  D16  -13
  C1  4
  C2  9
  C3  9
  C4  6
  C5  8
  C6  4
  C7  6
  C8  7
  C9  10
  C10  8
  C11  7
  C12  5
  C13  8
  C14  5
  C15  4
  C16  4
  C17  4
  C18  6
  C19  4
  C20  9
  C21  9
  C22  8
  C23  10
  C24  8
  C25  7
  C26  5
  C27  6
  C28  4
  C29  8
  C30  4
  C31  3
  C32  6
  C33  7
;
# Arcs parameters : u=capacity; c=fixed cost; h=unit cost; t=time
param : A : u c h t :=
D1  PF1  8 94.41908922492672 10.656087153008942 74.21114951477183
D2  PF1  13 52.49951940422002 2.561252698627077 72.58617660267566
D3  PF1  10 53.66411985579459 3.886144493048087 69.42975377908279
D4  PF1  8 75.71320047019469 11.608193021032708 51.08810303180334
D5  PF1  17 19.95538725660824 4.635534745494039 11.175731723707639
D6  PF1  20 60.55697794044989 16.200194338289165 21.14469715542942
D7  PF1  16 97.73317551940322 11.728583133634054 87.88193280778513
D8  PF1  24 90.21848823934317 2.9508753323823322 66.31587949693899
D9  PF1  12 16.99466757838389 8.170009250356024 99.71097376706031
D10  PF1  17 55.60799063634371 2.113987794756412 62.83826629830949
D11  PF1  17 74.57378290780859 5.641839055472342 23.532739878308043
D12  PF1  9 10.344554889909187 2.764012136926352 36.282656920016166
D13  PF1  24 45.109125451356654 16.9721826047345 47.44351072472733
D14  PF1  9 90.29366928255273 17.751354833144113 55.42894705870861
D15  PF1  23 22.051611559517077 2.368839948907148 80.80328266959843
D16  PF1  16 99.25777797102214 4.600108428584414 40.584991207273546
PF1  C1  9 61.563323906933526 10.960707621322996 28.267832417575566
PF1  C2  7 54.92134274147903 18.266347840910832 66.07601321902752
PF1  C3  8 24.65918061226054 2.939958203120513 68.79210124698176
PF1  C4  6 41.65198436170573 7.424930525178431 49.131103823356504
PF1  C5  7 45.442935357614466 1.3479525025319763 23.08145300965822
PF1  C6  6 79.25927649200321 19.702767010321168 79.89337512079922
PF1  C7  6 95.78913058723447 11.297860942693704 65.46736871792814
PF1  C8  8 19.312717171956415 9.026534331816384 59.780339738638006
PF1  C9  9 19.322514888571018 4.176960630836577 18.68414221461586
PF1  C10  7 43.12049308952214 1.0027978778474047 37.92107193450124
PF1  C11  9 80.04652048387965 3.1215740862513375 72.52314712175607
PF1  C12  9 17.970562320168384 8.998511200774876 47.89670558854847
PF1  C13  8 23.472347474806757 6.807624168865535 29.84121475350037
PF1  C14  6 40.735625815519 10.339865681484296 69.51084581775746
PF1  C15  9 70.60021925208916 6.349767363678785 55.89971934039392
PF1  C16  9 20.443554232920206 11.79745209568567 42.81645116454095
PF1  C17  8 87.60437113555624 12.852079538210102 79.51089482782791
PF1  C18  9 43.91484373814415 10.27571035812479 64.12574632940641
PF1  C19  9 36.573345373735464 17.90325873474151 56.967974901974294
PF1  C20  7 51.06862512785377 1.374630484709213 16.229727093751887
PF1  C21  6 65.15713914554851 4.059319256072724 92.2357200685918
PF1  C22  6 68.99884617215005 3.2416772263606246 67.5538261196908
PF1  C23  6 55.4727713173238 13.106736651934996 59.37785839444113
PF1  C24  9 26.42212671339235 10.88190495362245 77.47629926134206
PF1  C25  9 95.11985416019567 18.649024801269498 15.698041958176532
PF1  C26  8 82.59891111547844 9.844231140564494 17.53588565177632
PF1  C27  6 25.657688171906134 19.30970115849248 16.570875795303355
PF1  C28  6 87.32941692922319 11.951840831015721 30.755324669383707
PF1  C29  6 26.395478948572094 13.594617536804789 35.4395523171865
PF1  C30  8 51.12600906188788 4.494684914786778 33.807272989570166
PF1  C31  9 73.84723515412146 16.20662311374533 84.95668486907324
PF1  C32  6 17.16349898705154 13.05204813593915 49.2491934261593
PF1  C33  9 99.7028841716016 14.355525848724545 27.74489687644449
;
# platforms cost parameters
param g := 
  PF1  16.413947046107022
;
# platforms time parameters
param s := 
  PF1  69.51991670167112
;
