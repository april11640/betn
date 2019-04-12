package yu.betn.consume.domain;

import java.time.LocalDateTime;

/**
 * Created by zsp on 2019/4/12.
 */
public class AcknowledgeLog {

    private Long acknowledgeLogId;
    private Long id;
    private LocalDateTime createTime;

    public Long getAcknowledgeLogId() {
        return acknowledgeLogId;
    }

    public void setAcknowledgeLogId(Long acknowledgeLogId) {
        this.acknowledgeLogId = acknowledgeLogId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
}
