import java.util.concurrent.Semaphore;

/**
 * 
 */

/**
 * @author Smith
 *
 */
public class t {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args){
		
		switch(2){
		case 1:
			System.out.println("case 1");
			
		case 2:
			System.out.println("case 2");
			
		default:
			System.out.println("passei aki");
			break;
		}
		
		
		
//		final Semaphore sm = new Semaphore(0, true);
//		
//		new Thread(){
//			
//			public void run(){
//
//				System.out.println("primeiro teste");
////				sm.release();
//				try {
//					sm.acquire();
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
////				 try {
////					Thread.sleep(5000);
////				} catch (InterruptedException e1) {
////					// TODO Auto-generated catch block
////					e1.printStackTrace();
////				}
//				 
//				System.out.println("permissão concedida");
//				
//				try {
//					sm.acquire();
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				
//			}
//			
//		}.start();
//		
//		new Thread(){
//			public void run(){
//				this.setPriority(10);
//				System.out.println("segundo teste");
//				sm.release();
//				
//				
//			}
//			
//		}.start();
//		
//		new Thread(){
//			
//			public void run(){
//				this.setPriority(10);
//				try {
//					sm.acquire();
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				System.out.println("\nterceiro teste");
//				sm.release();
//			}
//			
//		}.start();
		
		
//		try {
//			sm.acquire(6);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
 
	}

}
