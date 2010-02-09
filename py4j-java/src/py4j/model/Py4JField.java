package py4j.model;

import java.lang.reflect.Field;

import py4j.reflection.TypeUtil;

public class Py4JField extends Py4JMember{

	private final String type;

	private final String container;
	
	
	public Py4JField(String name, String javadoc, String type,
			String container) {
		super(name, javadoc);
		this.type = type;
		this.container = container;
	}

	public final static Py4JField buildField(Field field) {
		return new Py4JField(field.getName(),null,field.getType().getCanonicalName(), field.getDeclaringClass().getCanonicalName());
	}
	
	public String getType() {
		return type;
	}

	
	
	public String getContainer() {
		return container;
	}

	@Override
	public String getSignature(boolean shortName) {
		StringBuilder builder = new StringBuilder();
		
		builder.append(getName());
		builder.append(" : ");
		builder.append(TypeUtil.getName(type,shortName));
		
		return builder.toString();
	}
	
	
	
}
