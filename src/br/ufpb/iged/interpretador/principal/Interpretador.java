package br.ufpb.iged.interpretador.principal;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.RuleReturnScope;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenStream;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeNodeStream;
import org.antlr.runtime.tree.TreeAdaptor;
import org.antlr.runtime.tree.CommonTreeAdaptor;

import br.ufpb.iged.GraficoAED;
import br.ufpb.iged.IGED;
import br.ufpb.iged.IGEDConst;
import br.ufpb.iged.grafico.manager.Quadro;
import br.ufpb.iged.interpretador.bytecodeassembler.asm.BytecodeAssembler;
import br.ufpb.iged.interpretador.bytecodeassembler.asm.Definicao;
import br.ufpb.iged.interpretador.parser.AssemblerLexer;
import br.ufpb.iged.interpretador.excecoes.AcessoIndevidoMemoriaException;
import br.ufpb.iged.interpretador.excecoes.ClassNotFoundException;
import br.ufpb.iged.interpretador.excecoes.LabelException;
import br.ufpb.iged.interpretador.symboltable.classes.BytecodesAST;
import br.ufpb.iged.interpretador.symboltable.classes.BytecodesErrorNode;
import br.ufpb.iged.interpretador.symboltable.classes.SimboloClasse;
import br.ufpb.iged.interpretador.symboltable.classes.SimboloMetodo;
import br.ufpb.iged.interpretador.symboltable.classes.TabelaSimbolos;
import br.ufpb.iged.interpretador.parser.Def;
import br.ufpb.iged.interpretador.parser.Ref;

public class Interpretador {
	
	public static GraficoAED con;
			
	private static final String DIRETORIO_FONTE = "./classes";
				
	public static TabelaSimbolos tabelaSimbolos;
	
	private static BytecodeAssembler assembler;
	
	private static MaquinaVirtual vm;
	
	private static CommonTokenStream tokens = new CommonTokenStream();
	
	private static CommonTree tree = new CommonTree();
	
	private static Map<String, Integer> variaveisCriadas = new HashMap<String, Integer>();
	
	public Interpretador() {
		
		con = new GraficoAED();
		
	}
	
	public void init(){
		con.endCommand();
	}
	
	public Quadro getQuadro() {
	      return con.quadro();
	}

	public boolean taskIsCorrect(){
	     return con.correctTask();
	}
	
	public void setMode(int mode){
        con.setMode(mode);
    }

    public void clear() {
        con.clearStruct();
        con.endCommand();
    }
	
	public static TreeAdaptor bytecodesAdaptor = new CommonTreeAdaptor() {
		
        public Object create(Token token) {
            return new BytecodesAST(token);
        }
        
        public Object dupNode(Object t) {
            if ( t==null ) {
                return null;
            }
            return create(((BytecodesAST)t).token);
        }
        
        public Object errorNode(TokenStream input, Token start, Token stop,
                                RecognitionException e)
        {
            BytecodesErrorNode t = new BytecodesErrorNode(input, start, stop, e);
            return t;
        }
        
    };

	public void interpretar() {
		
		try {
			
			carregar();
			
			vm = new MaquinaVirtual(Interpretador.getAssembler().getConstantPool());
			
			executarMain();
			
			
		} catch (IOException ioe) {

			System.out.println(ioe.getMessage());

		} catch (LabelException le) {
			
			System.out.println(le.getMessage());
			
		} catch (AcessoIndevidoMemoriaException aime) {
			
			System.out.println(aime.getMessage());
		
		} catch (ClassNotFoundException e) {
			
			System.out.println(e.getMessage());
			
		} catch (RecognitionException e) {
			
			System.out.println(e.getMessage());
			
		}
			

	}
	
	public static void executarMain() throws ClassNotFoundException {
						
		SimboloClasse principal = ClassLoader.carregarClasseMain();
		SimboloMetodo main = (SimboloMetodo) principal.resolver("main(VOID)V");
		
		vm.iniciarNovoMetodo("Main", null, main, true);
		vm.cpu();	
		
	}

	public static void carregar() 
			throws IOException, LabelException, 
				AcessoIndevidoMemoriaException, RecognitionException {
		
			File file = new File(DIRETORIO_FONTE);
		
			String[] arquivos = file.list();
			
		    int i;
		    
			for (i = 0; i < arquivos.length; i++){
			
				if (arquivos[i].endsWith(".j")) {
					
					ANTLRFileStream input = 
							new ANTLRFileStream(DIRETORIO_FONTE+"/"+arquivos[i]);
					
					//entrada.append(input.toString());
					
						
						System.err.println("Analisando arquivo "+arquivos[i]);
						
						parse(input);
						
					
				}
			
			}
			
			
	        tabelaSimbolos = new TabelaSimbolos(); 
            
            montar();
		
	}
	
