package com.naresh.old.javapractice.corejava.outputs.factset;
import java.util.List;



class TravelerFunEarningsgreater0 {

public static void main(String[] args) {
    
}

    public static int requiredAmountAtStart(List<Integer> netSaving) {

	// 3 length. {4,2,-3}
	//x -we need to find
	int numberofDays = netSaving.size();
	int X= 0;
	int totalSavings=-1;
	int findNegativeMax=0;
	for(int save: netSaving){
	    totalSavings = totalSavings+save;
	    if(save>0 || findNegativeMax<save){
		findNegativeMax = save;
	    }
	}
	X=   Math.floorDiv(totalSavings, numberofDays);
	if(X < findNegativeMax){

	}else{
	    X=  totalSavings- findNegativeMax;
	}

	return X;
    }

}

