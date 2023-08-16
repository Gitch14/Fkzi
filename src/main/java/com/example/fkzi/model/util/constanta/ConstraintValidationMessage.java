package com.example.fkzi.model.util.constanta;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ConstraintValidationMessage {

    private int code;
    private String message;
    private List<Error> listOfErrors;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<Error> getListOfErrors() {
        return listOfErrors;
    }

    public void setListOfErrors(List<Error> listOfErrors) {
        this.listOfErrors = listOfErrors;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class Error {
        public Error() {
        }

        public Error(String message, String field, int code) {
            this.message = message;
            this.field = field;
            this.code = code;
        }

        public Error(String message, int code) {
            this.message = message;
            this.code = code;
        }

        private String message;
        private String field;
        private int code;

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getField() {
            return field;
        }

        public void setField(String field) {
            this.field = field;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Error error = (Error) o;
            return code == error.code &&
                    Objects.equals(message, error.message) &&
                    Objects.equals(field, error.field);
        }

        @Override
        public int hashCode() {
            return Objects.hash(message, field, code);
        }

        @Override
        public String toString() {
            return "Error{" +
                    "message='" + message + '\'' +
                    ", field='" + field + '\'' +
                    ", code=" + code +
                    '}';
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConstraintValidationMessage that = (ConstraintValidationMessage) o;
        return code == that.code && Objects.equals(message, that.message) && Objects.equals(listOfErrors, that.listOfErrors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, message, listOfErrors);
    }
}
