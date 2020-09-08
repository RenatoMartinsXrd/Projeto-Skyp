/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebService;


import Modelo.Bean.*;
import dao.usuarioDAO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import controller.*;
import dao.TurmaProfessorDAO;
import dao.UsuariotestDAO;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import static javafx.scene.input.KeyCode.T;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Application;

/**
 * REST Web Service
 *
 * @author Automação
 */



@Path("generic")
public class SkypWS {

    @Context
    private UriInfo context;
    private static final String CHARSET_UTF8 = ";charset=utf-8";

    /**
     * Creates a new instance of SkypWS
     */
    public SkypWS() {
    }

    /**
     * Retrieves representation of an instance of WebService.SkypWS
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/text")
    public String getJson() {
        //TODO return proper representation object
        return "Meu Primeiro WebService melhor";
    }
    
     @GET
    @Produces("application/json")
     @Path("exemploteste/get")
    public String getExemplo() {
      Usuario user = new Usuario();
      user.setLogin("cuz1");
      user.setSenha("inexistente");
      Gson gson = new Gson();
      //Convertendo para JSON o objeto 
        return gson.toJson(user);
    }
    
         @GET
    @Produces("application/json")
     @Path("exemploteste2/get")
    public String getExemplos() {
      Usuario user = new Usuario();
      user.setLogin("cuz1");
      user.setSenha("massa de mais");
      Gson gson = new Gson();
      //Convertendo para JSON o objeto 
        return gson.toJson(user);
    }
  
      @GET
    @Produces("application/json")
     @Path("exemplotesteComLista/get")
    public List<Usuario> getExemploLista() {
        
        List<Usuario> lista = new ArrayList<Usuario>();
      Usuario user = new Usuario();
      user.setLogin("cuz1");
      user.setSenha("inexistente1");
      lista.add(user);
      
      user = new Usuario();
      user.setLogin("cuz1");
      user.setSenha("inexistente2");
      lista.add(user);
   
      user = new Usuario();
      user.setLogin("cuz2");
      user.setSenha("inexistente3");
      lista.add(user);
    
      user = new Usuario();
      user.setLogin("cuz3");
      user.setSenha("inexistente4");
      lista.add(user);
      
      Gson gson = new Gson();
      //Convertendo para JSON o objeto 
        return lista;
    }
    
    @GET
    @Produces("application/json")
     @Path("Usuario/list")
    public String getUsuario() {
        
         List<Usuario> lista = new ArrayList<Usuario>();
    usuarioDAO dao = new usuarioDAO();
      
      lista = dao.ListarTudoTeste();
      
      Gson gson = new Gson();
      //Convertendo para JSON o objeto 
        return gson.toJson(lista);
    }
    @GET
	@Path("/listarTodos")
	@Produces("application/json")
	public String listarTodos(){
              Gson gson = new Gson();
        ArrayList<Usuario> listarTodos = new UsuarioController().listarTodos();
		return gson.toJson(listarTodos);
	}
        
        
      @GET
    @Produces("application/json")
     @Path("SelecionarLoginProfessor/{Login},{Senha}")
    public String getAutenticarUsuario(@PathParam("Login") String Login, @PathParam("Senha") String Senha) {
        
        
                 Usuario u = new Usuario();
                 u.setLogin(Login);
                   Usuario a = new Usuario();
                   a.setSenha(Senha);
                 ArrayList lista = new UsuarioController().SelecionarLogin(u,a);
                 
              
      
    Gson gson = new Gson();
    
       
  
		return gson.toJson(lista);
    }
    
      @GET
       @Path("SelecionarLoginObjeto/{Login},{Senha}")
      @Consumes(MediaType.TEXT_PLAIN + CHARSET_UTF8)
    @Produces(MediaType.APPLICATION_JSON + CHARSET_UTF8)
    
    public String getUsuario(@PathParam("Login") String Login, @PathParam("Senha") String Senha) {
        
        
                 Usuario u = new Usuario();
                 u.setLogin(Login);
                   Usuario a = new Usuario();
                   u.setSenha(Senha);
              Professor lista = new UsuarioController().SelecionarLoginObject(u);
                 
              
      
    Gson gson = new Gson();
    
       
  
		return gson.toJson(lista);
    }
    
  
     @GET
    @Produces("application/json")
     @Path("SelecionarSecretaria/{LoginS},{SenhaS}")
    public String getAutenticarSecretaria(@PathParam("LoginS") String Login, @PathParam("SenhaS")String Senha) {
        
        
               Secretaria s = new Secretaria();
               Secretaria s2 = new Secretaria();
               s.setLogin(Login);
               s2.setSenha(Senha);
              
             boolean lista = new SecretariaController().SelecionarLoginSecretaria(s,s2);
                 
              
      
    Gson gson = new Gson();
    
       
  
		return gson.toJson(lista);
    }
    
    
     @GET
    @Produces("application/json")
     @Path("SelecionarSecretariaObjeto/{LoginS},{SenhaS}")
    public String getAutenticarSecretariaObjeto(@PathParam("LoginS") String Login, @PathParam("SenhaS")String Senha) {
               Secretaria s2 = new Secretaria();
               s2.setLogin(Login);
               s2.setSenha(Senha);
             boolean lista = new SecretariaController().SelecionarLoginSecretariaObjeto(s2);
    Gson gson = new Gson();
		return gson.toJson(lista);
    }
    
     @GET
    @Produces("application/json")
     @Path("SelecionarLoginAluno/{LoginS},{SenhaS}")
    public String getAutenticarLoginAluno(@PathParam("LoginS") String Login, @PathParam("SenhaS")String Senha) {
               UsuarioAluno s2 = new  UsuarioAluno();
               s2.setLogin(Login);
               s2.setSenha(Senha);
            UsuarioAluno lista = new  UsuarioAlunoController().SelecionarId_UsuarioAluno(s2);
    Gson gson = new Gson();
		return gson.toJson(lista);
    }
    
      @GET
	@Path("/listarBimestre")
	@Produces("application/json")
	public String listarBimestre(){
              Gson gson = new Gson();
        ArrayList<Bimestre> listarTodos = new BimestreController().listarBimestre();
		return gson.toJson(listarTodos);
	}
        
             @GET
	@Path("/listarId_Bimestre/{Bimestre}")
	@Produces("application/json")
	public String listarId_Bimestre(@PathParam("Bimestre") String b){
            Bimestre bi = new Bimestre();
            bi.setBimestre(b);
              Gson gson = new Gson();
        ArrayList<Bimestre> listarTodos = new BimestreController().listarId_Bimestre(bi);
		return gson.toJson(listarTodos);
	}
     
    
 
    
    @POST
    @Path("Usuario/inserir")
    @Consumes({MediaType.APPLICATION_JSON + CHARSET_UTF8})
    @Produces(MediaType.TEXT_PLAIN)
   
public boolean inserirUsuario(String content){
     Gson g = new Gson();
     Usuario u = (Usuario) g.fromJson(content,  Usuario.class);
         boolean lista = new UsuarioController().InserirUsuario(u);
        usuarioDAO dao = new usuarioDAO();  
 
        return lista;
}

    @POST
    @Consumes({"application/json"})
    @Path("Turma/inserir")
public boolean inserirTurma(String content){
     Gson g = new Gson();
     Turma t = (Turma) g.fromJson(content,  Turma.class);
         boolean lista = new TurmaController().InserirTurma(t);
        return lista;
}

   @GET
	@Path("/listarTodasTurmas")
	@Produces("application/json")
	public String listarTodasTurmas(){
              Gson gson = new Gson();
        ArrayList<Turma> listarTodos = new TurmaController().SelecionarTodasTurmas();
		return gson.toJson(listarTodos);
	}
      
        
         @GET
	@Path("/listarId_TurmaSerie/{Serie}")
	@Produces("application/json")
	public String listarId_TurmaSerie(@PathParam("Serie") String Serie){
              Gson gson = new Gson();
              Turma tur = new Turma();
              tur.setSerie(Serie);
        ArrayList<Turma> listarTodos = new TurmaController().SelecionarId_TurmaSerie(tur);
		return gson.toJson(listarTodos);
	}
        
    @POST
    @Consumes({"application/json"})
    @Path("TurmaProfessor/inserir")
public boolean inserirTurmaProfessor(String content){
     Gson g = new Gson();
     TurmaProfessor t = (TurmaProfessor) g.fromJson(content,  TurmaProfessor.class);
         boolean lista = new TurmaProfessorController().InserirTurma(t);
       
        return  lista;
}

 @POST
    @Consumes({"application/json"})
    @Path("ProfessorCadastro/inserir")
public boolean inserirProfessorCadastro(String content){
     Gson g = new Gson();
     ProfessorCadastro t = (ProfessorCadastro) g.fromJson(content,  ProfessorCadastro.class);
         boolean lista = new ProfessorCadastroController().InserirProfessorCadastro(t);
         
  
     
        
        
   
        return lista;
}

 @POST
    @Consumes({"application/json"})
    @Path("ProfessorUsuario/inserir")
public boolean inserirProfessorUsuario(String content){
     Gson g = new Gson();
     Professor t = (Professor) g.fromJson(content,  Professor.class);
         boolean lista = new ProfessorController().InserirProfessorUsuario(t);
         
  
     
        
        
   
        return lista;
}

   @GET
	@Path("listarTododProfessores")
	@Produces("application/json")
	public String listarTododProfessores(){
              Gson gson = new Gson();
        ArrayList<ProfessorCadastro> listarTodos = new ProfessorCadastroController().SelecionarTodosProfesosres();
		return gson.toJson(listarTodos);
	}
        
                   @GET
	@Path("/listarId_Professor/{Nome}")
	@Produces("application/json")
	public String listarId_Professor(@PathParam("Nome") String b){
          ProfessorCadastro bi = new ProfessorCadastro();
            bi.setNome(b);
              Gson gson = new Gson();
         ProfessorCadastro listarTodos = new  ProfessorCadastroController().SelecionarId_Professor(bi);
		return gson.toJson(listarTodos);
	}
        
          @GET
        @Path("/listarDisciplina/{Id_Professor}")
	@Produces("application/json")
	public String listarProfessorComId_Professor(@PathParam("Id_Professor") int b){
          ProfessorCadastro bi = new ProfessorCadastro();
            bi.setId_Professor(b);
              Gson gson = new Gson();
         ProfessorCadastro listarTodos = new  ProfessorCadastroController().SelecionarProfessorComId_Profesosr(bi);
		return gson.toJson(listarTodos);
	}


              @GET
	@Path("/listarCpfCadastro/{Cpf}")
	@Produces("application/json")
	public String listarCpfProfessor(@PathParam("Cpf") String b){
          ProfessorCadastro bi = new ProfessorCadastro();
            bi.setCPF(b);
              Gson gson = new Gson();
         ArrayList<ProfessorCadastro> listarTodos = new  ProfessorCadastroController().SelecionarCpfCadastro(bi);
		return gson.toJson(listarTodos);
	}

@POST
    @Consumes({"application/json"})
    @Path("Aluno/inserir")
public boolean inserirAluno(String content){
     Gson g = new Gson();
     Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create(); // your format
     Aluno a = (Aluno) gson.fromJson(content,  Aluno.class);
         boolean lista = new AlunoController().InserirAluno(a);
         
  
     
        
        
   
        return lista;
}

 @GET
    @Produces("application/json")
     @Path("SelecionarAlunoRa/{RA}")
    public String getSelecionarId_AlunoRA(@PathParam("RA") String RA) {
             Aluno s2 = new Aluno();
               s2.setRA(RA);
           
             Aluno lista = new AlunoController().SelecionarId_AlunoRA(s2);
    Gson gson = new Gson();
		return gson.toJson(lista);
    }
    
    @POST
    @Consumes({"application/json"})
    @Path("UsuarioAluno/inserir")
public boolean inserirUsuarioAluno(String content){
     Gson gson = new Gson();
 
    UsuarioAluno a = (UsuarioAluno) gson.fromJson(content,  UsuarioAluno.class);
         boolean lista = new UsuarioAlunoController().Salvar(a);
        return lista;
}
    
    
    @GET
    @Produces("application/json")
     @Path("SelecionarId_Alunos/{Id_Turma},{Nome}")
    public String getListarId_Alunos(@PathParam("Id_Turma") int Id_Turma, @PathParam("Nome") String Nome) {
        
        
                 Aluno u = new Aluno();
                 u.setId_Turma(Id_Turma);
                 
                   u.setNome(Nome);
                 ArrayList lista = new AlunoController().SelecionarId_Aluno(u);
                 
              
      
    Gson gson = new Gson();
    
       
  
		return gson.toJson(lista);
    }
    
    
       @GET
    @Produces("application/json")
     @Path("SelecionarCpfs/{CPF}")
    public String getListarCpfNovoLogin(@PathParam("CPF") String CPF) {
        
        
                 ProfessorCadastro u = new ProfessorCadastro();
                 u.setCPF(CPF);
                 
                 
                 boolean lista = new ProfessorCadastroController().ValidarCpf(u);
                 
              
      
    Gson gson = new Gson();
    
       
  
		return gson.toJson(lista);
    }


@POST
    @Consumes({"application/json"})
    @Path("Chamada/inserir")
public boolean inserirChamada(String content){
     Gson gson = new Gson();
 
     Chamada a = (Chamada) gson.fromJson(content,  Chamada.class);
         boolean lista = new ChamadaController().InserirChamada(a);
         
  
     
        
        
   
        return lista;
}

@POST
    @Consumes({"application/json"})
    @Path("Nota/inserir")
public boolean inserirNota(String content){
     Gson gson = new Gson();
 
    Nota a = (Nota) gson.fromJson(content,  Nota.class);
         boolean lista = new NotaController().InserirNota(a);
         
  
     
        
        
   
        return lista;
}


@POST
    @Consumes({"application/json"})
    @Path("Frequencia/inserir")
public boolean inserirFrequencia(String content){
     Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
 
    Frequencia a = (Frequencia) gson.fromJson(content,  Frequencia.class);
         boolean lista = new FrequenciaController().Salvar(a);
         
  
     
        
        
   
        return lista;
}

 @GET

     @Path("DeletarChamada/{Id_Turma}")
       @Produces({"application/json"})
     
    public String DeleteChamada(@PathParam("Id_Turma") int Id_Turma) {
              Chamada ch = new  Chamada();
               ch.setId_Turma(Id_Turma); 
           boolean lista = new ChamadaController().DeletarAluno(ch);
    Gson gson = new Gson();
		return gson.toJson(lista);
    }



      @GET
      
	@Path("/listarChamadaId_Turma/{Id_Turma}")
	@Produces("application/json")
	public String SelecionarChamadaId_TurmaSerie(@PathParam("Id_Turma") int Id_Turma){
              Gson gson = new Gson();
             Chamada tur = new Chamada();
              tur.setId_Turma (Id_Turma);
        ArrayList<Chamada> listarTodos = new ChamadaController().SelecionarChamadaId_TurmaSerie(tur);
        return gson.toJson(listarTodos);
	}

 @GET

     @Path("AutenticarChamada/{Nome},{Numero_Chamada}")
       @Produces({"application/json"})
     
    public String AutentiqueChamada(@PathParam("Nome") String Nome,@PathParam("Numero_Chamada") int Numero ) {
              Chamada ch = new  Chamada();
               ch.setNome(Nome); 
               ch.setNumero_Chamada(Numero);
           boolean lista = new ChamadaController().AutenticarListaChamada(ch);
    Gson gson = new Gson();
		return gson.toJson(lista);
    }













     @GET

     @Path("DeletarAluno/{Id_Aluno}")
       @Produces({"application/json"})
     
    public String DeleteAluno(@PathParam("Id_Aluno") int Id_Aluno) {
               Aluno s = new Aluno();
               Secretaria s2 = new Secretaria();
               s.setId_Aluno(Id_Aluno); 
           boolean lista = new AlunoController().DeletarAluno(s);
    Gson gson = new Gson();
		return gson.toJson(lista);
    }


    
    

      @GET
      
	@Path("/listarAlunos/{Id_Turma}")
	@Produces("application/json")
	public String listarId_TurmaSerie(@PathParam("Id_Turma") int Id_Turma){
              Gson gson = new Gson();
              Gson gson2 = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
             Aluno tur = new Aluno();
              tur.setId_Turma (Id_Turma);
        ArrayList<Aluno> listarTodos = new AlunoController().SelecionarId_Professor(tur);
		return gson2.toJson(listarTodos);
	}
        
        
      @GET
      
	@Path("/listarTurmaProfessor/{Id_Professor}")
	@Produces("application/json")
	public String listarTurmaProfessor(@PathParam("Id_Professor") int Id_Professor){
              Gson gson = new Gson();
            
           TurmaProfessor tur = new TurmaProfessor();
              tur.setId_Professor(Id_Professor);
        ArrayList<TurmaProfessor> listarTodos = new TurmaProfessorController().SelecionarTurmaProfessor(tur);
		return gson.toJson(listarTodos);
	}
        

@POST
    @Consumes({"application/json"})
    @Path("Avaliacao/inserir")
public boolean inserirAvaliacao(String content){
     Gson g = new Gson();
     Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create(); // your format

     
     Avaliacao a = (Avaliacao) gson.fromJson(content ,  Avaliacao.class);
      
   
 
         boolean lista = new AvaliacaoController().InserirAvaliacao(a);
         
  
     
        
        
   
        return lista;
}

@POST
    @Consumes({"application/json"})
    @Path("Conteudo_Programatico/inserir")
public boolean inserirConteudoProgramatico(String content){
     Gson g = new Gson();
     Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create(); // your format

     
     ConteudoProgramatico a = (ConteudoProgramatico) gson.fromJson(content , ConteudoProgramatico.class);
      
   
 
         boolean lista = new ConteudoProgramaticoController().Salvar(a);
         
  
     
        
        
   
        return lista;
}

  
      @GET
    @Produces("application/json")
     @Path("SelecionarAvaliacao/{Id_Professor},{Id_Bimestre},{Id_Turma}")
    public String getSelecionarAvaliacao(@PathParam("Id_Professor") int Id_Professor, @PathParam("Id_Bimestre") int  Id_Bimestre,@PathParam("Id_Turma") int  Id_Turma) {
        
        
              Avaliacao a = new  Avaliacao();
              a.setId_Professor(Id_Professor);
              a.setId_Bimestre(Id_Bimestre);
              a.setId_Turma(Id_Turma);
                 ArrayList lista = new AvaliacaoController().SelecionarAvaliacoes(a);
                 
               Gson gsons = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
      
    Gson gson = new Gson();
    
       
  
		return gsons.toJson(lista);
    }
    
        @GET
    @Produces("application/json")
     @Path("SelecionarNotasBimestre/{Id_Professor},{Id_Turma},{Id_Aluno},{Id_Bimestre}")
    public String getSelecionarNotaBimestre(@PathParam("Id_Professor") int Id_Professor, @PathParam("Id_Turma") int  Id_Turma,@PathParam("Id_Aluno") int  Id_Aluno
    ,@PathParam("Id_Bimestre") int Id_Bimestre) {
        
        
              Nota a = new  Nota();
              a.setId_Professor(Id_Professor);
              a.setId_Bimestre(Id_Bimestre);
              a.setId_Turma(Id_Turma);
              a.setId_Aluno(Id_Aluno);
                   ArrayList<Nota> lista = new NotaController().ConsultarNotasBimestre(a);
                 
      
      
    Gson gson = new Gson();
    
       
  
		return gson.toJson(lista);
    }
    
    
    
        @GET
    @Produces("application/json")
     @Path("SelecionarId_Avaliacao/{Id_Professor},{Id_Bimestre},{Id_Turma},{Titulo}")
    public String getSelecionarUdAvaliacao(@PathParam("Id_Professor") int Id_Professor, @PathParam("Id_Bimestre") int  Id_Bimestre,@PathParam("Id_Turma") int  Id_Turma
    ,@PathParam("Titulo") String Titulo) {
        
        
              Avaliacao a = new  Avaliacao();
              a.setId_Professor(Id_Professor);
              a.setId_Bimestre(Id_Bimestre);
              a.setId_Turma(Id_Turma);
              a.setTitulo(Titulo);
                 Avaliacao lista = new AvaliacaoController().SelecionarIdAvaliacoes(a);
                 
               Gson gsons = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
      
    Gson gson = new Gson();
    
       
  
		return gsons.toJson(lista);
    }
    
    
         @GET
    @Produces("application/json")
     @Path("SelecionarComId_Avaliacao/{Id_Avaliacao}")
    public String getSelecionarComIdAvaliacao(@PathParam("Id_Avaliacao") int Id_Avaliacao) {
        
        
              Avaliacao a = new  Avaliacao();
              a.setId_Avaliacao(Id_Avaliacao);
              
                 Avaliacao lista = new AvaliacaoController().SelecionarAvaliacoesComIdAvaliacao(a);
                 
               Gson gsons = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
      
    Gson gson = new Gson();
    
       
  
		return gsons.toJson(lista);
    }
    
    
     @GET
    @Produces("application/json")
     @Path("SelecionarFrequencia/{Data_entrada},{Data_Saida},{Falta},{Id_Professor},{Id_Aluno},{Id_Turma}")
    public String getSelecionarFrequencia(@PathParam("Data_entrada") java.sql.Date Data_entrada,@PathParam("Data_Saida") java.sql.Date Data_saida,@PathParam("Falta") String Falta   , @PathParam("Id_Professor") int Id_Professor,@PathParam("Id_Aluno") int Id_Aluno,@PathParam("Id_Turma") int Id_Turma) {
        
        
              Frequencia a = new  Frequencia();
              a.setData(Data_entrada);
              a.setData_Saida(Data_saida);
              a.setFalta(Falta);
              a.setId_Professor(Id_Professor);
               a.setId_Aluno(Id_Aluno);
              a.setId_Turma(Id_Turma);
             
                ArrayList<Frequencia> lista = new FrequenciaController().SelecionarData(a);
                 
               Gson gsons = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
      
    Gson gson = new Gson();
    
       
  
		return gsons.toJson(lista);
    }
    
    @GET
    @Produces("application/json")
     @Path("SelecionarFrequenciaBimestre/{Falta},{Id_Professor},{Id_Aluno},{Id_Turma},{Id_Bimestre}")
    public String getSelecionarFrequenciaBimestre(@PathParam("Falta") String Falta   , @PathParam("Id_Professor") int Id_Professor,@PathParam("Id_Aluno") int Id_Aluno, @PathParam("Id_Turma") int Id_Turma,@PathParam("Id_Bimestre") int Id_Bimestre) {
        
        
              Frequencia a = new  Frequencia();
           
              a.setFalta(Falta);
              a.setId_Professor(Id_Professor);
               a.setId_Aluno(Id_Aluno);
               a.setId_Turma(Id_Turma);
              a.setId_Bimestre(Id_Bimestre);
             
               Frequencia lista = new FrequenciaController().SelecionarFrequenciaBimestre(a);
                 
               Gson gsons = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
      
    Gson gson = new Gson();
    
       
  
		return gson.toJson(lista);
    }
   
    
  
    
      @POST
    @Path("Media/inserir")
    @Consumes({MediaType.APPLICATION_JSON + CHARSET_UTF8})
    @Produces(MediaType.TEXT_PLAIN)
   
public boolean inserirMedia(String content){
     Gson g = new Gson();
    Media u = (Media) g.fromJson(content, Media.class);
         boolean lista = new MediaController().InserirMedia(u);
        usuarioDAO dao = new usuarioDAO();  
 
        return lista;
}

@GET
    @Produces("application/json")
     @Path("SelecionarMediaBimestre/{Id_Turma},{Id_Aluno},{Id_Bimestre}")
    public String getSelecionarMediaBimestre(@PathParam("Id_Turma") int  Id_Turma,@PathParam("Id_Aluno") int  Id_Aluno
    ,@PathParam("Id_Bimestre") int Id_Bimestre) {
        
        
              Media a = new  Media();
    
           
              a.setId_Turma(Id_Turma);
              a.setId_Aluno(Id_Aluno);
                 a.setId_Bimestre(Id_Bimestre);
                   ArrayList<Media> lista = new MediaController().ConsultarMediaBimestre(a);
                 
      
      
    Gson gson = new Gson();
    
       
  
		return gson.toJson(lista);
    }

    
    
    @GET
    @Produces("application/json")
     @Path("SelecionarTodasMedia/{Id_Professor},{Id_Turma},{Id_Aluno}")
    public String getSelecionarTodasMedia(@PathParam("Id_Professor") int Id_Professor, @PathParam("Id_Turma") int  Id_Turma,@PathParam("Id_Aluno") int  Id_Aluno
    ) {
        
        
              Media a = new  Media();
              a.setId_Professor(Id_Professor);
           
              a.setId_Turma(Id_Turma);
              a.setId_Aluno(Id_Aluno);
                   ArrayList<Media> lista = new MediaController().ConsultarMediaTotal(a);
                 
      
      
    Gson gson = new Gson();
    
       
  
		return gson.toJson(lista);
    }
  


    /**
     * PUT method for updating or creating an instance of SkypWS
     * @param content representation for the resource
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }
    
}
