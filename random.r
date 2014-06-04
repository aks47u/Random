ABchoice = function(A, B, nbChancesA, outOfMe) {
	r=floor(runif(1,1,outOfMe+1))
	choice=A
	if(r>nbChancesA){
		choice=B
	}
	return(choice)
}

simulation = function(suggested, ntries) {
	margin=c()
	for(i in 1:ntries){
		margin[i]=0
		if(suggested=="chips"){
			choice=ABchoice("chips","bread",2,3)
		} else {
			choice=ABchoice("chips","bread",1,3)
		}
		if(choice=="chips"){
			margin[i]=margin[i]+0.2
			drink=ABchoice("soda","water",2,3)
			if(drink=="soda"){
				margin[i]=margin[i]+0.1
			} else {
				margin[i]=margin[i]-0.1
			}
		} else {
			margin[i]=margin[i]+0.3
			drink=ABchoice("soda","water",1,3)
			if(drink=="soda"){
				margin[i]=margin[i]+0.1
			} else {
				margin[i]=margin[i]-0.1
			}
		}
	}
	return(margin)
}


hist(simulation("chips",100000),breaks=seq(-0.1,0.5,0.01))
hist(simulation("bread",100000),breaks=seq(-0.1,0.5,0.01))
