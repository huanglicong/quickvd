package quickvd;

import org.hlc.quickvd.validator.Validator;

import junit.framework.TestCase;

public class TestValidator extends TestCase {

	public final void testValidate() {
		MockBean bean = new MockBean();
		bean.setName("zhangsan");
		bean.setAge(1001);
		bean.setSex("8");
		Validator.getinstance().validate(bean, bean);
	}

}