	public static void parse(ANTLRFileStream input) throws RecognitionException{
		
		StringBuffer entrada = new StringBuffer();
		entrada.append(input.toString());
		
		CharStream inputChar = new ANTLRStringStream(entrada.toString());
		
		AssemblerLexer lexer = new AssemblerLexer(inputChar);
		CommonTokenStream toks = new CommonTokenStream(lexer);
		BytecodeAssembler parser = new BytecodeAssembler(toks, Definicao.instrucoes);
		parser.setTreeAdaptor(bytecodesAdaptor);
		RuleReturnScope r = parser.programa(); 
		CommonTree arv = (CommonTree)r.getTree();
		tokens.getTokens().addAll(toks.getTokens());
		tree.addChild(arv);
		
	}
	
	public static void montar() throws LabelException, AcessoIndevidoMemoriaException {
		
			/*BytecodeAssembler parser = null;
				
			CharStream input = new ANTLRStringStream(entrada.toString());
			
			AssemblerLexer lexer = new AssemblerLexer(input);
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			parser = new BytecodeAssembler(tokens, Definicao.instrucoes);
			parser.setTreeAdaptor(bytecodesAdaptor);
			RuleReturnScope r = parser.programa();  			
			CommonTree tree = (CommonTree)r.getTree(); */
		   
		    assembler = new BytecodeAssembler(tokens, Definicao.instrucoes);
		
			CommonTreeNodeStream nos = new CommonTreeNodeStream(bytecodesAdaptor, tree);
			nos.setTokenStream(tokens);
			Def def = new Def(nos, tabelaSimbolos);       
			def.downup(tree);
		    nos.reset();
		    Ref ref = new Ref(nos, tabelaSimbolos, assembler);
			ref.downup(tree);
		
	}
	
	public static int referenceField(String field) {
        if (field != null) {
            if (field.equals("next")) {
                return IGEDConst.NODE_PROX;
            } else {
                if (field.equals("init")) {
                    return IGEDConst.LISTA_INICIO;
                }else{
                	if(field.equals("node_root")){
                		return IGEDConst.NODE_TREE_ROOT;
                	}else{
                		if(field.equals("left_chield")){
                			return IGEDConst.LEFT_CHIELD;
                		}else{
                			if(field.equals("right_chield")){
                    			return IGEDConst.RIGHT_CHIELD;
                			}
                		}
                	}
                }
            }
        }
        return -1;
    }
	
	public static void criarEstrutura(String tipo, int tamanho) {
		
		con.writeStructLength(tamanho);
		
		if (tipo.equals("LList"))
			con.createStruct(IGEDConst.LISTA);
		else if (tipo.equals("LNodeList"))
			con.createStruct(IGEDConst.NODE);
		else if (tipo.equals("LNodeTree"))
			con.createStruct(IGEDConst.NODE_TREE);
		else if (tipo.equals("LBinaryTree"))
			con.createStruct(IGEDConst.BINARY_TREE);
		else if (tipo.equals("[I"))
			con.createStruct(IGEDConst.VETOR);

		
	}
	
	public static String obterIdentificadorVariavel(StackFrame frame, int endereco) {
		
		String id = "";
		String idRev = "";
		
		char[]alfabeto= {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
				'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
				'u', 'v', 'w', 'x', 'y', 'z'};
		
		int div = endereco;
		do{
			int mod = div % 26;
			div = (int) div / 26;
			idRev += alfabeto[mod];
		}while(div > 0);
		
		for (int i = idRev.length() - 1; i >= 0; i--)
			id += idRev.charAt(i);
		
		return obterPrefixoVariavel(frame)+id;
		
    }
	
