package com.github.zmzhoustar.common;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户信息
 *
 * @author zmzhou
 * @version 1.0
 * date 2021/3/29 10:53
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserVo implements Serializable {
	/** serialVersionUID */
	private static final long serialVersionUID = 6885915526714692655L;
	private long id;
	private String name;
	private int age;
	private String address;

}
