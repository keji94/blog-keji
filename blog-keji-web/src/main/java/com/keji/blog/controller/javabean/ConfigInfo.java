package com.keji.blog.controller.javabean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by wb-ny291824 on 2017/8/10.
 */
@Component("configInfo")
@Data
public class ConfigInfo {

    @Value("${INDEX_DIRECTORY}")
    private String index_directory;
}
