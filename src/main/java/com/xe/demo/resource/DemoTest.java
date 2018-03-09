package com.xe.demo.resource;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * test
 * @author zhumj
 *
 */
@Api(description = "服务")
@RestController
@RequestMapping(value = "/external")
public class DemoTest {

	@ApiOperation(value="统一对外接口callback")
    @ApiResponses({
    	@ApiResponse(code=200,message="SUCCESS"),
        @ApiResponse(code=-1,message="查询失败"),
        @ApiResponse(code=-2,message="权限不够")
    })
    @PostMapping(value = "/unifiedInterfaceCallBack")
	public Object unifiedInterfaceCallBack(@RequestBody String value){
		return value;
	}
}