	public static String obterIdentificadorCampo(StackFrame frame, List<Objeto> heap, boolean estatico, int sp, int endereco){
		
		String formId = "";
		
		if (sp > 0) {
			
			Valor valor = frame.pilhaOperandos[sp - 1];
		
			if ((sp - 1) > 0){
				
				Referencia referenciaDeBaixo = (Referencia)frame.pilhaOperandos[sp - 2];
				
				if (valor != referenciaDeBaixo) {
				
					Objeto objetoDeBaixo = heap.get((Integer)referenciaDeBaixo.getValor());
									
					Objeto objeto = heap.get((Integer)valor.getValor());
					
					SimboloClasse classe = (SimboloClasse)tabelaSimbolos.global.resolver(objeto.getNome());
					
					formId = classe.obterIdentificadorVariavel(endereco, estatico);
					
					endereco = Arrays.asList(objetoDeBaixo.getMemoriaLocal()).indexOf(valor);
					
					
				} else
					
					formId = ""; 
			
			} else if ((sp - 1) == 0) {
							
				Objeto objeto = heap.get((Integer)valor.getValor());
				
				SimboloClasse classe = (SimboloClasse)tabelaSimbolos.global.resolver(objeto.getNome());
						
				formId = classe.obterIdentificadorVariavel(endereco, estatico);
				
				endereco = Arrays.asList(frame.variaveis).indexOf(valor);
			
			}
			
		} else {
			
			formId = obterIdentificadorVariavel(frame, endereco);

			return formId;
		}

		
		formId = obterIdentificadorCampo(frame, heap, estatico,  sp - 1, endereco) + "."+formId;
			
		return formId;
	}
	
	public static String obterIdentificadorCampoGet(StackFrame frame, List<Objeto> heap, boolean estatico, int sp, int endereco){
		
		Referencia referencia = (Referencia)frame.pilhaOperandos[sp];

		Objeto objeto = heap.get((Integer)referencia.getValor());
		
		SimboloClasse classe = (SimboloClasse)tabelaSimbolos.global.resolver(objeto.getNome());

		String formId = classe.obterIdentificadorVariavel(endereco, estatico);
		
		if (sp > 0){
			
			Referencia referenciaDeBaixo = (Referencia)frame.pilhaOperandos[sp - 1];
			
			if (referencia != referenciaDeBaixo){
			
				Objeto objetoDeBaixo = heap.get((Integer)referenciaDeBaixo.getValor());
	
				endereco = Arrays.asList(objetoDeBaixo.getMemoriaLocal()).indexOf(referencia);
	
				formId = obterIdentificadorCampoGet(frame, heap, estatico,  sp - 1, endereco) + "."+formId;
				
			} else {
				
				formId = "";
				
				formId = obterIdentificadorCampoGet(frame, heap, estatico,  sp - 1, endereco);
				
			}
							
			
		} else {
			
			endereco = Arrays.asList(frame.variaveis).indexOf(referencia);
			
			formId = obterIdentificadorVariavel(frame, endereco) + "." + formId;
			
		}
					
		return formId;
		
	}
	
	public static String obterIdentificadorCampo(SimboloClasse classe, StackFrame frame, int endereco, boolean estatico){
		
		return frame.pilhaOperandos[frame.sp - 1]+"."+classe.obterIdentificadorVariavel(endereco, estatico);
		
	}
	
	private static String obterPrefixoVariavel(StackFrame frame){
		
		if (frame.getProprietario().equals("Main"))
			return "";
		
		return frame.getProprietario()+"."+frame.getMetodo().obterNomeSimples()+".";
		
	}
	
	public static void criarVariavelGrafica(String id, String tipo, int endereco) {
		
		if (tipo.equals("I")) 			
			Interpretador.con.creat_Int(id);		
		else if (tipo.equals("LList"))
			Interpretador.con.createReference(id, IGEDConst.LISTA);
		else if (tipo.equals("LNodeList"))
			Interpretador.con.createReference(id, IGEDConst.NODE);
		else if (tipo.equals("LNodeTree"))
			Interpretador.con.createReference(id, IGEDConst.NODE_TREE);
		else if (tipo.equals("[I"))
			Interpretador.con.createReference(id, IGEDConst.VETOR);
		else if (tipo.equals("LBinaryTree"))
			Interpretador.con.createReference(id, IGEDConst.BINARY_TREE);
		else 
			Interpretador.con.creat_Int(id);
		
		variaveisCriadas.put(id, endereco);
		
	}
	
	public static boolean ehTipoEstruturaDeDadosReferencia(String tipo){
		
		if (tipo.equals("LList") || tipo.equals("LNodeList") 
				|| tipo.equals("LNodeTree") || tipo.equals("LBinaryTree"))
			
			return true;
		
		return false;
		
	}
	
	public static BytecodeAssembler getAssembler() {
		return assembler;
	}

	public static void setAssembler(BytecodeAssembler assembler) {
		Interpretador.assembler = assembler;
	}

	public static MaquinaVirtual getVm() {
		return vm;
	}

	public static void setVm(MaquinaVirtual vm) {
		Interpretador.vm = vm;
	}

	public static Map<String, Integer> getVariaveisCriadas() {
		return variaveisCriadas;
	}

	public static void setVariaveisCriadas(Map<String, Integer> variaveisCriadas) {
		Interpretador.variaveisCriadas = variaveisCriadas;
	}
	

}
