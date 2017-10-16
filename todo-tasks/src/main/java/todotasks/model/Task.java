// Definirá a estrutura da tabela Task que será populada com tarefas pela web, 
// e concluídas pelo dispositivo móvel

package todotasks.model;

// import org.hibernate.validator.constraints.NotBlank;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * Descrições
 * @author artursbm
 * As annotations abaixo descrevem:
 * @Entity -> marca a classe abaixo Task como uma classe persistente, para o modelo ser gerado pro BD.
 * @Table -> dá detalhes de mapeamento entre a tabela e este modelo
 * @JsonIgnoreProperties -> chama o Jackson para cuidar da serialização e desserialização dos objetos Java de e para JSON,
 * nesse caso, ignorando createdAt e updatedAt (valores que o cliente não pode alterar por conta própria, mas ainda são 
 * enviados no objeto JSON gerado pelo Jackson).
 * @Id -> seta uma chave primária
 * @GeneratedValue -> dá comando de Auto increment na chave id
 * @NotBlank -> validação de "não-nulidade" ou "não-vazio" para a coluna
 * @Column -> define propriedades específicas para essa coluna, como não permitir ser alterada ou ser nula 
 */

@Entity
@Table(name = "Tasks")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)
public class Task {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	// descrição da tarefa
	@Column(nullable = false, updatable = false )
	private String content;
	
	// informações sobre task completada e por quem foi completada
	private boolean completed;
	private long completedBy;
	
	// informações de geolocalização para a foto tirada
	// TODO: CHECK IF PUT @COLUMN(NULLABLE=FALSE) IS NECESSARY
	private double latitude;
	private double longitude;
	
	// Os próximos dois campos serão populados automaticamente.
	// Para isso, ativo o JpaAuditing no TodoTasksApplication.java
	// enquanto este arquivo fica com um AuditingListener ativado	
	@Column(nullable = false, updatable = false) 
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date createdAt;
	
	@Column(nullable = false) 
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date updatedAt;

// -----------------------------------------------------------------------
// Métodos Get e Set dos campos acima
	
	// SETTERS
	public void setId(long id) {
		this.id = id;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public void setCompletedBy(long idUser) {
		this.completedBy = idUser;
	}
	
	public void setGps(double latitude, double longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public void setComplete(boolean completed) {
		this.completed = completed;
	}
	
	public void setStartDate(Date create) {
		this.createdAt = create;
	}
	
	public void setFinishDate(Date completed) {
		this.updatedAt = completed;
	}
	
	// GETTERS
	public long getId() {
		return id;
	}
	
	public String getContent() {
		return content;
	}
	
	public long getCompletedBy() {
		return completedBy;
	}
	
	public double getLatitude() {
		return latitude;
	}
	
	public double getLongitude() {
		return longitude;
	}
	
	public String getGps() {
		return "latitude: " + latitude + " " + "longitude: " + longitude;
	}
	
	public boolean isComplete() {
		return completed;
	}
	
}
