package cn.xzhang.boot.service;

import cn.xzhang.boot.common.pojo.PageResult;
import cn.xzhang.boot.model.dto.question.*;
import cn.xzhang.boot.model.entity.Question;
import cn.xzhang.boot.model.vo.question.QuestionSimpleVo;
import cn.xzhang.boot.model.vo.question.QuestionVo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author <a href="https://github.com/XiaoZhangCode">XiaoZhangCode</a>
 * @description 针对表【question(题目表)】的数据库操作Service
 */
public interface QuestionService extends IService<Question> {

    /**
     * 添加题目信息。
     *
     * @param questionReqDTO 题目添加请求数据传输对象，包含要添加的题目的所有必要信息。
     * @return 返回添加操作的自增ID，用于标识此次添加操作。
     */
    long addQuestion(QuestionAddReqDTO questionReqDTO);

    /**
     * 更新题目信息。
     *
     * @param questionReqDTO 包含题目更新信息的请求DTO（数据传输对象）。该对象应包含需要更新的题目属性。
     * @return boolean 返回true如果题目信息更新成功，返回false如果更新失败或遇到错误。
     */
    boolean updateQuestion(QuestionUpdateReqDTO questionReqDTO);

    /**
     * 删除题目
     *
     * @param id 题目的唯一标识符
     * @return boolean 返回操作是否成功。true表示删除成功，false表示删除失败。
     */
    boolean deleteQuestion(Long id);

    /**
     * 根据Question对象获取对应的QuestionVo对象。
     *
     * @param question 一个包含题目信息的Question对象。
     * @return 返回一个包含题目信息的QuestionVo对象。
     */
    QuestionSimpleVo getSimpleQuestionVO(Question question);

    /**
     * 获取题目页面信息
     *
     * @param questionPageReqDTO 包含分页和筛选条件的题目请求数据传输对象
     * @return 返回题目页面的结果，包括题目列表和分页信息
     */
    PageResult<QuestionVo> getQuestionPage(QuestionPageReqDTO questionPageReqDTO);

    /**
     * 根据Question对象获取对应的QuestionVo对象。
     *
     * @param question 一个包含题目信息的Question对象。
     * @return 返回一个包含题目信息的QuestionVo对象。
     */
    QuestionVo getQuestionVO(Question question);

    /**
     * 根据题目id列表查询题目列表
     * @param questionIds 题目id列表
     * @return 题目信息
     */
    List<Question> selectListInIds(List<Long> questionIds);

    /**
     * 审核题目
     * @param reviewReqDTO 题目审核请求
     * @return boolean
     */
    Boolean reviewQuestion(QuestionReviewReqDTO reviewReqDTO);

    /**
     * 批量审核题目
     * @param reviewReqDTO 题目审核请求
     * @return boolean
     */
    Boolean reviewQuestionBatch(QuestionBatchReviewReqDTO reviewReqDTO);

    /**
     * 用户获取题目列表
     * @param reqDTO 参数
     * @return 题目列表
     */
    PageResult<QuestionVo> getUserQuestionPage(UserQuestionPageReqDTO reqDTO);

    /**
     *  从ES中获取题目 分页
     * @param questionQueryRequest 查询参数
     * @return 题目数据
     */
    PageResult<QuestionVo> searchFromEs(UserQuestionPageReqDTO questionQueryRequest);

    /**
     * 查询所有的数据 包括已经删除的数据
     * @return 所有数据
     */
    List<Question> listAll();

    /**
     * 批量删除题目
     * @param idList 题目id列表
     */
    void batchDeleteQuestions(List<Long> idList);

    /**
     * 更新题目收藏数
     * @param questionId 题目ID
     * @param type true + false -
     */
    void updateQuestionFavoriteCount(Long questionId, boolean type);

    void updateViewNum(Long id);
}
