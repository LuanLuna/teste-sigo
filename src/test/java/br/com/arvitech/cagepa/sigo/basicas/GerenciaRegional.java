package br.com.arvitech.cagepa.sigo.basicas;

public class GerenciaRegional {
    
    private String nome;
    private String sigla;
    
    public GerenciaRegional() { }
    
    public GerenciaRegional(String nome, String sigla) {
          super();
          this.nome = nome;
          this.sigla = sigla;
    }



    public String getNome() {
          return nome;
    }
    public void setNome(String nome) {
          this.nome = nome;
    }
    public String getSigla() {
          return sigla;
    }
    public void setSigla(String sigla) {
          this.sigla = sigla;
    }
}