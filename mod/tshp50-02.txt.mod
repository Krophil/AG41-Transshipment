set DEPOTS :=D1 D2 D3 D4 D5 D6 D7 D8 D9 D10 D11 D12 D13 ;
set PLATFORMS :=PF1 PF2 PF3 PF4 PF5 PF6 PF7 PF8 PF9 PF10 PF11 PF12 PF13 PF14 PF15 ;
set CLIENTS :=C1 C2 C3 C4 C5 C6 C7 C8 C9 C10 C11 C12 C13 C14 C15 C16 C17 C18 C19 C20 C21 C22 ;
param T := 32.647610395026874;
# demand for nodes
param b := 
  D1  -9
  D2  -27
  D3  -19
  D4  -10
  D5  -11
  D6  -11
  D7  -20
  D8  -13
  D9  -28
  D10  -28
  D11  -16
  D12  -10
  D13  -22
  C1  6
  C2  11
  C3  6
  C4  9
  C5  5
  C6  9
  C7  6
  C8  11
  C9  6
  C10  12
  C11  14
  C12  15
  C13  11
  C14  9
  C15  6
  C16  13
  C17  9
  C18  15
  C19  9
  C20  14
  C21  8
  C22  15
;
# Arcs parameters : u=capacity; c=fixed cost; h=unit cost; t=time
param : A : u c h t :=
D1  PF1  0 97.45915999750827 17.296945689070004 25.96920878881994
D1  PF2  0 36.21223886869961 15.692385765567753 96.35687307004585
D1  PF3  0 75.29867356518747 6.733658115763583 16.453861254297706
D1  PF4  0 57.22304721472892 8.761687469621169 24.83764644949549
D1  PF5  0 34.10662319890221 13.783636187947335 52.61637998241381
D1  PF6  0 13.977239964209708 7.399191114821801 93.43771328142098
D1  PF7  0 52.69051162803627 17.7601680374992 60.96627868116921
D1  PF8  0 37.95242200756233 8.341849996047904 54.99223773466423
D1  PF9  0 25.12621142613859 16.69021341027633 29.45245378292644
D1  PF10  0 58.031866829317686 9.288682416191458 93.07746909635362
D1  PF11  0 61.784433106660806 5.26130872873555 76.1216530367005
D1  PF12  0 48.86772146804042 14.796251093005532 94.69048082618013
D1  PF13  0 64.10292130495488 3.9341787457678175 37.54804346653893
D1  PF14  0 78.94696692802394 3.7207147238018843 38.96959287821148
D1  PF15  0 90.64344425493296 8.670277800955029 65.19796980447481
D2  PF1  0 77.14919204272286 15.030665270008267 31.3694887706474
D2  PF2  0 94.47262601081447 1.4734800806510653 50.39394924425832
D2  PF3  0 69.08525790062791 19.56497337115923 65.20509688668926
D2  PF4  0 64.40570204506417 14.695137504703325 41.04198088385775
D2  PF5  0 37.00591016299674 10.05986266994243 64.97833667037678
D2  PF6  0 95.15224834349846 18.80172025282474 55.786215032383424
D2  PF7  0 19.56939425592121 5.519423425186637 68.40174488583227
D2  PF8  0 23.902961275902484 16.05426237558035 63.755061419977665
D2  PF9  0 10.257142165533121 12.753795962124594 66.53305779333238
D2  PF10  0 93.39651891711988 5.29883387324481 20.56277411024947
D2  PF11  0 45.726607947053 11.659230231546974 33.934842865260705
D2  PF12  0 74.00562724849571 19.81724767295287 53.73061964643935
D2  PF13  0 87.89026904396059 16.564252451863723 73.27319085179319
D2  PF14  0 59.881282585186504 7.9372343538426975 13.191636056041748
D2  PF15  0 46.00992081941083 4.716146662860368 81.26957053654877
D3  PF1  0 56.69433287209827 14.851290927198582 55.0430845512045
D3  PF2  0 37.59526597347167 1.7319783430177351 75.41989923684909
D3  PF3  0 91.01338327556363 7.843429018558306 79.21064915884303
D3  PF4  0 19.39590277897913 10.588371741330507 93.3948757329829
D3  PF5  0 73.8581132908171 2.8730413577234617 94.18843180305592
D3  PF6  0 12.275753372168635 7.474269066420245 39.5356588559701
D3  PF7  0 23.467091696067286 15.215101589682694 94.5188215431086
D3  PF8  0 96.25900049160862 4.580876247387828 55.358941770982725
D3  PF9  0 14.819106281805702 7.605918718923746 39.176295547855545
D3  PF10  0 94.53660541755141 13.653030628813502 33.48549244542448
D3  PF11  0 55.947115473271076 14.093665871658263 91.5192043583299
D3  PF12  0 57.72243594264442 14.876195739032585 66.9062096682743
D3  PF13  0 23.583850174097268 14.542899167555017 43.97362651201321
D3  PF14  0 72.14812339422217 2.4233087263838584 47.99977785018818
D3  PF15  0 83.17815350304787 13.4922870933107 23.113333681125855
D4  PF1  0 98.4856500464796 11.735697069002233 74.21596259488997
D4  PF2  0 60.821112903404 2.8147711242900137 93.29992792912222
D4  PF3  0 29.486771861150164 19.36228519821664 99.83861887195717
D4  PF4  0 37.121028711011554 5.37937105007367 89.54724252914987
D4  PF5  0 88.12832684530342 9.93130693331953 85.74247725086103
D4  PF6  0 45.56631322313749 2.6638598554159456 42.774033750492144
D4  PF7  0 89.95247428573518 15.578745641818278 31.557765944769987
D4  PF8  0 20.41536770690277 10.017523169621754 53.10903561073791
D4  PF9  0 75.89096678108842 13.907716465763485 17.156730771214427
D4  PF10  0 81.65248243912679 17.023220916232276 19.412467361057452
D4  PF11  0 74.3624688152221 12.303015217924061 42.87611949530076
D4  PF12  0 97.0488628721882 9.157975377496149 15.678011387595845
D4  PF13  0 13.932032510145335 5.175047863721051 20.389685286498462
D4  PF14  0 93.86779684288544 6.701300049611509 57.479358672437435
D4  PF15  0 20.321742290377394 8.45736108742011 18.64478044855352
D5  PF1  0 55.2530719538722 4.5904854342371655 94.12536698979528
D5  PF2  0 94.06164647312578 19.431994228741026 81.77710923514945
D5  PF3  0 88.83966944403933 5.6720678918237475 94.68791087596824
D5  PF4  0 77.56999757442645 1.7068667181378059 38.41766732497278
D5  PF5  0 87.62580813814913 2.548696428213811 28.566457149331246
D5  PF6  0 32.951866372010755 18.919426817787894 14.30598840132766
D5  PF7  0 95.64541374240801 14.970614338594768 13.753456418289948
D5  PF8  0 94.30521924082043 18.49077310688451 42.62369657620957
D5  PF9  0 93.48006226584998 9.47097610113379 28.46460648168931
D5  PF10  0 50.823498991502014 6.504471262366917 68.9624830923261
D5  PF11  0 11.149458752619756 7.6942205496484934 44.29803849702465
D5  PF12  0 19.483771235159573 10.534287341393728 50.340526830094696
D5  PF13  0 78.41951820993866 10.616715479884387 21.586502608064542
D5  PF14  0 78.6095093617576 10.995050348983003 50.181450901567246
D5  PF15  0 25.06712533954407 16.608893727825652 40.106596531159056
D6  PF1  0 86.09707546158721 7.3408654386851895 73.66986235095395
D6  PF2  0 76.14060173590711 17.038101678612556 50.80913323785845
D6  PF3  0 28.594960218903392 10.184900297423832 40.39753706884486
D6  PF4  0 49.75498062834804 9.861373591123556 16.734674469309123
D6  PF5  0 10.424843801012623 2.1649562946589898 43.71432309133959
D6  PF6  0 87.46112118311558 19.407357934553605 63.7783054329323
D6  PF7  0 93.5335347369482 10.129050202911964 78.69781701510857
D6  PF8  0 89.72774165542961 1.2966067155091379 14.467723684957686
D6  PF9  0 42.264872278341336 17.965219910099673 63.155872617999115
D6  PF10  0 81.57544028792732 10.199452434779907 40.41869944440673
D6  PF11  0 39.240613697355954 5.149775542325368 98.57601318001608
D6  PF12  0 65.90173831851158 5.880688890066347 51.63195016724623
D6  PF13  0 41.13940877810178 1.83821323972179 40.435809947051524
D6  PF14  0 14.5362414866837 7.730274659820297 53.29552350668098
D6  PF15  0 55.66291447234939 18.073014844286934 79.78826805734182
D7  PF1  0 39.56495238970268 1.729278457259471 33.25672947664948
D7  PF2  0 43.478073521348136 13.432542956451774 10.536325958923177
D7  PF3  0 89.96282806599646 15.550283349420065 35.82769247516231
D7  PF4  0 61.42469785691591 2.1952612726885716 99.31047812210794
D7  PF5  0 71.07360912219681 3.2414745511881087 20.08858074835374
D7  PF6  0 25.777332974391662 13.84348923621606 17.363625063595848
D7  PF7  0 46.97601142846235 2.693620003317252 23.35259132796088
D7  PF8  0 26.85053403233584 13.48091794032843 56.39719602551242
D7  PF9  0 28.27533284999886 7.839169718422861 92.95671248383157
D7  PF10  0 78.73656541083898 5.4880973073316905 52.73259803456918
D7  PF11  0 40.35953586459033 9.28269315479334 12.042397380012154
D7  PF12  0 10.46462967289035 16.490123606029705 16.74208697605705
D7  PF13  0 19.65886859233361 15.811864888734076 37.49012068459763
D7  PF14  0 47.37065442447328 19.460736056694294 96.95307216307589
D7  PF15  0 97.94808978125566 6.988230727338778 20.671964562387984
D8  PF1  0 43.96671820740546 17.537048613679996 50.73996143509944
D8  PF2  0 57.23036094555885 18.76695844527926 64.18624804532496
D8  PF3  0 32.09917141323346 16.86913006300982 36.017604534384446
D8  PF4  0 90.2418624829937 17.84480288097088 40.238269096244366
D8  PF5  0 90.68451524728893 2.5786575341654467 60.85035395197787
D8  PF6  0 74.1162030030751 4.185500192782105 88.83122767565037
D8  PF7  0 85.81210747170822 17.650854723114726 40.39086737650398
D8  PF8  0 77.24767399877538 6.921808694835598 96.43141052643526
D8  PF9  0 32.50273851050796 12.33394148298131 93.06267294914225
D8  PF10  0 71.89243585721677 4.583416877071632 48.271653012623176
D8  PF11  0 51.91216877374247 10.370304522217904 10.400564461036105
D8  PF12  0 87.54666119045854 14.34993786941466 19.957191584121638
D8  PF13  0 90.26867279549221 3.1336188394696673 97.46291408121645
D8  PF14  0 82.6407275168718 10.778205433833554 36.53794164957475
D8  PF15  0 38.3336401390219 13.49612694532961 23.229927506488416
D9  PF1  0 94.58852215457135 4.203097114382807 49.71125206794226
D9  PF2  0 12.674327614172004 16.000305358611513 82.90193515633516
D9  PF3  0 80.730893019351 5.761094108134956 36.31924681330325
D9  PF4  0 42.537802702038185 12.659128117001803 26.511769114720625
D9  PF5  0 55.21234238675718 9.735805893629104 63.80475339098482
D9  PF6  0 48.61513316941962 17.459152401323927 80.76528658478503
D9  PF7  0 69.32999932240384 14.674672435649445 10.789934594484786
D9  PF8  0 32.484923788345945 11.39064351601137 83.5241090043297
D9  PF9  0 55.393956440775014 14.476062801491679 93.4416479917226
D9  PF10  0 58.02520485174451 10.578953991067488 52.84462484759269
D9  PF11  0 26.63801407269314 9.395992492120348 40.787622237444644
D9  PF12  0 78.5828008932003 14.841382117087154 44.98734336612262
D9  PF13  0 68.21989939678829 15.673677332447678 94.64749672854252
D9  PF14  0 46.18917424358616 7.743723121447031 58.310649305908655
D9  PF15  0 26.850033789998125 19.2251361733038 12.342786206468464
D10  PF1  0 41.611872503068184 12.980734758213666 42.462998244364265
D10  PF2  0 89.0878951653138 13.604074263871045 12.84985236277545
D10  PF3  0 96.53058059623405 7.654735474512331 94.78765421684622
D10  PF4  0 40.845053245667216 1.1792509119292047 69.55991655932411
D10  PF5  0 31.626892407251816 10.776553103757957 48.354020675694734
D10  PF6  0 63.133923871622926 12.227563998489678 95.31020175415408
D10  PF7  0 16.876822108822502 5.063044088784494 18.529594702384955
D10  PF8  0 91.6013196212174 11.392057370702913 77.85024914395031
D10  PF9  0 62.83515878244531 19.855399628102703 77.50666055934451
D10  PF10  0 99.88585155678874 2.7040824055677284 56.407479509191106
D10  PF11  0 94.20067706768437 4.732460871738164 38.697742443743394
D10  PF12  0 89.33823993112384 3.118821608620424 32.51605885450567
D10  PF13  0 29.451320178448555 2.1432605508067515 85.413892967228
D10  PF14  0 30.143613478199587 15.263400302374041 20.77313765977587
D10  PF15  0 32.83837540004794 11.133007646399124 30.739896903056017
D11  PF1  0 21.384839698143306 1.846800355810025 17.686507911807823
D11  PF2  0 47.528726889082655 2.9867354547131333 58.02041509208071
D11  PF3  0 60.08596375003215 1.9307998862772227 49.27777338364629
D11  PF4  0 81.18424277030165 3.3648354580080118 53.87116615395188
D11  PF5  0 91.77480707933614 2.0111513279290874 30.605056544237407
D11  PF6  0 37.76735788315817 8.254687590608032 68.12919570541558
D11  PF7  0 47.603794676445084 15.608221939615088 92.86933421275141
D11  PF8  0 71.86190984275177 18.812613981043576 47.65628714618346
D11  PF9  0 45.56807751578594 12.816314100993242 76.26845015070441
D11  PF10  0 34.298307872794496 9.920368599850713 73.40959523020935
D11  PF11  0 55.86000230816456 11.010880551434845 59.262869213548534
D11  PF12  0 20.37207128817117 13.03038748757965 12.693542401247234
D11  PF13  0 62.89899712749521 15.662859989467083 37.41724740640713
D11  PF14  0 94.44482848411988 4.624010152239796 41.00705307555749
D11  PF15  0 69.07593510283537 17.959346063909116 37.48185094966858
D12  PF1  0 77.21681263905003 18.356901765367862 90.40020541321849
D12  PF2  0 27.751038701919274 13.679810219811253 84.8779302150715
D12  PF3  0 34.459940294158656 10.715883206920989 83.75431742286473
D12  PF4  0 85.544386126555 12.527099216209498 95.25106219197913
D12  PF5  0 58.50051102851884 2.7613981634981997 46.89958113947329
D12  PF6  0 96.45808301663122 11.862421974802814 53.256569356132786
D12  PF7  0 26.24061104003974 18.279827869117966 22.984263731676347
D12  PF8  0 92.86916165365064 8.543550115591199 54.24103731776143
D12  PF9  0 40.00727963809213 8.419877455297042 96.00957653772922
D12  PF10  0 90.93226750777455 13.315444715166407 76.98403845078477
D12  PF11  0 30.018483236720115 14.637250586782658 42.94424630931315
D12  PF12  0 60.43120135426631 17.952531237155867 98.16407248059882
D12  PF13  0 79.75498737018914 9.521831111925122 46.3328608285553
D12  PF14  0 11.618384179392766 3.1018443719787356 11.71282385610657
D12  PF15  0 88.02716930813418 18.831591659946607 51.81204798787901
D13  PF1  0 84.0812735390884 3.5262529858489753 98.72179851600607
D13  PF2  0 14.025839663833702 11.807444658189452 57.4485692152456
D13  PF3  0 95.17485692848734 5.196995834529388 26.06536142038496
D13  PF4  0 84.14612563115722 1.593259806869685 44.31335750065412
D13  PF5  0 98.05921528635865 4.434733287135392 44.40430786562052
D13  PF6  0 91.87351307745888 4.3352630597359845 80.20558560032612
D13  PF7  0 11.881273475370591 13.048346423297652 68.73395307326007
D13  PF8  0 94.521057883173 4.285035627279566 70.94082887260657
D13  PF9  0 99.1397596959663 7.170693137374287 87.14086167149277
D13  PF10  0 63.10686844924963 19.980333854897502 96.11736741832085
D13  PF11  0 37.77247256986577 12.24054482716507 55.93224916909739
D13  PF12  0 24.160914690187134 10.327946652361552 38.774703379006894
D13  PF13  0 28.00489327367804 8.329921369797123 71.80213479568516
D13  PF14  0 94.75020709575394 10.162811468556042 30.858356170673527
D13  PF15  0 16.499207260474194 9.766041308866033 14.19828518419747
PF1  C1  0 14.511435377321082 15.607605629397902 18.90498535496619
PF1  C2  0 72.84281117128305 12.74710906077183 33.554046374387696
PF1  C3  0 50.980106929136625 18.307033608219303 16.861930076928658
PF1  C4  0 25.915359416076186 3.4011556396506224 43.54908282612749
PF1  C5  0 47.005259197761816 3.3610240737443426 25.455187278599958
PF1  C6  0 90.17340926239855 14.487151452937661 88.06313634396876
PF1  C7  0 61.53880965932868 15.531066203285217 60.01993304033669
PF1  C8  0 94.39172896949438 14.687613470964854 55.98681622572652
PF1  C9  0 47.588592687405736 4.043888772334006 31.20762870511536
PF1  C10  0 77.90034456989135 8.191919518626253 29.553522137125594
PF1  C11  0 83.62417316266949 16.066717029055745 55.483761822972454
PF1  C12  0 91.85636636696381 5.0195535496858765 54.3565385179191
PF1  C13  0 87.22445325010766 2.6783112895420382 84.83031520336021
PF1  C14  0 35.589668738781235 2.28249932327542 31.715389281028546
PF1  C15  0 32.25619371090798 6.910017873938846 17.56700673650125
PF1  C16  0 20.561489127196047 7.335999689787744 96.55547216409809
PF1  C17  0 93.37245611647464 7.181043538920357 34.70535907335497
PF1  C18  0 66.97500706198413 5.516901878495337 66.46508094102842
PF1  C19  0 74.1200786145469 5.202175108277598 28.749674682339254
PF1  C20  0 30.576950994081578 7.91880613566071 80.09385564000227
PF1  C21  0 17.445186920996264 2.1721635260724295 74.35897470186829
PF1  C22  0 49.68931993926851 15.40323937951716 65.55671734304411
PF2  C1  0 49.885887385441464 5.84098907948956 42.78395497862551
PF2  C2  0 25.010264353582546 5.796067964983164 22.00736727620829
PF2  C3  0 53.24110960609288 6.764229139252629 84.49303581554337
PF2  C4  0 87.22320050131985 17.968372781660193 60.04539804825918
PF2  C5  0 50.00474208920442 18.822743607565673 36.901558148856736
PF2  C6  0 69.95320474856294 12.25100261827058 69.12109473528123
PF2  C7  0 51.35406530891828 17.831901544861513 66.61818993770898
PF2  C8  0 78.10976807806374 8.382025478059472 72.60196226969339
PF2  C9  0 28.981586100297722 15.814562325024939 18.12261493169229
PF2  C10  0 34.154963293391134 18.936298166709484 13.66508030043523
PF2  C11  0 64.55930791618472 19.262035781299474 93.2885427893686
PF2  C12  0 67.33609246767878 3.9363680332897837 77.67930387788837
PF2  C13  0 33.12451607024419 4.457234550984527 18.666137523585846
PF2  C14  0 33.42186643433019 1.0939327066684372 69.2414144830615
PF2  C15  0 89.17612255511548 9.684242090204561 89.9378945294562
PF2  C16  0 74.98119795661404 1.881069867616334 74.53025517730465
PF2  C17  0 96.77066766294378 11.898510840906297 35.462046407005346
PF2  C18  0 14.743654338536683 3.3804604924940467 72.14291348839353
PF2  C19  0 37.40699148125583 1.1819135966825132 33.317553985896865
PF2  C20  0 77.08063300901364 5.613821147775647 48.07704012398208
PF2  C21  0 31.98868254973697 6.0568649561160335 48.764750023748086
PF2  C22  0 55.146333334369785 13.797767497251595 33.02333024789013
PF3  C1  0 75.65333753799338 17.48372670877536 71.53569399709832
PF3  C2  0 93.71758349732404 14.72632247774927 42.63227083292609
PF3  C3  0 56.75771039610959 11.115727490853558 74.86830076268002
PF3  C4  0 70.27157356926381 15.22929597672722 13.919160038591723
PF3  C5  0 23.80780696630984 6.135603902213377 70.69829681418784
PF3  C6  0 69.34057171887619 7.405744229823642 33.47153096111599
PF3  C7  0 56.6229921081447 8.748186202217607 27.923099769256876
PF3  C8  0 57.68268340112003 15.081738178252628 95.62297832808997
PF3  C9  0 20.52314856170542 16.153151772504188 73.15163256705284
PF3  C10  0 40.30770163585933 19.69165254315448 91.25749969803005
PF3  C11  0 44.82800355160172 14.572155732665074 65.85417941057385
PF3  C12  0 19.897139736097884 5.532196504692813 30.40836918315702
PF3  C13  0 69.45761742920482 4.654565719136144 92.32632242670894
PF3  C14  0 94.65747246691105 8.088406944471767 74.31565324406102
PF3  C15  0 65.92315639086132 16.33601573413743 25.381030538883614
PF3  C16  0 62.145684371089644 15.880816503843125 65.10638858619724
PF3  C17  0 41.496972403326964 3.9739991384804565 99.18295494803934
PF3  C18  0 79.1061545953531 18.0330252025334 63.76151628418004
PF3  C19  0 37.85106744712468 11.334718101619401 61.13900741064297
PF3  C20  0 79.85797494148986 19.50888376489077 99.53361295094052
PF3  C21  0 87.95301684159949 12.75540887495777 65.25926565118945
PF3  C22  0 88.27172846462553 2.718516407254683 56.479492290595466
PF4  C1  0 27.50838249426947 19.556363457691035 13.902286791759284
PF4  C2  0 70.87481260248417 8.942394206529762 15.27173998031656
PF4  C3  0 69.73871564867824 19.526863199049032 17.318879171064538
PF4  C4  0 71.12438042594836 4.772684396929149 40.95323845624206
PF4  C5  0 14.784172597273779 6.059245897145838 72.90839398952956
PF4  C6  0 37.38691895121506 1.521089121506554 49.79875058368968
PF4  C7  0 27.51985433290713 16.255322079861905 58.60161464548245
PF4  C8  0 39.66357498422674 7.292397428270818 50.947615433951725
PF4  C9  0 90.07487952387866 7.0793650007478615 77.28428441188375
PF4  C10  0 62.60027358921283 4.17296219720877 90.9716365473197
PF4  C11  0 27.84329172784151 11.381883665128344 41.675355012533984
PF4  C12  0 24.82167192624322 14.73332989328015 62.042196458603854
PF4  C13  0 50.27584308655018 13.368409506519608 21.574000099947874
PF4  C14  0 67.12803847662977 3.79423299141696 96.8606932874968
PF4  C15  0 60.24173999406241 13.837502772635592 17.889474182180276
PF4  C16  0 94.59411448267521 12.155170278931418 46.01633652280792
PF4  C17  0 58.24937353436666 19.26220825016888 10.367872400179643
PF4  C18  0 10.109006716917646 11.734790685367154 65.93536762806642
PF4  C19  0 30.315138285954284 16.539173607233938 68.42983482258033
PF4  C20  0 29.396187853385385 2.3222989087072974 48.085799594461115
PF4  C21  0 70.76938844084665 18.979648233093446 67.03330229203303
PF4  C22  0 40.052651544353715 19.889105141342572 52.601674683941695
PF5  C1  0 73.78856710981856 7.866586188010283 11.975335974028637
PF5  C2  0 49.64632060334261 16.159933625687245 61.99097002771927
PF5  C3  0 59.942625487105964 16.652065338843855 21.547096242926845
PF5  C4  0 10.410710470846043 10.892608803820274 93.09117379231942
PF5  C5  0 66.54673488927878 1.6192481335266657 23.956036642040793
PF5  C6  0 30.575971173965264 11.065744974361007 17.93659787596183
PF5  C7  0 83.10640364770121 2.5830993459434604 62.42936228438374
PF5  C8  0 24.87534147239255 12.923544772658717 86.70150952657
PF5  C9  0 85.64502533858901 18.954076476637837 52.41283592357186
PF5  C10  0 39.266061288408736 8.576940739606274 18.383120351542942
PF5  C11  0 66.2029495429664 19.239021022922387 17.77897368541371
PF5  C12  0 77.40385054464122 18.610285436718197 37.38851175783099
PF5  C13  0 66.29710765550234 12.803457102350265 55.458711678024144
PF5  C14  0 78.90997033239417 5.892817436292885 56.68955071514936
PF5  C15  0 65.63029365170812 3.469527200295599 20.410590164858903
PF5  C16  0 91.96996447601389 5.544118978254557 70.70986214037907
PF5  C17  0 49.8391142275652 10.273775347748447 25.341527801328233
PF5  C18  0 75.3031114976985 12.752781722295264 73.60792051316777
PF5  C19  0 63.569722302662335 3.4590033948018943 82.09324804208774
PF5  C20  0 47.04168303655809 10.897505871501647 91.12032232691466
PF5  C21  0 77.67036104140416 7.524412526230284 24.108404068126937
PF5  C22  0 60.55904476130465 14.169841310230021 36.62929192686801
PF6  C1  0 61.78979147968251 19.90825525995316 61.89050390333652
PF6  C2  0 49.785677725467146 3.647802402660912 24.618517878788964
PF6  C3  0 46.1706624275286 6.627212198199416 95.87164384819651
PF6  C4  0 59.052171627213056 1.519562122014963 87.18132078738671
PF6  C5  0 68.9269057934211 12.9467121187976 73.60215793523652
PF6  C6  0 44.99826591101477 19.906454750323803 61.7452946349796
PF6  C7  0 17.594179120394465 13.906417462263805 10.67622707317977
PF6  C8  0 80.58698413827192 5.484497207129746 80.6773977491538
PF6  C9  0 26.24246329005587 8.275093377429847 27.30751065742103
PF6  C10  0 13.762942257993846 19.853658954813085 45.93363614042668
PF6  C11  0 41.93984321962521 9.259073179816163 54.968863759765505
PF6  C12  0 85.79387955741463 7.35408246994208 94.41733878801496
PF6  C13  0 76.85655469767337 8.038549285691591 60.01021005115378
PF6  C14  0 76.83447347762933 7.778493712933476 32.210133416550065
PF6  C15  0 74.79834731189746 9.955898936998587 33.66861814759775
PF6  C16  0 58.75152797781151 4.1800013295149405 58.33964715227436
PF6  C17  0 53.458233874115464 19.930267976083865 10.38465220360505
PF6  C18  0 97.74955036499517 6.724519061641166 81.2480292021719
PF6  C19  0 36.175686354102794 10.4226317531241 38.83907864148185
PF6  C20  0 51.83582571899635 9.287018736577915 83.62533134395603
PF6  C21  0 29.49234135137835 5.0255497718182305 52.62393613832745
PF6  C22  0 90.66401388774156 11.240842790925573 53.77182124214301
PF7  C1  0 55.29327042269681 16.501834713407334 59.962109097156485
PF7  C2  0 67.79537751202598 16.639284122979532 94.15329187077639
PF7  C3  0 88.82289908147473 19.846353152398823 14.389389595737917
PF7  C4  0 37.91663319790804 3.738660389905616 80.31342261201594
PF7  C5  0 46.36459827095122 12.695177613128626 10.81315261688484
PF7  C6  0 94.05357385834635 14.562100877083102 65.80726000502173
PF7  C7  0 78.87306230216196 11.156308271465385 33.861659728635495
PF7  C8  0 62.31944696621094 5.953258192185283 41.31988779594431
PF7  C9  0 10.348487000243784 4.8861840923513595 37.93809523093983
PF7  C10  0 64.23720924763217 1.3191698478406932 18.634318724182286
PF7  C11  0 22.24163858081978 13.986198734702386 80.89335731336672
PF7  C12  0 99.17467809708883 4.011488638813362 82.61271189388314
PF7  C13  0 27.678874609191833 15.043447101485944 75.73169952326694
PF7  C14  0 61.931674091660874 12.045294278613463 76.85495822413243
PF7  C15  0 61.796161295985165 2.389912062497386 97.2632658760268
PF7  C16  0 13.018194331863638 3.604713270455476 51.19867412434309
PF7  C17  0 76.97117731571899 18.404316802970317 43.11759546083212
PF7  C18  0 91.66269824599627 14.534558769670133 11.724718978485472
PF7  C19  0 74.24253700255913 10.430860394519922 81.03212847418948
PF7  C20  0 24.08954491486881 15.767214722827605 56.43224775092325
PF7  C21  0 84.70521573365211 3.639051990722036 96.82983446162484
PF7  C22  0 92.10467495322904 6.3839767484833905 22.247386804853257
PF8  C1  0 77.17124052914806 19.89886818031727 69.99996452495563
PF8  C2  0 49.52855655873824 1.7600773007080872 41.52959319642868
PF8  C3  0 70.88469314004232 13.495444511951026 86.29601675960015
PF8  C4  0 56.51552564519085 18.992603758164627 98.73974999629468
PF8  C5  0 34.580092005704394 4.257529545586589 69.26498708730702
PF8  C6  0 74.29848669719912 14.560536555211124 30.434081370944536
PF8  C7  0 75.67324662032983 4.423910321086586 55.121953845081315
PF8  C8  0 35.398143825620785 18.916121518673073 84.2479178474007
PF8  C9  0 95.87357759998787 5.32203490944046 57.884052872987844
PF8  C10  0 66.83573737813009 14.456796307150487 15.03340555191324
PF8  C11  0 92.00705835085986 9.683049289234122 34.17792700087816
PF8  C12  0 66.38839590505955 1.0768909205059813 28.815206609986028
PF8  C13  0 53.33874145549032 5.167464163006119 29.63469259512394
PF8  C14  0 24.426151925108837 14.248317788007435 67.72824359473573
PF8  C15  0 49.18402500709286 7.42567476008884 71.28648627828392
PF8  C16  0 76.36968099962836 17.329473526186707 71.601582820104
PF8  C17  0 43.097641454748675 1.767550797750423 22.878687456414667
PF8  C18  0 13.307844076030573 12.551572263279963 94.35248053218102
PF8  C19  0 72.42949535579268 16.26531214450121 92.51181740559308
PF8  C20  0 70.81405975197606 16.88162087174558 75.85467807798159
PF8  C21  0 14.536364114180746 12.863915426359192 94.52723670389864
PF8  C22  0 68.50061525463377 9.71126803841275 82.44500564420112
PF9  C1  0 73.4385646318047 9.823163864034631 90.0506719352746
PF9  C2  0 25.349938092797508 2.0707325591207386 51.73235047044153
PF9  C3  0 83.21060598651836 17.565764024656872 13.107647183411013
PF9  C4  0 88.36191638903739 1.8170417964746255 79.87305650550911
PF9  C5  0 66.89493843991642 1.7555453150293512 51.72486264145679
PF9  C6  0 64.55632002452032 14.995786395382687 61.976822810662675
PF9  C7  0 12.2278101714498 16.180060379155638 65.93162066613706
PF9  C8  0 38.86938445214035 19.32562205344023 38.80714420908515
PF9  C9  0 87.9663480768899 6.76178944663503 37.07531813275426
PF9  C10  0 72.98362339218966 2.5047305279493184 15.440380931472383
PF9  C11  0 27.105870674964006 8.772162406278639 55.36509267915654
PF9  C12  0 62.629934277868536 10.788457511463347 20.04751483860951
PF9  C13  0 25.77654342520375 1.072619528128961 85.05769466877953
PF9  C14  0 43.401051265476404 6.0373527228217965 23.462628679409715
PF9  C15  0 39.10840260574015 15.95693069535826 39.19961680500853
PF9  C16  0 87.61541705265704 18.18481979473091 82.70220686897322
PF9  C17  0 47.85383860807143 5.918989680836764 88.33956730856404
PF9  C18  0 37.27053167230148 1.8236107894446965 14.09930564452957
PF9  C19  0 22.056569491403017 18.42030347140705 70.1253434005913
PF9  C20  0 60.62483810609327 7.360367402721834 84.21663945129764
PF9  C21  0 40.55621375849698 18.481395864315193 39.19916351051451
PF9  C22  0 72.44721696689703 8.937437600488451 89.20267768423173
PF10  C1  0 57.61746838519654 14.671342082931327 59.30552903293316
PF10  C2  0 40.47313869458655 9.07118546165691 65.75478321498659
PF10  C3  0 90.47299905390635 8.819655193381587 62.0256706998606
PF10  C4  0 73.10654886727474 18.706010089476692 49.3534767717858
PF10  C5  0 94.06909086798638 16.524743475761564 79.05263496988006
PF10  C6  0 15.90654110751192 10.133292072672656 97.9318847530641
PF10  C7  0 71.8031054770845 11.283153161306846 97.42110372199649
PF10  C8  0 16.897883127130974 1.9744908614814396 21.644416321090006
PF10  C9  0 93.54183781736714 10.813823191925438 69.60596577538598
PF10  C10  0 33.24445642527601 3.1776088501816697 81.89876021349944
PF10  C11  0 94.70981370280691 15.901560892587426 92.90373821668665
PF10  C12  0 54.32467585384557 3.726236896005882 75.31525047170798
PF10  C13  0 72.73659397884447 10.833966487025936 75.01088623088404
PF10  C14  0 48.74794889433453 14.510408249351219 90.77764391492254
PF10  C15  0 59.652148602807706 11.25601945251468 25.21309985485216
PF10  C16  0 15.35123482533551 11.558474634249638 40.23941689676631
PF10  C17  0 82.11937373848039 17.016547424563534 63.09959847782765
PF10  C18  0 90.71477234186338 5.579222535669737 36.44960070390853
PF10  C19  0 72.6927917598745 17.330795318811465 69.21652083732559
PF10  C20  0 58.23603379410669 6.513450369101413 23.262232958861702
PF10  C21  0 78.59252133319556 10.333316938129636 94.57346932311809
PF10  C22  0 56.300965889590465 18.54422614616684 56.69350674769761
PF11  C1  0 56.7825648481303 3.8454012113337237 58.41725627950005
PF11  C2  0 75.59158910795155 15.765041357072878 47.39064722563428
PF11  C3  0 96.64247823922119 6.931260286154409 76.18693654116521
PF11  C4  0 88.06900695513146 5.455083373308024 47.67659406848438
PF11  C5  0 44.02148723226385 7.567190065693757 82.06416383463322
PF11  C6  0 62.67089261232233 5.660841949837907 28.83456444991802
PF11  C7  0 42.96411438593944 12.497925173258228 43.03296533883427
PF11  C8  0 45.26252757579981 15.533269157420854 96.79653803215655
PF11  C9  0 23.896376269752324 2.1044126662161107 13.862953931881558
PF11  C10  0 52.88041893929078 4.619714977666005 46.89973127397543
PF11  C11  0 59.56161447793288 18.857211619861836 24.93008247592165
PF11  C12  0 94.8076041131749 9.059852087453137 60.87513540069334
PF11  C13  0 22.495023173136964 4.679748989059278 87.28898179531757
PF11  C14  0 25.519678349347263 9.384813056263994 51.732173940637196
PF11  C15  0 60.32593484794509 14.295640708939947 81.91094445526262
PF11  C16  0 37.04059686909921 10.368754473971437 44.703526680117875
PF11  C17  0 97.69692766854527 11.384305186524436 42.50162482982662
PF11  C18  0 10.747353347518033 7.132070241709013 44.91421818619826
PF11  C19  0 16.088816759154714 17.119082532934982 13.812506167144411
PF11  C20  0 21.162556376911134 1.4454723655151103 24.938984892228014
PF11  C21  0 25.340594803220952 17.41207946845495 39.86021251682293
PF11  C22  0 76.7739862167399 8.934156813860248 57.91204638806918
PF12  C1  0 43.153370238360594 8.939959903471555 48.967718238933536
PF12  C2  0 85.42019569736101 2.6312720709465336 14.353267417344329
PF12  C3  0 71.36739591371841 17.774898437897985 55.04151351365054
PF12  C4  0 64.28121545683582 9.079912052157708 63.37484494081102
PF12  C5  0 70.30120899406255 5.1949166405502964 36.99880606354512
PF12  C6  0 97.01341463761307 7.9328503057436865 91.43253291973198
PF12  C7  0 14.941990402000638 16.99782062512448 50.758795379370966
PF12  C8  0 13.067604714987652 12.749235326824628 44.28549156913463
PF12  C9  0 29.27615988876658 6.392956811467373 70.71210837853029
PF12  C10  0 46.72940740928933 12.437464615603524 70.32881597962175
PF12  C11  0 67.54931167220158 19.295009060300934 70.08244150423587
PF12  C12  0 65.92100989297376 8.543455748701064 85.96281141161114
PF12  C13  0 73.7445234961857 10.59405024794567 62.09447472522889
PF12  C14  0 23.303306116345183 8.333534785161342 26.16306680790498
PF12  C15  0 43.068112534187314 8.726072743251954 26.362129936710428
PF12  C16  0 74.71752533485876 9.371161833213495 85.91540656895967
PF12  C17  0 61.73190518935185 1.6182109948461694 27.411222458540244
PF12  C18  0 92.50540634088252 16.036707729091447 10.679756714054689
PF12  C19  0 63.8210734266773 4.832879133729 44.75057746080855
PF12  C20  0 33.74696953255249 19.189506608632907 26.5470289420606
PF12  C21  0 56.536608042459264 17.485040338358584 46.405666047804324
PF12  C22  0 35.954948675362104 7.921397332032665 83.25303792788446
PF13  C1  0 57.601483518209484 13.256829026962484 50.32884288877002
PF13  C2  0 35.26496064065734 11.100978117788104 45.713541286695616
PF13  C3  0 91.11958419367856 4.583740217673613 30.600204587196515
PF13  C4  0 74.66045955397693 19.15778833713931 72.24447185674268
PF13  C5  0 70.67646048778434 13.83660867840546 87.83319560404942
PF13  C6  0 62.27154223802081 2.3056391353820747 80.13140546475921
PF13  C7  0 50.970950703911214 18.073596029209554 65.69896282176958
PF13  C8  0 12.286665464783367 18.154311219748088 11.712323766485007
PF13  C9  0 91.76676598212934 14.686402898150321 67.9835500251694
PF13  C10  0 23.51636000654559 7.40883624247252 26.637768299928528
PF13  C11  0 80.45307058203717 18.014927266221928 23.09200915847243
PF13  C12  0 83.14795304994813 2.105585356501417 38.47240578131456
PF13  C13  0 62.00314902380643 10.754582846438538 65.4134505677362
PF13  C14  0 75.73042486652676 12.584376984067164 16.30209206416325
PF13  C15  0 27.620190259476058 11.730506701601325 15.461132557234045
PF13  C16  0 39.92840795117128 4.145830914610183 64.51049837734104
PF13  C17  0 25.859279731521823 8.362859328796407 43.201631915051244
PF13  C18  0 18.084421664828454 18.093176950127322 36.38934635884219
PF13  C19  0 42.51464759565933 19.89745052039689 31.487169584934044
PF13  C20  0 36.128403566538445 2.6077493196949564 79.7463255594254
PF13  C21  0 18.06123110784631 11.225903714212274 39.005135151302795
PF13  C22  0 53.87357883860178 6.657373240953916 25.174766084401924
PF14  C1  0 33.93963230950262 8.869573598063333 54.65890778379717
PF14  C2  0 18.237759164817433 7.886872443766668 50.149093779594075
PF14  C3  0 91.4735189526299 15.45144284660165 47.7939884745176
PF14  C4  0 84.42911179503712 18.189909554714113 34.610177510134776
PF14  C5  0 99.70852230620702 7.730215162189435 81.18355395482374
PF14  C6  0 12.635466686647323 13.411381504273978 86.20459392647017
PF14  C7  0 80.96172471254407 4.020817332482856 96.1874504776154
PF14  C8  0 10.256229948866677 17.379588508716584 55.84188104475727
PF14  C9  0 85.37076706564247 1.5755369611236816 81.9987425458225
PF14  C10  0 92.2159614221863 10.217392984557733 26.73386705627418
PF14  C11  0 48.23165768085524 7.250010141353748 13.391812644805121
PF14  C12  0 94.39868260718401 19.63159218536264 92.5800900371973
PF14  C13  0 26.41434558495574 9.528281057443062 43.88613845877853
PF14  C14  0 67.74196942227883 17.629715114738325 13.063429171528359
PF14  C15  0 12.645097451116888 10.731146226574667 23.73976978050213
PF14  C16  0 83.02990203962672 9.86347245994457 77.31994773582392
PF14  C17  0 78.94478211159644 14.982007772614637 44.68657593851013
PF14  C18  0 28.92392292596298 6.548070524643902 28.547065105748434
PF14  C19  0 93.01208108551081 5.2544565133891385 45.8313483124826
PF14  C20  0 98.27068003145796 5.656610402486021 35.41408954905988
PF14  C21  0 73.84072167841796 4.575792407134122 47.61677310519749
PF14  C22  0 70.22591228836163 9.838792005270092 68.43917475031647
PF15  C1  0 25.359773219316224 17.210716304915575 83.27640118645436
PF15  C2  0 18.233422846547985 8.263142347086898 91.99678480554121
PF15  C3  0 89.38607818134632 11.399397298782146 89.68760670808155
PF15  C4  0 56.39823677031758 11.33198274354819 85.1196950928637
PF15  C5  0 81.67788490334136 14.974146922788455 42.038661975969575
PF15  C6  0 89.29296649534488 2.9683578665309467 96.75962783897296
PF15  C7  0 17.37873018918304 19.92890916816498 99.22394508867617
PF15  C8  0 12.736485122890118 2.9241459850580194 23.67056521010287
PF15  C9  0 14.64065526591529 4.765789783916074 99.38136156044015
PF15  C10  0 25.58394493175944 18.30856356503164 81.57879650259169
PF15  C11  0 57.71579197818515 8.192845856809651 17.48604941177735
PF15  C12  0 15.067200281445709 10.286287663711178 82.80378048321573
PF15  C13  0 33.3054033705146 2.497346543108396 49.414409382913114
PF15  C14  0 60.72473330718884 6.644416511264269 65.9938734193689
PF15  C15  0 26.45543766319729 3.668734014984718 89.39253847040382
PF15  C16  0 74.46009263007338 1.6774802488391036 76.14098574437642
PF15  C17  0 74.78763752853197 5.095491954943548 10.243134593739757
PF15  C18  0 36.76795220008166 11.589728302611402 65.53823063850797
PF15  C19  0 42.355299212456124 10.4101522183666 18.344907006385245
PF15  C20  0 61.6668253056536 12.363903522960415 98.84463887036682
PF15  C21  0 26.912720055530134 8.806649404039655 17.71859445621361
PF15  C22  0 85.37751873944696 4.7957342397415275 77.92097434547283
;
# platforms cost parameters
param g := 
  PF1  26.6973061609687
  PF2  31.106392500099943
  PF3  46.53752486538076
  PF4  11.618140406284727
  PF5  44.01889478450806
  PF6  59.65451677527939
  PF7  90.94756615235535
  PF8  61.166274446021404
  PF9  22.042954606681015
  PF10  46.12818119046814
  PF11  15.83524339485163
  PF12  62.73278075697963
  PF13  93.36090797699704
  PF14  79.34324963125945
  PF15  77.66682285161346
;
# platforms time parameters
param s := 
  PF1  18.04400570967686
  PF2  44.28381940511823
  PF3  49.77228041806267
  PF4  73.014895919982
  PF5  32.838445159345696
  PF6  69.62686964973375
  PF7  20.188563263831085
  PF8  25.966941531232738
  PF9  24.91564603816709
  PF10  70.13296299718098
  PF11  38.999732366625345
  PF12  99.7105155148698
  PF13  33.754457351224694
  PF14  43.02154179474483
  PF15  55.12003369323213
;
