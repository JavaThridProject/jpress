/**
 * Copyright (c) 2016-2019, Michael Yang 杨福海 (fuhai999@gmail.com).
 * <p>
 * Licensed under the GNU Lesser General Public License (LGPL) ,Version 3.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.gnu.org/licenses/lgpl-3.0.txt
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.jpress.web.base;

import com.jfinal.aop.Before;
import com.jfinal.core.NotAction;
import com.jfinal.plugin.activerecord.Model;
import io.jpress.web.interceptor.CSRFInterceptor;
import io.jpress.web.interceptor.UserCenterInterceptor;
import io.jpress.web.interceptor.UserInterceptor;
import io.jpress.web.interceptor.UserMustLoginedInterceptor;

/**
 * @author Michael Yang 杨福海 （fuhai999@gmail.com）
 * @version V1.0
 * @Package io.jpress.web
 */
@Before({
        CSRFInterceptor.class,
        UserInterceptor.class,
        UserMustLoginedInterceptor.class,
        UserCenterInterceptor.class
})
public abstract class UcenterControllerBase extends ControllerBase {


    @NotAction
    public int getPagePara() {
        return getParaToInt("page", 1);
    }

    @NotAction
    public boolean notLogineUserModel(Model model) {
        return !isLogineUserModel(model, "user_id");
    }

    @NotAction
    public boolean notLogineUserModel(Model model, String attrName) {
        return !isLogineUserModel(model, attrName);
    }


    @NotAction
    public boolean isLogineUserModel(Model model) {
        return isLogineUserModel(model, "user_id");
    }

    @NotAction
    public boolean isLogineUserModel(Model model, String attrName) {
        if (model == null) return false;
        Object userId = model.get(attrName);
        return userId != null && userId.equals(getLoginedUser().getId());
    }


}
