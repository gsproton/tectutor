package com.tectutor;

public class Bank {
    int actNo;
    Double bal = 0.0;
    String name;
    void setAN(int actNo)
    {
    this.actNo=actNo;
    }
     void setName(String name)
    {
    this.name=name;
    }
      void setBal(Double bal)
    {
        this.bal=bal;
    }
     public int getac()
    {
        return(actNo);
        
    }
    String getName()
    {
        return(name);
    }
    Double getBal()
    {
        return bal;
    }
    
    
    void show()
    {
        System.out.println(actNo+ " "+ name+ " " +bal );
    }
    void deposit(Double amt)
    {
        bal=bal+amt;
    }
    
    void withdraw(Double amt)
    {
    	if(amt <= bal) {
    		bal=bal-amt;	
    	} else {
    		System.out.println("Insufficient Funds");
    	}
        
    }
}
