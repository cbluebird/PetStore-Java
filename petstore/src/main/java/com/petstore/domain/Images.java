package com.petstore.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.stereotype.Repository;

@Data
@Repository
@TableName("images")
public class Images {
    private Integer id;
    private Integer userid;
    private Integer productid;
    private String file;

    public Images(Integer userid, Integer productid, String file) {
        this.userid = userid;
        this.productid = productid;
        this.file = file;
    }

    public Images(Integer userid, String file) {
        this.userid = userid;
        this.file = file;
        this.productid=0;
    }

    public Images() {
    }
}
