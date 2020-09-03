package love.xuqinqin.suiMark.mapper;

import love.xuqinqin.suiMark.model.Mark;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author FGuy
 * @Date 2020/8/22 12:22
 */
@Mapper
public interface MarkMapper {

    Integer addMark(Mark mark);

    List<Mark> getMarkByCreator(Integer creator);

    Mark getMarkById(Integer id);

    Integer updateMark(Mark mark);

}
