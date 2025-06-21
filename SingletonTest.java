package com.cognizant;

class Logger{
		private static Logger logger;
		private Logger() {
			
		}
		public static Logger getObject(){
			
			if(logger == null) {
				logger = new Logger();
			}
			return logger;
		}
		public void message() {
			System.out.println("Hi this is from Logger Class.... and Iam a Singleton Class");	
		}
}
class SingletonTest{
	public static void main(String[] args) {
		Logger obj1 = Logger.getObject();
		obj1.message();
		Logger obj2 = Logger.getObject();
		//obj2.message();
		if(obj1 == obj2) {
			System.out.println("The singleton Design pattern has been implemented successfully.....");
		}
		
	}
}