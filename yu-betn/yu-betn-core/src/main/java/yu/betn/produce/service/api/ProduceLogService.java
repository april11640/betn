package yu.betn.produce.service.api;

import yu.betn.produce.domain.ProduceLog;

import java.util.Collection;

/**
 * Created by zsp on 2019/4/12.
 */
public interface ProduceLogService {

    void collectProduceLog(ProduceLog produceLog);

    void collectProduceLog(Collection<ProduceLog> collection);

    void emitProduceLog();

}
