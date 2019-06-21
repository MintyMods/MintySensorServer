package info.mintymods.repository.entities.converters;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import info.mintymods.repository.entities.Label;

@Converter(autoApply = true)
public class LabelConverter implements AttributeConverter<Label, String> {

	private static final String SEPARATOR = "|#|";

	@Override
	public String convertToDatabaseColumn(Label label) {
		final StringBuilder value = new StringBuilder();
		value.append(label.getName())
				.append(SEPARATOR)
				.append(label.getDescription())
				.append(SEPARATOR)
				.append(label.getIcon());
		return value.toString();
	}

	@Override
	public Label convertToEntityAttribute(String labelString) {
		final String[] parts = labelString.split(SEPARATOR);
		return new Label(parts[1], parts[1], parts[2]);
	}
}
