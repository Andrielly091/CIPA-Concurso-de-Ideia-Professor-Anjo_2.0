package br.edu.ifpe.cipa.model;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
public class Response {
  @JsonInclude(Include.NON_NULL)
  private String mensage;
  public String getMensage() {
    return mensage;
  }
  public void setMensage(String mensage) {
    this.mensage = mensage;
  }
  @JsonInclude(Include.NON_NULL)
  private HttpStatus statusCode;
  public HttpStatus getStatusCode() {
    return statusCode;
  }
  public void setStatusCode(HttpStatus statusCode) {
    this.statusCode = statusCode;
  }
  @JsonInclude(Include.NON_NULL)
  private List<Pessoa> pessoas;
  public List<Pessoa> getPessoas() {
    return pessoas;
  }
  public void setPessoas(List<Pessoa> pessoas) {
    this.pessoas = pessoas;
  }
  @JsonInclude(Include.NON_NULL)
  private Ideias ideias;
  public Ideias getIdeias() {
    return ideias;
  }
  public void setIdeias(Ideias ideias) {
    this.ideias = ideias;
  }
  @JsonInclude(Include.NON_DEFAULT)
  private String isCreated;
  public String isCreated() {
    return isCreated;
  }
  public void setCreated(String isCreated) {
    this.isCreated = isCreated;
  }
  
}
