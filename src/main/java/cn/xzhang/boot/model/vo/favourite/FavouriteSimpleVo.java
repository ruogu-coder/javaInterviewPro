package cn.xzhang.boot.model.vo.favourite;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;


import java.io.Serializable;

/**
 * 收藏表信息Vo
 *
 * @author <a href="https://github.com/XiaoZhangCode">XiaoZhangCode</a>
 */
@Data
@Schema(description = "收藏表简要信息VO")
public class FavouriteSimpleVo implements Serializable {

    @Schema(description = "id")
    private Long id;

    @Schema(description = "用户id")
    private Long userId;

    @Schema(description = "题目id")
    private Long questionId;


}
