package io.geemov42.hexarch.domain.business.todo;

import io.geemov42.hexarch.domain.commons.entity.Auditable;
import lombok.*;
import org.hibernate.envers.AuditOverride;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Entity
@Table(name = "TODO_TABLE")
@Audited
@AuditOverride(forClass = Auditable.class)
@Data
@EqualsAndHashCode(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TodoEntity extends Auditable {
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "todo_id_seq")
    @SequenceGenerator(name = "todo_id_seq", sequenceName = "todo_id_seq", allocationSize = 50)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "content", nullable = false)
    private String title;
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    private boolean resolved;
    @Version
    private int version;

}
