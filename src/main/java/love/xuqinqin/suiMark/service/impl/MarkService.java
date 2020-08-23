package love.xuqinqin.suiMark.service.impl;

import love.xuqinqin.suiMark.mapper.MarkMapper;
import love.xuqinqin.suiMark.model.Mark;
import love.xuqinqin.suiMark.service.IMarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author FGuy
 * @Date 2020/8/22 12:21
 */
@Service
public class MarkService implements IMarkService {

    @Autowired
    private MarkMapper markMapper;

    @Override
    public Integer addMark(Mark mark) {
        return markMapper.addMark(mark);
    }
}
