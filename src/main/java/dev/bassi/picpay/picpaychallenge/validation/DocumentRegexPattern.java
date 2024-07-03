package dev.bassi.picpay.picpaychallenge.validation;

import lombok.experimental.UtilityClass;

@UtilityClass
public class DocumentRegexPattern {
    public static final String DOCUMENT_REGEX_PATTERN = "^(\\d{11}|\\d{14})$";
}
