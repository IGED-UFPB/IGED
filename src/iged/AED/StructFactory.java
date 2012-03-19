package iged.AED;

import iged.IGEDConst;

public class StructFactory {

	private int lengthStruct = 10;
        private static StructFactory sf = null;
        
        
        private StructFactory(){
            
        }
                
        public static synchronized StructFactory getInstance(){
            if(sf == null){
                sf = new StructFactory();
            }
            return sf;
        }
        
	public Struct createStruct(int type) {
		Struct s;
                switch (type) {
                    case IGEDConst.LISTA:
			s = new LinkedList();
			break;
                    case IGEDConst.VETOR:
			s = new Vector(lengthStruct);
			break;
                    case IGEDConst.NODE:
			s = new LinkedListNode();
			break;
                    default:
                        return null;

		}
                return s;
                //StructManager.pilha.add(new WrapperStruct(s));
	}
        
	/*public WrapperStruct duplicateStruct(Struct s) {
		if (s != null) {
                    switch (s.getType()) {

			case IGEDConst.VETOR:
				this.lengthStruct = ((Vector) s).getLength();
				this.createStruct(IGEDConst.VETOR);
                                return StructManager.pilha.pop();
			case IGEDConst.LISTA:
				this.createStruct(IGEDConst.LISTA);
                                return StructManager.pilha.pop();
                        case IGEDConst.NODE:
                                this.createStruct(IGEDConst.NODE);
                                return StructManager.pilha.pop();
                        default:
                                return null;
                    }
		}
                else {
			this.createStruct(IGEDConst.LISTA);
                        return StructManager.pilha.pop();
		}
	}*/

        
	public void setLengthStruct(int lengthStruct) {
		this.lengthStruct = lengthStruct;
	}

	public int getLengthStruct() {
		return this.lengthStruct;
	}

}
