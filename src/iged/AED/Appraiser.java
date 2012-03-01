package iged.AED;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Set;


public class Appraiser {
	
	private Map <String , Struct> structOriginal;
	private Map <String , Struct> structReplica;
	private List<String> correct;
	
	public Appraiser(StructManager sm){
		structOriginal = new HashMap<String , Struct>();
		structReplica = new HashMap<String , Struct>();
		
		for(String k : sm.structOriginal.keySet()){
			this.structOriginal.put(k, sm.structOriginal.get(k).getStruct());
		}
		
		for(String k : sm.structReplica.keySet()){
			this.structReplica.put(k, sm.structReplica.get(k).getStruct());
		}
		
	}
	
	public boolean compare(Struct s1, Struct s2){
		return s1.compare(s2);
	}
	
	public boolean assess(){
		correct = new ArrayList<String>();
		for(String keyAlun: this.structOriginal.keySet()){
			for(String keyProf: this.structReplica.keySet()){
				if(this.compare(this.structReplica.get(keyProf), this.structOriginal.get(keyAlun))){
					correct.add(keyAlun);
					break;
				}
			}
			
		}
		if(this.structReplica.size() == correct.size()){
			return true;
		}
		return false;
	}
	
	public List<String> correct(){
		return this.correct;
	}
	
}
