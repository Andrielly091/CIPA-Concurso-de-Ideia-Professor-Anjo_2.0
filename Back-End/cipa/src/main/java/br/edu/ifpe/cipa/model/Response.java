package br.edu.ifpe.cipa.model;

import java.util.List;
import org.springframework.http.HttpStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Data;

@Data
public class Response {
<<<<<<< HEAD
	@JsonInclude(Include.NON_NULL)
	private String mensagem;
	@JsonInclude(Include.NON_DEFAULT)
	private String isCreated;
	@JsonInclude(Include.NON_NULL)
	private HttpStatus statusCode;
	@JsonInclude(Include.NON_NULL)
	private List<Pessoa> pessoas;
	@JsonInclude(Include.NON_NULL)
	private List<Ideias> ideias;
	@JsonInclude(Include.NON_NULL)
	private String auth;

	public String getAuth() {
		return auth;
	}

	public void setAuth(String auth) {
		this.auth = auth;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public HttpStatus getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(HttpStatus statusCode) {
		this.statusCode = statusCode;
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	public List<Ideias> getIdeias() {
		return ideias;
	}

	public void setIdeias(List<Ideias> ideias) {
		this.ideias = ideias;
	}

	public String isCreated() {
		return isCreated;
	}

	public void setCreated(String isCreated) {
		this.isCreated = isCreated;
	}

=======
  @JsonInclude(Include.NON_NULL)
  private String mensagem;
  @JsonInclude(Include.NON_DEFAULT)
  private String isCreated;
  @JsonInclude(Include.NON_NULL)
  private HttpStatus statusCode;
  @JsonInclude(Include.NON_NULL)
  private List<Pessoa> pessoas;
  @JsonInclude(Include.NON_NULL)
  private List<Ideias> ideias;
  @JsonInclude(Include.NON_NULL)
  private String auth;
  @JsonInclude(Include.NON_NULL)
  private String found;
  public String getFound() {
    return found;
  }
  public void setFound(String found) {
    this.found = found;
  }
  public String getAuth() {
    return auth;
  }
  public void setAuth(String auth) {
    this.auth = auth;
  }
  public String getMensagem() {
    return mensagem;
  }
  public void setMensagem(String mensagem) {
    this.mensagem = mensagem;
  }
  public HttpStatus getStatusCode() {
    return statusCode;
  }
  public void setStatusCode(HttpStatus statusCode) {
    this.statusCode = statusCode;
  }
  public List<Pessoa> getPessoas() {
    return pessoas;
  }
  public void setPessoas(List<Pessoa> pessoas) {
    this.pessoas = pessoas;
  }
  public List<Ideias> getIdeias() {
    return ideias;
  }
  public void setIdeias(List<Ideias> ideias) {
    this.ideias = ideias;
  }
  public String isCreated() {
    return isCreated;
  }
  public void setCreated(String isCreated) {
    this.isCreated = isCreated;
  }
  
>>>>>>> eb2bfbac3f7a40e063d60435a656dd6a8d92f4d7
}
