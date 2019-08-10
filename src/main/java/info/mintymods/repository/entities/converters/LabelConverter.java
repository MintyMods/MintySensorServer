package info.mintymods.repository.entities.converters;

// @Converter(autoApply = true)
public class LabelConverter {// implements AttributeConverter<Label, String>

	private static final String SEPARATOR = "|#|";
	private static final String SEPARATOR_REGEX = "\\|\\#\\|";
	// @Override
	// public String convertToDatabaseColumn(Label label) {
	// final StringBuilder value = new StringBuilder();
	// value.append(label.getName())
	// .append(SEPARATOR)
	// .append(label.getDesc())
	// .append(SEPARATOR)
	// .append(label.getIcon());
	// return value.toString();
	// }
	//
	// @Override
	// public Label convertToEntityAttribute(String labelString) {
	// final String[] parts = labelString.split(SEPARATOR_REGEX);
	// return new Label(parts[1], parts[1], parts[2]);
	// }
}
