package logonedigital.springcourse.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.AbstractAuditable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.time.Instant;

@EqualsAndHashCode(callSuper = true)
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class AbstractEntity extends AbstractAuditable<User,Long> implements Serializable {

/*    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;*/

    @CreatedDate
    @Column(name = "creationDate", nullable = false)
    @JsonIgnore
    private Instant creationDate;

    @LastModifiedDate
    @Column(name = "lastModifiedDate", nullable = false)
    @JsonIgnore
    private Instant lastModifiedDate;
}
