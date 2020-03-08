package br.com.caelum.clines.api;


import java.util.ArrayList;
import java.util.List;

public class ErrorPayload {
    private List<ErrorView> errors = new ArrayList<>();

    public void addError(String message) {
        errors.add(ErrorView.of(message));
    }

    public void addErrorForField(String field, String message) {
        errors.add(FieldErrorView.of(field, message));
    }

    public List<ErrorView> getErrors() {
        return errors;
    }

    private static class FieldErrorView extends ErrorView {
        private String field;

        static FieldErrorView of(String field, String message) {
            return new FieldErrorView(field, message);
        }

        private FieldErrorView(String field, String message) {
            super(message);
            this.field = field;
        }

        public String getField() {
            return field;
        }
    }

    private static class ErrorView {
        private String message;

        static ErrorView of(String message) {
            return new ErrorView(message);
        }

        private ErrorView(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
}
