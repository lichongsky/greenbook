package com.lichong.greenbook.vo;

import com.emdata.common.mvc.entity.BaseEntity;
import com.emdata.common.mvc.vo.BaseVo;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.lichong.greenbook.entity.Demo;
import lombok.Getter;
import lombok.Setter;

/**
 * @author ：lichongsky
 * @date ：Created in 2019/7/25 13:47
 */

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DemoVo extends BaseVo {

    /**
     *
     */
    private static final long serialVersionUID = -7956009962358130982L;

    String name;

    String address;

    @Override
    public void convert(BaseEntity entity) {
        if (entity instanceof Demo) {
            super.setBaseVo(entity);
            Demo u = (Demo) entity;
            this.name = u.getName();
            this.address = u.getAddress();
        }

    }
}
