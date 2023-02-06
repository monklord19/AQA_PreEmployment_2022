package utils;

public enum Endpoints {

    TEXT_BOX("/text-box"),
    AUTOMATION_PRACTICE_FORM("/automation-practice-form"),
    RADIO_BUTTON("/radio-button"),
    BUTTONS("/buttons");

    private final String endpoint;

    Endpoints(String endpoint) {
        this.endpoint = endpoint;
    }

    public String get() {
        return this.endpoint;
    }
}
