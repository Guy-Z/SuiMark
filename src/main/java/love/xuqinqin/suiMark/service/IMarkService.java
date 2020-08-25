package love.xuqinqin.suiMark.service;

import love.xuqinqin.suiMark.model.Mark;

import java.util.List;

/**
 * @Author FGuy
 * @Date 2020/8/22 12:21
 */
public interface IMarkService {

    Integer addMark(Mark mark);

    List<Mark> getMarkByCreator(Integer creator);


}
