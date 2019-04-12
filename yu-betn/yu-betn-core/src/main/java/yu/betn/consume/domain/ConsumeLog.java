package yu.betn.consume.domain;

import java.time.LocalDateTime;

/**
 * Created by zsp on 2019/4/12.
 */
public class ConsumeLog {

    private Long id;
    private LocalDateTime originalCreateTime;
    private LocalDateTime createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getOriginalCreateTime() {
        return originalCreateTime;
    }

    public void setOriginalCreateTime(LocalDateTime originalCreateTime) {
        this.originalCreateTime = originalCreateTime;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
}
