package yu.betn.produce.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

/**
 * Created by zsp on 2019/4/10.
 */
public class ProduceLogGroup<T extends ProduceLog> extends ProduceLog {

    private Comparator<T> comparator;
    private List<T> produceLogList;

    public void setNotificationComparator(Comparator<T> value) {
        this.comparator = value;
    }

    public Collection<T> getProduceLogs() {
        return produceLogList;
    }

    public void setProduceLogs(Collection<T> value) {
        this.produceLogList = new ArrayList<>(value);
    }

    public void addProduceLog(T item) {
        this.produceLogList.add(item);
    }

    public void  removeNotification(T item) {
        this.produceLogList.remove(item);
    }

}
