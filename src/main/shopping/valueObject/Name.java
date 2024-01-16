package main.shopping.valueObject;

/**
 * 名称に関する値オブジェクト
 *
 */
public class Name {
	private final String name;

	//nullと空白を扱わない
	public Name(String value) {
		if(value == null || value.equals("")) {
			throw new IllegalArgumentException();
		}
		this.name = value;
	}
	@Override
	public String toString() {
		return this.name;
	}
	@Override
	public boolean equals(Object targetObject) {
		if (targetObject instanceof Name) {
			Name targetName = (Name)targetObject;
			return this.name.equals(targetName.name);
		}else {
			return false;
		}
	}

}
