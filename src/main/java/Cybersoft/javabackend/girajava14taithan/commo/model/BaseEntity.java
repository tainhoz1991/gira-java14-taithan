package Cybersoft.javabackend.girajava14taithan.commo.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
// Tat ca cac thuoc tinh chung cho entity duoc khai bao trong day
@MappedSuperclass // o duoi DB cung nhan cac thuoc tinh nay khi co class extends no
public class BaseEntity {
	@Id
	@GeneratedValue // khi qua mot table moi (01 class khac extends tiep)
														// no se resert lai so tt tu dau
	
	protected Long id;
	
	@Version
	protected int version;
	
	@CreatedBy
	@Column(name = "created_by")
	protected String createdBy;
	
	@CreatedDate
	@Column(name = "created_at")
	protected LocalDateTime createAt;
	
	@LastModifiedBy
	@Column(name = "updated_by")
	protected String updatedBy;
	
	@LastModifiedDate
	@Column(name = "updated_at")
	protected LocalDateTime updatedAt;
}
