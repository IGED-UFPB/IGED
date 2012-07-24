package br.ufpb.iged;

public class testClassProperties {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		IGEDProperties properties = IGEDProperties.getInstance();
		
		System.out.println(properties.getPropety("imagePath"));
		System.out.println(properties.getPropety("nclPath"));
		System.out.println(properties.getPropety("tarefasPath"));
		
		IGEDProperties properties2 = IGEDProperties.getInstance();
		
		System.out.println(properties.getPropety("imagePath"));
		System.out.println(properties.getPropety("nclPath"));
		System.out.println(properties.getPropety("tarefasPath"));
		
	}

}
