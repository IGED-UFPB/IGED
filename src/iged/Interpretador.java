package iged;

import iged.grafico.manager.Quadro;
import java.util.StringTokenizer;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author GILBERTO FARIAS
 */
public class Interpretador {

    private static GraficoAED con = new GraficoAED();

    public Quadro getQuadro() {
        return con.quadro();
    }

    public void init() {
        /*con.createReference("l", Struct.LISTA);
        con.createStruct(Struct.LISTA);
        con.writeReference();
        //con.readReference("l");
        //con.writeInfo(10);
        
        /*con.createReference("v", Struct.VETOR);
        con.setPosVector(4); //asdasdas o erro � pq ele ta criando um vetor com 0 casas pq na criacao do vc nao ta atualizando
        con.createStruct(Struct.VETOR);
        con.writeReference();*/

        con.endCommand();
    }

    public void interprete(String comando) {
        StringTokenizer st = new StringTokenizer(comando);
        String metodo = st.nextToken();
        System.out.println("METODO:" + metodo);
        if (metodo.equals("CREATE_STRUCT")) {
            String tipo = st.nextToken();
            if (tipo.equals("NODE")) {
                con.createStruct(IGEDConst.NODE);
            } else {
                if (tipo.equals("VECTOR")) {
                    String s = st.nextToken();
                    if ((s == null) || s.isEmpty()) {
                        return;
                    }
                    try {
                        int size = Integer.parseInt(s);
                        con.setPosVector(size);
                        con.createStruct(IGEDConst.VETOR);
                    } catch (Exception e) {
                    }
                } else {
                    if (tipo.equals("LIST")) {
                        con.createStruct(IGEDConst.LISTA);
                    }
                }
            }
        } else {
            if (metodo.equals("CREATE_REF")) {
                String tipo = st.nextToken();
                String var = st.nextToken();
                if ((var != null) && (!var.equals(""))) {
                    if (tipo.equals("NODE")) {
                        con.createReference(var, IGEDConst.NODE);
                    } else {
                        if (tipo.equals("VECTOR")) {
                            con.createReference(var, IGEDConst.VETOR);
                        } else {
                            if (tipo.equals("LIST")) {
                                con.createReference(var, IGEDConst.LISTA);
                            }
                        }
                    }
                }
            } else {
                if (metodo.equals("WRITE_REF")) {
                    con.writeReference();
                } else {
                    if (metodo.equals("END_COMMAND")) {
                        con.endCommand();
                    } else {
                        if (metodo.equals("READ_REF")) {
                            String var = st.nextToken();
                            if ((var != null) && (!var.equals(""))) {
                                con.readReference(var);
                            }
                        } else {
                            if (metodo.equals("WRITE_INFO")) {
                                String s = st.nextToken();
                                if ((s == null) || s.isEmpty()) {
                                    return;
                                }
                                try {
                                    int v = Integer.parseInt(s);
                                    con.writeStructInfo(v);
                                } catch (Exception e) {
                                }
                            } else {
                                if (metodo.equals("WRITE_REF_FIELD")) {
                                    int field = Interpretador.referenceField(st.nextToken());
                                    if (field != -1) {
                                        con.writeReferenceField(field);
                                    }
                                } else {
                                    if (metodo.equals("READ_REF_FIELD")) {
                                        int field = Interpretador.referenceField(st.nextToken());
                                        if (field != -1) {
                                            con.readReferenceField(field);
                                        }
                                    } else {
                                        if (metodo.equals("READ_INFO")) {
                                            con.readStructInfo();
                                        } else {
                                            if (metodo.equals("REMOVE_REF")) {
                                                String var = st.nextToken();
                                                if ((var != null) && (!var.equals(""))) {
                                                    con.removeReference(var);
                                                }
                                            } else {
                                                if (metodo.equals("WRITE_REF_FIELD_NULL")) {
                                                    int field = Interpretador.referenceField(st.nextToken());
                                                    if (field != -1) {
                                                        con.writeReferenceFieldNull(field);
                                                    }
                                                } else {
                                                    if (metodo.equals("CREATE_INT")) {
                                                        String var = st.nextToken();
                                                        if ((var != null) && (!var.equals(""))) {
                                                            con.creat_Int(var);
                                                        }
                                                    } else {
                                                        if (metodo.equals("DELETE_INT")) {
                                                            String var = st.nextToken();
                                                            if ((var != null) && (!var.equals(""))) {
                                                                con.remove_int(var);
                                                            }
                                                        } else {
                                                            if (metodo.equals("LOAD_INT")) {
                                                                String var = st.nextToken();
                                                                if ((var != null) && (!var.equals(""))) {
                                                                    con.readReferenceInt(var);
                                                                }

                                                            } else {
                                                                if (metodo.equals("WRITE_INT")) {
                                                                    String s = st.nextToken();
                                                                    if ((s == null) || s.isEmpty()) {
                                                                        return;
                                                                    }
                                                                    try {
                                                                        int v = Integer.parseInt(s);
                                                                        con.setValueInt(v);
                                                                    } catch (Exception e) {
                                                                    }
                                                                } else {
                                                                    if (metodo.equals("READ_INT")) {
                                                                        String var = st.nextToken();
                                                                        if ((var != null) && (!var.equals(""))) {
                                                                            con.ler_Int(var);
                                                                        }
                                                                    } else {
                                                                        if (metodo.equals("WRITE_LENGTH")) {
                                                                            String s = st.nextToken();
                                                                            if ((s == null) || s.isEmpty()) {
                                                                                return;
                                                                            }
                                                                            try {
                                                                                int v = Integer.parseInt(s);
                                                                                con.writeStructLength(v);
                                                                            } catch (Exception e) {
                                                                            }
                                                                        }else{
                                                                            if (metodo.equals("SET_POS_VET")) {
                                                                                String s = st.nextToken();
                                                                                if ((s == null) || s.isEmpty()) {
                                                                                    return;
                                                                                }
                                                                                try {
                                                                                    int v = Integer.parseInt(s);
                                                                                    con.setPosVector(v);
                                                                                } catch (Exception e) {
                                                                                }
                                                                            }else{
                                                                                if (metodo.equals("DELETE_REF")) {
                                                                                    String var = st.nextToken();
                                                                                    if ((var != null) && (!var.equals(""))) {
                                                                                        con.removeReference(var);
                                                                                 
                                                                                    }
                                                                                }else{
                                                                                    
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }

                        }
                    }
                }
            }
        }
    }

    public static int referenceField(String field) {
        if (field != null) {
            if (field.equals("NEXT")) {
                return IGEDConst.NODE_PROX;
            } else {
                if (field.equals("INIT")) {
                    return IGEDConst.LISTA_INICIO;
                }
            }
        }
        return -1;
    }
}
