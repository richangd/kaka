package kr.canon.CanonERP.kakaoworkagent.exeption;

public class MissingRequiredHeaderException extends RuntimeException {
    public MissingRequiredHeaderException(String message) {
        super(message);
    }
}    