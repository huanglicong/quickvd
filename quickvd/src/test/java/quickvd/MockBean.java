package quickvd;

import java.util.Locale;

import org.hlc.quickvd.annotation.Length;
import org.hlc.quickvd.annotation.Max;
import org.hlc.quickvd.annotation.Min;
import org.hlc.quickvd.annotation.NotEmpty;
import org.hlc.quickvd.annotation.NotNull;
import org.hlc.quickvd.annotation.Pattern;
import org.hlc.quickvd.validator.ValidateResult;

public class MockBean implements ValidateResult {

	@Length(6)
	@NotEmpty
	private String name;

	@NotNull
	@Pattern("0|1")
	private String sex;

	@Min(10)
	@Max(100)
	private int age;

	public String getName() {

		return name;
	}

	public void setName(String name) {

		this.name = name;
	}

	public String getSex() {

		return sex;
	}

	public void setSex(String sex) {

		this.sex = sex;
	}

	public int getAge() {

		return age;
	}

	public void setAge(int age) {

		this.age = age;
	}

	@Override
	public void setMessage(String typeName, String fieldName, String errorType, Object value) {

		StringBuilder result = new StringBuilder("message.");
		result.append(typeName.toLowerCase(Locale.getDefault())).append(".");
		result.append(fieldName.toLowerCase(Locale.getDefault())).append(".");
		result.append(errorType.toLowerCase(Locale.getDefault())).append(".text");
		System.out.println("===>>" + result + "=" + value);
	}

}
