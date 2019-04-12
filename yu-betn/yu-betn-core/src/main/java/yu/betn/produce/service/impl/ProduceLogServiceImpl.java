package yu.betn.produce.service.impl;

import org.springframework.stereotype.Service;
import yu.betn.produce.domain.ProduceLog;
import yu.betn.produce.service.api.ProduceLogService;

import java.util.Collection;

/**
 * Created by zsp on 2019/4/12.
 */
@Service
public class ProduceLogServiceImpl implements ProduceLogService {
    @Override
    public void collectProduceLog(ProduceLog produceLog) {

    }

    @Override
    public void collectProduceLog(Collection<ProduceLog> collection) {

    }

    @Override
    public void emitProduceLog() {

    }
}
