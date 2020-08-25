package love.xuqinqin.suiMark.service.impl;

import love.xuqinqin.suiMark.mapper.MarkMapper;
import love.xuqinqin.suiMark.model.Mark;
import love.xuqinqin.suiMark.model.dto.AccountAndInfo;
import love.xuqinqin.suiMark.service.IMarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<Mark> getMarkByCreator(Integer creator) {
        return markMapper.getMarkByCreator(creator);
    }

    @Override
    public Integer updateMark(Mark mark) {
        return markMapper.updateMark(mark);
    }

    /**
     * 将账户信息添加到随记、保存随记
     *
     * @param mark
     * @param accountAndInfo
     * @return
     */
    public Integer addMark(Mark mark, AccountAndInfo accountAndInfo){
        mark.setCreator(accountAndInfo.getId());
        mark.setCreat_time(System.currentTimeMillis());
        mark.setEditor_time(mark.getCreat_time());
        return addMark(mark);
    }

    /**
     * 将账户信息添加到随记、更新随记
     *
     * @param mark
     * @param accountAndInfo
     * @return
     */
    public Integer updateMark(Mark mark, AccountAndInfo accountAndInfo){
        mark.setCreator(accountAndInfo.getId());
        if(isOwn(mark)) {
            mark.setEditor_time(System.currentTimeMillis());
            return updateMark(mark);
        }
        return 0;
    }

    //******************************************************************************************************************

    /**
     * 随记是否归属
     *
     * @param mark
     * @return
     */
    private boolean isOwn(Mark mark){
        for (Mark mark1 : this.getMarkByCreator(mark.getCreator())) {
            if(mark1.getId().equals(mark.getId())){
                return true;
            }
        }
        return false;
    }
}
