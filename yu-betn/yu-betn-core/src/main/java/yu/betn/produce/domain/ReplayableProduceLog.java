package yu.betn.produce.domain;

import java.time.LocalDateTime;

/**
 * Created by zsp on 2019/4/10.
 */
public class ReplayableProduceLog extends ProduceLog {

    private boolean immediately;
    private LocalDateTime nextPlayTime;
    private int playCount;

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
