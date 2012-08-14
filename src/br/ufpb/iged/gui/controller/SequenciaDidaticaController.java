package br.ufpb.iged.gui.controller;


import br.ufpb.iged.IGEDProperties;
import br.ufpb.iged.model.SequenciaDidatica;
import java.io.File;
import java.util.List;

/**
 * @author Renan Oliveira
 */
public class SequenciaDidaticaController {
    
    private File file;
    

    public List<SequenciaDidatica> listaDeSequenciaDidatica(String filtro){
    
        return null;        
    
    }
    
    public void salvarSequenciaDidatica(SequenciaDidatica sequenciaDidatica){
        
        //CRIAR PASTA CASO NÃO EXISTA
        
        
        
        //CONVERTER O ARQUIVO EM XML
        
        
        //SALVAR O ARQUIVO NO HD
        //CRIAR UMA PASTA        
        String path = IGEDProperties.getInstance().getPropety("tarefasPath");
        
        file = new File(path);
        
        
        //CRIAR O XML
    
    }
    
}
