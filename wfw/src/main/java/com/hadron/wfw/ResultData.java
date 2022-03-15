package com.hadron.wfw;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author xuychao
 * @date 2022年3月15日
 * @classname ResultData.java
 * @email xuychao@163.com  git@github.com:geek208/wfw.git
 * @param <T>
 */

@ApiModel(value = "返回说明")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultData<T>{

    @ApiModelProperty(value = "成功标识；true：成功；false:失败")
	private boolean success;

	@ApiModelProperty(value = "返回状态码；200:成功")
	private int code;

	@ApiModelProperty(value = "描述信息")
	private String message;

	private T data;
}