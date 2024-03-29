package com.factory.design.pattern;

public class MobileFactory {
	
	public MobileFactory(){

    }

    IMobile createMobile(String type){

       IMobile mob=null;
       if("len".equalsIgnoreCase(type)){
          mob=new Lenovo();
          System.out.println("Lenovo created");
       }else if("sam".equalsIgnoreCase(type)){
          mob=new Samsung();
          System.out.println("Samsung created");
       }
       return mob;
    }
    
    public static void main(String[] args) {
    	MobileFactory factory= new MobileFactory();

        Lenovo len = (Lenovo)factory.createMobile("len");
        len.batteryPower();

        Samsung sam= (Samsung)factory.createMobile("sam");
        sam.cost();
	}
}
