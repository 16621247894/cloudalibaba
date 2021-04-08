package zwq.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import zwq.domain.Order;

@Mapper
public interface OrderMapper extends BaseMapper<Order> {
}
