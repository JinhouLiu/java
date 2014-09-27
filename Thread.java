import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
public class demo{
/**
 * 四种线程池的创建方式
 * 
 * 	
 */	
public static void main(String[]  args)
{	
demo3();	
}
//基于可缓存线程池的实现
public  static  void  demo1()
{
ExecutorService Service=Executors.newCachedThreadPool();
for(int i = 0;i<100;i++)
{
int index=i;
try{	
Thread.sleep(i*1000);
}
catch(Exception e){
e.printStackTrace();
}
Service.execute(new  Runnable() {
	
	@Override
public void run(){	
System.out.println(index);	
		
}
});
}
}   
//基于定长线程池的实现
public static void demo2()
{
ExecutorService  service=Executors.newFixedThreadPool(10);
for(int i = 0; i < 100;i++){
	
int index=i; 
	
try{
Thread.sleep(index*1000);
} catch (Exception e) {
e.printStackTrace();
}
service.execute(new Runnable() {	
	@Override
	public void run(){		
	System.out.println(index);	
	}
});
}
} 
//定长线程池，支持定时及周期性的任务执行
public static void demo3()
{
	ScheduledExecutorService  service=Executors.newScheduledThreadPool(10);
for(int i = 0; i <100;i++){
int  index=i;
try {
	Thread.sleep(i*1000);
} catch (Exception e) {
	e.printStackTrace();
}

service.schedule(new  Runnable(){
	
	@Override
	public void run()
	{
		
	 System.out.println(index);   	
		
	}
	
},3,TimeUnit.SECONDS);
}


}    
//单线程化的线程池
public  static  void  demo4()
{
ExecutorService  service=Executors.newSingleThreadExecutor(); 	
for (int i = 0; i < 100;i++){
int  index=i;
try {
	Thread.sleep(i*1000);
	
} catch (Exception e) {

e.printStackTrace();
}
service.execute(new  Runnable() {
	
	@Override
	public void run() {
		
		System.out.println(index);
		
	}
});

}

}  

}
//基于四种线程池的实现
