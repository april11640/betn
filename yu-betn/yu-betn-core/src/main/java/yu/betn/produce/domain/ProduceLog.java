package yu.betn.produce.domain;

import java.time.LocalDateTime;

/**
 * Created by zsp on 2019/4/10.
 */
public class ProduceLog {

    private Long id;
    private ProduceLogTypeEnum type;
    private int priority;
    private ProduceLogStatusEnum status;
    private LocalDateTime createTime;
    private LocalDateTime playTime;
    private LocalDateTime acknowledgeTime;
    private boolean immediately;
    private LocalDateTime nextPlayTime;
    private int playCount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProduceLogTypeEnum getType() {
        return type;
    }

    public void setType(ProduceLogTypeEnum type) {
        this.type = type;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public ProduceLogStatusEnum getStatus() {
        return status;
    }

    public void setStatus(ProduceLogStatusEnum status) {
        this.status = status;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getPlayTime() {
        return playTime;
    }

    public void setPlayTime(LocalDateTime playTime) {
        this.playTime = playTime;
    }

    public LocalDateTime getAcknowledgeTime() {
        return acknowledgeTime;
    }

    public void setAcknowledgeTime(LocalDateTime acknowledgeTime) {
        this.acknowledgeTime = acknowledgeTime;
    }

    public boolean isImmediately() {
        return immediately;
    }

    public void setImmediately(boolean immediately) {
        this.immediately = immediately;
    }

    public LocalDateTime getNextPlayTime() {
        return nextPlayTime;
    }

    public void setNextPlayTime(LocalDateTime nextPlayTime) {
        this.nextPlayTime = nextPlayTime;
    }

    public int getPlayCount() {
        return playCount;
    }

    public void setPlayCount(int playCount) {
        this.playCount = playCount;
    }
}
