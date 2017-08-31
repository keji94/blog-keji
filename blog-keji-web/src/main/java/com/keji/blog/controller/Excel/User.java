/**

 * Copyright (c) 2017, 吴汶泽 (wuwz@live.com).

 *

 * Licensed under the Apache License, Version 2.0 (the "License");

 * you may not use this file except in compliance with the License.

 * You may obtain a copy of the License at

 *

 *      http://www.apache.org/licenses/LICENSE-2.0

 *

 * Unless required by applicable law or agreed to in writing, software

 * distributed under the License is distributed on an "AS IS" BASIS,

 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.

 * See the License for the specific language governing permissions and

 * limitations under the License.

 */
package com.keji.blog.controller.Excel;

import org.apache.poi.hssf.util.HSSFColor;
import org.wuwz.poi.annotation.ExportConfig;

public class User {

	@ExportConfig("UID")
	private Integer uid;

	@ExportConfig("用户名")
	private String username;

	@ExportConfig(value = "密码", replace = "******", color = HSSFColor.RED.index)
	private String password;

	@ExportConfig(value = "性别", width = 50, convert = "s:1=男,2=女")
	private Integer sex;

	@ExportConfig(value = "年级")
	private Integer gradeId;

	public Integer getUid() {
		return uid;
	}

	public User setUid(Integer uid) {
		this.uid = uid;
		return this;
	}

	public String getUsername() {
		return username;
	}

	public User setUsername(String username) {
		this.username = username;
		return this;
	}

	public String getPassword() {
		return password;
	}

	public User setPassword(String password) {
		this.password = password;
		return this;
	}

	public Integer getSex() {
		return sex;
	}

	public User setSex(Integer sex) {
		this.sex = sex;
		return this;
	}

	public Integer getGradeId() {
		return gradeId;
	}

	public User setGradeId(Integer gradeId) {
		this.gradeId = gradeId;
		return this;
	}

}
