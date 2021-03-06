package by.mercury.core.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Describes users
 *
 * @author Yegor Ikbaev
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Builder
@Entity
@Table(name = "users")
public class UserModel {

    @Id
    @Column(name = "id")
    private Long id;
    
    @Column(name = "uid")
    private String uid;

    @Column(name = "telegram_id")
    private Integer telegramId;
    
    @Column(name = "hash_id")
    private String telegramToken;

    @Column(name = "telegram_chat_id")
    private Long chatId;
    
    @Transient
    private Integer peerId;

    public Integer getPeerId() {
        return Integer.valueOf(uid);
    }

    public void setPeerId(Integer peerId) {
        this.peerId = peerId;
        uid = peerId.toString();
    }
}
